
package com.rastredor;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    private final RegistroSintomaService service = new RegistroSintomaService();

    public Main() {
        setTitle("RastreaDor");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titulo = new JLabel("RastreaDor", JLabel.CENTER);
        titulo.setBounds(0, 20, 350, 30);
        titulo.setFont(titulo.getFont().deriveFont(20f));
        panel.add(titulo);

        JLabel subtitulo = new JLabel("Diário de dor para consultas médicas", JLabel.CENTER);
        subtitulo.setBounds(0, 50, 350, 20);
        panel.add(subtitulo);

        JButton btnRegistrar = new JButton("Registrar Episódio de Dor");
        btnRegistrar.setBounds(75, 90, 200, 35);
        btnRegistrar.addActionListener(e -> registrarEpisodio());
        panel.add(btnRegistrar);

        JButton btnHistorico = new JButton("Ver Histórico");
        btnHistorico.setBounds(75, 135, 200, 35);
        btnHistorico.addActionListener(e -> verHistorico());
        panel.add(btnHistorico);

        JButton btnResumo = new JButton("Gerar Resumo do Período");
        btnResumo.setBounds(75, 180, 200, 35);
        btnResumo.addActionListener(e -> gerarResumo());
        panel.add(btnResumo);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(75, 225, 200, 35);
        btnSair.addActionListener(e -> System.exit(0));
        panel.add(btnSair);

        add(panel);
    }

    private void registrarEpisodio() {
        try {
            String dataStr = JOptionPane.showInputDialog(this,
                    "Data (AAAA-MM-DD) — deixe vazio para hoje:");
            if (dataStr == null) {
                return;
            }
            LocalDate data = dataStr.isBlank() ? LocalDate.now() : LocalDate.parse(dataStr);

            String localizacao = JOptionPane.showInputDialog(this,
                    "Localização da dor (ex: cabeça, costas):");
            if (localizacao == null || localizacao.isBlank()) {
                JOptionPane.showMessageDialog(this, "Localização não pode ser vazia.");
                return;
            }

            String intensidadeStr = JOptionPane.showInputDialog(this,
                    "Intensidade da dor (1 a 10):");
            if (intensidadeStr == null) {
                return;
            }
            int intensidade = Integer.parseInt(intensidadeStr.trim());

            String gatilho = JOptionPane.showInputDialog(this,
                    "Gatilho suspeito (ex: estresse, sol, jejum):");
            if (gatilho == null || gatilho.isBlank()) {
                JOptionPane.showMessageDialog(this, "Gatilho não pode ser vazio.");
                return;
            }

            service.registrar(data, localizacao, intensidade, gatilho);
            JOptionPane.showMessageDialog(this, "Episódio registrado com sucesso!");

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato AAAA-MM-DD.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Intensidade inválida. Digite um número de 1 a 10.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }
    }

    private void verHistorico() {
        try {
            List<RegistroSintoma> lista = service.listarTodos();
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum episódio registrado ainda.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            lista.forEach(e -> sb.append(e).append("\n"));
            JOptionPane.showMessageDialog(this,
                    sb.toString(),
                    "Histórico de Episódios",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar histórico: " + e.getMessage());
        }
    }

    private void gerarResumo() {
        try {
            String inicioStr = JOptionPane.showInputDialog(this,
                    "Data de início (AAAA-MM-DD):");
            if (inicioStr == null) {
                return;
            }
            LocalDate inicio = LocalDate.parse(inicioStr.trim());

            String fimStr = JOptionPane.showInputDialog(this,
                    "Data de fim (AAAA-MM-DD):");
            if (fimStr == null) {
                return;
            }
            LocalDate fim = LocalDate.parse(fimStr.trim());

            String resumo = service.gerarResumo(inicio, fim);
            JOptionPane.showMessageDialog(this,
                    resumo,
                    "Resumo do Período",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato AAAA-MM-DD.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar resumo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Database.inicializar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inicializar banco: " + e.getMessage());
            return;
        }
        SwingUtilities.invokeLater(() -> {
            Main janela = new Main();
            janela.setVisible(true);
        });
    }
}