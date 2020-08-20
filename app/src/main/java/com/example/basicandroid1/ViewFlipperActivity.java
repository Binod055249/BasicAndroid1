package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    ImageButton btnAnimalImagePrevious,btnAnimalImageNext;
    ViewAnimator viewAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        viewFlipper=findViewById(R.id.viewFlipper);
        viewAnimator=findViewById(R.id.viewAnimator);
        btnAnimalImageNext=findViewById(R.id.btnAnimalImageNext);
        btnAnimalImagePrevious=findViewById(R.id.btnAnimalImagePrevious);


        letsAddImagesToTheViewFlipper(viewFlipper);
        letsAddImageToTheViewAnimator(viewAnimator);

        useAnimationForViewFlipper(viewFlipper);
        useAnimationForViewAnimator(viewAnimator);

        btnAnimalImagePrevious.setOnClickListener(this);
        btnAnimalImageNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View buttonView) {

        switch (buttonView.getId()){

            case R.id.btnAnimalImagePrevious:
                 viewFlipper.showPrevious();
                 viewAnimator.showPrevious();
                break;

            case R.id.btnAnimalImageNext:
                viewFlipper.showNext();
                viewAnimator.showNext();
                break;

        }
    }

    public void letsSetLayoutParamsForImageView(ImageView imageView){
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));
    }

    private void letsAddImagesToTheViewFlipper(ViewFlipper viewFlipper){
        for(int index=0;index<AnimalClass.image.length;index++){
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(AnimalClass.image[index]);
            letsSetLayoutParamsForImageView(imageView);
            imageView.setPadding(100,100,100,100);
            viewFlipper.addView(imageView);
        }
    }

    private void letsAddImageToTheViewAnimator(ViewAnimator viewAnimator){
        for(int index=0;index<AnimalClass.image.length;index++){
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(AnimalClass.image[index]);
            letsSetLayoutParamsForImageView(imageView);
            imageView.setPadding(100,100,100,100);
            viewAnimator.addView(imageView);
        }
    }

    private void useAnimationForViewFlipper(ViewFlipper viewFlipper){
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
    }

    private void useAnimationForViewAnimator(ViewAnimator viewAnimator){
        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
    }
}