package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GalleryPhotos extends AppCompatActivity {

  LinearLayout linearLayoutHorizontal;
  ImageView imgAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_photos);

        linearLayoutHorizontal=findViewById(R.id.linearLayoutHorizontal);
        imgAnimal=findViewById(R.id.imgAninal);

        for(int index = 0; index< AnimalClass.image.length; index++){
            final int i=index;
            final ImageView imageView=new ImageView(GalleryPhotos.this);
            imageView.setImageResource(AnimalClass.image[i]);
            letsSetLayoutParamsForImageView(imageView);
            imageView.setPadding(100,100,100,100);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgAnimal.setImageResource(AnimalClass.image[i]);
                    letsSetLayoutParamsForImageView(imgAnimal);
                    Toast.makeText(GalleryPhotos.this, "This is:"+ AnimalClass.name[i], Toast.LENGTH_SHORT).show();
                }
            });
            linearLayoutHorizontal.addView(imageView);
        }
    }

    public void letsSetLayoutParamsForImageView(ImageView imageView){
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));
    }
}