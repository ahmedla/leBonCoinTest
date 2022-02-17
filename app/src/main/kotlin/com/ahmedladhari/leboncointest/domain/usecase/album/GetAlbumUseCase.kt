package com.ahmedladhari.leboncointest.domain.usecase.album

import com.ahmedladhari.leboncointest.domain.model.AlbumModel
import com.ahmedladhari.leboncointest.domain.model.Results
import com.ahmedladhari.leboncointest.domain.usecase.UseCase
import io.reactivex.Single

interface GetAlbumUseCase : UseCase {
    fun getAlbums(): Single<Results<List<AlbumModel>>>
}