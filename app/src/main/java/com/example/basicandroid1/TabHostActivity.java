package com.example.basicandroid1;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class TabHostActivity extends ActivityGroup {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        TabHost tabHost=findViewById(R.id.tabHostAnother);
        tabHost.setup(getLocalActivityManager());

        //Tab1
        TabHost.TabSpec spec=tabHost.newTabSpec("One");
        spec.setIndicator("Tab One");
        Intent intent1=new Intent(TabHostActivity.this,TabHostSecondActivity.class);
        spec.setContent(intent1);
        tabHost.addTab(spec);

        //Tab2
        spec=tabHost.newTabSpec("Two");
        spec.setIndicator("Tab Two");
        Intent intent2=new Intent(TabHostActivity.this,TabHostThirdActivity.class);
        spec.setContent(intent2);
        tabHost.addTab(spec);

        //Tab3
        spec=tabHost.newTabSpec("Three");
        spec.setIndicator("Tab Three");
        Intent intent3=new Intent(TabHostActivity.this,TabHostFourthActivty.class);
        spec.setContent(intent3);
        tabHost.addTab(spec);


    }

}