package com.murattuzel.catchsomezs.domain.mapper

import com.murattuzel.catchsomezs.data.ImageResponse
import com.murattuzel.catchsomezs.data.MeditationResponse
import com.murattuzel.catchsomezs.domain.model.MeditationUiModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MeditationUiModelMapperTest {

    lateinit var mapper: MeditationUiModelMapper

    @Before
    fun setup() {
        mapper = MeditationUiModelMapper()
    }

    @Test
    fun `assert mapper result`() {
        val imageResponse = ImageResponse(
            small = "smallUrl",
            large = "largeUrl"
        )
        val meditationResponse = MeditationResponse(
            title = "title",
            subtitle = "subtitle",
            image = imageResponse,
            releaseDate = 123123,
            content = "content"
        )

        val meditationUiModel = MeditationUiModel(
            title = "title",
            subtitle = "subtitle",
            imageUrl = "smallUrl",
            date = 123123,
            content = "content"
        )

        val actualResult = mapper.mapToUiModel(meditationResponse)

        assertEquals(actualResult, meditationUiModel)
    }
}
