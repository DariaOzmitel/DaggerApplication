package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.database.dao.BouquetDao
import com.example.database.dao.FlowerDao
import com.example.database.entities.Bouquet
import com.example.database.entities.BouquetFlowerCrossRef
import com.example.database.entities.BouquetFlowerView
import com.example.database.entities.Flower

@Database(
    entities = [Flower::class, Bouquet::class, BouquetFlowerCrossRef::class],
    views = [BouquetFlowerView::class],
    version = 8
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
                        .addMigrations(MIGRATION_7_8)
                        .build()
                db = instance
                return instance
            }
        }

        private val MIGRATION_7_8 = object : Migration(7, 8) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE bouquets ADD COLUMN decoration TEXT")

                db.execSQL("ALTER TABLE flowers ADD COLUMN country TEXT")
            }
        }
    }

    abstract fun flowerDao(): FlowerDao
    abstract fun bouquetDao(): BouquetDao
}