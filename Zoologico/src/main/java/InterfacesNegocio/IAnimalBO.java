/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfacesNegocio;

import Entidades.Animal;
import java.util.List;

/**
 *
 * @author santi
 */

public interface IAnimalBO {

    boolean registrarAnimal(Animal a);

    boolean modificarAnimal(Animal a);

    boolean removerAnimal(int id);

    Animal obtenerAnimalPorId(int id);

    List<Animal> obtenerTodosLosAnimales();
}

