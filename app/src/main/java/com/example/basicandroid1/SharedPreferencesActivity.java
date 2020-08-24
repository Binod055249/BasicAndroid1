package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class SharedPreferencesActivity extends AppCompatActivity {

    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

         checkBox=findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    checkBox.setText("The CheckBox is checked");
                }else{
                    checkBox.setText("The checkbox is not checked");
                }

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "The onPause method is called", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences=getPreferences(0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("CHECKBOX_TEXT_VALUE",checkBox.getText().toString());
        editor.putBoolean("CHECKBOX_VALUE",checkBox.isChecked());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "The onResume method is called", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPreferences=getPreferences(0);
        boolean checkBoxValue=sharedPreferences.getBoolean("CHECKBOX_VALUE",false);
        String checkBoxStringValue=sharedPreferences.getString("CHECKBOX_TEXT_VALUE","This is my checkBox");
        checkBox.setChecked(checkBoxValue);
        checkBox.setText(checkBoxStringValue);
    }
}