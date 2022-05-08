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

    public void putValueDevice(String name, String value) {
        HashMap<String, Integer> mapValue = new HashMap<>();
        mapValue.put(name, Integer.valueOf(value));
        Call<Void> setValue = getCall(name, value);
        setValue.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println(gson.toJson(response.isSuccessful()));
                if (response.isSuccessful()) {
                    mainActivity.setValuesOnOff(mapValue);
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("++++++++++++++" + t.getLocalizedMessage());
                mapResponse = null;
            }
        });
    }
    
    private Call<Void> getCall(String name, String value) {
        switch (name) {
            case "v1":
                return callsV.putValueDeviceV1(value);
            case "v2":
                return callsV.putValueDeviceV2(value);
            case "v4":
                return callsV.putValueDeviceV4(value);
            case "v5":
                return callsV.putValueDeviceV5(value);
            case "v6":
                return callsV.putValueDeviceV6(value);
            case "v7":
                return callsV.putValueDeviceV7(value);
            case "v9":
                return callsV.putValueDeviceV9(value);
            case "v10":
                return callsV.putValueDeviceV10(value);
            default:
                return null;
        }
    }
}
