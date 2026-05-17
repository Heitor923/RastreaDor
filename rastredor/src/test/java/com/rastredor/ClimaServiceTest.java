package com.rastredor;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClimaServiceTest {

    @Test
    public void deveBuscarTemperaturaAtual() throws Exception {

        ClimaService climaService = new ClimaService();

        String temperatura = climaService.buscarTemperaturaAtual();

        assertNotNull(temperatura);
        assertTrue(temperatura.contains("°C"));
    }
}