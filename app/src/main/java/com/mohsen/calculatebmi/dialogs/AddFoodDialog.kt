package com.mohsen.calculatebmi.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import com.mohsen.calculatebmi.R
import com.mohsen.calculatebmi.constants.Calories

class AddFoodDialog(val mContext : Context): Dialog(mContext) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.food_item)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

    }

}