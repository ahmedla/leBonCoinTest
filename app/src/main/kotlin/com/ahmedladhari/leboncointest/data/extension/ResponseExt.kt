package com.ahmedladhari.leboncointest.data.extension

import com.ahmedladhari.leboncointest.domain.exception.LeBonCoinException
import com.ahmedladhari.leboncointest.domain.model.Results
import retrofit2.Response
import java.io.IOException

fun <T> processApiResponse(response: Response<T>): Results<T> {
    return try {
        val responseCode = response.code()
        val responseMessage = response.message()
        if (response.isSuccessful) {
            Results.success(response.body()!!)
        } else {
            val errorMessage =
                "responseCode ======> $responseCode responseMessage =====>$responseMessage "
            Results.failure(LeBonCoinException.NetworkException(errorMessage))
        }
    } catch (e: IOException) {
        Results.failure(LeBonCoinException.NetworkException())
    }
}