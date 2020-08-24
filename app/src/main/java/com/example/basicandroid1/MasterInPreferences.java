package com.example.basicandroid1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MasterInPreferences extends AppCompatActivity {

    private TextView txtNumber1,txtNumber2,txtNumber3;

    Typeface font1,font2,font3;
    String txtView1Size,txtView2Size,txtView3Size;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_in_preferences);

        txtNumber1=findViewById(R.id.txtNumber1);
        txtNumber2=findViewById(R.id.txtNumber2);
        txtNumber3=findViewById(R.id.txtNumber3);

        font1= Typeface.createFromAsset(getAssets(),"fonts/font1.otf");
        font2= Typeface.createFromAsset(getAssets(),"fonts/font2.ttf");
        font3= Typeface.createFromAsset(getAssets(),"fonts/font3.otf");

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);



    }

    public void specifyTheFontForTextView1(){
        boolean font1ForText1Value,font2ForText1Value,font3ForText1Value;
        font1ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT1",false);
        font2ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT1",false);
        font3ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT1",false);

        if(font1ForText1Value){

            txtNumber1.setTypeface(font1);

        }else if(font2ForText1Value){

            txtNumber1.setTypeface(font2);

        }else if(font3ForText1Value) {

            txtNumber1.setTypeface(font3);

        }

    }
    public void specifyTheFontForTextView2(){
        boolean font1ForText1Value,font2ForText1Value,font3ForText1Value;
        font1ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT2",false);
        font2ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT2",false);
        font3ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT2",false);

        if(font1ForText1Value){

            txtNumber2.setTypeface(font1);

        }else if(font2ForText1Value){

            txtNumber2.setTypeface(font2);

        }else if(font3ForText1Value) {

            txtNumber2.setTypeface(font3);

        }

    }
    public void specifyTheFontForTextView3(){
        boolean font1ForText1Value,font2ForText1Value,font3ForText1Value;
        font1ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT3",false);
        font2ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT3",false);
        font3ForText1Value=sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT3",false);

        if(font1ForText1Value){

            txtNumber3.setTypeface(font1);

        }else if(font2ForText1Value){

            txtNumber3.setTypeface(font2);

        }else if(font3ForText1Value) {

            txtNumber3.setTypeface(font3);

        }

    }

    public void specifyTheSizeForTextView1(){

        txtView1Size=sharedPreferences.getString("FONT_SIZE_TEXT1","20");
        txtNumber1.setTextSize(Float.parseFloat(txtView1Size));
    }
    public void specifyTheSizeForTextView2(){

        txtView2Size=sharedPreferences.getString("FONT_SIZE_TEXT2","20");
        txtNumber2.setTextSize(Float.parseFloat(txtView2Size));
    }
    public void specifyTheSizeForTextView3(){

        txtView3Size=sharedPreferences.getString("FONT_SIZE_TEXT3","20");
        txtNumber3.setTextSize(Float.parseFloat(txtView3Size));
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume method is called", Toast.LENGTH_SHORT).show();
        specifyTheFontForTextView1();
        specifyTheFontForTextView2();
        specifyTheFontForTextView3();

        specifyTheSizeForTextView3();
        specifyTheSizeForTextView2();
        specifyTheSizeForTextView1();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_prefernces,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.settingPreferences:

                Intent intent =new Intent(MasterInPreferences.this,PreferencesActivity.class);
                startActivity(intent);

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}