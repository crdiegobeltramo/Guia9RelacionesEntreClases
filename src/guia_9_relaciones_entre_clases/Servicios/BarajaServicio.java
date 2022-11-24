/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia_9_relaciones_entre_clases.Servicios;


import guia_9_relaciones_entre_clases.Entidades.BarajaEntidad;
import guia_9_relaciones_entre_clases.Entidades.CartaEntidad;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class BarajaServicio {

    int cont = 1;

    public ArrayList<CartaEntidad> inicio() {
        ArrayList<CartaEntidad> miBaraja2 = new ArrayList();
        BarajaEntidad miBarajaEntidad = new BarajaEntidad();
        int cont2 = 0;
        while (cont2 != 40) {
            CartaEntidad miCarta = crearCarta();
            miBaraja2.add(miCarta);
            miBarajaEntidad.setBaraja (miBaraja2);
            cont2 = cont2 + 1;
        }
        return miBaraja2;
    }

    String palo = "oro";

    public CartaEntidad crearCarta() {
        CartaEntidad miCarta = new CartaEntidad();

        if (cont == 8) {
            cont = 10;
        }

        if (cont == 13) {
            if (palo.equals("oro")) {
                palo = "espada";
                cont = 1;
            } else if (palo.equals("espada")) {
                cont = 1;
                palo = "basto";
            } else if (palo.equals("basto")) {
                cont = 1;
                palo = "copa";
            }
        }

        miCarta.setNumero(cont);
        miCarta.setPalo(palo);
        cont = cont + 1;
        return miCarta;
    }

    public void barajar(ArrayList<CartaEntidad> miCarta) {
        Collections.shuffle(miCarta);
    }

    public void darCartas(ArrayList<CartaEntidad> miCarta, int num) {
        siguienteCarta(miCarta, num);
    }

    ArrayList<CartaEntidad> miCartasSacadas = new ArrayList();

    public ArrayList<CartaEntidad> siguienteCarta(ArrayList<CartaEntidad> miCarta, int num) {

        for (int i = 1; i <= num; i++) {
            if (num == 1) {
                System.out.println("LA CARTA QUE SACO ES:");
                System.out.println(miCarta.get(0).getNumero() + " de " + miCarta.get(0).getPalo());
                miCartasSacadas.add(miCarta.get(0));
                miCarta.remove(0);
            } else {
                System.out.println("LAS CARTAS QUE SACO ES:");
                System.out.println(miCarta.get(0).getNumero() + " de " + miCarta.get(0).getPalo());
                miCartasSacadas.add(miCarta.get(0));
                miCarta.remove(0);
            }
        }
        return miCartasSacadas;
    }

    public void cartasMonton() {

        System.out.println(miCartasSacadas);
    }

    public int cartasDisponibles(ArrayList<CartaEntidad> miCarta) {
        int disponible = miCarta.size();

        return disponible;
    }

    public void mostrar(ArrayList<CartaEntidad> miCarta) {
        System.out.println("--------------- LAS CARTAS SON: ----------------------");
        System.out.println(miCarta);
        System.out.println("HAY " + cartasDisponibles(miCarta) + " CARTAS EN EL MASO");

        barajar(miCarta);
        System.out.println("-------------- LAS CARTAS DESORDENADAS SON: ----------------");
        System.out.println(miCarta);

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opc = 1;
        String opc2;

        while (opc != 0) {
            int cantidad = 0;

            if (miCarta.size() > 1) {
                System.out.println("--------------- LAS CARTAS QUE QUEDARON EN EL MASO SON: ----------------------");
                System.out.println(miCarta);
            } else {
                opc = 0;
                System.out.println("NO QUEDARON CARTAS EN EL MASO");
            }

            if (miCarta.size() > 0) {
                System.out.println("QUEDAN " + cartasDisponibles(miCarta) + " CARTAS EN EL MASO");
                System.out.println("Desea sacar una carta?");
                opc2 = leer.next();

                if ("S".equals(opc2) || "s".equals(opc2) || "Si".equals(opc2) || "si".equals(opc2)) {
                    opc = 1;
                    System.out.println("Cuatas cartas quiere sacar?");
                    cantidad = leer.nextInt();

                    if (cantidad > miCarta.size()) {
                        System.out.println("EL NUMERO DE CARTAS INGRESADAS SUPERA AL DEL MASO, VULVE A INTENTARLO");
                    } else {
                        darCartas(miCarta, cantidad);

                    }

                } else {
                    opc = 0;
                }
            } else {
                System.out.println("-------------- NO HAY MAS CARTA EN LA BARAJA ---------------");
            }

            System.out.println("------------LAS CARTAS QUE SE SACO HASTA EL MOMENTO SON: -----------");
            cartasMonton();
        }

    }

}