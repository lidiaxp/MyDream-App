package com.lidiaxp.mydream;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ConfigAlarme extends AppCompatActivity {
    private TimePicker timePicker1;
    protected TextView text;
    ToggleButton toggle;
    int hour;
    int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_alarme);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker);
        toggle = (ToggleButton)findViewById(R.id.toggleButton);
        text = (TextView) findViewById(R.id.textView11);

        RequestQueue queue3 = Volley.newRequestQueue(this);
        String url3 = "https://mydream-ufpa-phi.herokuapp.com/sensor/ambientea";
        StringRequest stringRequest3 = new StringRequest(Request.Method.GET, url3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data3 = response.toString();
                        if(data3.substring(1, data3.length() - 1).equals("desligado")){
                            toggle.setChecked(false);
                        }else{
                            toggle.setChecked(true);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConfigAlarme.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue3.add(stringRequest3);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://mydream-ufpa-phi.herokuapp.com/sensor/hora";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        final String data = response.toString();
                        RequestQueue queue2 = Volley.newRequestQueue(ConfigAlarme.this);
                        String url2 = "https://mydream-ufpa-phi.herokuapp.com/sensor/minuto";
                        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        String data2 = response.toString();
                                        text.setText("Alarme: " + data.substring(1, data.length() - 1) + ":" + data2.substring(1, data2.length() - 1));
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(ConfigAlarme.this, "Sem conexão", Toast.LENGTH_SHORT).show();
                            }
                        });
                        queue2.add(stringRequest2);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConfigAlarme.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }

    public void defineHorario(View view) {
        if (Build.VERSION.SDK_INT >= 23){
            hour = timePicker1.getHour();
            min = timePicker1.getMinute();
        }else {
            hour = timePicker1.getCurrentHour();
            min = timePicker1.getCurrentMinute();
        }

        putRequest("hora", Integer.toString(hour));
        putRequest("minuto", Integer.toString(min));

        Toast.makeText(ConfigAlarme.this, "Alarme Definido", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainClass.class));
        finish();
    }

    public void toggle(View view) {
        if(toggle.isChecked()){
            putRequest("ambientea", "ligado");
        }else{
            putRequest("ambientea", "desligado");
        }
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
                        Toast.makeText(ConfigAlarme.this, "Sem conexão", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, MainClass.class));
        finish();
    }
}
