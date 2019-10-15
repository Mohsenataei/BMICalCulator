package com.mohsen.calculatebmi.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mohsen.calculatebmi.db.daos.AddedFoodDao
import com.mohsen.calculatebmi.db.daos.FoodDao
import com.mohsen.calculatebmi.db.entities.AddedFood
import com.mohsen.calculatebmi.db.entities.Food
import java.security.AccessControlContext

@Database(entities = arrayOf(Food::class, AddedFood::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
    abstract fun addedFoodDao(): AddedFoodDao

    val MIGRATION_1_2 = object : Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE `Added_Foods` (`id` INTEGER, `food_name` TEXT, " +
                    " `calory` INTEGER , `type` TEXT, `category` TEXT, `meal` INTEGER, `amount`  INTEGER" +
                    "PRIMARY KEY(`id`))")
        }
    }

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            if (INSTANCE == null){
                synchronized(AppDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java,
                            "appDAtabase").createFromAsset("db/BMICalory.db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }


}