package com.mohsen.calculatebmi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.mohsen.calculatebmi.db.AppDatabase

class FoodViewModel(app: Application) : AndroidViewModel(app) {
    private val database = AppDatabase.getDatabase(app)
    private val foodDao = database.foodDao()


}