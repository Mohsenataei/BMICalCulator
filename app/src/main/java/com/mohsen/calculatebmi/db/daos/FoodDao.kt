package com.mohsen.calculatebmi.db.daos

import androidx.room.*
import com.mohsen.calculatebmi.db.entities.Food

@Dao
interface FoodDao {

    @Query("select * from food_items")
    fun getAll(): List<Food>

    @Query("SELECT * FROM food_items WHERE food_name LIKE :title")
    fun findByTitle(title: String): Food

    @Insert
    fun insertAll(vararg todo: Food)

    @Delete
    fun delete(todo: Food)

    @Update
    fun updateTodo(vararg todos: Food)

}