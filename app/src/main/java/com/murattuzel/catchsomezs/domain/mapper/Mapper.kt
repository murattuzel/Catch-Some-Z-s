package com.murattuzel.catchsomezs.domain.mapper

/**
 * Convention for transforming DataSourceModel to UiModel
 */
interface Mapper<UM, DSM> {
    fun mapToUiModel(response: DSM): UM
}
