package main.java.com.rastredor;

import java.time.LocalDate;

public class RegistroSintoma {

    private LocalDate data;
    private String localizacao;
    private int intensidade;
    private String gatilho;

    public RegistroSintoma(LocalDate data, String localizacao, int intensidade, String gatilho) {
        this.data = data;
        this.localizacao = localizacao;
        this.intensidade = intensidade;
        this.gatilho = gatilho;
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