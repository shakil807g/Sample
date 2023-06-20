package com.sample.domain.mapper

import com.sample.data.model.response.ViewerResponse
import com.sample.ui.list.ListItemUi
import com.sample.utils.Mapper
import javax.inject.Inject

class CharacterDetailsMapper @Inject constructor() : Mapper<ViewerResponse, List<ListItemUi>> {
    override fun map(t: ViewerResponse): List<ListItemUi> {
        return t.relatedTopics.map {
            ListItemUi(
                name = it.text.split("-")[0].trim(),
                description = it.text,
                icon = it.icon.url
            )
        }
    }
}