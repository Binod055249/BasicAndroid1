package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ImgSwitcher extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    LinearLayout linearLayoutHorizontal;
    ImageSwitcher imgSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_switcher);

     linearLayoutHorizontal=findViewById(R.id.linearLayoutHorizontal);
     imgSwitcher=findViewById(R.id.imgSwitcher);

     imgSwitcher.setFactory(ImgSwitcher.this);

     imgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
     imgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));

     for(int index=0;index<AnimalClass.image.length;index++){
         final int i=index;
         ImageView imgView=new ImageView(ImgSwitcher.this);
         imgView.setImageResource(AnimalClass.image[index]);
         letsSetLayoutParamsForImageView(imgView);
         imgView.setPadding(100,100,100,100);
         imgView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 imgSwitcher.setImageResource(AnimalClass.image[i]);
                 Toast.makeText(ImgSwitcher.this,"This is:"+AnimalClass.name[i],Toast.LENGTH_SHORT).show();
             }
         });
         linearLayoutHorizontal.addView(imgView);
     }

    }

    public void letsSetLayoutParamsForImageView(ImageView imageView){
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));
    }

    @Override
    public View makeView() {

        ImageView imgView=new ImageView(ImgSwitcher.this);
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
//        imgView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT));
        imgView.setLayoutParams(new ImageSwitcher.LayoutParams(600,600));
        return imgView;
    }
}