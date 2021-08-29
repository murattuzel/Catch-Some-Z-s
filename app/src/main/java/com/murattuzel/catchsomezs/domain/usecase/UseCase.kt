package com.murattuzel.catchsomezs.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

abstract class UseCase<DataSourceType, DomainType, Params> {

    protected abstract suspend fun buildUseCase(params: Params): DataSourceType

    protected abstract fun map(dataSourceType: DataSourceType): DomainType

    suspend operator fun invoke(params: Params): Result<DomainType> =
        withContext(Dispatchers.IO) {
            try {
                Result.success(buildUseCase(params))
                    .map { map(it) }
            } catch (exception: IOException) {
                Result.failure(exception)
            }
        }
}
