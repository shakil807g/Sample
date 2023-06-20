package com.sample.data.repository

import com.sample.BuildConfig
import com.sample.data.model.response.ViewerResponse
import com.sample.data.networking.Api
import com.sample.data.networking.Resource
import com.sample.domain.repository.ViewerRepository
import com.sample.utils.AppConstants
import javax.inject.Inject

class ViewerRepositoryImpl @Inject constructor(
    private val api: Api
): ViewerRepository {

    override suspend fun getViewerData(): ViewerResponse {
        return api.getCharactersViewer(BuildConfig.VIEWER, AppConstants.format)
    }

}