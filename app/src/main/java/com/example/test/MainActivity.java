package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listViews);

        ArrayList<DataFlags> list = new ArrayList<>();
        list.clear();

        list.add(new DataFlags(R.drawable.flag_russian, R.string.russian, R.string.russianRUB));
        list.add(new DataFlags(R.drawable.flag_africa, R.string.africa, R.string.africaZAR));
        list.add(new DataFlags(R.drawable.flag_singapore, R.string.singapore, R.string.singaporeSGD));
        list.add(new DataFlags(R.drawable.flag_turkish, R.string.turkish, R.string.turkishTRY));
        list.add(new DataFlags(R.drawable.flag_usa, R.string.usa, R.string.usaUSD));
        list.add(new DataFlags(R.drawable.flag_switzerland, R.string.switzerland, R.string.switzerlandCHF));
        list.add(new DataFlags(R.drawable.flag_korea, R.string.korea, R.string.koreaKRW));

        MyListAdapter myListAdaptery = new MyListAdapter(this, list);
        listView.setAdapter(myListAdaptery);
    }
}
