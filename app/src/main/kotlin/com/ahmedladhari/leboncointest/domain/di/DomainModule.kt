package com.ahmedladhari.leboncointest.domain.di

import com.ahmedladhari.leboncointest.domain.di.repository.repositoryModule
import com.ahmedladhari.leboncointest.domain.di.usecase.useCaseModule

val domainModule = repositoryModule + useCaseModule