package com.rastredor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:rastredor.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void inicializar() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS RegistroSintoma (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    data TEXT NOT NULL,
                    localizacao TEXT NOT NULL,
                    intensidade INTEGER NOT NULL,
                    gatilho TEXT NOT NULL
                )
                """;
        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
}