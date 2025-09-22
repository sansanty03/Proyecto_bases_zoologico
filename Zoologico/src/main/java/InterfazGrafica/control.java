/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;
import ImplementacionesNegocio.*;
import gui.GUIEspecies;
import javax.swing.JFrame;

/**
 *
 * @author riosr
 */
public class control {

    public control() {
    
    }
    
    // metodos de navegación
    
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }
    
    public void navegarGUIAnimales(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIAnimales admin = new GUIAnimales();
        admin.setVisible(true);
    }
    
    public void navegarGUIZoologico(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIZoologicos admin = new GUIZoologicos();
        admin.setVisible(true);
    }
    
    public void navegarGUIEspecies(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        gui.GUIEspecies admin = new GUIEspecies();
        admin.setVisible(true);
    }
    
    public void navegarGUIMenuPrincipal(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIMenuPrincipal admin = new GUIMenuPrincipal();
        admin.setVisible(true);
    }
    
    public void salirPrograma (JFrame frameActual){
        cerrarFrameActual(frameActual);
    }
}
