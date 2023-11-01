package com.gopi.stocksbrowser.api

import com.gopi.stocksbrowser.model.network.EtfApiResponse
import com.gopi.stocksbrowser.model.network.StockApiResponse
import retrofit2.http.GET

interface NasdaqApiService {

    @GET("api/screener/stocks?download=true")
    suspend fun getStocks(): StockApiResponse?

    @GET("api/screener/etf?download=true")
    suspend fun getEtfs(): EtfApiResponse?
}
