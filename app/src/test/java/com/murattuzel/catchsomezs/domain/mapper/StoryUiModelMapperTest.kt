package com.murattuzel.catchsomezs.domain.mapper

import com.murattuzel.catchsomezs.data.ImageResponse
import com.murattuzel.catchsomezs.data.StoryResponse
import com.murattuzel.catchsomezs.domain.model.StoryUiModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StoryUiModelMapperTest {

    lateinit var mapper: StoryUiModelMapper

    @Before
    fun setup() {
        mapper = StoryUiModelMapper()
    }

    @Test
    fun `assert mapper result`() {
        val imageResponse = ImageResponse(
            small = "smallUrl",
            large = "largeUrl"
        )
        val storyResponse = StoryResponse(
            name = "name",
            category = "category",
            image = imageResponse,
            date = 123123,
            text = "text"
        )

        val storyUiModel = StoryUiModel(
            name = "name",
            category = "category",
            imageUrl = "smallUrl",
            date = 123123,
            text = "text"
        )

        val actualResult = mapper.mapToUiModel(storyResponse)

        assertEquals(actualResult, storyUiModel)
    }
}
