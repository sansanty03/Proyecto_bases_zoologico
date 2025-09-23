/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDatos;

import Entidades.Especie;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IEspecieDAO {
    public boolean agregar(Especie especie);
    public boolean actualizar (Especie especie);
    public boolean eliminar (int id);
    public Especie consultar (int id);
    public List<Especie> consultarTodos ();
    List<Especie> BuscarESpecies(String s);
}
