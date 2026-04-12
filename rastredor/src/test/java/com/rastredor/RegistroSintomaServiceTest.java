package com.rastredor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistroSintomaServiceTest {

    private RegistroSintomaService service;

    @BeforeEach
    void setUp() throws SQLException {
        Database.inicializar();
        service = new RegistroSintomaService();
    }

    @Test
    void deveRegistrarEpisodioValido() throws SQLException {
        service.registrar(LocalDate.now(), "cabeça", 7, "estresse");
        List<RegistroSintoma> lista = service.listarTodos();
        assertFalse(lista.isEmpty(), "A lista não deve estar vazia após registrar.");
    }

    @Test
    void deveRejeitarLocalizacaoVazia() {
        assertThrows(IllegalArgumentException.class, () -> service.registrar(LocalDate.now(), "", 5, "sol"));
    }

    @Test
    void deveRejeitarIntensidadeAcimaDoLimite() {
        assertThrows(IllegalArgumentException.class, () -> service.registrar(LocalDate.now(), "costas", 11, "jejum"));
    }

    @Test
    void deveRejeitarIntensidadeAbaixoDoLimite() {
        assertThrows(IllegalArgumentException.class, () -> service.registrar(LocalDate.now(), "costas", 0, "jejum"));
    }

    @Test
    void deveRejeitarGatilhoVazio() {
        assertThrows(IllegalArgumentException.class, () -> service.registrar(LocalDate.now(), "cabeça", 5, ""));
    }

    @Test
    void deveRetornarMensagemQuandoPeriodoSemRegistros() throws SQLException {
        String resumo = service.gerarResumo(
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2000, 1, 2));
        assertEquals("Nenhum registro encontrado no período.", resumo);
    }
}