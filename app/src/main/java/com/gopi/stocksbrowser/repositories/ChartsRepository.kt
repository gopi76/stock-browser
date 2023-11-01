package com.gopi.stocksbrowser.repositories

import com.gopi.stocksbrowser.api.YahooApiService
import com.gopi.stocksbrowser.model.network.ChartApiResult
import javax.inject.Inject

class ChartsRepository @Inject constructor(
    private val yahooApiService: YahooApiService
) {

    suspend fun getChart(symbol: String, interval: String, range: String): ChartApiResult =
        yahooApiService.getChart(symbol = symbol, interval = interval, range = range)
}
