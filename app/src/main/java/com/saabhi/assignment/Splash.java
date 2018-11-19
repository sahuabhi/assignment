package com.saabhi.assignment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView developer;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        pic=(ImageView)findViewById(R.id.logo);

        //link in name
        developer=(TextView)findViewById(R.id.social);
        developer.setMovementMethod(LinkMovementMethod.getInstance());


        //animation in image
        final Animation blink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animsplash);
        pic.startAnimation(blink);




        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(Splash.this,Home.class);
                startActivity(i);
                finish();
            }
        },5000);




    }
}

