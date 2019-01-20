package com.example.haydane.onboarding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txt1;
    TextView txt2;
    Button btn;
    Animation smltobig,nothingtocome, btnaim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smltobig = AnimationUtils.loadAnimation(this,R.anim.smltobig);
        nothingtocome = AnimationUtils.loadAnimation(this,R.anim.nothingtocome);
        btnaim = AnimationUtils.loadAnimation(this,R.anim.btnaim);
        imageView = findViewById(R.id.imageView);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        btn = findViewById(R.id.btn);

        imageView.setAnimation(smltobig);
        txt1.setAnimation(nothingtocome);
        txt2.setAnimation(nothingtocome);
        btn.setAnimation(btnaim);
    }
}
