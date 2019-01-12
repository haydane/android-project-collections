package com.example.haydane.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {
    TextView title;
    ImageView imageView;

    String title_name;
    int image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        title = findViewById(R.id.title_name);
        imageView = findViewById(R.id.icon_name);

        title_name = getIntent().getStringExtra("title_name");
        image = getIntent().getIntExtra("image",0);

        title.setText(title_name);
        imageView.setImageResource(image);
        Log.d("title: ", "onCreate: " + title_name);
    }
}
