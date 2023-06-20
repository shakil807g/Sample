package com.sample.domain.usecase

import com.sample.data.networking.Resource
import com.sample.domain.mapper.CharacterDetailsMapper
import com.sample.domain.repository.ViewerRepository
import com.sample.ui.list.ListItemUi
import com.sample.utils.AppConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCharacters @Inject constructor(
    private val repository: ViewerRepository,
    private val mapper: CharacterDetailsMapper
) {
    fun getCharacters(): Flow<Resource<List<ListItemUi>>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.getViewerData()
            if(response != null) {
                emit(Resource.Success(mapper.map(response)))
            }
        } catch (e: IOException) {
            emit(Resource.Error(AppConstants.internetError))
        } catch (e: Exception) {
            emit(Resource.Error(AppConstants.genericError))
        }
    }
}