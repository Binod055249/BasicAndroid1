package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoveFromView extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_from_view);


    Button btnSecondActivity=findViewById(R.id.btnSecondActivity);

    btnSecondActivity.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(this,MoveToSecondView.class);
        startActivity(intent);
        finish();

    }
}