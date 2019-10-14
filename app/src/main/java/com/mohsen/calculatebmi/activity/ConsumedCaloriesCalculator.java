package com.mohsen.calculatebmi.activity;

import android.content.Context;

import android.os.Bundle;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mohsen.calculatebmi.R;
import com.mohsen.calculatebmi.adapter.TabAdapter;
import com.mohsen.calculatebmi.fragments.FavouriteFoodsFragment;
import com.mohsen.calculatebmi.fragments.FoodCategoryFragment;
import com.mohsen.calculatebmi.fragments.PersonalFoods;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class ConsumedCaloriesCalculator extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter tabAdapter;
    private static final String TAG = "ConsumedCaloriesCalcula";
    private String mealType;


    private int[] tabIcons = {
            R.drawable.ic_add_black_24dp,
            R.drawable.ic_star_border_black_24dp,
            R.drawable.ic_person_add_black_24dp
    };

    @Override
    protected void onResume() {
        super.onResume();
        mealType = getMeal();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories_activity);

        tabLayout = findViewById(R.id.calories_tab);
        viewPager = findViewById(R.id.viewpager);

        tabAdapter = new TabAdapter(getSupportFragmentManager(),this);

        mealType =  getMeal();
        if(mealType.isEmpty()){
            Log.d(TAG, "onCreate: string extra founded");
        }else {
            Log.d(TAG, "onCreate: string extra not retrieve successfully");
        }
//        if (getIntent().hasExtra("type")){
//            mealType = getIntent().getStringExtra("type");
//            Log.d(TAG, "onCreate: string extra founded"+mealType);
//        }else {
//            mealType = "کله پاچه";
//        }


        Bundle bundle = new Bundle();
        bundle.putString("type",mealType);
        FoodCategoryFragment foodCategoryFragment = new FoodCategoryFragment();
        foodCategoryFragment.setArguments(bundle);
        tabAdapter.addFragment(new PersonalFoods(),"غذا های شخصی", tabIcons[2]);
        tabAdapter.addFragment(new FavouriteFoodsFragment(),"غذا های مورد علاقه", tabIcons[1]);
        tabAdapter.addFragment(foodCategoryFragment,"لیست غذا ها",tabIcons[0]);

        viewPager.setAdapter(tabAdapter);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(tabAdapter.getTabView(i));
        }
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.bmi_below_18_5));
        tabLayout.setSelectedTabIndicatorHeight(5);




        tabLayout.setupWithViewPager(viewPager);
        highLightCurrentTab(2);

        viewPager.setCurrentItem(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(tabAdapter.getTabView(i));
        }
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(tabAdapter.getSelectedTabView(position));
    }
    private String getMeal (){
        if (getIntent().hasExtra("type")){
            Log.d(TAG, "getMeal: string extra founded");
            return getIntent().getStringExtra("type");
        }
        return "asghar";
    }


}
