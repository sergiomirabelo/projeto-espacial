public interface Sensor {
    // Contrato: toda classe que implementar Sensor DEVE ter esses métodos
    double lerValor();
    boolean verificarFuncionamento();
    String retornarTipo();
}