package com.mohsen.calculatebmi.activity.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mohsen.calculatebmi.R;
import com.mohsen.calculatebmi.dialogs.AddFoodDialog;

public class CaloriesMainPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories_main_page);
        AddFoodDialog addFoodDialog = new AddFoodDialog(this);
        findViewById(R.id.adFoodButton).setOnClickListener(view ->{
            addFoodDialog.show();
        });
    }
}
