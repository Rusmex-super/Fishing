package com.example.fishing_act;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private ListView list;
private String[] array;
private ArrayAdapter<String> adapter;
private Toolbar toolbar;
private int category_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.fish_array);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                intent.putExtra("category",category_index);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
            toolbar.setTitle(R.string.menu_home);
            array = getResources().getStringArray(R.array.fish_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 0;
        }
        else if(id == R.id.nav_gallery){
            toolbar.setTitle(R.string.menu_gallery);
            array = getResources().getStringArray(R.array.vp_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 1;

        }
        else if(id == R.id.nav_slideshow){
            toolbar.setTitle(R.string.menu_slideshow);
            array = getResources().getStringArray(R.array.um_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = 2;
        }
        return true;
    }
}