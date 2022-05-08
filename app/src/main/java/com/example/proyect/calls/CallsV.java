package com.example.proyect.calls;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallsV {

    @GET("get?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6&v1&v2&v4&v5&v6&v7&v8&v9&v10")
    Call<HashMap<String, Integer>> getAllDevices();

    @GET("{url}")
    Call<Void> putValueDevice(@Path("url") String url);
}
