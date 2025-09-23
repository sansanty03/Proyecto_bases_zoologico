/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImplementacionesNegocio;
import Entidades.Animal;
import InterfacesDatos.IAnimalDAO;
import InterfacesNegocio.IAnimalBO;
import Excepciones.NegocioException;
import java.util.List;
/**
 *
 * @author santi
 */


public class AnimalBO implements IAnimalBO {

    private final IAnimalDAO dao;

    public AnimalBO(IAnimalDAO dao) {
        this.dao = dao;
    }

    private void validar(Animal a) throws NegocioException {
        if (a == null)
            throw new NegocioException("El Animal no puede ser nulo");
        if (a.getIdentificacion() == null || a.getIdentificacion().isEmpty())
            throw new NegocioException("La identificación no puede estar vacía");
        if (a.getSexo() == null || a.getSexo().isEmpty())
            throw new NegocioException("El sexo no puede estar vacío");
        if (a.getAnioNacimiento() <= 0)
            throw new NegocioException("El año de nacimiento debe ser positivo");
        if (a.getIdEspecie() <= 0)
            throw new NegocioException("Debe asignar una especie válida");
        if (a.getIdZoologico() <= 0)
            throw new NegocioException("Debe asignar un zoológico válido");
    }

    @Override
    public boolean registrarAnimal(Animal a) {
        try {
            validar(a);
            return dao.agregar(a);
        } catch (NegocioException e) {
            System.out.println("Error al registrar animal: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarAnimal(Animal a) {
        try {
            validar(a);
            if (a.getIdAnimal() <= 0)
                throw new NegocioException("ID de animal inválido");
            return dao.actualizar(a);
        } catch (NegocioException e) {
            System.out.println("Error al modificar animal: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean removerAnimal(int id) {
        if (id <= 0) {
            System.out.println("ID de animal inválido");
            return false;
        }
        return dao.eliminar(id);
    }

    @Override
    public Animal obtenerAnimalPorId(int id) {
        if (id <= 0)
            throw new RuntimeException("ID de animal inválido");
        return dao.consultar(id);
    }

    @Override
    public List<Animal> obtenerTodosLosAnimales() {
        return dao.consultarTodos();
    }

    @Override
    public List<Animal> buscarAnimales(String s) {
        return dao.buscarAnimales(s);
    }
}

