package com.arbeat.domain.repository

import com.arbeat.domain.model.Product
import com.arbeat.domain.network.ResultWrapper

interface ProductRepository {
    suspend fun getProducts(): ResultWrapper<List<Product>>
}