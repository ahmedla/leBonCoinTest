package com.ahmedladhari.leboncointest.app.di

import com.ahmedladhari.leboncointest.app.ui.album.AlbumViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AlbumViewModel(get())
    }
}