package com.example.a5;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    String[] countries = new String[] { "Android", "iOS", "Firefox", "Ubuntu",
            "Windows", "Maemo", };
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list = new ArrayList<String>(Arrays.asList(countries));
        
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, list);
        
        final ListView listView = (ListView) findViewById(R.id.listview);
        
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            
            @Override
            public void onItemClick(AdapterView<?> parentView, View childView,
                    int position, long id) {
                adapter.remove(list.get(position));
                listView.setAdapter(adapter);
            }
            
        });
        listView.setTextFilterEnabled(true);
        Log.d("Debuga5", "" + listView.getCount());
    }
}