/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDatos;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public interface IConexionBD {
    public Connection crearConexion() throws SQLException ;
}
