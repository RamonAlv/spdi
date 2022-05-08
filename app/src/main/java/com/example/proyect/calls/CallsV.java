package com.example.proyect.calls;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallsV {

    @GET("get?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6&v1&v2&v4&v5&v6&v7&v8&v9&v10")
    Call<HashMap<String, Integer>> getAllDevices();

    @GET("update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6")
    Call<Void> putValueDeviceV1(@Query("v1") String v1);

    @GET("update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6")
    Call<Void> putValueDeviceV2(@Query("v2") String v2);

    @GET("update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6")
    Call<Void> putValueDeviceV4(@Query("v4") String v4);

    @GET("update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6")
    Call<Void> putValueDeviceV5(@Query("v5") String v5);

    @GET("update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6")
    Call<Void> putValueDeviceV6(@Query("v6") String v6);

    @GET("update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6")
    Call<Void> putValueDeviceV7(@Query("v7") String v7);

    @GET("update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6")
    Call<Void> putValueDeviceV9(@Query("v9") String v9);

    @GET("update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6")
    Call<Void> putValueDeviceV10(@Query("v10") String v10);

}
