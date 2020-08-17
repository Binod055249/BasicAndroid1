package com.example.basicandroid1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MoveToSecondView extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_to_second_view);

       Button btnFirstActivity=findViewById(R.id.btnFirstActivity);

       btnFirstActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(this,MoveFromView.class);
        startActivity(intent);
       finish();
    }
}
