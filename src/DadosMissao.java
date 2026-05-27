public class DadosMissao {
    private String codigoAcesso;
    private double coordenadaX;
    private double coordenadaY;
    private double nivelCombustivel; // 0 a 100%
    private String trajetoria;
    private int numeroDeTripulantes;

    public DadosMissao(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
        this.nivelCombustivel = 100.0;
        this.numeroDeTripulantes = 0;
        this.trajetoria = "Indefinida";
    }

    // Coordenadas protegidas por senha
    public String getCoordenadas(String senha) {
        if (senha.equals(this.codigoAcesso)) {
            return "X: " + coordenadaX + " | Y: " + coordenadaY;
        } else {
            return "❌ Acesso negado! Senha incorreta.";
        }
    }

    public boolean setCoordenadas(String senha, double x, double y) {
        if (senha.equals(this.codigoAcesso)) {
            this.coordenadaX = x;
            this.coordenadaY = y;
            System.out.println("✅ Coordenadas atualizadas.");
            return true;
        }
        System.out.println("❌ Acesso negado!");
        return false;
    }

    // Combustível com validação e alerta automático
    public double getNivelCombustivel() { return nivelCombustivel; }

    public void setNivelCombustivel(double nivel) {
        if (nivel < 0) {
            System.out.println("❌ Valor inválido! Nível não pode ser negativo.");
            return;
        }
        if (nivel > 100) {
            System.out.println("❌ Valor inválido! Nível não pode passar de 100%.");
            return;
        }
        this.nivelCombustivel = nivel;
        if (nivel < 20) {
            System.out.println("🔴 CRÍTICO - Combustível baixo: " + nivel + "%! Reabastecimento necessário!");
        }
    }

    public String getTrajetoria() { return trajetoria; }
    public void setTrajetoria(String trajetoria) { this.trajetoria = trajetoria; }

    public int getNumeroDeTripulantes() { return numeroDeTripulantes; }

    public void setNumeroDeTripulantes(int numero) {
        if (numero < 0) {
            System.out.println("❌ Número de tripulantes não pode ser negativo.");
            return;
        }
        this.numeroDeTripulantes = numero;
    }

    public void exibirStatus() {
        System.out.println("=== DADOS DA MISSÃO ===");
        System.out.println("Trajetória: " + trajetoria);
        System.out.println("Combustível: " + nivelCombustivel + "%");
        System.out.println("Tripulantes: " + numeroDeTripulantes);
        System.out.println("Coordenadas: [PROTEGIDAS POR SENHA]");
    }
}