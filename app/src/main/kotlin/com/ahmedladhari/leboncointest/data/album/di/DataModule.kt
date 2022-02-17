package com.ahmedladhari.leboncointest.data.album.di

import com.ahmedladhari.leboncointest.data.album.di.local.localModule
import com.ahmedladhari.leboncointest.data.album.di.remote.remoteModule

val dataModule = localModule + remoteModule