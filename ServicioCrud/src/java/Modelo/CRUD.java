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
public interface CRUD {

    public List listar();

    public Persona listarId(int id);

    public String add(String Nombre, String Apellido, String Telefono, String direccion, String Correo,int idTarjeta);

    public String edit(int id, String Nombre, String Apellido, String Telefono, String direccion, String Correo,int idTarjeta);

    public String delete(int id);
  
}
