package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class GridViews extends AppCompatActivity {

private GridView grdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_views);

        grdView=findViewById(R.id.grdView);

        GridViewAdapter adapter=new GridViewAdapter(GridViews.this);
        grdView.setAdapter(adapter);

    }
}