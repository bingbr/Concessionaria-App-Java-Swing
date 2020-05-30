package ap3;
//@author William S.
public class Carro {
    private int cod;
    private String modelo;
    private String marca;
    private int ano;
    private String dataAdicionado;
    
    public Carro(){
    }
    public Carro(int cod, String modelo, String marca, int ano, String dataAdicionado){
        this.cod = cod;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.dataAdicionado = dataAdicionado;
    }
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getDataAdicionado() {
        return dataAdicionado;
    }
    public void setDataAdicionado(String dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }
}