package com.mohsen.calculatebmi.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mohsen.calculatebmi.R;
import com.mohsen.calculatebmi.adapter.TabAdapter;
import com.mohsen.calculatebmi.fragments.FavouriteFoodsFragment;
import com.mohsen.calculatebmi.fragments.FoodCategoryFragment;
import com.mohsen.calculatebmi.fragments.PersonalFoods;




public class ConsumedCaloriesCalculator extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter tabAdapter;

    private int[] tabIcons = {
            R.drawable.ic_add_black_24dp,
            R.drawable.ic_star_border_black_24dp,
            R.drawable.ic_person_add_black_24dp
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories_activity);

        tabLayout = findViewById(R.id.calories_tab);
        viewPager = findViewById(R.id.viewpager);

        tabAdapter = new TabAdapter(getSupportFragmentManager());

        tabAdapter.addFragment(new PersonalFoods(),"غذا های شخصی");
        tabAdapter.addFragment(new FavouriteFoodsFragment(),"غذا های مورد علاقه");
        tabAdapter.addFragment(new FoodCategoryFragment(),"لیست غذا ها");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.bmi_below_18_5));
        tabLayout.setSelectedTabIndicatorHeight(5);



        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[2]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[0]);
        viewPager.setCurrentItem(2);

    }
}
