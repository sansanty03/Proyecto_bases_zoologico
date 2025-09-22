/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;
import ImplementacionDatos.AnimalDAO;
import ImplementacionDatos.ConexionBD;
import ImplementacionDatos.EspecieDAO;
import ImplementacionDatos.ZoologicoDAO;
import ImplementacionesNegocio.*;
import InterfacesDatos.IAnimalDAO;
import InterfacesDatos.IConexionBD;
import InterfacesDatos.IEspecieDAO;
import InterfacesDatos.IZoologicoDAO;
import InterfacesNegocio.IAnimalBO;
import InterfacesNegocio.IEspecieBO;
import InterfacesNegocio.IZoologicoBO;
import javax.swing.JFrame;

/**
 *
 * @author riosr
 */
public class control {

    private IConexionBD conexion;

    // BOs
    private IAnimalBO animalBO;
    private IEspecieBO especieBO;
    private IZoologicoBO zoologicoBO;

    public control() {
        conexion = new ConexionBD("jdbc:mysql://localhost:3306/zoologicos?useSSL=false&serverTimezone=UTC"
                                  , "root"
                                  , "SanSanty03");
        IAnimalDAO Daoanimal = new AnimalDAO(conexion);
        IEspecieDAO DaoEspecie = new EspecieDAO(conexion);
        IZoologicoDAO ZoologicoDao = new ZoologicoDAO(conexion);
        animalBO = new AnimalBO(Daoanimal);
        especieBO = new EspecieBO(DaoEspecie);
        zoologicoBO = new ZoologicoBO(ZoologicoDao);
    }
    
    // metodos de navegación
    
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }
    
    public void navegarGUIAnimales(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIAnimales admin = new GUIAnimales(this);
        admin.setVisible(true);
    }
    
    public void navegarGUIZoologico(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIZoologicos admin = new GUIZoologicos(this);
        admin.setVisible(true);
    }
    
    public void navegarGUIEspecies(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIEspecies admin = new GUIEspecies(this);
        admin.setVisible(true);
    }
    
    public void navegarGUIMenuPrincipal(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIMenuPrincipal admin = new GUIMenuPrincipal(this);
        admin.setVisible(true);
    }
    
    public void IniciarSistema(){
        GUIMenuPrincipal admin = new GUIMenuPrincipal(this);
        admin.setVisible(true);
    }
    
    public void salirPrograma (JFrame frameActual){
        cerrarFrameActual(frameActual);
    }

    public IAnimalBO getAnimalBO() {
        return animalBO;
    }

    public IEspecieBO getEspecieBO() {
        return especieBO;
    }

    public IZoologicoBO getZoologicoBO() {
        return zoologicoBO;
    }
    
    
}
