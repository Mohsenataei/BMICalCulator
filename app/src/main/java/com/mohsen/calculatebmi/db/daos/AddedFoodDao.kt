package com.mohsen.calculatebmi.db.daos

import androidx.room.*
import com.mohsen.calculatebmi.db.entities.AddedFood
import com.mohsen.calculatebmi.db.entities.Food

@Dao
interface AddedFoodDao {

    @Query("select * from Added_Foods")
    suspend fun getAll(): List<AddedFood>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg todo: AddedFood)

    @Delete
    suspend fun delete(todo: Food)

    @Update
    suspend fun updateTodo(vararg todos: AddedFood)
}