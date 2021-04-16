/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SirGohan
 */
public class Tarjeta {

    int id;
    String Numero;
    int Agno;
    int Mes;
    int Codigo;

     public Tarjeta() {
    }
     
    public Tarjeta(int id, String Numero, int Agno, int Mes, int Codigo) {
        this.id = id;
        this.Numero = Numero;
        this.Agno = Agno;
        this.Mes = Mes;
        this.Codigo = Codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public int getAgno() {
        return Agno;
    }

    public void setAgno(int Agno) {
        this.Agno = Agno;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
      

}
