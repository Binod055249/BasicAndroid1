package com.example.basicandroid1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridViewAdapter extends BaseAdapter {


    int[] animalImages={R.drawable.bear,R.drawable.bird,R.drawable.cat,R.drawable.cow,
    R.drawable.dolphin,R.drawable.fish,R.drawable.horse,R.drawable.lion,R.drawable.tiger};

    String[] animalNames={"Bear","Bird","Cat","Cow","Dolphin","Fish","Horse","Lion","Tiger"};

    Context context;

    public GridViewAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return animalImages.length;
    }

    @Override
    public Object getItem(int position) {
        return animalImages[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        ImageView imgView=new ImageView(context);
        imgView.setImageResource(animalImages[position]);
         imgView.setLayoutParams(new GridView.LayoutParams(200,200));
         imgView.setPadding(10,10,10,10);
         imgView.setScaleType(ImageView.ScaleType.FIT_XY);
         imgView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(context,"The Name of the animal is: "+animalNames[position],Toast.LENGTH_SHORT).show();
             }
         });
        return imgView;
    }
}
