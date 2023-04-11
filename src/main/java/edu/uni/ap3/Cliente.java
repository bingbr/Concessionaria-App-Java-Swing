package edu.uni.ap3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author William S.
 */
public class Cliente {
    private Long cpf;
    private String nome;
    private String email;
    private Long telefone;
    private Date data;

    public Cliente(Long cpf, String nome, String email, Long telefone, Date data) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.data = data;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getCpfFormatado() {
        String cpfString = Data.fixDataString(cpf.toString());
        return cpfString.substring(0, 3) + "." + cpfString.substring(3, 6) + "." + cpfString.substring(6, 9) + "-"+ cpfString.substring(9);
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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneFormatado() {
        String telefoneString = telefone.toString();
        return "(" + telefoneString.substring(0, 2) + ")" + telefoneString.substring(2, 7) + "-" + telefoneString.substring(7);
    }

    public Date getData() {
        return data;
    }

    public String getDataAdicionado() {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    @Override
    public String toString() {
        return nome;
    }
}