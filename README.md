

# RastreaDor

<p align="center">
  <img src="https://img.shields.io/badge/status-concluído-green" alt="Status">
  <img src="https://img.shields.io/badge/versão-1.1.0-blue" alt="Versão">
  <img src="https://img.shields.io/badge/licença-MIT-blue" alt="Licença">
  <img src="https://img.shields.io/badge/java-17-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/maven-3.9+-C71A36?style=flat-square&logo=apache-maven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/sqlite-%2307405e.svg?style=flat-square&logo=sqlite&logoColor=white" alt="SQLite">
  <img src="https://img.shields.io/github/last-commit/Heitor923/RastreaDor?style=flat-square" alt="Último commit">
  <img src="https://img.shields.io/badge/CI-passing-brightgreen?style=flat-square&logo=github-actions&logoColor=white" alt="CI">
  <img src="https://img.shields.io/badge/testes-7%20passando-brightgreen?style=flat-square&logo=junit5&logoColor=white" alt="Testes">
</p>

---

## 🔗 Repositório

https://github.com/Heitor923/RastreaDor

---

## 📌 Sobre o Projeto

O **RastreaDor** é uma aplicação desktop desenvolvida como parte da disciplina de Bootcamp II, com foco em boas práticas de desenvolvimento, testes automatizados e integração contínua.

A aplicação resolve um problema real e silencioso: pacientes com dores crônicas (enxaqueca, fibromialgia, artrite) chegam às consultas médicas sem conseguir descrever seu histórico de forma organizada. O médico trabalha no escuro, o diagnóstico demora e o tratamento sofre.

O **RastreaDor** permite registrar episódios de dor com data, localização, intensidade e gatilho suspeito, gerando um resumo do período para apresentar ao médico na consulta.

---

## 🌦️ Integração com API Pública

Na Entrega Intermediária, o RastreaDor passou a consumir a API pública Open-Meteo.

A aplicação agora consulta a temperatura atual por meio de requisições HTTP utilizando OkHttp e exibe as informações diretamente na interface gráfica.

Essa funcionalidade ajuda a relacionar possíveis fatores climáticos aos episódios registrados.

API utilizada:

https://open-meteo.com

---

## 👥 Público-Alvo

- Pacientes com dores crônicas (enxaqueca, fibromialgia, artrite)
- Pessoas que desejam monitorar sintomas de forma organizada
- Profissionais de saúde que precisam de dados mais claros para diagnóstico

---

## 🎬 Visuais

<p align="center">
  <img src="https://i.imgur.com/wIZCdJH.gif" alt="Demo do RastreaDor" width="700">
</p>

---

## 🧠 Tecnologias Utilizadas

- Java 17
- Swing (Interface gráfica)
- SQLite (Banco de dados local)
- Maven (Gerenciamento de dependências)
- JUnit 5 (Testes automatizados)
- Checkstyle (Padronização de código)
- GitHub Actions (CI/CD)
- Open-Meteo API (API pública de clima)
- OkHttp (Cliente HTTP)
- JSON.org (Leitura de JSON)

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
mvn exec:java "-Dexec.mainClass=com.rastredor.Main"
```

A interface gráfica será aberta com as opções:

- Registrar episódio de dor
- Ver histórico
- Gerar resumo do período
- Ver clima atual

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
- [x] Integração com API pública de clima
- [x] Teste de integração da API
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

**Concluído** — Versão 1.1.0 entregue com interface gráfica, banco de dados, integração com API pública de clima, testes automatizados e CI funcionando.
