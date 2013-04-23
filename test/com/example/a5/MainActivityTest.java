package com.example.a5;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.AbsListView;
import android.widget.ListView;

import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowListView;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    MainActivity mainActivity;
    ListView listView;
    @Before
    public void setup(){
        mainActivity = new MainActivity();
        mainActivity.onCreate(null);
        listView = (ListView) mainActivity.findViewById(R.id.listview);
    }


    @Test
    public void shouldShowListViewHas6Items() throws Exception{
        Assert.assertEquals(listView.getCount(), 6);
    }

    @Test
    public void shouldDeleteItemWhenClickOnIt() throws Exception{
        listView.performItemClick(listView, 0, 0);
        Assert.assertTrue(listView.getItemAtPosition(0).toString().equals("Android"));

        Assert.assertEquals(listView.getCount(),5);
    }
}