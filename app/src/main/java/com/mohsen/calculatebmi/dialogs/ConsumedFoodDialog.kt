package com.mohsen.calculatebmi.dialogs

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.mohsen.calculatebmi.R
import com.mohsen.calculatebmi.constants.Calories.Companion.AJIL
import com.mohsen.calculatebmi.constants.Calories.Companion.AJIL_DARHAM
import com.mohsen.calculatebmi.constants.Calories.Companion.ARD_GANDOM
import com.mohsen.calculatebmi.constants.Calories.Companion.ARD_ZORRAT
import com.mohsen.calculatebmi.constants.Calories.Companion.ASH_DOOGH
import com.mohsen.calculatebmi.constants.Calories.Companion.ASH_JOO
import com.mohsen.calculatebmi.constants.Calories.Companion.ASH_RESHTE
import com.mohsen.calculatebmi.constants.Calories.Companion.BADEMJAN
import com.mohsen.calculatebmi.constants.Calories.Companion.BISCOEIT
import com.mohsen.calculatebmi.constants.Calories.Companion.OIL
import com.mohsen.calculatebmi.constants.Calories.Companion.PEANUTS
import com.mohsen.calculatebmi.constants.CaloriesList
import com.mohsen.calculatebmi.constants.TYPE_SPOON
import com.mohsen.calculatebmi.db.AppDatabase
import com.mohsen.calculatebmi.model.Food
import kotlinx.android.synthetic.main.get_consumed_food_dialog.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ConsumedFoodDialog(context: Context, food_title: String, type: String) : Dialog(context){

    val hashMap: HashMap<String, Int> = HashMap()
    val caloriesList = CaloriesList()
    val food = food_title
    val key:  String? = null
    val dilogType = type
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "todo-list.db"
    ).build()
    //val db1 = Room.databaseBuilder(context,Food::class.java,"appDAtabase.db")

    val foodlist = arrayListOf<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.get_consumed_food_dialog)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        instantiateHashMap()
        initailFoodList()

        //
        ///db.foodDao()
        //counsumed_amount_edit_text.addTextChangedListener()
        GlobalScope.launch {
//            Toast.makeText(context,"is it working ?",Toast.LENGTH_SHORT).show()
//            db.foodDao().insertAll(com.mohsen.calculatebmi.db.entities.Food(1,"pizza",236,"type"))
            println("worked ?")

        }
        confirm.setOnClickListener {
            if (counsumed_amount_edit_text.text.isNullOrEmpty()){
                Toast.makeText(context,"please enter a amount",Toast.LENGTH_SHORT).show()
            }else{
                val amount = counsumed_amount_edit_text.text
                val calory = (hashMap[food]?.times(amount.toString().toInt()))?.div(100)

                    (amount.toString().toInt() * caloriesList.getData(food)) / 100

                Consumed_calories_text_view.text = "کالری: $calory"
                val proteins = calory?.div(100)
                Consumed_proteins_text_view.text = "پروتئین $proteins گرم "
            }

        }
//        glass_edit_text.setOnClickListener {
//
//        }

        if (food.isNullOrEmpty()){
            Toast.makeText(context,"title not set", Toast.LENGTH_SHORT).show()

        }else {
            food_name.text = food
        }

        Toast.makeText(context,"شما در حال انتخاب $dilogType  هستید", Toast.LENGTH_SHORT).show()
//        when(dilogType){
//            0 -> {
//                Toast.makeText(context,"شما در حال انتخاب صبحانه هستید", Toast.LENGTH_SHORT).show()
//            }
//            1->{
//                Toast.makeText(context,"شما در حال انتخاب نهار هستید", Toast.LENGTH_SHORT).show()
//            }
//            2 ->{
//                Toast.makeText(context,"شما در حال انتخاب میان وعده هستید", Toast.LENGTH_SHORT).show()
//            }
//            3 ->{
//                Toast.makeText(context,"شما در حال انتخاب شام هستید", Toast.LENGTH_SHORT).show()
//            }
//        }


    }


    private fun instantiateHashMap(){
        hashMap.put(ASH_JOO,250)
        hashMap.put(ASH_DOOGH,250)
        hashMap.put(ASH_RESHTE,250)
        hashMap.put(AJIL,560)
        hashMap.put(AJIL_DARHAM,450)
        hashMap.put(ARD_ZORRAT,370)
        hashMap.put(ARD_GANDOM,360)
        hashMap.put(BISCOEIT,370)
        hashMap.put(BADEMJAN,17)
        hashMap.put("آبنبات", 20)
        hashMap.put(PEANUTS,15)
        hashMap.put(OIL,600)
        hashMap.put("مربا", 450)
//        hashMap.put(Resources.getSystem().getString(R.string.app_name),230)
        caloriesList.setCaloriesMap(hashMap)

    }

    private fun initailFoodList(){
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
        foodlist.add(Food("عسل",350, TYPE_SPOON))
    }
}