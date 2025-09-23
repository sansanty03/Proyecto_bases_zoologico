/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;
import Entidades.Especie;
import java.util.List;
/**
 *
 * @author santi
 */



public interface IEspecieBO {

    boolean registrarEspecie(Especie e);

    boolean actualizarEspecie(Especie e);

    boolean eliminarEspecie(int id);

    Especie obtenerEspeciePorId(int id);

    List<Especie> listarEspecies();
    
    List<Especie> BuscarESpecies(String s);
}

