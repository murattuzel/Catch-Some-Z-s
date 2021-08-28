package com.murattuzel.catchsomezs.domain.mapper

import com.murattuzel.catchsomezs.data.StoryResponse
import com.murattuzel.catchsomezs.domain.model.StoryUiModel
import javax.inject.Inject

class StoryUiModelMapper @Inject constructor() : Mapper<StoryUiModel, StoryResponse> {

    override fun mapToUiModel(response: StoryResponse) = with(response) {
        StoryUiModel(
            name = name,
            category = category,
            imageUrl = image.small,
            date = date,
            text = text,
        )
    }
}
