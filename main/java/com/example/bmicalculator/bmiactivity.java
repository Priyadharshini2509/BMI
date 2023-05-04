package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {

    TextView bmidisplay,bmicategory,gender;
    Button gotomain;
    Intent intent;

    ImageView imageview;
    String bmi;
    String category;
    float bmin;

    String height;
    String weight;

    float intheight,intweight;

    RelativeLayout background;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().setElevation(0);
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");


        intent=getIntent();
        bmidisplay=findViewById(R.id.bmidisplay);
        bmicategory = findViewById(R.id.bmicategorydispaly);
        gotomain=findViewById(R.id.gotomain);
        imageview=findViewById(R.id.imageview);
        gender=findViewById(R.id.genderdisplay);
        background=findViewById(R.id.contentlayout);
        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");
        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);
        intheight=intheight/100;
        bmin=intweight/(intheight*intheight);

        bmi=Float.toString(bmin);
        System.out.println(bmi);

        if(bmin<16)
        {
            bmicategory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageview.setImageResource(R.drawable.crosss);
        }
        else if(bmin<16.9 && bmin>16)
        {
            bmicategory.setText("Moderate Thinness");
            background.setBackgroundColor(R.color.halfwarn);
            imageview.setImageResource(R.drawable.warning);
        }
        else if(bmin<18.4 && bmin>17)
        {
            bmicategory.setText("Mild Thinness");
            background.setBackgroundColor(R.color.halfwarn);
            imageview.setImageResource(R.drawable.warning);
        }
        else if(bmin<24.9 && bmin>18.5 )
        {
            bmicategory.setText("Normal");
            imageview.setImageResource(R.drawable.ok);

        }
        else if(bmin<29.9 && bmin>25)
        {
            bmicategory.setText("Overweight");
            background.setBackgroundColor(R.color.halfwarn);
            imageview.setImageResource(R.drawable.warning);
        }
        else if(bmin<34.9 && bmin>30) {
            bmicategory.setText("Obese Class I");
            background.setBackgroundColor(R.color.halfwarn);
            imageview.setImageResource(R.drawable.warning);
        }
        else
        {
            bmicategory.setText("Obese Class II");
            background.setBackgroundColor(R.color.warn);
            imageview.setImageResource(R.drawable.crosss);
        }
        gender.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(bmi);

        gotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
