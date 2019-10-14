package com.mohsen.calculatebmi.dialogs

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import com.mohsen.calculatebmi.R
import com.mohsen.calculatebmi.activity.ConsumedCaloriesCalculator
import kotlinx.android.synthetic.main.food_item.*

class AddFoodDialog(val mContext : Context): Dialog(mContext) {

    private val BREAKFAST = "صبحانه"
    private val LAUNCH = "نهار"
    private val DINNER = "شام"
    private val MIANVADE = "میان وعده"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.food_item)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

        breakfast.setOnClickListener{
            val intent = Intent(context,ConsumedCaloriesCalculator::class.java)
            intent.putExtra("type",BREAKFAST)
            context.startActivity(intent)
        }

        dinner.setOnClickListener {
            val intent = Intent(context,ConsumedCaloriesCalculator::class.java)
            intent.putExtra("type",DINNER)
            context.startActivity(intent)
        }

        launch.setOnClickListener{
            val intent = Intent(context,ConsumedCaloriesCalculator::class.java)
            intent.putExtra("type",LAUNCH)
            context.startActivity(intent)
        }
        middle_meal.setOnClickListener {
            val intent = Intent(context,ConsumedCaloriesCalculator::class.java)
            intent.putExtra("type",MIANVADE)
            context.startActivity(intent)
        }



    }

}