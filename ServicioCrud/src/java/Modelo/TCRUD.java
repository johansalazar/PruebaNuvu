/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author SirGohan
 */
public interface TCRUD {

    public List listarTajeta();
    
    public List listarTajetasLibres();

    public Tarjeta tarjetaId(int id);

    public String addTarjeta(String Numero, int Agno, int Mes, int Codigo);

    public String editTarjeta(int id, String Numero, int Agno, int Mes, int Codigo);

    public String deleteTarjeta(int id);
}
