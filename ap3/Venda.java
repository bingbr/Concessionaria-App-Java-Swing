package ap3;
//@author William S.
public class Venda {
    private int id;
    private String nomeCliente;
    private String modeloCarro;
    private String preco;
    private String dataAdicionado;
    
    public Venda(){
    }
    public Venda(int id, String nomeCliente, String modeloCarro, String preco, String dataAdicionado){
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.modeloCarro = modeloCarro;
        this.preco = preco;
        this.dataAdicionado = dataAdicionado;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getModeloCarro() {
        return modeloCarro;
    }
    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }
    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }
    public String getDataAdicionado() {
        return dataAdicionado;
    }
    public void setDataAdicionado(String dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }
}