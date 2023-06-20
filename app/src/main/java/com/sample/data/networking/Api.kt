package com.sample.data.networking

import com.sample.BuildConfig
import com.sample.BuildConfig.BASE_URL
import com.sample.data.model.response.ViewerResponse
import retrofit2.http.*

interface Api {

    //-- Viewer API
    @GET(BASE_URL)
    suspend fun getCharactersViewer(
        @Query("q") q : String,
        @Query("format") format : String,
    ): ViewerResponse

}