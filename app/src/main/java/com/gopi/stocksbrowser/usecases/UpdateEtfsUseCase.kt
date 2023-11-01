package com.gopi.stocksbrowser.usecases

import com.gopi.stocksbrowser.api.NasdaqApiService
import com.gopi.stocksbrowser.model.room.toEtfEntity
import com.gopi.stocksbrowser.repositories.EtfRepository
import timber.log.Timber
import javax.inject.Inject

class UpdateEtfsUseCase @Inject constructor(
    private val nasdaqApiService: NasdaqApiService,
    private val repository: EtfRepository,
) {

    suspend operator fun invoke(): Boolean {
        try {
            val apiResponse = nasdaqApiService.getEtfs() ?: return false
            repository.insertEtfs(apiResponse.data.data.rows.map { it.toEtfEntity() })
        } catch (e: Exception) {
            Timber.e(e)
            return false
        }

        return true
    }
}
