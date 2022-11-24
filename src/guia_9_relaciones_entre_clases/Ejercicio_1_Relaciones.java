/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia_9_relaciones_entre_clases;

import guia_9_relaciones_entre_clases.Entidades.Perro;
import guia_9_relaciones_entre_clases.Entidades.Persona;

/**
   //Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
   clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
   tributos: nombre, apellido, edad, documento y Perro.
   Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
   pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
   la clase Persona, la información del Perro y de la Persona.
 */
public class Ejercicio_1_Relaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      

        Perro perro1 = new Perro();
        Perro perro2 = new Perro();
        Persona persona1 = new Persona();
        Persona persona2 = new Persona();

        perro1.setNombre("Duke");
        perro1.setEdad(4);
        perro1.setRaza("Chihuaha");
        perro1.setTamanio(4);

        perro2.setNombre("Tom");
        perro2.setEdad(5);
        perro2.setRaza("Ovejero");
        perro2.setTamanio(2);

        persona1.setNombre("Carlos");
        persona1.setApellido("Hernandez");
        persona1.setDNI("27898456");
        persona1.setEdad(Integer.SIZE);
        persona1.setPerro(perro1);

        persona2.setNombre("Karen");
        persona2.setApellido("Hernandez");
        persona2.setDNI ("464980007");
        persona2.setEdad(25);
        persona2.setPerro(perro2);

        System.out.println("Persona1");
        System.out.println(persona1.toString());
        System.out.println("Persona2");
        System.out.println(persona2.toString());

    }

}
