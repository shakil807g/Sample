package com.sample.ui.list

import androidx.lifecycle.ViewModel
import com.sample.data.networking.Resource
import com.sample.domain.usecase.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val characters: GetCharacters,
) : ViewModel() {

    fun getCharacters(): Flow<Resource<List<ListItemUi>>>{
        return characters.getCharacters()
    }

}