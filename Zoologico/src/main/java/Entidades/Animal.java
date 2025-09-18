/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author santi
 */
public class Animal {
    private int idAnimal;
    private String identificacion;
    private String sexo; 
    private int anioNacimiento;
    private int idEspecie;     
    private int idZoologico;  

    public Animal() {
    }

    public Animal(int idAnimal, String identificacion, String sexo, int anioNacimiento, int idEspecie, int idZoologico) {
        this.idAnimal = idAnimal;
        this.identificacion = identificacion;
        this.sexo = sexo;
        this.anioNacimiento = anioNacimiento;
        this.idEspecie = idEspecie;
        this.idZoologico = idZoologico;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public int getIdZoologico() {
        return idZoologico;
    }

    public void setIdZoologico(int idZoologico) {
        this.idZoologico = idZoologico;
    }
}
