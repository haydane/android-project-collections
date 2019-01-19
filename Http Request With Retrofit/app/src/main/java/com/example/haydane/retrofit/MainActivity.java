package com.example.haydane.retrofit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

import response.ApiResponse;
import response.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String title[];
    String image[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostApi api = retrofit.create(PostApi.class);

        Call<ApiResponse> call = api.getPost();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call< ApiResponse> call, Response<ApiResponse> response) {
                Toast.makeText(getApplicationContext(),"Success: " + response.body().getMsg().getResults()[0].getTitle() ,Toast.LENGTH_LONG).show();
                Post[] posts = response.body().getMsg().getResults();
                image = new String[posts.length];
                title = new String[posts.length];
                for(int i=0;i<posts.length;i++)
                {
                    image[i] = PostApi.BASE_URL + posts[i].getImage();
                    title[i] = posts[i].getTitle();
                }
                recyclerView.setAdapter(new MyAdapter(image,title));

            }


            @Override
            public void onFailure(Call< ApiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Failed ",Toast.LENGTH_LONG).show();
                Log.d("Tag", "onFailure: " + t.getMessage());

            }
        });
    }

}
