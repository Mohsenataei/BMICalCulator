package com.mohsen.calculatebmi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mohsen.calculatebmi.R;
import com.mohsen.calculatebmi.activity.ui.CaloriesMainPage;
import com.xw.repo.BubbleSeekBar;

import at.grabner.circleprogress.CircleProgressView;

public class CalculateBMI extends AppCompatActivity implements BubbleSeekBar.OnProgressChangedListener {

    private static final int MIN_HEIGHT = 130;
    private static final int MAX_HEIGHT = 220;
    private static final int MIN_WEIGHT = 35;
    private static final int MAX_WEIGHT = 200;
    private static final int DEFAULT_HEIGHT = 175;
    private static final int DEFAULT_WEIGHT = 70;

    BubbleSeekBar hightSB;
    BubbleSeekBar wightSB;
    CircleProgressView bmiProgressV;
    TextView hightTV;
    TextView weightTV;
    TextView resultDescriptionTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);


        hightSB = findViewById(R.id.bmi_seekbar_hight);
        wightSB = findViewById(R.id.bmi_seekbar_weight);
        bmiProgressV = findViewById(R.id.bmi_progress);
        hightTV = findViewById(R.id.bmi_hight);
        weightTV = findViewById(R.id.bmi_weight);
        resultDescriptionTV = findViewById(R.id.bmi_result_description);
        resultDescriptionTV.setOnClickListener(view ->{
            startActivity(new Intent(CalculateBMI.this,ConsumedCaloriesCalculator.class));
        });

        hightSB.setOnProgressChangedListener(this);
        wightSB.setOnProgressChangedListener(this);
        ///FloatingActionButton fab = findViewById(R.id.add);

        findViewById(R.id.bmi_result_title).setOnClickListener(view ->{
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, CaloriesMainPage.class));
        });
        setDefaults();
    }

    private void setDefaults() {
        hightSB.getConfigBuilder()
                .min(MIN_HEIGHT)
                .max(MAX_HEIGHT)
                .build();

        wightSB.getConfigBuilder()
                .min(MIN_WEIGHT)
                .max(MAX_WEIGHT)
                .build();

        hightSB.setProgress(DEFAULT_HEIGHT);
        wightSB.setProgress(DEFAULT_WEIGHT);
    }

    private void calculateBMI(){
        int hight = hightSB.getProgress();
        int wight = wightSB.getProgress();

        float hightMeter = (float) hight / 100;

        hightTV.setText(Integer.toString(hight));
        weightTV.setText(Integer.toString(wight));
        int bmi = (int) (wight / (hightMeter * hightMeter));
        bmiProgressV.setValueAnimated(bmi);

        //insure its a text and will be shown as english digits on all phones.
        bmiProgressV.setText(Integer.toString(bmi));

        int descriptionResource = -1;

        if(bmi > 40)
            descriptionResource = R.string.bmi_more_than_40_description;

        else if (bmi > 30)
            descriptionResource = R.string.bmi_30_to_40_description;

        else if (bmi > 25)
            descriptionResource = R.string.bmi_25_to_30_description;

        else if (bmi > 20)
            descriptionResource = R.string.bmi_20_to_25_description;

        else if (bmi > 18.5)
            descriptionResource = R.string.bmi_18_5_to_20_description;

        else
            descriptionResource = R.string.bmi_below_18_5_description;


        resultDescriptionTV.setText(descriptionResource);

    }
    @Override
    public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
        calculateBMI();

    }

    @Override
    public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

    }

    @Override
    public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

    }
}
