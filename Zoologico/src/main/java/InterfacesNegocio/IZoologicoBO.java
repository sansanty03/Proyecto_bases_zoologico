/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import Entidades.Zoologico;
import java.util.List;
/**
 *
 * @author santi
 */


public interface IZoologicoBO {

    boolean registrarZoologico(Zoologico z);

    boolean modificarZoologico(Zoologico z);

    boolean eliminarZoologico(int id);

    Zoologico obtenerZoologicoPorId(int id);

    List<Zoologico> listarZoologicos();
}
