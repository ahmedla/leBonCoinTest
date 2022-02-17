package com.ahmedladhari.leboncointest.domain.di.repository

import com.ahmedladhari.leboncointest.data.GetAlbumRepositoryImpl
import com.ahmedladhari.leboncointest.data.params.NetworkParamsImpl
import com.ahmedladhari.leboncointest.domain.repository.GetAlbumRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<GetAlbumRepository> {
        GetAlbumRepositoryImpl(get(), get(), NetworkParamsImpl())
    }
}