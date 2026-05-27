public abstract class ComponenteEspacial {
    // Atributos comuns a todos os componentes
    protected String id;
    protected String nome;
    protected boolean status; // true = ligado, false = desligado
    protected double temperatura;

    // Construtor
    public ComponenteEspacial(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.status = false;
        this.temperatura = 20.0;
    }

    // Método concreto - ligar
    public void ligar() {
        this.status = true;
        System.out.println("[" + nome + "] Componente LIGADO.");
    }

    // Método concreto - desligar
    public void desligar() {
        this.status = false;
        System.out.println("[" + nome + "] Componente DESLIGADO.");
    }

    // Método abstrato - cada subclasse DEVE implementar
    public abstract void verificarComponente();

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public boolean getStatus() { return status; }
    public double getTemperatura() { return temperatura; }
}