package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.database.dao.BouquetDao
import com.example.database.dao.FlowerDao
import com.example.database.entities.Bouquet
import com.example.database.entities.BouquetFlowerCrossRef
import com.example.database.entities.BouquetFlowerView
import com.example.database.entities.Flower

@Database(
    entities = [Flower::class, Bouquet::class, BouquetFlowerCrossRef::class],
    views = [BouquetFlowerView::class],
    version = 5
)
internal abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun flowerDao(): FlowerDao
    abstract fun bouquetDao(): BouquetDao
}