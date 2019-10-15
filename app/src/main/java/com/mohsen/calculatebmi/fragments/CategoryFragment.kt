package com.mohsen.calculatebmi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.mohsen.calculatebmi.R
import com.mohsen.calculatebmi.Utils.OnDialogClicked
import com.mohsen.calculatebmi.adapter.CustomExpandableListAdapter
import com.mohsen.calculatebmi.dialogs.ConsumedFoodDialog
import com.mohsen.calculatebmi.model.AddedFood
import com.mohsen.calculatebmi.model.ExpandableListDataPump
import kotlinx.android.synthetic.main.fragment_food_category.*
import kotlinx.coroutines.launch
import java.util.HashMap


class CategoryFragment: BaseFragment() {
    private var expandableListTitle: List<String>? = null
    private var expandableListDetail: HashMap<String, List<String>>? = null
    private var expandableListAdapter: ExpandableListAdapter? = null
    private val BREAKFAST = 0
    private val LUANCH = 1
    private val DINNER = 2
    private val MIANVADE = 3
    private val selectedFoods = java.util.ArrayList<AddedFood>()

    private var meal: String? = null
    private val TAG = "ConsumedCaloriesCalcula"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expandableListDetail = ExpandableListDataPump.getData()
        expandableListTitle = ArrayList<String>((expandableListDetail as HashMap<String, MutableList<String>>?)!!.keys)
        expandableListAdapter =
            CustomExpandableListAdapter(context, expandableListTitle, expandableListDetail)
        expandableListView.setAdapter(expandableListAdapter)


        expandableListView.setOnGroupExpandListener(ExpandableListView.OnGroupExpandListener { groupPosition ->
            Toast.makeText(
                context,
                (expandableListTitle as ArrayList<String>).get(groupPosition) + " List Expanded.",
                Toast.LENGTH_SHORT
            ).show()
        })
        expandableListView.setOnGroupCollapseListener(ExpandableListView.OnGroupCollapseListener { groupPosition ->
            Toast.makeText(
                context,
                (expandableListTitle as ArrayList<String>).get(groupPosition) + " List Collapsed.",
                Toast.LENGTH_SHORT
            ).show()
        })

        expandableListView.setOnChildClickListener(ExpandableListView.OnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(
                context,
                (expandableListTitle as ArrayList<String>).get(groupPosition)
                        + " -> "
                        + (expandableListDetail as HashMap<String, MutableList<String>>?)!!.get(
                    (expandableListTitle as ArrayList<String>).get(groupPosition)
                )!!.get(
                    childPosition
                ), Toast.LENGTH_SHORT
            ).show()
            val consumedFoodDialog = meal?.let {
                ConsumedFoodDialog(
                    context!!,
                    (expandableListDetail as HashMap<String, MutableList<String>>?)!!.get(
                        (expandableListTitle as ArrayList<String>).get(groupPosition)
                    )!!.get(
                        childPosition
                    ),
                    it,
                    OnDialogClicked { addedFood ->
                        Toast.makeText(context, "do something", Toast.LENGTH_SHORT).show()
                        selectedFoods.add(addedFood)
                        launch {

                        }
                    }
                )
            }


            consumedFoodDialog?.show()

            false
        })
        Toast.makeText(context, "number of items" + selectedFoods.size, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_category, container, false)
    }
}