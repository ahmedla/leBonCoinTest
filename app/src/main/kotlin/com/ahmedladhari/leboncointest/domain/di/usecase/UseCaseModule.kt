package com.ahmedladhari.leboncointest.domain.di.usecase

import com.ahmedladhari.leboncointest.domain.usecase.album.GetAlbumUseCase
import com.ahmedladhari.leboncointest.domain.usecase.album.GetAlbumUseCaseImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAlbumUseCase> { GetAlbumUseCaseImpl(get(), androidApplication()) }
}