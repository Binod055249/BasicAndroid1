package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecivingInfoActivity extends AppCompatActivity {

    private ImageView imgAnimalReceived;
    private TextView txtNameReceived,txtEmailReceived,txtUsernameReceived,txtPasswordReceived,txtGenderReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciving_info);

        imgAnimalReceived=findViewById(R.id.imgAnimalReceived);
        txtEmailReceived=findViewById(R.id.txtEmailReceived);
        txtGenderReceived=findViewById(R.id.txtGenderReceived);
        txtNameReceived=findViewById(R.id.txtNameReceived);
        txtUsernameReceived=findViewById(R.id.txtUserNameReceived);
        txtPasswordReceived=findViewById(R.id.txtPasswordReceived);

        Bundle extras=getIntent().getExtras();
        String name=extras.getString("NAME");
        String email=extras.getString("EMAIL");
        String username=extras.getString("USER_NAME");
        String password=extras.getString("PASSWORD");
        String gender=extras.getString("GENDER_TYPE");

        txtNameReceived.setText("Name: "+name);
        txtPasswordReceived.setText("Password: "+password);
        txtUsernameReceived.setText("Username: "+username);
        txtEmailReceived.setText("Email: "+email);
        txtGenderReceived.setText("Gender: "+gender);

        byte[] byteArray=extras.getByteArray("PICTURE");
        Bitmap bitmap= BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
        imgAnimalReceived.setImageBitmap(bitmap);

    }
}