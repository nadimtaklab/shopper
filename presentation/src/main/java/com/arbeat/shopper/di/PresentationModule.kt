package com.arbeat.shopper.di

import org.koin.dsl.module

val presentationModule = module {
    includes(viewModelModule)
}