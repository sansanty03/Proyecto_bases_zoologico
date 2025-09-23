/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDatos;

import Entidades.Zoologico;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IZoologicoDAO {
    public boolean agregar(Zoologico zoologico);
    public boolean actualizar (Zoologico zoologico);
    public boolean eliminar (int id);
    public Zoologico consultar (int id);
    public List<Zoologico> consultarTodos ();
    List<Zoologico> buscarZoologicos(String S);
}
