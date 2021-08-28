package com.murattuzel.catchsomezs.ui.mediadetail

import androidx.annotation.StringRes
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.TextStyle
import java.util.Locale

data class MedialDetailViewState(
    @StringRes val toolbarTitleRes: Int,
    val header: String,
    val description: String,
    val date: LocalDateTime
) {
    private val formattedDate: String = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    private val shortDay: String = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US)
    val printableDate: String = "$formattedDate, $shortDay"
}
