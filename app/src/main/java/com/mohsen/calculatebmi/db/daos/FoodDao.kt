package com.mohsen.calculatebmi.db.daos

import androidx.room.*
import com.mohsen.calculatebmi.db.entities.Food

@Dao
interface FoodDao {

    @Query("select * from food_items")
    suspend fun getAll(): List<Food>

    @Query("SELECT * FROM food_items WHERE food_name LIKE :title")
    suspend fun findByTitle(title: String): Food

//    @Query("SELECT * FROM food_items WHERE category LIKE :category")
//    fun findByCategory(category: String)

    @Insert
    suspend fun insertAll(vararg todo: Food)

    @Delete
    suspend fun delete(todo: Food)

    @Update
    suspend fun updateTodo(vararg todos: Food)

}