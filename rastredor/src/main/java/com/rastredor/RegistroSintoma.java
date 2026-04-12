package com.rastredor;

import java.time.LocalDate;

public class RegistroSintoma {
    private int id;
    private LocalDate data;
    private String localizacao;
    private int intensidade;
    private String gatilho;

    public RegistroSintoma(int id, LocalDate data, String localizacao, int intensidade, String gatilho) {
        this.id = id;
        this.data = data;
        this.localizacao = localizacao;
        this.intensidade = intensidade;
        this.gatilho = gatilho;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getIntensidade() {
        return intensidade;
    }

    public String getGatilho() {
        return gatilho;
    }

    @Override
    public String toString() {
        return "[" + data + "] "
                + localizacao
                + " | Intensidade: " + intensidade + "/10"
                + " | Gatilho: " + gatilho;
    }
}