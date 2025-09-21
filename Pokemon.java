public class Pokemon {
    private String especie;
    private String tipo;

    public Pokemon(String especie, String tipo) {
        this.especie = especie;
        this.tipo = tipo;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void exibir() {
        System.out.println("Espécie: " + especie + " | Tipo: " + tipo);
    }
}
