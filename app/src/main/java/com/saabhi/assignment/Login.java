package com.saabhi.assignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button btnLogin;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String name,email,password;
    SessionManager session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        pref = getSharedPreferences("Registration", 0);
        editor = pref.edit();

         name = pref.getString("Name", null);
         email = pref.getString("Email", null);
         password = pref.getString("Password", null);

        txtUsername = (EditText) findViewById(R.id.editTextEmail);
        txtPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if(username.equals(email) && password.equals(password)){
                    session.createLoginSession(email,password);
                    Toast.makeText(getApplicationContext(),"Logged In",Toast.LENGTH_LONG).show();

                    Intent ob = new Intent(Login.this, Dashboard.class);
                    startActivity(ob);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Error ,Try Again",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
