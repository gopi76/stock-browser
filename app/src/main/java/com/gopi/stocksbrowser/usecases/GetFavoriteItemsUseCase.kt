package com.gopi.stocksbrowser.usecases

import com.gopi.stocksbrowser.repositories.EtfRepository
import com.gopi.stocksbrowser.repositories.PreferencesRepository
import com.gopi.stocksbrowser.repositories.StocksRepository
import com.gopi.stocksbrowser.ui.home.screen.ListItem
import com.gopi.stocksbrowser.ui.home.screen.toInstrumentItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapMerge
import javax.inject.Inject

class GetFavoriteItemsUseCase @Inject constructor(
    private val stocksRepository: StocksRepository,
    private val preferencesRepository: PreferencesRepository,
    private val etfRepository: EtfRepository,
) {

    operator fun invoke(): Flow<List<ListItem.InstrumentItem>> {
        return preferencesRepository.getFavoritesStocks()
            .combine(preferencesRepository.getFavoritesEtfs()) { stocks, etf ->
                Pair(stocks, etf)
            }.flatMapMerge {
                stocksRepository.getStocks(it.first.toList())
                    .combine(etfRepository.getEtfs(it.second.toList())) { stocks, etfs ->
                        stocks.map { stock -> stock.toInstrumentItem() } +
                            etfs.map { etf -> etf.toInstrumentItem() }
                    }
            }
    }
}
