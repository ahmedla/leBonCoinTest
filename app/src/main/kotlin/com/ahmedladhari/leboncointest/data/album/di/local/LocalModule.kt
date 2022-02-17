package com.ahmedladhari.leboncointest.data.album.di.local

import com.ahmedladhari.leboncointest.data.datasource.local.LeBonCoinDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {
    single {
        LeBonCoinDatabase.getInstance(androidApplication())
    }

    single {
        get<LeBonCoinDatabase>().albumDao()
    }
}