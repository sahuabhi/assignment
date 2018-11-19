package com.saabhi.assignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Button btn_register;
    EditText et_name, et_pass, et_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        et_name = (EditText) findViewById(R.id.editTextUserName);
        et_pass = (EditText) findViewById(R.id.editTextPassword);
        et_email = (EditText) findViewById(R.id.editTextEmail);
        btn_register = (Button) findViewById(R.id.buttonRegister);

        pref = getSharedPreferences("Registration", 0);
        editor = pref.edit();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String email = et_email.getText().toString();
                String pass = et_pass.getText().toString();

                if(name.isEmpty()||name.length() < 4){
                    et_name.setError("Enter a Valid Name");
                    et_name.requestFocus();
                    return;
                }
                else if(email.isEmpty()||name.length() < 4){
                    et_email.setError("Enter a Valid Name");
                    et_email.requestFocus();
                    return;
                }
                else if(pass.isEmpty()||name.length() < 4) {
                    et_pass.setError("Enter a Valid Name");
                    et_pass.requestFocus();
                    return;
                }
                else {

                    editor.putString("Name", name);
                    editor.putString("Email", email);
                    editor.putString("Password", pass);
                    editor.commit();

                    Intent ob = new Intent(Register.this, Home.class);
                    startActivity(ob);
                }
            }
        });
    }
}
