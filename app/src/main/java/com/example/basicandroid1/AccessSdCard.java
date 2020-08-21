package com.example.basicandroid1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class AccessSdCard extends AppCompatActivity implements View.OnClickListener, ViewSwitcher.ViewFactory {

    private Button btnDownloadFolder,btnMusicFolder,btnDocumentsFolder,btnRingTonesFolder,
            btnPodcastFolder,btnMoviesFolder,btnPictureFolder,btnAlarmsFolder,btnSaveFile,btnRetriveTheInfo,
    btnAllowAccessPicture;
    private EditText edtValue;
    private TextView txtValue;
    private ImageSwitcher imageSwitcher;
    private ImageView imgAnimals;
    private LinearLayout linearLayoutHorizontal;

    ArrayList<String> filePathNames;
    File[] files;
   // public static final int REQUEST_CODE=1234;

    public boolean isStoragePermissionGranted(){

        if(Build.VERSION.SDK_INT>=23){
            if(checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                    PackageManager.PERMISSION_GRANTED){
                Log.v("LOG","permission is granted");
                Toast.makeText(this, "Permission is granted", Toast.LENGTH_LONG).show();
                return true;
            }else{
                 Log.v("LOG","permission is revoked");
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                return false;
            }
        }else{
            Toast.makeText(this, "permission is granted", Toast.LENGTH_LONG).show();
            Log.v("LOG","permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if((grantResults[0] == PackageManager.PERMISSION_GRANTED)){
            Toast.makeText(this, "Permission: "+permissions[0]+" was "+grantResults[0], Toast.LENGTH_LONG).show();
           Log.v("LOG","Permission: "+permissions[0]+" was "+grantResults[0]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_sd_card);

        SDCARDChecker.checkWeatherExternalStorageAvailableOrNot(this);
        isStoragePermissionGranted();

        btnAlarmsFolder=findViewById(R.id.btnAlarmsFolder);
        btnAllowAccessPicture=findViewById(R.id.btnAllowAccessPicture);
        btnDocumentsFolder=findViewById(R.id.btnDocumentsFolder);
        btnDownloadFolder=findViewById(R.id.btnDownloadFolder);
        btnMoviesFolder=findViewById(R.id.btnMoviesFolder);
        btnMusicFolder=findViewById(R.id.btnMusicFolder);
        btnPictureFolder=findViewById(R.id.btnPictureFolder);
        btnPodcastFolder=findViewById(R.id.btnPodcastFolder);
        btnRetriveTheInfo=findViewById(R.id.btnRetrieveTheInfo);
        btnRingTonesFolder=findViewById(R.id.btnRingtonesFolder);
        btnSaveFile=findViewById(R.id.btnSaveFile);

        edtValue=findViewById(R.id.edtValue);
        txtValue=findViewById(R.id.txtValue);

        imageSwitcher=findViewById(R.id.imageSwitcher);
        imgAnimals=findViewById(R.id.imgAnimals);

        linearLayoutHorizontal=findViewById(R.id.linearLayoutHorizontal);

        btnSaveFile.setOnClickListener(this);
        btnRingTonesFolder.setOnClickListener(this);
        btnRetriveTheInfo.setOnClickListener(this);
        btnPodcastFolder.setOnClickListener(this);
        btnPictureFolder.setOnClickListener(this);
        btnMusicFolder.setOnClickListener(this);
        btnMoviesFolder.setOnClickListener(this);
        btnDownloadFolder.setOnClickListener(this);
        btnDocumentsFolder.setOnClickListener(this);
        btnAllowAccessPicture.setOnClickListener(this);
        btnAlarmsFolder.setOnClickListener(this);

        imgAnimals.setOnClickListener(this);

        imageSwitcher.setFactory(this);

        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
    }

    public File returnStorageDirectoryForFolderName(String directoryName,String nameOfFolder){

        File filePath=new File(Environment.getExternalStoragePublicDirectory(directoryName),nameOfFolder);

        if(!filePath.mkdirs()){
            letsCreateAToast("There cannot be such directory in sd card");
        }else{
            letsCreateAToast("Your Folder is created and its name is: "+nameOfFolder);
        }
        return filePath;
    }

    public void letsCreateAToast(String message){
        Toast.makeText(this, message+"", Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void letsSaveFileToDocumentFolder(){

        File filePath=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                "NiceFile.txt");

        try{

            FileOutputStream fileOutputStream=new FileOutputStream(filePath);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append(edtValue.getText().toString());
            outputStreamWriter.close();
            fileOutputStream.close();
            letsCreateAToast("Saved");

        }catch (Exception e){
            Log.i("LOG",e.toString());
            letsCreateAToast("Exception occured check the log for info");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void letsRetriveDataFromDocumentsFolder(){
        File filePath=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                "NiceFile.txt");
     try{

         FileInputStream fileInputStream=new FileInputStream(filePath);
         BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
         String fileData="";
         String bufferData="";
         while((fileData=bufferedReader.readLine())!=null){
             bufferData=bufferData+fileData+"\n";
         }
         txtValue.setText(bufferData);
          bufferedReader.close();
     }catch (Exception e){
         Log.i("LOG",e.toString());
         letsCreateAToast("Exception occured check the log for info");
     }

    }

    public void letsSaveTheImageToPictureFolder(){

        try{
            Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.tiger);
            File filePath=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "tiger_image.png");
            OutputStream outputStream=new FileOutputStream(filePath);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
            outputStream.flush();
            outputStream.close();
            letsCreateAToast("Your Image has been SuccessFully Saved");

        }catch (Exception e){
            Log.i("LOG",e.toString());
            letsCreateAToast("Exception occured check the log for info");
        }
    }

    public void letsAllowAccessPictures(){

        if(isStoragePermissionGranted()) {

                filePathNames = new ArrayList<String>();
                File filepath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                        "AnimalImages");
                if (filepath.isDirectory() && filepath != null) {
                    files = filepath.listFiles();
                    for (int index = 0; index < files.length; index++) {
                        filePathNames.add(files[index].getAbsolutePath());
                    }
                }

                for (int index = 0; index < filePathNames.size(); index++) {
                    final ImageView imageView = new ImageView(this);
                    imageView.setImageURI(Uri.parse(filePathNames.get(index)));
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(500, 500));

                    final int i = index;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            imageSwitcher.setImageURI(Uri.parse(filePathNames.get(i)));
                        }
                    });
                    linearLayoutHorizontal.addView(imageView);
                }
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnDownloadFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_DOWNLOADS,"Nice Downloads!!!");
                break;
            case R.id.btnMusicFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_MUSIC,"Nice Musics!!!");
                break;
            case R.id.btnDocumentsFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_DOCUMENTS,"Nice Documents!!!");
                break;
            case R.id.btnAlarmsFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_ALARMS,"Nice Alarms!!!");
                break;
            case R.id.btnMoviesFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_MOVIES,"Nice Movies!!!");
                 break;
            case R.id.btnRingtonesFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_RINGTONES,"Nice RingTones!!!");
                break;
            case R.id.btnPictureFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_PICTURES,"Nice Picture!!!");
                break;
            case R.id.btnPodcastFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_PODCASTS,"Nice Podcast!!!");
                break;

            case R.id.btnSaveFile:
                letsSaveFileToDocumentFolder();
                break;
            case R.id.btnRetrieveTheInfo:
                letsRetriveDataFromDocumentsFolder();
                break;
            case R.id.imgAnimals:
                letsSaveTheImageToPictureFolder();
                break;

            case R.id.btnAllowAccessPicture:
                        letsAllowAccessPictures();
                break;
        }
    }

    @Override
    public View makeView() {
        ImageView imageView=new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(1000,1000));
        return imageView;
    }
}