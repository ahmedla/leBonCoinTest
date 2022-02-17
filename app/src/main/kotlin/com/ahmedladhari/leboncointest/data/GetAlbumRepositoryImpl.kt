package com.ahmedladhari.leboncointest.data

import android.content.Context
import com.ahmedladhari.leboncointest.data.datasource.local.AlbumDao
import com.ahmedladhari.leboncointest.data.datasource.remote.LeBonCoinAlbumApi
import com.ahmedladhari.leboncointest.data.params.NetworkParams
import com.ahmedladhari.leboncointest.data.transformer.transformLocalDataToModel
import com.ahmedladhari.leboncointest.data.transformer.transformRemoteDataToModel
import com.ahmedladhari.leboncointest.domain.model.AlbumModel
import com.ahmedladhari.leboncointest.domain.model.Results
import com.ahmedladhari.leboncointest.domain.repository.GetAlbumRepository
import io.reactivex.Completable
import io.reactivex.Single

class GetAlbumRepositoryImpl(
    private val remote: LeBonCoinAlbumApi,
    private val local: AlbumDao,
    private val networkParams: NetworkParams
) : GetAlbumRepository {

    override fun getAlbums(context: Context): Single<Results<List<AlbumModel>>> {
        return if (networkParams.getNetworkAvailable(context)) {
            remote.getAlbums()
                .compose(transformRemoteDataToModel())
                .flatMapCompletable { apiResult ->
                    when (apiResult) {
                        is Results.Success -> local.insertAll(apiResult.data)
                        else -> Completable.complete()
                    }
                }
                .andThen(local.getAll())
                .compose(transformLocalDataToModel())
        } else {
            local.getAll()
                .compose(transformLocalDataToModel())
        }
    }

}