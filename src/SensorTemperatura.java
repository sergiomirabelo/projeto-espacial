public class SensorTemperatura extends ComponenteEspacial implements Sensor {
    private double limiteAlerta = 80.0; // graus Celsius

    public SensorTemperatura(String id) {
        super(id, "Sensor de Temperatura");
    }

    @Override
    public double lerValor() {
        // Simula leitura com valor aleatório entre 10 e 120
        double valor = 10 + Math.random() * 110;
        this.temperatura = valor;
        System.out.println("[Temperatura] Leitura: " + String.format("%.1f", valor) + " °C");
        return valor;
    }

    @Override
    public boolean verificarFuncionamento() {
        return this.status;
    }

    @Override
    public String retornarTipo() {
        return "Temperatura";
    }

    @Override
    public void verificarComponente() {
        double valor = lerValor();
        if (valor >= 100) {
            System.out.println("🔴 CRÍTICO - Temperatura extremamente alta!");
        } else if (valor >= 90) {
            System.out.println("🔶 ALERTA - Temperatura perigosa!");
        } else if (valor >= limiteAlerta) {
            System.out.println("⚠️ ATENÇÃO - Temperatura acima do limite!");
        } else {
            System.out.println("✅ Temperatura normal.");
        }
    }

    public double getLimiteAlerta() { return limiteAlerta; }
    public void setLimiteAlerta(double limite) { this.limiteAlerta = limite; }
}