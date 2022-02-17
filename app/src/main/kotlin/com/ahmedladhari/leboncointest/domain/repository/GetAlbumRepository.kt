package com.ahmedladhari.leboncointest.domain.repository

import android.content.Context
import com.ahmedladhari.leboncointest.domain.model.AlbumModel
import com.ahmedladhari.leboncointest.domain.model.Results
import io.reactivex.Single

interface GetAlbumRepository {
    fun getAlbums(context: Context): Single<Results<List<AlbumModel>>>
}