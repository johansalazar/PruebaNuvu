/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Conexion;
import Modelo.TCRUD;
import Modelo.Tarjeta;
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
public class TarjetaDao implements TCRUD {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int resp;
    String msg;

    @Override
    public List listarTajeta() {
        List<Tarjeta> data = new ArrayList<>();
        String sql = "SELECT * FROM tarjeta";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setId(rs.getInt("id"));
                tarjeta.setNumero(rs.getString("numero"));
                tarjeta.setAgno(rs.getInt("agno"));
                tarjeta.setMes(rs.getInt("mes"));
                tarjeta.setCodigo(rs.getInt("codigo"));
                data.add(tarjeta);
            }
        } catch (SQLException e) {
            System.out.println("Listar Tarjeta Error: " + e);
        }
        return data;
    }
    
     @Override
    public List listarTajetasLibres() {
        List<Tarjeta> data = new ArrayList<>();
        String sql = "SELECT tar.`id` , tar.`numero` , tar.`agno` , tar.`mes` "
                + ", tar.`codigo` FROM `tarjeta` as tar "
                + "left join `persona` as per on tar.id = per.idtarjeta "
                + "WHERE per.idtarjeta is null";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setId(rs.getInt("id"));
                tarjeta.setNumero(rs.getString("numero"));
                tarjeta.setAgno(rs.getInt("agno"));
                tarjeta.setMes(rs.getInt("mes"));
                tarjeta.setCodigo(rs.getInt("codigo"));
                data.add(tarjeta);
            }
        } catch (SQLException e) {
            System.out.println("Listar Tarjetas Libres Error: " + e);
        }
        return data;
    }

    @Override
    public Tarjeta tarjetaId(int id) {
        Tarjeta tarjeta = new Tarjeta();
        String sql = "SELECT * FROM tarjeta where id = ? ";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                tarjeta.setId(rs.getInt("id"));
                tarjeta.setNumero(rs.getString("numero"));
                tarjeta.setAgno(rs.getInt("agno"));
                tarjeta.setMes(rs.getInt("mes"));
                tarjeta.setCodigo(rs.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Tarjeta por Id Error: " + e);
        }
        return tarjeta;
    }

    @Override
    public String addTarjeta(String Numero, int Agno, int Mes, int Codigo) {
        String sql = "INSERT INTO tarjeta(`numero`, `agno`, `mes`, `codigo`) VALUES (?,?,?,?) ";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Numero);
            ps.setInt(2, Agno);
            ps.setInt(3, Mes);
            ps.setInt(4, Codigo);
            resp = ps.executeUpdate();
            if (resp == 1) {
                msg = "0";
            } else {
                msg = "99";
            }
        } catch (SQLException e) {
            System.out.println("Agregar Tarjeta Error: " + e);
            msg = "98";
        }
        return msg;
    }

    @Override
    public String editTarjeta(int id, String Numero, int Agno, int Mes, int Codigo) {
        String sql = "UPDATE `tarjeta` SET `numero`=?,"
                + "`agno`=?,`mes`=?,`codigo`=? WHERE id = ? ";
        try {
            con = conex.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Numero);
            ps.setInt(2, Agno);
            ps.setInt(3, Mes);
            ps.setInt(4, Codigo);
            ps.setInt(5, id);
            resp = ps.executeUpdate();
            if (resp == 1) {
                msg = "0";
            } else {
                msg = "99";
            }
        } catch (SQLException e) {
            System.out.println("Actualizar Tarjeta Error: " + e);
            msg = "98";
        }
        return msg;
    }

    @Override
    public String deleteTarjeta(int id) {
        String sql = "DELETE FROM `tarjeta` WHERE id = ? ";
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
            System.out.println("Eliminar Tarjeta Error: " + e);
            msg = "98";
        }
        return msg;
    }

}
