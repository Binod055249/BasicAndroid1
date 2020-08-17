package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class UserInterface extends AppCompatActivity implements View.OnClickListener{

    private TextView txtValue;
    private EditText edtValue;
    private AutoCompleteTextView autoCompleteTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;

    String[] courseName={"Android course","ios course","java course","Java Developer course","Java core","Advanced Java"};
    ArrayAdapter<String> myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);

        txtValue=findViewById(R.id.txtValue);
        edtValue=findViewById(R.id.edtValue);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView=findViewById(R.id.multiAutoCompleteTextView);

        txtValue.setText("Awesome!");
        txtValue.setBackgroundColor(Color.BLUE);

        txtValue.setOnClickListener(UserInterface.this);
        edtValue.setOnClickListener(this);

        myAdapter=new ArrayAdapter<String>(UserInterface.this,android.R.layout.simple_list_item_1,courseName);
          autoCompleteTextView.setAdapter(myAdapter);
          multiAutoCompleteTextView.setAdapter(myAdapter);
          multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.txtValue:
                txtValue.setTextColor(Color.RED);
                break;
            case R.id.edtValue:
                txtValue.setText(edtValue.getText().toString());
        }

    }
}