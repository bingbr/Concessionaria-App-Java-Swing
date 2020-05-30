package ap3;
//@author William S.
public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String dataAdicionado;
    
    public Cliente(){
    }
    public Cliente(String cpf, String nome, String email, String telefone, String dataAdicionado){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataAdicionado = dataAdicionado;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDataAdicionado() {
        return dataAdicionado;
    }
    public void setDataAdicionado(String dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }
}