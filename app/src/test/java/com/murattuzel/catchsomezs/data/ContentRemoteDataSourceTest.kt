package com.murattuzel.catchsomezs.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.create
import java.io.File
import java.net.HttpURLConnection

@Ignore
@RunWith(JUnit4::class)
class ContentRemoteDataSourceTest {

    lateinit var retrofit: Retrofit
    lateinit var service: ContentService
    lateinit var remoteDataSource: ContentRemoteDataSource
    lateinit var mockWebServer: MockWebServer

    @ExperimentalSerializationApi
    @Before
    fun setup() {

        mockWebServer = MockWebServer().apply { start() }

        val okHttpClient = OkHttpClient.Builder()
            .build()

        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
            coerceInputValues = true
        }

        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()

        service = retrofit.create()
        remoteDataSource = ContentRemoteDataSource(service)
    }

    @Test
    fun `given response ok when fetching content list`() = runBlocking {
        mockHttpResponse(
            "response_data_content_list.json",
            HttpURLConnection.HTTP_OK
        )

        val response = remoteDataSource.fetchContents()

        with(response) {
            assertEquals(isBannerEnabled, true)
            assertEquals(meditations.size, 16)
            assertEquals(meditations[0].title, "Meditation_1")
            assertEquals(meditations[0].subtitle, "Meditation_1_subtitle")
            assertEquals(stories.size, 24)
            assertEquals(stories[0].name, "Story_1")
            assertEquals(stories[0].category, "Category_1")
        }
    }

    private fun mockHttpResponse(fileName: String, responseCode: Int) =
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(responseCode)
                .setBody(getMockJson(fileName))
        )

    private fun getMockJson(path: String): String {
        val uri = this.javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}
