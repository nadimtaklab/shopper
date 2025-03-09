package com.arbeat.shopper.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arbeat.domain.model.Product
import com.arbeat.domain.network.ResultWrapper
import com.arbeat.domain.usecase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getProductsUseCase: GetProductUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenUIEvents>(HomeScreenUIEvents.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getProducts()
    }

     fun getProducts(){
         viewModelScope.launch {
             _uiState.value = HomeScreenUIEvents.Loading
             getProductsUseCase.execute().let { result ->
                 when (result){
                     is ResultWrapper.Success->{
                         val data = (result).value
                         _uiState.value = HomeScreenUIEvents.Success(data)
                     }
                     is ResultWrapper.Failure->{
                         val error = result.exception.message?: "An error occurred"
                         _uiState.value = HomeScreenUIEvents.Error(error)
                     }
                 }
             }
         }
     }
}

sealed class HomeScreenUIEvents {
    data object Loading : HomeScreenUIEvents()
    data class Success(val data: List<Product>) : HomeScreenUIEvents()
    data class Error(val message: String) : HomeScreenUIEvents()
}