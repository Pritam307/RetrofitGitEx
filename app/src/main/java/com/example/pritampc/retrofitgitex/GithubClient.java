package com.example.pritampc.retrofitgitex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pritamPC on 1/28/2018.
 */

public interface GithubClient { // Retrofit API Interface for Get request

    String base_url="https://jsonplaceholder.typicode.com/";

    @GET("users/{user}/repos")
    Call<List<GithubRepo>> getUserRepo(@Path("user") String user);

    @GET("posts")
    Call<List<ModelClassEX>> getFakeUser();

}
