package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class DownloadImage extends AppCompatActivity {

    private ImageView imgDownload;
    private Button btnDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);

        imgDownload=findViewById(R.id.imgDownload);
        btnDownload=findViewById(R.id.btnDownload);
//https://4.bp.blogspot.com/-zj7lkPuo_lo/XNRD7KQyc7I/AAAAAAAAI9g/bK-GrXVsTV4Rvy_6zH0bkf4HE1P5A7oHwCLcBGAs/s1600/Z08bLbWsQat.png
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadImageTask downloadImageTask=new DownloadImageTask(DownloadImage.this);
                downloadImageTask.execute("https://4.bp.blogspot.com/-zj7lkPuo_lo/XNRD7KQyc7I/AAAAAAAAI9g/bK-GrXVsTV4Rvy_6zH0bkf4HE1P5A7oHwCLcBGAs/s1600/Z08bLbWsQat.png");
            }
        });

    }

   private class DownloadImageTask extends AsyncTask<String,Void, Bitmap>{

        ProgressDialog progressDialog;
        Context context;

        public DownloadImageTask(Context context){
            this.context=context;
            progressDialog=new ProgressDialog(context);
        }

       @Override
       protected void onPreExecute() {
           super.onPreExecute();

            progressDialog.setMessage("Downloading image...Please Wait");
            progressDialog.show();
       }

       @Override
       protected Bitmap doInBackground(String... params) {

            String stringUrl=params[0];
            Bitmap bitmap=null;
            try {
                URL url=new URL(stringUrl);
                InputStream inputStream=url.openStream();
                bitmap= BitmapFactory.decodeStream(inputStream);

            }catch (Exception e){
                e.printStackTrace();
            }
           return bitmap;
       }

       @Override
       protected void onPostExecute(Bitmap bitmap) {
           super.onPostExecute(bitmap);

           imgDownload.setImageBitmap(bitmap);

           if(progressDialog.isShowing()){
               progressDialog.dismiss();
           }
       }
   }
}