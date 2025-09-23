/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDatos;

import Entidades.Animal;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IAnimalDAO {
    public boolean agregar(Animal animal);
    public boolean actualizar (Animal animal);
    public boolean eliminar (int id);
    public Animal consultar (int id);
    public List<Animal> consultarTodos ();
    List<Animal> buscarAnimales(String s);
}
