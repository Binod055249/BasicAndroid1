package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class TxtSwitcher extends AppCompatActivity implements View.OnClickListener {

    TextSwitcher txtSwitcher1,txtSwitcher2,txtSwitcher3;
    ImageButton btnPre1,btnNext1,btnPre2,btnNext2,btnPre3,btnNext3;

    String[] stringValues1={"Complete Android Developer Course","Complete ios Developer Course"};
    String[] stringValues2={"Complete Java Developer Course","Complete Swift Developer Course"};
    String[] stringValues3={"Complete Objective-C Developer Course","Complete JSP Developer Course"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt_switcher);

        txtSwitcher1=findViewById(R.id.txtSwitcher1);
        txtSwitcher2=findViewById(R.id.txtSwitcher2);
        txtSwitcher3=findViewById(R.id.txtSwitcher3);

        btnNext1=findViewById(R.id.btnNext1);
        btnNext2=findViewById(R.id.btnNext2);
        btnNext3=findViewById(R.id.btnNext3);
        btnPre1=findViewById(R.id.btnPre1);
        btnPre2=findViewById(R.id.btnPre2);
        btnPre3=findViewById(R.id.btnPre3);


        useTheAnimationForTextSwitcher(txtSwitcher1);
        useTheAnimationForTextSwitcher(txtSwitcher2);
        useTheAnimationForTextSwitcher(txtSwitcher3);
        createTextviewByIteratingOverTheValuesOfTheArrayForTextSwitcher(stringValues1,txtSwitcher1);
        createTextviewByIteratingOverTheValuesOfTheArrayForTextSwitcher(stringValues2,txtSwitcher2);
        createTextviewByIteratingOverTheValuesOfTheArrayForTextSwitcher(stringValues3,txtSwitcher3);

        btnPre1.setOnClickListener(this);
        btnPre2.setOnClickListener(this);
        btnPre3.setOnClickListener(this);
        btnNext1.setOnClickListener(this);
        btnNext2.setOnClickListener(this);
        btnNext3.setOnClickListener(this);

    }

    @Override
    public void onClick(View textView) {

        switch (textView.getId()){

            case R.id.btnPre1:
                txtSwitcher1.showPrevious();
                break;
            case R.id.btnPre2:
                txtSwitcher2.showPrevious();
                break;
            case R.id.btnPre3:
                txtSwitcher3.showPrevious();
                break;
            case R.id.btnNext1:
                txtSwitcher1.showNext();
                break;
            case R.id.btnNext2:
                txtSwitcher2.showNext();
                break;
            case R.id.btnNext3:
                txtSwitcher3.showNext();
                break;
        }
    }

    private void useTheAnimationForTextSwitcher(TextSwitcher textSwitcher){

        textSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
        textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
    }

    private void createTextviewByIteratingOverTheValuesOfTheArrayForTextSwitcher(String[] stringValues,
                                                                                 TextSwitcher textSwitcher){

        for(int index=0;index< stringValues.length;index++){
            TextView textView=new TextView(this);
            textView.setText(stringValues[index]);
            textView.setTextColor(Color.BLUE);
            textView.setTextSize(60f);
            textSwitcher.addView(textView);
        }
    }
}