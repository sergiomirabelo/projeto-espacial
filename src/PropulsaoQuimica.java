public class PropulsaoQuimica extends SistemaPropulsao {
    private String tipoCombustivel;
    private double massaPropelente; // kg

    public PropulsaoQuimica(String tipoCombustivel, double massaPropelente) {
        super("Propulsão Química");
        this.tipoCombustivel = tipoCombustivel;
        this.massaPropelente = massaPropelente;
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
        super.potencia = potencia;
        // Consome combustível
        massaPropelente -= potencia * 0.5;
        if (massaPropelente < 0) massaPropelente = 0;

        System.out.println("[Química] Acelerando com " + potencia + "% de potência.");
        System.out.println("[Química] Empuxo gerado: " + String.format("%.1f", calcularEmpuxo()) + " kN");
        System.out.println("[Química] Propelente restante: " + String.format("%.1f", massaPropelente) + " kg");
    }

    @Override
    public double calcularEmpuxo() {
        // Empuxo = potência * fator químico
        return potencia * 4.5;
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Combustível: " + tipoCombustivel);
        System.out.println("Propelente: " + String.format("%.1f", massaPropelente) + " kg");
    }
}