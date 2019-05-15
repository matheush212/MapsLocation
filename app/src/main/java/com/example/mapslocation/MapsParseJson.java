package com.example.mapslocation;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsParseJson {
    private static final String TAG = "MapsParseJson";
    private List<Contato> contatos;
    private JSONArray jsonArray;

    public MapsParseJson() {
        contatos = new ArrayList<>();
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void parse(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            jsonArray = json.getJSONArray("");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject contato = jsonArray.getJSONObject(i);
                Log.d(TAG, "parse: " + contato);
                Contato c = new Contato(
                        contato.getString("nome"),
                        contato.getString("email"),
                        contato.getDouble("lagitude"),
                        contato.getDouble("longitude")
                );
                contatos.add(c);
            }
        } catch (JSONException e) {
            Log.d(TAG, "parse: Erro fazendo parse de String JSON: " + e.getMessage());
        }

    }
}
