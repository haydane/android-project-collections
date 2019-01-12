package com.example.haydane.recyclerview;

import android.graphics.drawable.RippleDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] title = {"H", "A", "Y","D","A","N","E"};
        int[] image = {R.drawable.ic_archive_black_24dp,R.drawable.ic_android_black_24dp,
                       R.drawable.ic_send_black_24dp,R.drawable.ic_sentiment_satisfied_black_24dp,
                       R.drawable.ic_settings_input_component_black_24dp, R.drawable.ic_signal_cellular_2_bar_black_24dp,
                        R.drawable.ic_settings_bluetooth_black_24dp};
        recyclerView.setAdapter(new MyAdapter(image,title));
    }
}
