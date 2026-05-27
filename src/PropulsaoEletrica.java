public class PropulsaoEletrica extends SistemaPropulsao {
    private double nivelBateria; // 0 a 100%
    private double eficiencia;   // fator de eficiência

    public PropulsaoEletrica(double nivelBateria) {
        super("Propulsão Elétrica");
        this.nivelBateria = nivelBateria;
        this.eficiencia = 0.92; // 92% eficiente
    }

    @Override
    public void acelerar(double potencia) {
        if (!ligado) {
            System.out.println("❌ Ligue o motor primeiro!");
            return;
        }
        if (potencia < 0 || potencia > 100) {
            System.out.println("❌ Potência inválida! Use entre 0 e 100.");
            return;
        }
        if (nivelBateria <= 0) {
            System.out.println("🔴 CRÍTICO - Bateria descarregada!");
            return;
        }
        super.potencia = potencia;
        nivelBateria -= potencia * 0.3;
        if (nivelBateria < 0) nivelBateria = 0;

        System.out.println("[Elétrica] Acelerando com " + potencia + "% de potência.");
        System.out.println("[Elétrica] Empuxo gerado: " + String.format("%.1f", calcularEmpuxo()) + " kN");
        System.out.println("[Elétrica] Bateria restante: " + String.format("%.1f", nivelBateria) + "%");
    }

    @Override
    public double calcularEmpuxo() {
        return potencia * eficiencia * 2.0;
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Bateria: " + String.format("%.1f", nivelBateria) + "%");
        System.out.println("Eficiência: " + (eficiencia * 100) + "%");
    }
}