package com.lidiaxp.mydream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigTranca extends AppCompatActivity {
    private TextView txt;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_tranca);

        txt = (TextView)findViewById(R.id.textView10);
        edt = (EditText)findViewById(R.id.editText);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://mydream-ufpa-phi.herokuapp.com/sensor/senha";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String data = response.toString();
                        txt.setText(data.substring(1, data.length() - 1));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConfigTranca.this, "Sem conexão", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    public void mudarSenha(View view){
        String novaSenha = edt.getText().toString();
        if(novaSenha.length() == 4){
            Pattern p = Pattern.compile("[A-D0-9*#]+");
            Matcher m = p.matcher(novaSenha);
            boolean b = m.matches();
            if(b){
                putRequest("senha", novaSenha);
                Toast.makeText(ConfigTranca.this, "Senha atualizada", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ConfigTranca.this, MainClass.class));
            }else{
                Toast.makeText(ConfigTranca.this, "Senha só pode conter: 1 2 3 4 5 6 7 8 9 * # 0 A B C D", Toast.LENGTH_LONG).show();
            }
        } else{
            Toast.makeText(ConfigTranca.this, "A senha deve conter 4 caracteres", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(ConfigTranca.this, "Sem conexão", Toast.LENGTH_SHORT).show();
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
