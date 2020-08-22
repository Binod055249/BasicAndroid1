package com.example.basicandroid1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.ByteArrayOutputStream;

public class SendingInfoToOtherActivity extends AppCompatActivity implements View.OnClickListener,
RadioGroup.OnCheckedChangeListener{

    private EditText edtEmail,edtName,edtUsername,edtPassword;
    private ImageView imgAnimalSend;
   private RadioGroup radioGroup;
   private RadioButton radioMale,radioFemale;
   private Button btnAdd;
   String genderType="";
   final int IMAGE_REQUEST_CODE=1000;
   String photoPath="";
   Bitmap bitmap;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_info_to_other);

        edtEmail=findViewById(R.id.edtEmail);
        edtUsername=findViewById(R.id.edtUsername);
        edtName=findViewById(R.id.edtName);
        edtPassword=findViewById(R.id.edtPassword);

        imgAnimalSend=findViewById(R.id.imgAnimalSend);
        radioGroup=findViewById(R.id.radioGroup);
        radioMale=findViewById(R.id.radioMale);
        radioFemale=findViewById(R.id.radioFemale);
        btnAdd=findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(this);

        imgAnimalSend.setOnClickListener(this);

        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.tiger);
        imgAnimalSend.setImageBitmap(bitmap);
    }

    @Override
    public void onClick(View v) {

           switch (v.getId()){

               case R.id.btnAdd :
                   Intent intent=new Intent(SendingInfoToOtherActivity.this,RecivingInfoActivity.class);
                    intent.putExtra("NAME",edtName.getText().toString());
                    intent.putExtra("EMAIL",edtEmail.getText().toString());
                    intent.putExtra("USER_NAME",edtUsername.getText().toString());
                    intent.putExtra("PASSWORD",edtPassword.getText().toString());
                    intent.putExtra("GENDER_TYPE",genderType);

                   ByteArrayOutputStream stream=new ByteArrayOutputStream();
                   bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                   byte[] byteArray=stream.toByteArray();
                   intent.putExtra("PICTURE",byteArray);

                   startActivity(intent);

                   break;

               case R.id.imgAnimalSend:
                   Intent intentImage=new Intent(Intent.ACTION_GET_CONTENT);
                   intentImage.setType("image/*");
                   startActivityForResult(intentImage,IMAGE_REQUEST_CODE);

                   break;

           }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case IMAGE_REQUEST_CODE:

                if(resultCode==RESULT_OK){

                    Uri chosenImage=data.getData();
                    try{
                        bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(), chosenImage);
                        imgAnimalSend.setImageBitmap(bitmap);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                break;

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){

            case R.id.radioMale:
                genderType="Male";

                break;

            case R.id.radioFemale:
                genderType="Female";

                break;
        }
    }
}