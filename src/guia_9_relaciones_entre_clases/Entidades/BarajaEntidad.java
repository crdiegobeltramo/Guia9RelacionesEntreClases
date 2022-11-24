/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia_9_relaciones_entre_clases.Entidades;
import guia_9_relaciones_entre_clases_Entidades.CartaEntidad;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class BarajaEntidad {
    ArrayList <CartaEntidad>   baraja;

    public BarajaEntidad() {
    }
    
    public BarajaEntidad(ArrayList<CartaEntidad> baraja) {
        this.baraja = baraja;
    }

    public ArrayList<CartaEntidad> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<CartaEntidad> baraja) {
        this.baraja = baraja;
    }

    
    
}