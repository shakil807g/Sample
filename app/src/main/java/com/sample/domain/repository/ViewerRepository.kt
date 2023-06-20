package com.sample.domain.repository

import com.sample.data.model.response.ViewerResponse
import com.sample.data.networking.Resource
import com.sample.data.repository.ViewerRepositoryImpl
import retrofit2.Response

interface ViewerRepository {
    suspend fun getViewerData() : ViewerResponse
}