package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UsingFonts extends AppCompatActivity implements View.OnClickListener{

    Typeface fontName1,fontName2;
    TextView txtFontCheck;
    Button btnFont1,btnFont2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_fonts);

        txtFontCheck=findViewById(R.id.txtFontcheck);
         btnFont1=findViewById(R.id.btnFont1);
         btnFont2=findViewById(R.id.btnFont2);

        fontName1=Typeface.createFromAsset(getAssets(), "fonts/font1.otf");
        fontName2=Typeface.createFromAsset(getAssets(), "fonts/font2.ttf");

        btnFont1.setOnClickListener(this);
        btnFont2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnFont1:
                txtFontCheck.setTypeface(fontName1);
                txtFontCheck.setTextSize(60f);
                break;

            case R.id.btnFont2 :
                txtFontCheck.setTypeface(fontName2);
                txtFontCheck.setTextSize(30f);
                break;
        }
    }
}