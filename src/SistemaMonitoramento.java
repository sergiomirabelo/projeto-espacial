import java.util.Scanner;

public class SistemaMonitoramento {

    // Objetos do sistema
    static SensorTemperatura sensorTemp = new SensorTemperatura("S001");
    static SensorPressao sensorPress = new SensorPressao("S002");
    static SensorRadiacao sensorRad = new SensorRadiacao("S003");
    static DadosMissao dados = new DadosMissao("FIAP2026");
    static PropulsaoQuimica propQuimica = new PropulsaoQuimica("Hidrogênio Líquido", 1000);
    static PropulsaoEletrica propEletrica = new PropulsaoEletrica(100);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Liga todos os sensores
        sensorTemp.ligar();
        sensorPress.ligar();
        sensorRad.ligar();

        // Dados iniciais da missão
        dados.setTrajetoria("Terra → Marte");
        dados.setNumeroDeTripulantes(4);
        dados.setCoordenadas("FIAP2026", -23.5505, -46.6333);

        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: menuSensores(); break;
                case 2: menuPropulsao(); break;
                case 3: menuDadosMissao(); break;
                case 4: simularAlertas(); break;
                case 5: exibirStatusCompleto(); break;
                case 0: System.out.println("👋 Encerrando sistema. Boa viagem!"); break;
                default: System.out.println("❌ Opção inválida!");
            }
        }
    }

    static void exibirMenu() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║   PLATAFORMA ESPACIAL 🚀     ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1 - Verificar Sensores       ║");
        System.out.println("║ 2 - Controlar Propulsão      ║");
        System.out.println("║ 3 - Dados da Missão          ║");
        System.out.println("║ 4 - Simular Alertas          ║");
        System.out.println("║ 5 - Status Completo          ║");
        System.out.println("║ 0 - Sair                     ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Escolha: ");
    }

    static void menuSensores() {
        System.out.println("\n=== VERIFICANDO SENSORES ===");
        sensorTemp.verificarComponente();
        sensorPress.verificarComponente();
        sensorRad.verificarComponente();
    }

    static void menuPropulsao() {
        System.out.println("\n=== CONTROLE DE PROPULSÃO ===");
        System.out.println("1 - Ligar Propulsão Química");
        System.out.println("2 - Ligar Propulsão Elétrica");
        System.out.println("3 - Acelerar Propulsão Química");
        System.out.println("4 - Acelerar Propulsão Elétrica");
        System.out.println("5 - Desligar tudo");
        System.out.print("Escolha: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1: propQuimica.ligar(); break;
            case 2: propEletrica.ligar(); break;
            case 3:
                System.out.print("Potência (0-100): ");
                double p1 = scanner.nextDouble();
                propQuimica.acelerar(p1);
                break;
            case 4:
                System.out.print("Potência (0-100): ");
                double p2 = scanner.nextDouble();
                propEletrica.acelerar(p2);
                break;
            case 5:
                propQuimica.desligar();
                propEletrica.desligar();
                break;
        }
    }

    static void menuDadosMissao() {
        System.out.println("\n=== DADOS DA MISSÃO ===");
        System.out.println("1 - Ver status geral");
        System.out.println("2 - Ver coordenadas (requer senha)");
        System.out.println("3 - Atualizar combustível");
        System.out.println("4 - Atualizar trajetória");
        System.out.print("Escolha: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                dados.exibirStatus();
                break;
            case 2:
                System.out.print("Digite a senha: ");
                String senha = scanner.nextLine();
                System.out.println(dados.getCoordenadas(senha));
                break;
            case 3:
                System.out.print("Novo nível de combustível (0-100): ");
                double comb = scanner.nextDouble();
                dados.setNivelCombustivel(comb);
                break;
            case 4:
                System.out.print("Nova trajetória: ");
                String traj = scanner.nextLine();
                dados.setTrajetoria(traj);
                System.out.println("✅ Trajetória atualizada!");
                break;
        }
    }

    static void simularAlertas() {
        System.out.println("\n=== SIMULAÇÃO DE ALERTAS ===");
        System.out.println("Verificando todos os sistemas...\n");
        sensorTemp.verificarComponente();
        sensorPress.verificarComponente();
        sensorRad.verificarComponente();
        if (dados.getNivelCombustivel() < 20) {
            System.out.println("🔴 CRÍTICO - Combustível abaixo de 20%!");
        } else {
            System.out.println("✅ Combustível OK: " + dados.getNivelCombustivel() + "%");
        }
    }

    static void exibirStatusCompleto() {
        System.out.println("\n====== STATUS COMPLETO DO SISTEMA ======");
        dados.exibirStatus();
        System.out.println("\n--- Propulsão Química ---");
        propQuimica.exibirStatus();
        System.out.println("\n--- Propulsão Elétrica ---");
        propEletrica.exibirStatus();
        System.out.println("\n--- Sensores ---");
        System.out.println("Temperatura: " + (sensorTemp.getStatus() ? "✅ Ligado" : "❌ Desligado"));
        System.out.println("Pressão:     " + (sensorPress.getStatus() ? "✅ Ligado" : "❌ Desligado"));
        System.out.println("Radiação:    " + (sensorRad.getStatus() ? "✅ Ligado" : "❌ Desligado"));
        System.out.println("========================================");
    }
}