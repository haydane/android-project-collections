package com.example.haydane.retrofit;

import java.util.List;

import response.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    String BASE_URL = "http://172.20.10.2:8000";
    @GET("/promo/api/")
    Call<ApiResponse> getPost();
}
