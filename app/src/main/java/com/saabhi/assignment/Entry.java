package com.saabhi.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Entry extends AppCompatActivity {



    EditText nameEditText,companyEditText,locationEditText,feeEditText,descriptionEditText;
    Button saveBtn,retrieveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        nameEditText= (EditText)findViewById(R.id.nameEditTxt);
        companyEditText= (EditText)findViewById(R.id.companyEditTxt);
        locationEditText= (EditText)findViewById(R.id.locationEditTxt);
        feeEditText= (EditText)findViewById(R.id.feeEditTxt);
        descriptionEditText= (EditText)findViewById(R.id.descriptionEditTxt);
        saveBtn= (Button)findViewById(R.id.saveBtn);
        retrieveBtn= (Button)findViewById(R.id.retrieveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nm= nameEditText.getText().toString();
                String com= companyEditText.getText().toString();
                String lo= locationEditText.getText().toString();
                String fe= feeEditText.getText().toString();
                String dsc= descriptionEditText.getText().toString();

                save(nm,com,lo,fe,dsc);

            }
        });
        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Entry.this,Home.class);
                startActivity(i);
            }
        });


    }

    private void save(String name,String company,String location,String fee,String description)
    {
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        if(db.add(name,company,location,fee,description))
        {
            nameEditText.setText("");
            companyEditText.setText("");
            locationEditText.setText("");
            feeEditText.setText("");
            descriptionEditText.setText("");
        }else {
            Toast.makeText(this,"Unable to save",Toast.LENGTH_SHORT).show();
        }

        db.closeDB();
    }


}

