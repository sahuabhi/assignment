package com.saabhi.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rv;
    MyAdapter adapter;
    ArrayList<Workshop> workshops=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Home");
        ProgressBar progressBar;


        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter=new MyAdapter(this,workshops);
        getworkshops();







        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_workshop) {
            Intent i = new Intent(Home.this,Home.class);
            startActivity(i);
        } else if (id == R.id.nav_dashboard) {
            Intent i = new Intent(Home.this,Dashboard.class);
            startActivity(i);
        } else if (id == R.id.nav_signup) {
            Intent i = new Intent(Home.this,Register.class);
            startActivity(i);
        } else if (id == R.id.nav_login) {
            Intent i = new Intent(Home.this,Login.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getworkshops()
    {
        workshops.clear();

        DBAdapter db=new DBAdapter(this);
        db.openDB();
        Cursor c=db.retrieve();


        if (c.moveToFirst()) {
            do {

                int id=c.getInt(0);
                String name=c.getString(1);
                String company=c.getString(2);
                String location=c.getString(3);
                String fee=c.getString(4);
                String description=c.getString(5);

                Workshop s=new Workshop();
                s.setId(id);
                s.setName(name);
                s.setCompany(company);
                s.setLocation(location);
                s.setFee(fee);
                s.setDescr(description);
                workshops.add(s);
            } while (c.moveToNext());

        }

        db.closeDB();

        rv.setAdapter(adapter);
    }


}
