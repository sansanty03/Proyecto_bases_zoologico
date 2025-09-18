/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImplementacionDatos;

import Entidades.Animal;
import InterfacesDatos.IAnimalDAO;
import InterfacesDatos.IConexionBD;
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

public class AnimalDAO implements IAnimalDAO {

    private final IConexionBD conexion;

    public AnimalDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Animal a) {
        String sql = "INSERT INTO animales(identificacion, sexo, año_nacimiento, id_especie, id_zoologico) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getIdentificacion());
            ps.setString(2, a.getSexo());
            ps.setInt(3, a.getAnioNacimiento());
            ps.setInt(4, a.getIdEspecie());
            ps.setInt(5, a.getIdZoologico());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar animal: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Animal a) {
        String sql = "UPDATE animales SET identificacion=?, sexo=?, año_nacimiento=?, id_especie=?, id_zoologico=? WHERE id_animal=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getIdentificacion());
            ps.setString(2, a.getSexo());
            ps.setInt(3, a.getAnioNacimiento());
            ps.setInt(4, a.getIdEspecie());
            ps.setInt(5, a.getIdZoologico());
            ps.setInt(6, a.getIdAnimal());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar animal: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM animales WHERE id_animal=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar animal: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Animal consultar(int id) {
        String sql = "SELECT * FROM animales WHERE id_animal=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Animal a = new Animal();
                a.setIdAnimal(rs.getInt("id_animal"));
                a.setIdentificacion(rs.getString("identificacion"));
                a.setSexo(rs.getString("sexo"));
                a.setAnioNacimiento(rs.getInt("año_nacimiento"));
                a.setIdEspecie(rs.getInt("id_especie"));
                a.setIdZoologico(rs.getInt("id_zoologico"));
                return a;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar animal: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Animal> consultarTodos() {
        String sql = "SELECT * FROM animales";
        List<Animal> lista = new ArrayList<>();

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Animal a = new Animal();
                a.setIdAnimal(rs.getInt("id_animal"));
                a.setIdentificacion(rs.getString("identificacion"));
                a.setSexo(rs.getString("sexo"));
                a.setAnioNacimiento(rs.getInt("año_nacimiento"));
                a.setIdEspecie(rs.getInt("id_especie"));
                a.setIdZoologico(rs.getInt("id_zoologico"));
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar todos los animales: " + e.getMessage());
        }

        return lista;
    }
}
