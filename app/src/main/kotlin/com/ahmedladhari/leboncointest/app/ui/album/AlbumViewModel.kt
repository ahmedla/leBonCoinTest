package com.ahmedladhari.leboncointest.app.ui.album

import com.ahmedladhari.leboncointest.app.base.viewmodel.LoadingViewModel
import com.ahmedladhari.leboncointest.domain.model.AlbumModel
import com.ahmedladhari.leboncointest.domain.model.Results
import com.ahmedladhari.leboncointest.domain.usecase.album.GetAlbumUseCase
import io.reactivex.Single

class AlbumViewModel(private val getAlbumUseCase: GetAlbumUseCase) :
    LoadingViewModel<Results<List<AlbumModel>>>() {

    fun getAlbums(): Single<Results<List<AlbumModel>>> {
        return getAlbumUseCase.getAlbums()
            .bindLoadingState(data)
    }

}
