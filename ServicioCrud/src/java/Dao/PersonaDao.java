/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.CRUD;
import Modelo.Conexion;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SirGohan
 */
public class PersonaDao implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int resp;
    String msg;

    @Override
    public List listar() {
        List<Persona> data = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombres"));
                persona.setApellido(rs.getString("apellidos"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCorreo(rs.getString("correo"));
                persona.setIdTarjeta(rs.getInt("idTarjeta"));
                data.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("Listar Persona Error: " + e);
        }
        return data;
    }

    @Override
    public Persona listarId(int id) {
        Persona data = new Persona();
        String sql = "SELECT * FROM persona where id = ? ";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                data.setId(rs.getInt("id"));
                data.setNombre(rs.getString("nombres"));
                data.setApellido(rs.getString("apellidos"));
                data.setTelefono(rs.getString("telefono"));
                data.setDireccion(rs.getString("direccion"));
                data.setCorreo(rs.getString("correo"));
                data.setIdTarjeta(rs.getInt("idTarjeta"));
            }
        } catch (SQLException e) {
            System.out.println("Persona por Id Error: " + e);
        }
        return data;
    }

    @Override
    public String add(String Nombre, String Apellido, String Telefono, String direccion, String Correo,int idTarjeta) {
        String sql = "INSERT INTO persona(nombres, apellidos, telefono, direccion, correo,idTarjeta) VALUES (?,?,?,?,?,?) ";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, Telefono);
            ps.setString(4, direccion);
            ps.setString(5, Correo);
            ps.setInt(6, idTarjeta);
            resp = ps.executeUpdate();
            if (resp == 1) {
                msg = "0";
            } else {
                msg = "99";
            }
        } catch (SQLException e) {
            System.out.println("Agregar Persona Error: " + e);
            msg = "98";
        }
        return msg;
    }

    @Override
    public String edit(int id, String Nombre, String Apellido, String Telefono, String direccion, String Correo,int idTarjeta) {
        String sql = "UPDATE `persona` SET `nombres`=?,"
                + "`apellidos`=?,`telefono`=?,`direccion`=?,"
                + "`correo`=?,`idTarjeta`=? WHERE id = ? ";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, Telefono);
            ps.setString(4, direccion);
            ps.setString(5, Correo);
             ps.setInt(6, idTarjeta);
            ps.setInt(7, id);
            resp = ps.executeUpdate();
            if (resp == 1) {
                msg = "0";
            } else {
                msg = "99";
            }
        } catch (SQLException e) {
            System.out.println("Actualizar Persona Error: " + e);
            msg = "98";
        }
        return msg;
    }

    @Override
    public String delete(int id) {
        String sql = "DELETE FROM `persona` WHERE id = ? ";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            resp = ps.executeUpdate();
            if (resp == 1) {
                msg = "0";
            } else {
                msg = "99";
            }
        } catch (SQLException e) {
            System.out.println("Eliminar Persona Error: " + e);
            msg = "98";
        }
        return msg;
    }

}
