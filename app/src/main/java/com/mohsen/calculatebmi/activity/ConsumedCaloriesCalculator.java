package com.mohsen.calculatebmi.activity;

import android.content.Context;

import android.os.Bundle;



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

        tabAdapter = new TabAdapter(getSupportFragmentManager(),this);

        tabAdapter.addFragment(new PersonalFoods(),"غذا های شخصی", tabIcons[2]);
        tabAdapter.addFragment(new FavouriteFoodsFragment(),"غذا های مورد علاقه", tabIcons[1]);
        tabAdapter.addFragment(new FoodCategoryFragment(),"لیست غذا ها",tabIcons[0]);
      //  setTabLayoutCustomTextView();
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
//        tabLayout.getTabAt(0).setIcon(tabIcons[2]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[0]);

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

}
