/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia_9_relaciones_entre_clases.Entidades;

/**
 *
 * @author Usuario
 */
public class CartaEntidad {
    private int numero;
    private String palo;

    public CartaEntidad() {
    }

    public CartaEntidad(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "CartaEntidad{" + "numero=" + numero + ", palo=" + palo + '}';
    }
    
    
}