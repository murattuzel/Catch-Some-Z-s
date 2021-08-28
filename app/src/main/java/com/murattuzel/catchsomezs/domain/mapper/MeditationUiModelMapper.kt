package com.murattuzel.catchsomezs.domain.mapper

import com.murattuzel.catchsomezs.data.MeditationResponse
import com.murattuzel.catchsomezs.domain.model.MeditationUiModel
import javax.inject.Inject

class MeditationUiModelMapper @Inject constructor() :
    Mapper<MeditationUiModel, MeditationResponse> {

    override fun mapToUiModel(response: MeditationResponse) = with(response) {
        MeditationUiModel(
            title = title,
            subtitle = subtitle,
            imageUrl = image.small,
            date = releaseDate,
            content = content,
        )
    }
}
