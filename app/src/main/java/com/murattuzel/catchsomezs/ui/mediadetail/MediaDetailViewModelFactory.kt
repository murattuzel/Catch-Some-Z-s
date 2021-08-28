package com.murattuzel.catchsomezs.ui.mediadetail

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface MediaDetailViewModelFactory {
    fun create(
        @Assisted("titleRes") titleRes: Int,
        @Assisted("header") header: String,
        @Assisted("description") description: String,
        @Assisted("date") date: Long,
    ): MediaDetailViewModel
}
