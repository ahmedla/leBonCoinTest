package com.ahmedladhari.leboncointest.domain.usecase.album

import android.content.Context
import com.ahmedladhari.leboncointest.app.extension.io
import com.ahmedladhari.leboncointest.domain.model.AlbumModel
import com.ahmedladhari.leboncointest.domain.model.Results
import com.ahmedladhari.leboncointest.domain.repository.GetAlbumRepository
import io.reactivex.Single

class GetAlbumUseCaseImpl(
    private val repository: GetAlbumRepository,
    private val context: Context
) : GetAlbumUseCase {
    override fun getAlbums(): Single<Results<List<AlbumModel>>> {
        return repository.getAlbums(context)
            .io()
    }
}