package com.rastredor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class ClimaService {

    private static final String URL_API = "https://api.open-meteo.com/v1/forecast?latitude=-15.79&longitude=-47.88&current_weather=true";

    public String buscarTemperaturaAtual() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL_API)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                throw new IOException("Erro ao buscar dados climáticos.");
            }

            String json = response.body().string();
            JSONObject objeto = new JSONObject(json);
            JSONObject climaAtual = objeto.getJSONObject("current_weather");

            return climaAtual.getDouble("temperature") + "°C";
        }
    }
}