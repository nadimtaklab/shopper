package com.arbeat.data.di

import com.arbeat.data.repository.ProductRepositoryImpl
import com.arbeat.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> {
        ProductRepositoryImpl(get())
    }
}