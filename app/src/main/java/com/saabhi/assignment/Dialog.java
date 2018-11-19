package com.saabhi.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Dialog extends AppCompatActivity {
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        session = new SessionManager(getApplicationContext());

        if(!session.isLoggedIn()){
            Intent i = new Intent(Dialog.this, Login.class);
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Applied For This Workshop",Toast.LENGTH_LONG).show();
            Intent ob = new Intent(Dialog.this, Home.class);
            startActivity(ob);
            finish();
        }
    }
}
