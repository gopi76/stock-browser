package com.gopi.stocksbrowser.repositories

import com.gopi.stocksbrowser.dao.EtfDao
import com.gopi.stocksbrowser.model.room.EtfEntity
import com.gopi.stocksbrowser.utils.toSafeString
import javax.inject.Inject

class EtfRepository @Inject constructor(
    private val dao: EtfDao
) {

    suspend fun insertEtfs(entities: List<EtfEntity>) =
        dao.insertAll(entities)

    fun getEtfs(symbols: List<String>) =
        dao.getEtfsBySymbols(symbols)

    fun getEtf(symbol: String) =
        dao.getEtfBySymbol(symbol)

    fun findEtf(searchQuery: String) =
        dao.findEtfs(searchQuery.toSafeString() + "%")
}
