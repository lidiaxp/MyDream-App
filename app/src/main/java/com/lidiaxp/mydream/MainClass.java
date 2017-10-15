package com.lidiaxp.mydream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainClass extends AppCompatActivity {
    Switch simpleSwitch1;
    ImageView img1;
    Switch simpleSwitch2;
    ImageView img2;
    Switch simpleSwitch3;
    ImageView img3;
    Switch simpleSwitch4;
    ImageView img4;
    Switch simpleSwitch5;
    ImageView img5;
    Switch simpleSwitch6;
    ImageView img6;
    Switch simpleSwitch7;
    ImageView img7;
    Switch simpleSwitch8;
    ImageView img8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class);

        simpleSwitch1 = (Switch) findViewById(R.id.switch1);
        img1 = (ImageView) findViewById(R.id.imageView3);
        simpleSwitch2 = (Switch) findViewById(R.id.switch2);
        img2 = (ImageView) findViewById(R.id.imageView4);
        simpleSwitch3 = (Switch) findViewById(R.id.switch3);
        img3 = (ImageView) findViewById(R.id.imageView5);
        simpleSwitch4 = (Switch) findViewById(R.id.switch4);
        img4 = (ImageView) findViewById(R.id.imageView6);
        simpleSwitch5 = (Switch) findViewById(R.id.switch5);
        img5 = (ImageView) findViewById(R.id.imageView7);
        simpleSwitch6 = (Switch) findViewById(R.id.switch6);
        img6 = (ImageView) findViewById(R.id.imageView8);
        simpleSwitch7 = (Switch) findViewById(R.id.switch7);
        img7 = (ImageView) findViewById(R.id.imageView9);
        simpleSwitch8 = (Switch) findViewById(R.id.switch8);
        img8 = (ImageView) findViewById(R.id.imageView10);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://mydream-ufpa-phi.herokuapp.com/sensor/celular";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data = response.toString();
                        if(data.substring(1, data.length() - 1).equals("desligado")){
                            simpleSwitch1.setChecked(false);
                            img1.setBackgroundResource(R.drawable.devif);
                        }else{
                            simpleSwitch1.setChecked(true);
                            img1.setBackgroundResource(R.drawable.devia);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainClass.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);

        RequestQueue queue2 = Volley.newRequestQueue(this);
        String url2 = "https://mydream-ufpa-phi.herokuapp.com/sensor/e_tranca";
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data2 = response.toString();
                        if(data2.substring(1, data2.length() - 1).equals("desligado")){
                            simpleSwitch2.setChecked(false);
                            img2.setBackgroundResource(R.drawable.portf);
                        }else{
                            simpleSwitch2.setChecked(true);
                            img2.setBackgroundResource(R.drawable.porta);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainClass.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue2.add(stringRequest2);

        RequestQueue queue3 = Volley.newRequestQueue(this);
        String url3 = "https://mydream-ufpa-phi.herokuapp.com/sensor/alarme";
        StringRequest stringRequest3 = new StringRequest(Request.Method.GET, url3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data3 = response.toString();
                        if(data3.substring(1, data3.length() - 1).equals("desligado")){
                            simpleSwitch3.setChecked(false);
                            img3.setBackgroundResource(R.drawable.alarmf);
                        }else{
                            simpleSwitch3.setChecked(true);
                            img3.setBackgroundResource(R.drawable.alarma);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainClass.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue3.add(stringRequest3);

        RequestQueue queue4 = Volley.newRequestQueue(this);
        String url4 = "https://mydream-ufpa-phi.herokuapp.com/sensor/e_vent";
        StringRequest stringRequest4 = new StringRequest(Request.Method.GET, url4,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data4 = response.toString();
                        if(data4.substring(1, data4.length() - 1).equals("desligado")){
                            simpleSwitch4.setChecked(false);
                            img4.setBackgroundResource(R.drawable.ventf);
                        }else{
                            simpleSwitch4.setChecked(true);
                            img4.setBackgroundResource(R.drawable.venta);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainClass.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue4.add(stringRequest4);

        RequestQueue queue5 = Volley.newRequestQueue(this);
        String url5 = "https://mydream-ufpa-phi.herokuapp.com/sensor/e_lamp1";
        StringRequest stringRequest5 = new StringRequest(Request.Method.GET, url5,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data5 = response.toString();
                        if(data5.substring(1, data5.length() - 1).equals("desligado")){
                            simpleSwitch5.setChecked(false);
                            img5.setBackgroundResource(R.drawable.lu1f);
                        }else{
                            simpleSwitch5.setChecked(true);
                            img5.setBackgroundResource(R.drawable.lu1a);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainClass.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue5.add(stringRequest5);

        RequestQueue queue6 = Volley.newRequestQueue(this);
        String url6 = "https://mydream-ufpa-phi.herokuapp.com/sensor/e_lamp2";
        StringRequest stringRequest6 = new StringRequest(Request.Method.GET, url6,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data6 = response.toString();
                        if(data6.substring(1, data6.length() - 1).equals("desligado")){
                            simpleSwitch6.setChecked(false);
                            img6.setBackgroundResource(R.drawable.lu2f);
                        }else{
                            simpleSwitch6.setChecked(true);
                            img6.setBackgroundResource(R.drawable.lu2a);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainClass.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue6.add(stringRequest6);

        RequestQueue queue7 = Volley.newRequestQueue(this);
        String url7 = "https://mydream-ufpa-phi.herokuapp.com/sensor/e_janela";
        StringRequest stringRequest7 = new StringRequest(Request.Method.GET, url7,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data7 = response.toString();
                        if(data7.substring(1, data7.length() - 1).equals("desligado")){
                            simpleSwitch7.setChecked(false);
                            img7.setBackgroundResource(R.drawable.janf);
                        }else{
                            simpleSwitch7.setChecked(true);
                            img7.setBackgroundResource(R.drawable.jana);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainClass.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue7.add(stringRequest7);

        RequestQueue queue8 = Volley.newRequestQueue(this);
        String url8 = "https://mydream-ufpa-phi.herokuapp.com/sensor/e_cortina";
        StringRequest stringRequest8 = new StringRequest(Request.Method.GET, url8,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data8 = response.toString();
                        if(data8.substring(1, data8.length() - 1).equals("desligado")){
                            simpleSwitch8.setChecked(false);
                            img8.setBackgroundResource(R.drawable.cortf);
                        }else{
                            simpleSwitch8.setChecked(true);
                            img8.setBackgroundResource(R.drawable.corta);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainClass.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue8.add(stringRequest8);
    }

    public void putRequest(String extensao, final String estado){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "";
        url += "https://mydream-ufpa-phi.herokuapp.com/sensor/";
        url += extensao;
        StringRequest putRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("estado", estado);

                return params;
            }
        };
        queue.add(putRequest);
    }

    public void click1(View view){
        if(simpleSwitch1.isChecked()){
            putRequest("celular", "ligado");
            img1.setBackgroundResource(R.drawable.devia);
        }else{
            putRequest("celular", "desligado");
            img1.setBackgroundResource(R.drawable.devif);
        }
    }

    public void click2(View view){
        if(simpleSwitch2.isChecked()){
            putRequest("e_tranca", "ligado");
            img2.setBackgroundResource(R.drawable.porta);
        }else{
            putRequest("e_tranca", "desligado");
            img2.setBackgroundResource(R.drawable.portf);
        }
    }

    public void click3(View view){
        if(simpleSwitch3.isChecked()){
            putRequest("alarme", "ligado");
            img3.setBackgroundResource(R.drawable.alarma);
        }else{
            putRequest("alarme", "desligado");
            img3.setBackgroundResource(R.drawable.alarmf);
        }
    }

    public void click4(View view){
        if(simpleSwitch4.isChecked()){
            putRequest("e_vent", "ligado");
            img4.setBackgroundResource(R.drawable.venta);
        }else{
            putRequest("e_vent", "desligado");
            img4.setBackgroundResource(R.drawable.ventf);
        }
    }

    public void click5(View view){
        if(simpleSwitch5.isChecked()){
            putRequest("e_lamp1", "ligado");
            img5.setBackgroundResource(R.drawable.lu1a);
        }else{
            putRequest("e_lamp1", "desligado");
            img5.setBackgroundResource(R.drawable.lu1f);
        }
    }

    public void click6(View view){
        if(simpleSwitch6.isChecked()){
            putRequest("e_lamp2", "ligado");
            img6.setBackgroundResource(R.drawable.lu2a);
        }else{
            putRequest("e_lamp2", "desligado");
            img6.setBackgroundResource(R.drawable.lu2f);
        }
    }

    public void click7(View view){
        if(simpleSwitch7.isChecked()){
            putRequest("e_janela", "ligado");
            img7.setBackgroundResource(R.drawable.jana);
        }else{
            putRequest("e_janela", "desligado");
            img7.setBackgroundResource(R.drawable.janf);
        }
    }

    public void click8(View view){
        if(simpleSwitch8.isChecked()){
            putRequest("e_cortina", "ligado");
            img8.setBackgroundResource(R.drawable.corta);
        }else{
            putRequest("e_cortina", "desligado");
            img8.setBackgroundResource(R.drawable.cortf);
        }
    }

    public void mudaTranca(View view){
        startActivity(new Intent(this, ConfigTranca.class));
        finish();
    }

    public void mudaAlarme(View view){
        startActivity(new Intent(this, ConfigAlarme.class));
        finish();
    }

    @Override
    public void onBackPressed(){
       finish();
    }
}
