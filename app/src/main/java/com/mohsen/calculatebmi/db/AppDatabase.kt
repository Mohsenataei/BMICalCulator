package com.mohsen.calculatebmi.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohsen.calculatebmi.db.daos.FoodDao
import com.mohsen.calculatebmi.db.entities.Food
import java.security.AccessControlContext

@Database(entities = arrayOf(Food::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context) : AppDatabase {
            if (INSTANCE == null){
                synchronized(AppDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java,
                            "appDAtabase").createFromAsset("db/appDAtabase.db")
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}