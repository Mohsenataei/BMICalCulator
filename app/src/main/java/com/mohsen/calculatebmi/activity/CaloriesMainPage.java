package com.mohsen.calculatebmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mohsen.calculatebmi.R;
import com.mohsen.calculatebmi.adapter.SectionAdapter;
import com.mohsen.calculatebmi.db.AppDatabase;
import com.mohsen.calculatebmi.db.daos.AddedFoodDao;
import com.mohsen.calculatebmi.dialogs.AddFoodDialog;
import com.mohsen.calculatebmi.dialogs.ConsumedFoodDialog;
import com.mohsen.calculatebmi.model.AddedFood;
import com.shuhart.stickyheader.StickyHeaderItemDecorator;

import java.util.ArrayList;
import java.util.List;

public class CaloriesMainPage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager linearLayoutManager;
    private SectionAdapter sectionAdapter;
    private List<AddedFood> foodList = new ArrayList<>();
    private AppDatabase appDatabase;
    private AddedFoodDao addedFoodDao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories_main_page);
        appDatabase = AppDatabase.Companion.getDatabase(this);
        addedFoodDao = appDatabase.addedFoodDao();

       // AddFoodDialog addFoodDialog = new AddFoodDialog(this);
        AddFoodDialog addFoodDialog = new AddFoodDialog(this);
        findViewById(R.id.adFoodButton).setOnClickListener(view ->{
//           // addFoodDialog.show();
//            addFoodDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//
//            addFoodDialog.show();
            startActivityForResult(new Intent(CaloriesMainPage.this, ConsumedCaloriesCalculator.class),1);
        });

        recyclerView = findViewById(R.id.consumed_food_recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        for (int i =0; i<25 ; i++){
            foodList.add(new AddedFood("پیتزا",150,"عدد",7,"نهار",0));
        }
       // sectionAdapter = new SectionAdapter(foodList,this);

//        DividerItemDecoration dividerDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerDecorator);
//
//
//        recyclerView.setAdapter(sectionAdapter);
//        StickyHeaderItemDecorator decorator = new StickyHeaderItemDecorator(sectionAdapter);
//        decorator.attachToRecyclerView(recyclerView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "on Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "on Restart", Toast.LENGTH_SHORT).show();
    }
}
