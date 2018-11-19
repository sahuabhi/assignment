package com.saabhi.assignment;

import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    RecyclerView rv;
    MyAdapter2 adapter;
    ArrayList<Workshop> workshops=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rv= (RecyclerView) findViewById(R.id.rv1);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter=new MyAdapter2(this,workshops);
        getappliedworkshops();
    }

    private void getappliedworkshops()
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
