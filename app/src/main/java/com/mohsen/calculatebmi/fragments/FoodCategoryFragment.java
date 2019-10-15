package com.mohsen.calculatebmi.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.mohsen.calculatebmi.R;
import com.mohsen.calculatebmi.Utils.OnDialogClicked;
import com.mohsen.calculatebmi.adapter.CustomExpandableListAdapter;
import com.mohsen.calculatebmi.dialogs.ConsumedFoodDialog;
import com.mohsen.calculatebmi.model.AddedFood;
import com.mohsen.calculatebmi.model.ExpandableListDataPump;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodCategoryFragment extends BaseFragment {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;
     private static final int BREAKFAST = 0;
     private static final int LUANCH = 1;
     private static final int DINNER = 2;
     private static final int MIANVADE = 3;
     private List<AddedFood> selectedFoods =new ArrayList<>();

     private String meal;
    private static final String TAG = "ConsumedCaloriesCalcula";



    public FoodCategoryFragment() {
        // Required empty public constructor
    }

    public List<AddedFood> getSelectedFoods(){
        return selectedFoods;
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        assert getArguments() != null;
        meal = getArguments().getString("type");
        if (meal == null){
            Log.d(TAG, "onCreateView: damn it, what the hell is going wrong ?");
            meal = "کله ";
        }
        return inflater.inflate(R.layout.fragment_food_category, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        expandableListView =  view.findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(getContext(),expandableListTitle,expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                ConsumedFoodDialog consumedFoodDialog = new ConsumedFoodDialog(getContext(),
                        expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition),
                        meal,
                        new OnDialogClicked() {
                            @Override
                            public void onClick(AddedFood addedFood) {
                                Toast.makeText(getContext(), "do something", Toast.LENGTH_SHORT).show();
                                selectedFoods.add(addedFood);

                            }
                        }
                );


                consumedFoodDialog.show();

                return false;
            }
        });
        Toast.makeText(getContext(), "number of items" + selectedFoods.size(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "number of items" + selectedFoods.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

