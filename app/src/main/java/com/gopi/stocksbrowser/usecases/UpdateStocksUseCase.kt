package com.gopi.stocksbrowser.usecases

import com.gopi.stocksbrowser.api.NasdaqApiService
import com.gopi.stocksbrowser.model.room.toStockEntity
import com.gopi.stocksbrowser.repositories.StocksRepository
import timber.log.Timber
import javax.inject.Inject

class UpdateStocksUseCase @Inject constructor(
    private val nasdaqApiService: NasdaqApiService,
    private val repository: StocksRepository
) {

    suspend operator fun invoke(): Boolean {
        try {
            val apiResponse = nasdaqApiService.getStocks() ?: return false
            repository.insertStocks(apiResponse.data.rows.map { it.toStockEntity() })
        } catch (e: Exception) {
            Timber.e(e)
            return false
        }

        return true
    }
}
