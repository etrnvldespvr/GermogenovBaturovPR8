package com.example.germogenpr9;

import android.os.Bundle;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("ПР9");
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setContent(R.id.linearLayout);
        tabSpec.setIndicator("ВКЛД 1");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.linearLayout2);
        tabSpec.setIndicator("ВКЛД 2");
        tabHost.addTab(tabSpec);

        tabSpec= tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.linearLayout3);
        tabSpec.setIndicator("ВКЛД 3");
        tabHost.addTab(tabSpec);

        tabSpec= tabHost.newTabSpec("tag4");
        tabSpec.setContent(R.id.linearLayout4);
        tabSpec.setIndicator("ВКЛД 4");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
    }
}