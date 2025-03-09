package com.arbeat.domain.di

import com.arbeat.domain.usecase.GetProductUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetProductUseCase(get())
    }
}
