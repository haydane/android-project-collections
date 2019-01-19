package com.example.haydane.butterknife;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add bind here
        ButterKnife.bind(this);
        textView1.setText("Hello From Butter Knife");
        textView2.setPaintFlags(textView2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"you clicked Me :D",Toast.LENGTH_LONG).show();
    }
}
