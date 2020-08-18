package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class CustomizedListView extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_list_view);

        listView=findViewById(R.id.listView);

        ListViewCustom adapter=new ListViewCustom(CustomizedListView.this);

        listView.setAdapter(adapter);


    }
}