package com.gopi.stocksbrowser.repositories

import com.gopi.stocksbrowser.dao.StocksDao
import com.gopi.stocksbrowser.model.room.StockEntity
import com.gopi.stocksbrowser.utils.toSafeString
import javax.inject.Inject

class StocksRepository @Inject constructor(
    private val dao: StocksDao
) {

    suspend fun insertStocks(entities: List<StockEntity>) = dao.insertAll(entities)

    fun getStocks(symbols: List<String>) =
        dao.getStocksBySymbols(symbols)

    fun getStock(symbol: String) =
        dao.getStockBySymbol(symbol)

    fun findStocks(searchQuery: String) =
        dao.findStocks(searchQuery.toSafeString() + "%")
}
