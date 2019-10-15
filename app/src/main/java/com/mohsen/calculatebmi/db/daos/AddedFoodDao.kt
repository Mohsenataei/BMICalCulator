package com.mohsen.calculatebmi.db.daos

import androidx.room.*
import com.mohsen.calculatebmi.db.entities.AddedFood
import com.mohsen.calculatebmi.db.entities.Food

@Dao
interface AddedFoodDao {

    @Query("select * from Added_Foods")
    fun getAll(): List<AddedFood>

    @Insert
    fun insertAll(vararg todo: AddedFood)

    @Delete
    fun delete(todo: Food)

    @Update
    fun updateTodo(vararg todos: AddedFood)
}