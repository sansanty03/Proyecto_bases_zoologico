/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImplementacionDatos;

import Entidades.Especie;
import InterfacesDatos.IConexionBD;
import InterfacesDatos.IEspecieDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author santi
 */


public class EspecieDAO implements IEspecieDAO {

    private final IConexionBD conexion;

    public EspecieDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Especie esp) {
        String sql = "INSERT INTO especies(nombre_vulgar, nombre_cientifico, familia, peligro_extincion) VALUES(?, ?, ?, ?)";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, esp.getNombreVulgar());
            ps.setString(2, esp.getNombreCientifico());
            ps.setString(3, esp.getFamilia());
            ps.setBoolean(4, esp.isPeligroExtincion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar especie: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Especie esp) {
        String sql = "UPDATE especies SET nombre_vulgar=?, nombre_cientifico=?, familia=?, peligro_extincion=? WHERE id_especie=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, esp.getNombreVulgar());
            ps.setString(2, esp.getNombreCientifico());
            ps.setString(3, esp.getFamilia());
            ps.setBoolean(4, esp.isPeligroExtincion());
            ps.setInt(5, esp.getIdEspecie());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar especie: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM especies WHERE id_especie=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar especie: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Especie consultar(int id) {
        String sql = "SELECT * FROM especies WHERE id_especie=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Especie e = new Especie();
                e.setIdEspecie(rs.getInt("id_especie"));
                e.setNombreVulgar(rs.getString("nombre_vulgar"));
                e.setNombreCientifico(rs.getString("nombre_cientifico"));
                e.setFamilia(rs.getString("familia"));
                e.setPeligroExtincion(rs.getBoolean("peligro_extincion"));
                return e;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar especie: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Especie> consultarTodos() {
        String sql = "SELECT * FROM especies";
        List<Especie> lista = new ArrayList<>();

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Especie e = new Especie();
                e.setIdEspecie(rs.getInt("id_especie"));
                e.setNombreVulgar(rs.getString("nombre_vulgar"));
                e.setNombreCientifico(rs.getString("nombre_cientifico"));
                e.setFamilia(rs.getString("familia"));
                e.setPeligroExtincion(rs.getBoolean("peligro_extincion"));
                lista.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar todas las especies: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public List<Especie> BuscarESpecies(String s) {
        String sql = "SELECT * FROM especies WHERE nombre_vulgar LIKE ? OR nombre_cientifico LIKE ? OR familia LIKE ?";
        List<Especie> lista = new ArrayList<>();

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String busqueda = "%" + s + "%";
            ps.setString(1, busqueda);
            ps.setString(2, busqueda);
            ps.setString(3, busqueda);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Especie e = new Especie();
                    e.setIdEspecie(rs.getInt("id_especie"));
                    e.setNombreVulgar(rs.getString("nombre_vulgar"));
                    e.setNombreCientifico(rs.getString("nombre_cientifico"));
                    e.setFamilia(rs.getString("familia"));
                    e.setPeligroExtincion(rs.getBoolean("peligro_extincion"));
                    lista.add(e);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar especies: " + ex.getMessage());
        }

        return lista;
    }
}

