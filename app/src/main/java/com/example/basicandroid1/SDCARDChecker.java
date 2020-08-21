package com.example.basicandroid1;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

public class SDCARDChecker {

    public static void checkWeatherExternalStorageAvailableOrNot(Context context){

        boolean isExternalStorageAvailable=false;
        boolean isExternalStorageWriteable=false;

        String state= Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state)){
            isExternalStorageAvailable=isExternalStorageWriteable=true;
            Toast.makeText(context, "read and write", Toast.LENGTH_SHORT).show();
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){

            isExternalStorageAvailable=true;
            isExternalStorageWriteable=false;
            Toast.makeText(context, "read only", Toast.LENGTH_SHORT).show();
        }else{
            isExternalStorageAvailable=isExternalStorageWriteable=false;
            Toast.makeText(context, "neither read nor write", Toast.LENGTH_SHORT).show();
        }


    }
}
