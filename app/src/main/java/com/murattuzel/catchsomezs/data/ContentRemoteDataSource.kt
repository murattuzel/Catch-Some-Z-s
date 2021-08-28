package com.murattuzel.catchsomezs.data

import javax.inject.Inject

class ContentRemoteDataSource @Inject constructor(
    private val service: ContentService
) : BaseRemoteDataSource() {

    suspend fun fetchContents(): ContentResponse = service.fetchContents()
}
