package com.example.pondd.dessertmaker.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pondd.dessertmaker.R;
import com.example.pondd.dessertmaker.fragment.FragmentMain;
import com.example.pondd.dessertmaker.manager.bus.event.BusDessertListItem;
import com.inthecheesefactory.thecheeselibrary.manager.bus.MainBus;
import com.squareup.otto.Subscribe;


public class MainActivity extends ActionBarActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, FragmentMain.newInstance(), "FragmentMain")
                    .commit();
        }
    }

    public void initInstance() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout,
                R.string.hello_world,
                R.string.hello_world);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainBus.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MainBus.getInstance().unregister(this);
    }

    @Subscribe
    public void busEventRecieved(BusDessertListItem event) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("position",event.getPosition());
        startActivity(intent);
    }
}
