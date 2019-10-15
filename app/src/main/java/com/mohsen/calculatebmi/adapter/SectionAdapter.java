package com.mohsen.calculatebmi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mohsen.calculatebmi.Utils.ConstantsKt;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mohsen.calculatebmi.R;
import com.mohsen.calculatebmi.Utils.Section;
import com.mohsen.calculatebmi.db.entities.Food;
import com.mohsen.calculatebmi.model.AddedFood;
import com.shuhart.stickyheader.StickyAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionAdapter extends StickyAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder> {

    private List<AddedFood> foodList = new ArrayList<>();
    private Context context;

    public SectionAdapter(List<AddedFood> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }


    @Override
    public int getHeaderPositionForItem(int itemPosition) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        AddedFood model = foodList.get(i);
        ((HeaderViewholder) viewHolder).textView.setText("Header " + i);
        ((HeaderViewholder) viewHolder).textView.setText(model.getMeal() + model.getCalory() * model.getAmount());

    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return createViewHolder(parent, Section.HEADER);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == Section.HEADER || viewType == Section.CUSTOM_HEADER) {
            return new HeaderViewholder(inflater.inflate(R.layout.recycler_setction_header, parent, false));
        }
        return new ItemViewHolder(inflater.inflate(R.layout.recycler_row_item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AddedFood model = foodList.get(position);
        int type = model.getMeal();
        ((HeaderViewholder) holder).textView.setText(model.getMeal());
        ((ItemViewHolder) holder).amount.setText(model.getAmount());
        ((ItemViewHolder) holder).food_name.setText(model.getFood_name());
        ((ItemViewHolder) holder).unit.setText(model.getUnit());


//        switch (type){
//            case 0 :
//                ((HeaderViewholder) holder).textView.setText(model.getMeal() + model.getCalory() * model.getAmount());
//                ((ItemViewHolder) holder).amount.setText(model.getAmount());
//                ((ItemViewHolder) holder).food_name.setText(model.getFood_name());
//                ((ItemViewHolder) holder).unit.setText(model.getUnit());
//                break;
//            case 1 :
//                break;
//            case 2 :
//                break;
//            case 3 :
//                break;
//            case 4 :
//                break;
//        }

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
    public static class HeaderViewholder extends RecyclerView.ViewHolder {
        TextView textView;

        HeaderViewholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.header_title);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageButton edit, remove;
        TextView food_name, amount, unit;

        ItemViewHolder(View itemView) {
            super(itemView);
            food_name = itemView.findViewById(R.id.recycler_item_food_name);
            amount = itemView.findViewById(R.id.recycler_food_amount);
            unit = itemView.findViewById(R.id.recycler_food_unit);
            edit = itemView.findViewById(R.id.recycler_edit_button);
            remove = itemView.findViewById(R.id.recycler_remove_button);
        }
    }
}
