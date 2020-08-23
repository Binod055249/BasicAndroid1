package com.example.basicandroid1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TabHostAnotherTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_type_tab_host);

        TabHost tabHostAnother=findViewById(R.id.tabHostAnother);
        tabHostAnother.setup();

        //Tab1
        TabHost.TabSpec spec=tabHostAnother.newTabSpec("One");
        spec.setIndicator("",getResources().getDrawable(R.drawable.bear));
        spec.setContent(R.id.tab1);
        tabHostAnother.addTab(spec);

        //Tab2
        spec=tabHostAnother.newTabSpec("Two");
        spec.setIndicator("",getResources().getDrawable(R.drawable.cat));
        spec.setContent(R.id.tab2);
        tabHostAnother.addTab(spec);

        //Tab3
        spec=tabHostAnother.newTabSpec("Three");
        spec.setIndicator("",getResources().getDrawable(R.drawable.bird));
        spec.setContent(R.id.tab3);
        tabHostAnother.addTab(spec);

    }
}
