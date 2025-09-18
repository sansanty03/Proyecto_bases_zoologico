/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author santi
 */
public class Zoologico {
    private int idZoologico;
    private String nombre;
    private String ciudad;
    private String pais;
    private Date fechaInauguracion;

    public Zoologico() {
    }

    public Zoologico(int idZoologico, String nombre, String ciudad, String pais, java.sql.Date fechaInauguracion) {
        this.idZoologico = idZoologico;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fechaInauguracion = fechaInauguracion;
    }

    public int getIdZoologico() {
        return idZoologico;
    }

    public void setIdZoologico(int idZoologico) {
        this.idZoologico = idZoologico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(Date fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }
}

