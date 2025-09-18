/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImplementacionesNegocio;

import Entidades.Zoologico;
import InterfacesDatos.IZoologicoDAO;
import InterfacesNegocio.IZoologicoBO;
import Excepciones.NegocioException;
import java.util.List;
/**
 *
 * @author santi
 */


public class ZoologicoBO implements IZoologicoBO {

    private final IZoologicoDAO dao;

    public ZoologicoBO(IZoologicoDAO dao) {
        this.dao = dao;
    }

    private void validar(Zoologico z) throws NegocioException {
        if (z == null)
            throw new NegocioException("Zoológico no puede ser nulo");
        if (z.getNombre() == null || z.getNombre().isEmpty())
            throw new NegocioException("Nombre vacío");
        if (z.getCiudad() == null || z.getCiudad().isEmpty())
            throw new NegocioException("Ciudad vacía");
        if (z.getPais() == null || z.getPais().isEmpty())
            throw new NegocioException("País vacío");
        if (z.getFechaInauguracion() == null)
            throw new NegocioException("Fecha de inauguración nula");
    }

    @Override
    public boolean registrarZoologico(Zoologico z) {
        try {
            validar(z);
            return dao.agregar(z);
        } catch (NegocioException ex) {
            System.out.println("Error al registrar zoológico: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarZoologico(Zoologico z) {
        try {
            validar(z);
            if (z.getIdZoologico() <= 0)
                throw new NegocioException("ID de zoológico inválido");
            return dao.actualizar(z);
        } catch (NegocioException ex) {
            System.out.println("Error al modificar zoológico: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarZoologico(int id) {
        if (id <= 0) {
            System.out.println("ID de zoológico inválido");
            return false;
        }
        return dao.eliminar(id);
    }

    @Override
    public Zoologico obtenerZoologicoPorId(int id) {
        if (id <= 0)
            throw new RuntimeException("ID de zoológico inválido");
        return dao.consultar(id);
    }

    @Override
    public List<Zoologico> listarZoologicos() {
        return dao.consultarTodos();
    }
}

