package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListview extends ListActivity implements AdapterView.OnItemClickListener {

    String[] courseName={"Android course","Web Development","java course","Core Java"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter=new ArrayAdapter<String>(SimpleListview.this,R.layout.activity_simple_listview,courseName);

        setListAdapter(adapter);

        ListView listView=getListView();
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String itemValue=parent.getItemAtPosition(position).toString();
        Toast.makeText(this, itemValue+"", Toast.LENGTH_SHORT).show();
    }
}