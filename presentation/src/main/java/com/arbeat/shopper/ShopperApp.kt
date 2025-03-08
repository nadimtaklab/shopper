package com.arbeat.shopper

import android.app.Application
import com.arbeat.data.di.dataModule
import com.arbeat.domain.di.domainModule
import com.arbeat.shopper.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShopperApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@ShopperApp)
            modules(listOf(
                presentationModule,
                dataModule,
                domainModule
            ))
        }
    }

}