package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyect.service.ServiceV;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final Gson gson = new Gson();

    private FloatingActionButton refresh;
    private Button cocina;
    private Button lam1And2;
    private Button recamara;
    private Button oficina;
    private Button lucesAlb;
    private Button puertaEnt;
    private Button llenado;
    private Button vaciado;

    private ServiceV serviceV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceV = new ServiceV("api/", this);
        callEndpointAllDevices();
        setButtons();
    }

    private void callEndpointAllDevices() {
        try {
            serviceV.getAllDevices();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setButtons() {
        cocina = (Button) findViewById(R.id.cocina);
        lam1And2 = (Button) findViewById(R.id.lam1_2);
        recamara = (Button) findViewById(R.id.recamara);
        oficina = (Button) findViewById(R.id.oficina);
        lucesAlb = (Button) findViewById(R.id.lucesAlb);
        puertaEnt = (Button) findViewById(R.id.puertaEnt);
        llenado = (Button) findViewById(R.id.llenado);
        vaciado = (Button) findViewById(R.id.vaciado);
        refresh = (FloatingActionButton) findViewById(R.id.refresh);

        cocina.setOnClickListener(this);
        lam1And2.setOnClickListener(this);
        recamara.setOnClickListener(this);
        oficina.setOnClickListener(this);
        lucesAlb.setOnClickListener(this);
        puertaEnt.setOnClickListener(this);
        llenado.setOnClickListener(this);
        vaciado.setOnClickListener(this);
        refresh.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        HashMap<String, Integer> setValues =  new HashMap<>();
        switch (view.getId()) {
            case R.id.cocina: // v1
                if (checkStatus(cocina.getCurrentTextColor())) {
                    setValues.put("v1", 1);
                } else {
                    setValues.put("v1", 0);
                }
                serviceV.putValueDevice(setValues);
                break;
            case R.id.lam1_2: // v2
                if (checkStatus(lam1And2.getCurrentTextColor())) {
                    setValues.put("v2", 1);
                } else {
                    setValues.put("v2", 0);
                }
                serviceV.putValueDevice(setValues);
                break;
            case R.id.recamara: // v4
                if (checkStatus(recamara.getCurrentTextColor())) {
                    setValues.put("v4", 1);
                } else {
                    setValues.put("v4", 0);
                }
                serviceV.putValueDevice(setValues);
                break;
            case R.id.oficina: // v5
                if (checkStatus(oficina.getCurrentTextColor())) {
                    setValues.put("v5", 1);
                } else {
                    setValues.put("v5", 0);
                }
                serviceV.putValueDevice(setValues);
                break;
            case R.id.lucesAlb: // v6
                if (checkStatus(lucesAlb.getCurrentTextColor())) {
                    setValues.put("v6", 1);
                } else {
                    setValues.put("v6", 0);
                }
                serviceV.putValueDevice(setValues);
                break;
            case R.id.puertaEnt: // v7
                if (checkStatus(puertaEnt.getCurrentTextColor())) {
                    setValues.put("v7", 1);
                } else {
                    setValues.put("v7", 0);
                }
                serviceV.putValueDevice(setValues);
                break;
            case R.id.llenado: // v9
                if (checkStatus(llenado.getCurrentTextColor())) {
                    setValues.put("v9", 1);
                } else {
                    setValues.put("v9", 0);
                }
                serviceV.putValueDevice(setValues);
                break;
            case R.id.vaciado: // v10
                if (checkStatus(vaciado.getCurrentTextColor())) {
                    setValues.put("v10", 1);
                } else {
                    setValues.put("v10", 0);
                }
                serviceV.putValueDevice(setValues);
                break;
            case R.id.refresh:
                callEndpointAllDevices();
                break;
            default:
                break;
        }
    }

    private Boolean checkStatus(int textButtonColor) {
        return Color.WHITE == textButtonColor;
    }

    public void setValuesOnOff(HashMap<String, Integer> valuesResponse) {
        System.out.println("--+-+-+-+-+-+-+" + gson.toJson(valuesResponse));
        for (Map.Entry<String, Integer> value: valuesResponse.entrySet()) {
            switch (value.getKey()) {
                case "v1":
                    setColor(value.getValue(), cocina);
                    break;
                case "v2":
                    setColor(value.getValue(), lam1And2);
                    break;
                case "v4":
                    setColor(value.getValue(), recamara);
                    break;
                case "v5":
                    setColor(value.getValue(), oficina);
                    break;
                case "v6":
                    setColor(value.getValue(), lucesAlb);
                    break;
                case "v7":
                    setColor(value.getValue(), puertaEnt);
                    break;
                case "v9":
                    setColor(value.getValue(), llenado);
                    break;
                case "v10":
                    setColor(value.getValue(), vaciado);
                    break;

            }
        }
    }

    public void setColor(int value, Button button) {
        if (value == 1) {
            button.setBackgroundColor(Color.rgb(122, 205, 252));
            button.setTextColor(Color.BLACK);
        } else {
            button.setBackgroundColor(Color.RED);
            button.setTextColor(Color.WHITE);
        }
    }
}