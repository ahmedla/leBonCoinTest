package com.ahmedladhari.leboncointest.app.di

import com.ahmedladhari.leboncointest.data.album.di.dataModule
import com.ahmedladhari.leboncointest.domain.di.domainModule

val appModule = dataModule + domainModule + viewModule