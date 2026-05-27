public class SensorRadiacao extends ComponenteEspacial implements Sensor {
    private double limiteAlerta = 50.0; // mSv

    public SensorRadiacao(String id) {
        super(id, "Sensor de Radiação");
    }

    @Override
    public double lerValor() {
        double valor = Math.random() * 100;
        System.out.println("[Radiação] Leitura: " + String.format("%.1f", valor) + " mSv");
        return valor;
    }

    @Override
    public boolean verificarFuncionamento() {
        return this.status;
    }

    @Override
    public String retornarTipo() {
        return "Radiação";
    }

    @Override
    public void verificarComponente() {
        double valor = lerValor();
        if (valor >= 85) {
            System.out.println("🔴 CRÍTICO - Radiação letal!");
        } else if (valor >= 70) {
            System.out.println("🔶 ALERTA - Radiação muito alta!");
        } else if (valor >= limiteAlerta) {
            System.out.println("⚠️ ATENÇÃO - Radiação acima do limite!");
        } else {
            System.out.println("✅ Radiação normal.");
        }
    }
}