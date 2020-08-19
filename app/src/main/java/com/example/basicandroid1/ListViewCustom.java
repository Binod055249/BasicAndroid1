package com.example.basicandroid1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewCustom extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;

    int[] animalImages={R.drawable.bear,R.drawable.bird,R.drawable.cat,R.drawable.cow,
    R.drawable.dolphin,R.drawable.fish,R.drawable.fox,R.drawable.horse,
            R.drawable.lion,R.drawable.tiger};

    String[] animalName={"Bear","Bird","Cat","Cow","Dolphin","Fish","Fox","Horse","Lion","Tiger"};
    int[] animalPower={200,20,50,150,50,10,70,400,250,220};
    int[] animalSpeed={50,80,60,10,50,40,80,350,200,100};

    public ListViewCustom(Context context){

        this.context=context;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public View getView(int position, View view, ViewGroup parent) {

        view= layoutInflater.inflate(R.layout.customized_list_view,null);

        ImageView imgAnimal=view.findViewById(R.id.imgAnimal);
       final TextView txtAnimalName=view.findViewById(R.id.txtAnimalName);
        final TextView txtAnimalPower=(TextView) view.findViewById(R.id.txtAnimalPower);
        final TextView txtAnimalSpeed=(TextView) view.findViewById(R.id.txtAnimalSpeed);

        String oldTxtAnimalName=txtAnimalName.getText().toString();
        String oldTxtAnimalPower=txtAnimalPower.getText().toString();
        String oldTxtAnimalspeed=txtAnimalSpeed.getText().toString();

//        final BitmapFactory.Options options=new BitmapFactory.Options();
//        options.inSampleSize=1;
//        Bitmap bm=BitmapFactory.decodeResource(context.getResources(),
//        animalImages[position],options);
//        imgAnimal.setImageBitmap(bm);

        imgAnimal.setImageResource(animalImages[position]);

//        imgAnimal.setImageBitmap(decodeSampleBitmapFromResource(context.getResources(),
//                animalImages[position],50,50));

        txtAnimalName.setText(oldTxtAnimalName+animalName[position]);
        txtAnimalPower.setText(oldTxtAnimalPower+animalPower[position]);
        txtAnimalSpeed.setText(oldTxtAnimalspeed+animalSpeed[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,txtAnimalName.getText()+"\n"+
                        txtAnimalPower.getText()+"\n"+txtAnimalSpeed.getText(),
                        Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

  /*  public static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        final int height=options.outHeight;
        final int width=options.outWidth;
        int inSampleSize=1;

        if(height>reqHeight || width>reqWidth){
            final int halfHeight=height/2;
            final int halfWidth=width/2;

            while((halfHeight/inSampleSize)>reqHeight &&(halfWidth/inSampleSize)>reqWidth){
                inSampleSize*=2 ;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampleBitmapFromResource(Resources res,int resId,
                                                        int reqWidth,int reqHeight){

        final BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(res,resId,options);

        options.inSampleSize=calculateInSampleSize(options,reqWidth,reqHeight);

        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(res,resId,options);
    }
*/

}
