package com.arbeat.data.repository

import com.arbeat.domain.model.Product
import com.arbeat.domain.network.NetworkService
import com.arbeat.domain.network.ResultWrapper
import com.arbeat.domain.repository.ProductRepository

class ProductRepositoryImpl(private val networkService: NetworkService) : ProductRepository {
    override suspend fun getProducts(): ResultWrapper<List<Product>> {
       return networkService.getProducts()
    }
}