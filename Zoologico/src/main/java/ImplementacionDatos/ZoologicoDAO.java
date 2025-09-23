/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImplementacionDatos;

import Entidades.Zoologico;
import InterfacesDatos.IConexionBD;
import InterfacesDatos.IZoologicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 *
 * @author santi
 */


public class ZoologicoDAO implements IZoologicoDAO {

    private final IConexionBD conexion;

    public ZoologicoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Zoologico zoo) {
        String sql = "INSERT INTO zoologicos(nombre, ciudad, pais, fecha_inauguracion) VALUES(?, ?, ?, ?)";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, zoo.getNombre());
            ps.setString(2, zoo.getCiudad());
            ps.setString(3, zoo.getPais());
            ps.setDate(4, new java.sql.Date(zoo.getFechaInauguracion().getTime()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar zoológico: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Zoologico zoo) {
        String sql = "UPDATE zoologicos SET nombre=?, ciudad=?, pais=?, fecha_inauguracion=? WHERE id_zoologico=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, zoo.getNombre());
            ps.setString(2, zoo.getCiudad());
            ps.setString(3, zoo.getPais());
            ps.setDate(4, new java.sql.Date(zoo.getFechaInauguracion().getTime()));
            ps.setInt(5, zoo.getIdZoologico());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar zoológico: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM zoologicos WHERE id_zoologico=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar zoológico: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Zoologico consultar(int id) {
        String sql = "SELECT * FROM zoologicos WHERE id_zoologico=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Zoologico z = new Zoologico();
                z.setIdZoologico(rs.getInt("id_zoologico"));
                z.setNombre(rs.getString("nombre"));
                z.setCiudad(rs.getString("ciudad"));
                z.setPais(rs.getString("pais"));
                z.setFechaInauguracion(new Date(rs.getDate("fecha_inauguracion").getTime()));
                return z;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar zoológico: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Zoologico> consultarTodos() {
        String sql = "SELECT * FROM zoologicos";
        List<Zoologico> lista = new ArrayList<>();

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Zoologico z = new Zoologico();
                z.setIdZoologico(rs.getInt("id_zoologico"));
                z.setNombre(rs.getString("nombre"));
                z.setCiudad(rs.getString("ciudad"));
                z.setPais(rs.getString("pais"));
                z.setFechaInauguracion(new Date(rs.getDate("fecha_inauguracion").getTime()));
                lista.add(z);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar todos los zoológicos: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public List<Zoologico> buscarZoologicos(String S) {
         String sql = "SELECT * FROM zoologicos WHERE nombre LIKE ? OR ciudad LIKE ? OR pais LIKE ?";
    List<Zoologico> lista = new ArrayList<>();

    try (Connection conn = conexion.crearConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        String busqueda = "%" + S + "%";
        ps.setString(1, busqueda);
        ps.setString(2, busqueda);
        ps.setString(3, busqueda);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Zoologico z = new Zoologico();
                z.setIdZoologico(rs.getInt("id_zoologico"));
                z.setNombre(rs.getString("nombre"));
                z.setCiudad(rs.getString("ciudad"));
                z.setPais(rs.getString("pais"));
                z.setFechaInauguracion(new Date(rs.getDate("fecha_inauguracion").getTime()));
                lista.add(z);
            }
        }

        } catch (SQLException e) {
            System.out.println("Error al buscar zoológicos: " + e.getMessage());
        }

        return lista;
    }
}

