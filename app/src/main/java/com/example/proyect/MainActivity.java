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
        String value;
        switch (view.getId()) {
            case R.id.cocina: // v1
                value = checkStatus(cocina.getCurrentTextColor());
                serviceV.putValueDevice("v1", value);
                break;
            case R.id.lam1_2: // v2
                value = checkStatus(lam1And2.getCurrentTextColor());
                serviceV.putValueDevice("v2", value);
                break;
            case R.id.recamara: // v4
                value = checkStatus(recamara.getCurrentTextColor());
                serviceV.putValueDevice("v4", value);
                break;
            case R.id.oficina: // v5
                value = checkStatus(oficina.getCurrentTextColor());
                serviceV.putValueDevice("v5", value);
                break;
            case R.id.lucesAlb: // v6
               value = checkStatus(lucesAlb.getCurrentTextColor());
                serviceV.putValueDevice("v6", value);
                break;
            case R.id.puertaEnt: // v7
                value = checkStatus(puertaEnt.getCurrentTextColor());
                serviceV.putValueDevice("v7", value);
                break;
            case R.id.llenado: // v9
                value = checkStatus(llenado.getCurrentTextColor());
                serviceV.putValueDevice("v9", value);
                break;
            case R.id.vaciado: // v10
                value = checkStatus(vaciado.getCurrentTextColor());
                serviceV.putValueDevice("v10", value);
                break;
            case R.id.refresh:
                callEndpointAllDevices();
                break;
            default:
                break;
        }
    }

    private String checkStatus(int textButtonColor) {
        return Color.WHITE == textButtonColor ? "1" : "0";
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