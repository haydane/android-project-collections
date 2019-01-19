package com.example.haydane.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class ItemDetailActivity extends AppCompatActivity {
    TextView title;
    ImageView image;
    TextView content;
    String tt,img,cont;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        title = findViewById(R.id.title_detail);
        image = findViewById(R.id.image_detail);
        content = findViewById(R.id.content_detail);
        tt = getIntent().getStringExtra("title");
        cont = getIntent().getStringExtra("content");
        img = getIntent().getStringExtra("image");
        title.setText(tt);
        content.setText(cont);
        Picasso.with(getApplicationContext()).load(img).memoryPolicy(MemoryPolicy.NO_CACHE).into(image);
    }
}
