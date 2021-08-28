package com.murattuzel.catchsomezs.data

import retrofit2.http.GET

interface ContentService {

    @GET(CONTENT_LIST)
    suspend fun fetchContents(): ContentResponse

    companion object {
        const val CONTENT_LIST = "files/MobileInterviewProjectData.json"
    }
}
