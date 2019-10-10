package com.mohsen.calculatebmi.Utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mohsen.calculatebmi.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomImageView extends View {
    private Context mContext;
    private View rootView;
    private TextView description;
    private CircleImageView imageView;
    public CustomImageView(Context context) {
        super(context);
        mContext = context;
        description = rootView.findViewById(R.id.root_text_view);
        imageView = rootView.findViewById(R.id.root_image_view);
    }

    public void setDescription(String description){
        this.description.setText(description);
    }

    public void setImageView(int imageId){
        imageView.setImageResource(imageId);
    }




}
