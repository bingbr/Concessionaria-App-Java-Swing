package edu.uni.ap3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author William S.
 */
public class Carro {
    private int cod;
    private String modelo;
    private String marca;
    private int ano;
    private Date data;
    
    public Carro(int cod, String modelo, String marca, int ano, Date data){
        this.cod = cod;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.data = data;
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

    public Date getData() {
        return data;
    }

    public String getDataAdicionado() {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " " + ano;
    }
}