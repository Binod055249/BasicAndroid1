package com.example.basicandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.QuickContactBadge;

public class AccessContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_contacts);

        QuickContactBadge quickContactBadge=findViewById(R.id.quickContactBadge);
        quickContactBadge.assignContactFromPhone("9490238093",true);
    }
}