package com.rastredor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistroSintomaService {

    public void registrar(LocalDate data, String localizacao,
            int intensidade, String gatilho) throws SQLException {

        if (localizacao == null || localizacao.isBlank()) {
            throw new IllegalArgumentException("Localização não pode ser vazia.");
        }

        if (intensidade < 1 || intensidade > 10) {
            throw new IllegalArgumentException("Intensidade deve ser entre 1 e 10.");
        }

        if (gatilho == null || gatilho.isBlank()) {
            throw new IllegalArgumentException("Gatilho não pode ser vazio.");
        }

        Connection conn = Database.conectar();
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO RegistroSintoma (data, localizacao, intensidade, gatilho) VALUES (?, ?, ?, ?)");
        stmt.setString(1, data.toString());
        stmt.setString(2, localizacao);
        stmt.setInt(3, intensidade);
        stmt.setString(4, gatilho);
        stmt.executeUpdate();
        conn.close();
    }

    public List<RegistroSintoma> listarTodos() throws SQLException {
        List<RegistroSintoma> lista = new ArrayList<>();
        Connection conn = Database.conectar();
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM RegistroSintoma ORDER BY data DESC");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lista.add(new RegistroSintoma(
                    rs.getInt("id"),
                    LocalDate.parse(rs.getString("data")),
                    rs.getString("localizacao"),
                    rs.getInt("intensidade"),
                    rs.getString("gatilho")));
        }
        conn.close();
        return lista;
    }

    public List<RegistroSintoma> listarPorPeriodo(LocalDate inicio, LocalDate fim) throws SQLException {
        List<RegistroSintoma> lista = new ArrayList<>();
        Connection conn = Database.conectar();
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM RegistroSintoma WHERE data BETWEEN ? AND ?");
        stmt.setString(1, inicio.toString());
        stmt.setString(2, fim.toString());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lista.add(new RegistroSintoma(
                    rs.getInt("id"),
                    LocalDate.parse(rs.getString("data")),
                    rs.getString("localizacao"),
                    rs.getInt("intensidade"),
                    rs.getString("gatilho")));
        }
        conn.close();
        return lista;
    }

    public String gerarResumo(LocalDate inicio, LocalDate fim) throws SQLException {
        List<RegistroSintoma> lista = listarPorPeriodo(inicio, fim);

        if (lista.isEmpty()) {
            return "Nenhum registro encontrado no período.";
        }

        int total = lista.size();
        int soma = 0;
        int max = 0;

        for (RegistroSintoma r : lista) {
            soma += r.getIntensidade();
            if (r.getIntensidade() > max) {
                max = r.getIntensidade();
            }
        }

        double media = (double) soma / total;

        return "Total de episódios: " + total
                + "\nIntensidade média: " + String.format("%.1f", media) + "/10"
                + "\nIntensidade máxima: " + max + "/10";
    }
}