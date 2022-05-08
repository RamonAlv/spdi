package com.example.proyect.service;

import com.example.proyect.MainActivity;
import com.example.proyect.calls.CallsV;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceV extends Services {

    private CallsV callsV;
    private final Gson gson = new Gson();
    private HashMap<String, Integer> mapResponse = new HashMap<>();
    private MainActivity mainActivity;

    public ServiceV(String uri, MainActivity mainActivity) {
        super(uri);
        callsV = retrofit.create(CallsV.class);
        this.mainActivity = mainActivity;

    }

    public void getAllDevices() throws IOException {
        Call<HashMap<String, Integer>> callsVAllDevices = callsV.getAllDevices();
        callsVAllDevices.enqueue(new Callback<HashMap<String, Integer>>() {
            @Override
            public void onResponse(Call<HashMap<String, Integer>> call, Response<HashMap<String, Integer>> response) {
                if (response.isSuccessful()) {
                    mapResponse = response.body();
                    mainActivity.setValuesOnOff(mapResponse);
                }
            }
            @Override
            public void onFailure(Call<HashMap<String, Integer>> call, Throwable t) {
                System.out.println("++++++++++++++" + t.getLocalizedMessage());
                mapResponse = null;
            }
        });
    }

    public void putValueDevice(HashMap<String, Integer> values) {
        String url = "update?token=uEve8oCvmnu1pyoW1kFqVSFYZ8M9NLf6&v6=0";
        Call<Void> setValue = callsV.putValueDevice(url);
        setValue.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println(gson.toJson(response.headers()));
                System.out.println(gson.toJson(response.code()));
                System.out.println(gson.toJson(response.message()));
                System.out.println(gson.toJson(response.isSuccessful()));
                if (response.isSuccessful()) {
                    mainActivity.setValuesOnOff(values);
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("++++++++++++++" + t.getLocalizedMessage());
                mapResponse = null;
            }
        });
    }
}
