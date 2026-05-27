# 🚀 Plataforma de Monitoramento Espacial

Projeto desenvolvido para a Global Solution 2026 da FIAP, aplicando conceitos de Programação Orientada a Objetos (POO) em Java.

## 📋 Sobre o Projeto

Sistema de monitoramento de uma estação espacial capaz de verificar sensores, controlar sistemas de propulsão, gerenciar dados da missão e emitir alertas automáticos quando algo sai do normal.

## 🧠 Conceitos de POO Aplicados

- **Classe Abstrata** → `ComponenteEspacial` e `SistemaPropulsao`
- **Interface** → `Sensor` implementada em 3 sensores diferentes
- **Encapsulamento** → `DadosMissao` com atributos privados, getters/setters e proteção por senha
- **Herança** → `PropulsaoQuimica` e `PropulsaoEletrica` herdam de `SistemaPropulsao`

## 📁 Estrutura do Projeto
projeto-espacial/
├── ComponenteEspacial.java   (classe abstrata)
├── Sensor.java               (interface)
├── SensorTemperatura.java    (implementa Sensor)
├── SensorPressao.java        (implementa Sensor)
├── SensorRadiacao.java       (implementa Sensor)
├── DadosMissao.java          (encapsulamento)
├── SistemaPropulsao.java     (classe abstrata)
├── PropulsaoQuimica.java     (herda de SistemaPropulsao)
├── PropulsaoEletrica.java    (herda de SistemaPropulsao)
└── SistemaMonitoramento.java (classe principal com menu)

## ⚙️ Funcionalidades

- ✅ Leitura de sensores de Temperatura, Pressão e Radiação
- ✅ Alertas automáticos em 3 níveis: ⚠️ ATENÇÃO, 🔶 ALERTA, 🔴 CRÍTICO
- ✅ Controle de propulsão química e elétrica com cálculo de empuxo
- ✅ Dados da missão protegidos por senha
- ✅ Alerta automático quando combustível abaixo de 20%
- ✅ Menu interativo no console

## ▶️ Como Executar

1. Clone o repositório
2. Abra no IntelliJ IDEA
3. Execute o arquivo `SistemaMonitoramento.java`
4. A senha para acessar as coordenadas é: `FIAP2026`

## 🖥️ Status Completo do Sistema

<pre>
====== STATUS COMPLETO DO SISTEMA ======
=== DADOS DA MISSÃO ===
Trajetória: Terra → Marte
Combustível: 100.0%
Tripulantes: 4
Coordenadas: [PROTEGIDAS POR SENHA]
--- Propulsão Química ---
Motor: Propulsão Química
Ligado: Não
Potência: 0.0%
Combustível: Hidrogênio Líquido
Propelente: 1000,0 kg
--- Propulsão Elétrica ---
Motor: Propulsão Elétrica
Ligado: Não
Potência: 0.0%
Bateria: 100,0%
Eficiência: 92.0%
--- Sensores ---
Temperatura: ✅ Ligado
Pressão:     ✅ Ligado
Radiação:    ✅ Ligado
========================================
</pre>

## 🛠️ Tecnologia

- Java
- IntelliJ IDEA
