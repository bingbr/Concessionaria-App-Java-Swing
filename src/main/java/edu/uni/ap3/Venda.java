package edu.uni.ap3;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author William S.
 */
public class Venda {
    private int id;
    private String carro;
    private String cliente;
    private Double preco;
    private Date data;

    public Venda(int id, String carro, String cliente, Double preco, Date data) {
        this.id = id;
        this.carro = carro;
        this.cliente = cliente;
        this.preco = preco;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getCarro() {
        return carro;
    }

    public String getCliente() {
        return cliente;
    }

    public Double getPreco() {
        return preco;
    }

    public String getPrecoFormatado() {
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String formatado = moeda.format(preco);
        return (formatado.indexOf(".") == formatado.length() - 2) ? formatado += "0" : formatado;
    }

    public Date getData() {
        return data;
    }

    public String getDataAdicionado() {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
}