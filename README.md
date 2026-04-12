# RastreaDor

<p align="center">
  <img src="https://img.shields.io/badge/status-concluído-green" alt="Status">
  <img src="https://img.shields.io/badge/licença-MIT-blue" alt="Licença">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/sqlite-%2307405e.svg?style=flat-square&logo=sqlite&logoColor=white" alt="SQLite">
  <img src="https://img.shields.io/github/actions/workflow/status/Heitor923/RastreaDor/ci.yml?label=CI&style=flat-square" alt="CI">
</p>

## 📌 Sobre o Projeto

O **RastreaDor** é uma aplicação desktop desenvolvida como parte da disciplina de Bootcamp II, com foco em boas práticas de desenvolvimento, testes automatizados e integração contínua.

A aplicação resolve um problema real e silencioso: pacientes com dores crônicas (enxaqueca, fibromialgia, artrite) chegam às consultas médicas sem conseguir descrever seu histórico de forma organizada. O médico trabalha no escuro, o diagnóstico demora e o tratamento sofre.

O **RastreaDor** permite registrar episódios de dor com data, localização, intensidade e gatilho suspeito, gerando um resumo do período para apresentar ao médico na consulta.

## Visuais

*(Espaço reservado para capturas de tela da interface.)*

---

## Instalação

Certifique-se de ter o **Java 17** e o **Maven** instalados. Então:

```bash
git clone https://github.com/Heitor923/RastreaDor.git
cd RastreaDor/rastredor
mvn install -DskipTests
```

---

## Uso

Para executar a aplicação:

```bash
mvn exec:java -Dexec.mainClass="com.rastredor.Main"
```

A interface gráfica será aberta com as opções:
- Registrar episódio de dor
- Ver histórico
- Gerar resumo do período

---

## Testes

```bash
mvn test
```

---

## Lint

```bash
mvn checkstyle:check
```

---

## Suporte

Para dúvidas ou sugestões, utilize a aba de **Issues** deste repositório.

---

## Roteiro (Roadmap)

- [x] Definição do problema e proposta de solução
- [x] Implementação da interface gráfica com Swing
- [x] Integração com banco de dados SQLite
- [x] Testes automatizados com JUnit 5
- [x] Análise estática com Checkstyle
- [x] Pipeline de CI com GitHub Actions
- [ ] Exportar resumo em PDF para levar ao médico
- [ ] Adicionar gráfico de evolução da dor por período

---

## Como contribuir

Pull requests são bem-vindos. Para mudanças maiores, abra uma **issue** primeiro para discutir o que gostaria de alterar.

- Certifique-se de atualizar/adicionar testes quando apropriado.
- Descreva claramente o problema resolvido ou a funcionalidade adicionada.

---

## Autor

- **Heitor** — Concepção, desenvolvimento e arquitetura do sistema.

---

## Licença

Este projeto está sob a licença [MIT](https://choosealicense.com/licenses/mit/).

---

## Status do projeto

**Concluído** — Versão 1.0.0 entregue com interface gráfica, banco de dados, testes e CI funcionando.
