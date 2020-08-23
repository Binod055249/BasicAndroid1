package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

public class AccessPhoneServices extends AppCompatActivity implements View.OnClickListener{

    private Button btnOpenudemy,btnSearchGoogle,btnCall,btnAcessDialPad;
    private static final int CALL=1;

    private static String[] PERMISSIONS={Manifest.permission.CALL_PHONE};

    public static void verifyThatWeCanCallSomeOne(Activity activity){
        int permission= ActivityCompat.checkSelfPermission(activity,Manifest.permission.CALL_PHONE);

        if(permission!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(activity,PERMISSIONS,CALL);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_phone_services);

        btnOpenudemy=findViewById(R.id.btnOpenUdemy);
        btnSearchGoogle=findViewById(R.id.btnSearchGoogle);
        btnAcessDialPad=findViewById(R.id.btnAcessDialPad);
        btnCall=findViewById(R.id.btnCall);

        verifyThatWeCanCallSomeOne(this);

        btnCall.setOnClickListener(this);
        btnAcessDialPad.setOnClickListener(this);
        btnSearchGoogle.setOnClickListener(this);
        btnOpenudemy.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnCall:

                if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},CALL);
                }else{

                    Intent intent2=new Intent(Intent.ACTION_CALL);
                    intent2.setData(Uri.parse("tel:3333445667"));
                    startActivity(intent2);
                }

                break;

            case R.id.btnAcessDialPad:

                Intent intent4=new Intent(Intent.ACTION_DIAL);
                startActivity(intent4);

                break;

            case R.id.btnOpenUdemy:

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.udemy.com"));
                startActivity(intent);

                break;

            case R.id.btnSearchGoogle:

                Intent intent1= new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.google.com"));
                startActivity(intent1);

                break;
        }
    }
}