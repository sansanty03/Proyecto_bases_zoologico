/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImplementacionesNegocio;

import Entidades.Especie;
import InterfacesDatos.IEspecieDAO;
import InterfacesNegocio.IEspecieBO;
import Excepciones.NegocioException;
import Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author santi
 */

public class EspecieBO implements IEspecieBO {

    private final IEspecieDAO dao;

    public EspecieBO(IEspecieDAO dao) {
        this.dao = dao;
    }

    private void validar(Especie e) throws NegocioException {
        if (e == null)
            throw new NegocioException("Especie no puede ser nula");
        if (e.getNombreVulgar() == null || e.getNombreVulgar().isEmpty())
            throw new NegocioException("Nombre vulgar vacío");
        if (e.getNombreCientifico() == null || e.getNombreCientifico().isEmpty())
            throw new NegocioException("Nombre científico vacío");
        if (e.getFamilia() == null || e.getFamilia().isEmpty())
            throw new NegocioException("Familia vacía");
    }

    @Override
    public boolean registrarEspecie(Especie e) {
        try {
            validar(e);
            return dao.agregar(e);
        } catch (NegocioException ex) {
            System.out.println("Error al registrar especie: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarEspecie(Especie e) {
        try {
            validar(e);
            if (e.getIdEspecie() <= 0)
                throw new NegocioException("ID de especie inválido");
            return dao.actualizar(e);
        } catch (NegocioException ex) {
            System.out.println("Error al actualizar especie: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarEspecie(int id) {
        if (id <= 0) {
            System.out.println("ID de especie inválido");
            return false;
        }
        return dao.eliminar(id);
    }

    @Override
    public Especie obtenerEspeciePorId(int id) {
        if (id <= 0)
            throw new RuntimeException("ID de especie inválido");
        return dao.consultar(id);
    }

    @Override
    public List<Especie> listarEspecies() {
        return dao.consultarTodos();
    }

    @Override
    public List<Especie> BuscarESpecies(String s) {
       return dao.BuscarESpecies(s);
    }
}
