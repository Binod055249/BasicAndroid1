package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class WidgetComponents extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, RatingBar.OnRatingBarChangeListener,RadioGroup.OnCheckedChangeListener{

    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8;
    private SeekBar seekBar;
    private RatingBar ratingBar;
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2,radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_components);

        checkBox1=findViewById(R.id.checkBox1);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        checkBox5=findViewById(R.id.checkBox5);
        checkBox6=findViewById(R.id.checkBox6);
        checkBox7=findViewById(R.id.checkBox7);
        checkBox8=findViewById(R.id.checkBox8);

        seekBar=findViewById(R.id.seekBar);
        ratingBar=findViewById(R.id.ratingBar);

        radioGroup=findViewById(R.id.radioGroup);
        radioButton1=findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton3);


        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);
        checkBox5.setOnCheckedChangeListener(this);
        checkBox6.setOnCheckedChangeListener(this);
        checkBox7.setOnCheckedChangeListener(this);
        checkBox8.setOnCheckedChangeListener(this);

        seekBar.setOnSeekBarChangeListener(this);

        ratingBar.setOnRatingBarChangeListener(this);

        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch(buttonView.getId()){

            case R.id.checkBox1:
                if(isChecked){
                    Toast.makeText(this, "Boxing! is Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox2:
                if(isChecked){
                    Toast.makeText(this, "KickBoxing! is Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox3:
                if(isChecked){
                    Toast.makeText(this, "Judo! is Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox4:
                if(isChecked){
                    Toast.makeText(this, "Aikido! is Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox5:
                if(isChecked){
                    Toast.makeText(this, "Football! is Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox6:
                if(isChecked){
                    Toast.makeText(this, "Taekwondo! is Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox7:
                if(isChecked){
                    Toast.makeText(this, "Wrestling! is Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox8:
                if(isChecked){
                    Toast.makeText(this, "Swimming! is Checked", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(this, "The current value of The SeekBar is: "+progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this, "Now the SeekBar is Started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this, "Now the SeekBar is stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(this, "The value of Stars are: "+rating, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){

            case R.id.radioButton1:
                Toast.makeText(this, "Android is Checked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(this, "iOS is checked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                Toast.makeText(this, "Windows Phone is checked!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}