package com.gopi.stocksbrowser.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gopi.stocksbrowser.model.room.EtfEntity
import com.gopi.stocksbrowser.model.room.StockEntity

@Database(entities = [StockEntity::class, EtfEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stocksDao(): StocksDao
    abstract fun etfDao(): EtfDao
}
