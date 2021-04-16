/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SirGohan
 */
public class Conexion {
    
    Connection con;
    public Conexion(){
        try {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3308/prueba","root","");
        }
        catch(Exception e){
            System.out.println("Error sql: "+ e ); 
        }    
    }
    public Connection obtenerConexion(){
        return con;
    }
    public void cerrarConexion() throws SQLException{
        con.close();
    }
    
}
