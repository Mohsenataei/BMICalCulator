package com.mohsen.calculatebmi.dialogs

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.mohsen.calculatebmi.R
import com.mohsen.calculatebmi.constants.Calories.Companion.ASH_DOOGH
import com.mohsen.calculatebmi.constants.Calories.Companion.ASH_JOO
import com.mohsen.calculatebmi.constants.Calories.Companion.OIL
import com.mohsen.calculatebmi.constants.Calories.Companion.PEANUTS
import com.mohsen.calculatebmi.constants.CaloriesList
import kotlinx.android.synthetic.main.get_consumed_food_dialog.*

class ConsumedFoodDialog(context: Context, food_title: String, type: Int) : Dialog(context){

    val hashMap: HashMap<String, Int> = HashMap()
    val caloriesList = CaloriesList()
    val food = food_title
    val key:  String? = null
    val dilogType = type
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.get_consumed_food_dialog)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        instantiateHashMap()

        //counsumed_amount_edit_text.addTextChangedListener()
        gram_edit_text.setOnClickListener {
            if (counsumed_amount_edit_text.text.isNullOrEmpty()){
                Toast.makeText(context,"please enter a amount",Toast.LENGTH_SHORT).show()
            }else{
                val amount = counsumed_amount_edit_text.text
                val calory = (amount.toString().toInt() * caloriesList.getData(food)) / 100

                Consumed_calories_text_view.text = "کالری: $calory"
                val proteins = calory / 100
                Consumed_proteins_text_view.text = "پروتئین $proteins گرم "
            }

        }

        if (food.isNullOrEmpty()){
            Toast.makeText(context,"title not set", Toast.LENGTH_SHORT).show()

        }else {
            food_name.text = food
        }

        when(dilogType){
            0 -> {
                Toast.makeText(context,"شما در حال انتخاب صبحانه هستید", Toast.LENGTH_SHORT).show()
            }
            1->{
                Toast.makeText(context,"شما در حال انتخاب نهار هستید", Toast.LENGTH_SHORT).show()
            }
            2 ->{
                Toast.makeText(context,"شما در حال انتخاب میان وعده هستید", Toast.LENGTH_SHORT).show()
            }
            3 ->{
                Toast.makeText(context,"شما در حال انتخاب شام هستید", Toast.LENGTH_SHORT).show()
            }
        }


    }


    private fun instantiateHashMap(){
        hashMap.put(ASH_JOO,250)
        hashMap.put(ASH_DOOGH,250)
        hashMap.put(PEANUTS,15)
        hashMap.put(OIL,600)
        hashMap.put("مربا", 450)
//        hashMap.put(Resources.getSystem().getString(R.string.app_name),230)
        caloriesList.setCaloriesMap(hashMap)

    }
}