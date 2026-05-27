public abstract class SistemaPropulsao {
    protected String nome;
    protected boolean ligado;
    protected double potencia; // 0 a 100%

    public SistemaPropulsao(String nome) {
        this.nome = nome;
        this.ligado = false;
        this.potencia = 0;
    }

    public void ligar() {
        this.ligado = true;
        System.out.println("[" + nome + "] Motor LIGADO.");
    }

    public void desligar() {
        this.ligado = false;
        this.potencia = 0;
        System.out.println("[" + nome + "] Motor DESLIGADO.");
    }

    // Método abstrato - cada tipo implementa do seu jeito
    public abstract void acelerar(double potencia);

    public abstract double calcularEmpuxo();

    public void exibirStatus() {
        System.out.println("Motor: " + nome);
        System.out.println("Ligado: " + (ligado ? "Sim" : "Não"));
        System.out.println("Potência: " + potencia + "%");
    }
}