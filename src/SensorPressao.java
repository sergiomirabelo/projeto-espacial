public class SensorPressao extends ComponenteEspacial implements Sensor {
    private double limiteAlerta = 150.0; // kPa

    public SensorPressao(String id) {
        super(id, "Sensor de Pressão");
    }

    @Override
    public double lerValor() {
        double valor = 50 + Math.random() * 150;
        System.out.println("[Pressão] Leitura: " + String.format("%.1f", valor) + " kPa");
        return valor;
    }

    @Override
    public boolean verificarFuncionamento() {
        return this.status;
    }

    @Override
    public String retornarTipo() {
        return "Pressão";
    }

    @Override
    public void verificarComponente() {
        double valor = lerValor();
        if (valor >= 190) {
            System.out.println("🔴 CRÍTICO - Pressão extremamente alta!");
        } else if (valor >= 170) {
            System.out.println("🔶 ALERTA - Pressão perigosa!");
        } else if (valor >= limiteAlerta) {
            System.out.println("⚠️ ATENÇÃO - Pressão acima do limite!");
        } else {
            System.out.println("✅ Pressão normal.");
        }
    }
}