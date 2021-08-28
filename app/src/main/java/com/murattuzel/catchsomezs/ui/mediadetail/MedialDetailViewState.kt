package com.murattuzel.catchsomezs.ui.mediadetail

import androidx.annotation.StringRes
import org.threeten.bp.LocalDateTime

data class MedialDetailViewState(
    @StringRes val toolbarTitleRes: Int,
    val header: String,
    val description: String,
    val date: LocalDateTime
) {
    val printableDate: String = date.toString()
}
