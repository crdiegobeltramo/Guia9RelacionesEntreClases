/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia_9_relaciones_entre_clases.Servicios;

import guia_9_relaciones_entre_clases.Entidades.Juego;
import guia_9_relaciones_entre_clases.Entidades.Jugador;
import guia_9_relaciones_entre_clases.Entidades.Revolver;
import java.util.ArrayList;
import java.util.Scanner;

/*
  2. Realizar el juego de la ruleta rusa de agua en Java. Como muchos saben, el juego se trata de
un número de jugadores, que, con un revolver de agua, el cual posee una sola carga de agua,
se dispara y se moja. Las clases por hacer del juego son las siguientes:
Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición 
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del 
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)
Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica 
si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero 
debe ser entre 1 y 6. Si no está en este rango, por defecto será 6. 
Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.
Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y 
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
10
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego
 */
 
public class JuegoService {
    Scanner  leer = new Scanner (System.in);
    /*llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.*/
   public void llenarRevolver(Revolver r){
        r.setPosicionActual ((int)(Math.random()*6)+1);
        r.setPosicionAgua((int)(Math.random()*6)+1);
    }
    //• mojar(): devuelve true si la posición del agua coincide con la posición actual
   public boolean mojar (Revolver r){
       if (r.getPosicionActual()== r.getPosicionAgua()) {
           return true;
       }
           return false;
           
   }
  //• siguienteChorro(): cambia a la siguiente posición del tambor
   public void siguienteChorro(Revolver r){
        if (r.getPosicionActual() == 6) {
            r.setPosicionActual(1);
            return;
        }
        
        r.setPosicionActual(r.getPosicionActual()+ 1);
    }
    /* //disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
    //mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
    //revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
    //devuelve true, sino false.*/
   public boolean disparo (Revolver r, Jugador j){
       if (mojar (r)) {
           j.setMojado(true);
       }else{
           j.setMojado(false);
       }
       siguienteChorro(r);
       return j.isMojado();
       }
   public Jugador crearJugador(int id){
      Jugador j = new Jugador();
      j.getId();
      j.setNombre("Jugador" + id);
      j.setMojado(false);
     
      return j;
   }
   public void llenarListaJugadores(ArrayList<Jugador>jugadores){
        int cantidadJugadores;
        System.out.println("Indique la cantidad de jugadores del 1 al 6");
        
        try {
            cantidadJugadores = leer.nextInt();
        } catch (Exception e) {
            cantidadJugadores = 6;     
        }        
        
        if (cantidadJugadores < 1 || cantidadJugadores > 6) {
            cantidadJugadores = 6;            
        }        
        
        for (int i = 0; i < cantidadJugadores; i++) {
            jugadores.add(crearJugador(i+1));
        }
    }
   //• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
    //y el revolver para guardarlos en los atributos del juego.
    //10
    
    public Juego llenarJuego(ArrayList<Jugador>jugadores, Revolver r){
        
        Juego juego = new Juego();
        
        // Metodo llenar jugadores
        llenarListaJugadores(jugadores);
        
        juego.setJugadores(jugadores);
        juego.setRevolver(r);
        
        return juego;       
        
    }
     //ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
    //aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
    //moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
    //mojar. Al final del juego, se debe mostrar que jugador se mojó.
    //Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
    
    public void ronda(Juego juego){
        boolean bandera;
        int contador = 0;       
        
        do {
            if (contador == juego.getJugadores().size()-1 ) {
                contador = 0;
            }                  
            
            bandera = disparo(juego.getRevolver(), juego.getJugadores().get(contador));
            
            if (!bandera) {
                contador += 1;
            }            

        } while (!bandera);
            
        System.out.println("El " + juego.getJugadores().get(contador) + " ha perdido");
        System.out.println("Fin del juego");        
        
    }
    
}
    
   

