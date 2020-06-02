/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javax.swing.JOptionPane;
import sources.APD;
import sources.APND;

/**
 *
 * @author Adrian
 */
public class testAP {
    public static void main(String[] args) {
        APD ej1 = new APD();
        APD ej2 = new APD();
        APD ej3 = new APD();
        APND ej4 = new APND();
        APND ej5 = new APND();
        
        String cadena;
        int opcion=0;
        JOptionPane.showMessageDialog(null,"Practica 6 de TC");
        
              do {
            cadena = JOptionPane.showInputDialog(null,"Introduce la cadena a evaluar para el ejercicio libre: ");
        
            ej1.setCadena(cadena);
        
            System.out.println("Resultados de la cadena del ejercicio 1: ");
            if(ej1.validarEjercicio1()) {
                System.out.println("La cadena esta correcta.");
            }
            else {
                System.out.println("Algo anda mal con tu cadena.");
            }
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Repetir? (1 = Si)"));
        } while(opcion==1);
           
        do {
            cadena = JOptionPane.showInputDialog(null,"Introduce la cadena a evaluar para el primer ejercicio: ");
        
            ej2.setCadena(cadena);
        
            System.out.println("Resultados de la cadena del ejercicio 1: ");
            if(ej2.validarEjercicio2()) {
                System.out.println("La cadena esta correcta.");
            }
            else {
                System.out.println("Algo anda mal con tu cadena.");
            }
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Repetir? (1 = Si)"));
        } while(opcion==1);
  
        do {
            cadena = JOptionPane.showInputDialog(null,"Introduce la cadena a evaluar para el segundo ejercicio: ");
        
            ej3.setCadena(cadena);
        
            System.out.println("Resultados de la cadena del ejercicio 2: ");
            if(ej3.validarEjercicio3()) {
                System.out.println("La cadena esta correcta.");
            }
            else {
                System.out.println("Algo anda mal con tu cadena.");
            }
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Repetir? (1 = Si)"));
        } while(opcion==1);
        
        do {
            cadena = JOptionPane.showInputDialog(null,"Introduce la cadena a evaluar para el tercer ejercicio: ");
        
            ej4.setCadena(cadena);
        
            System.out.println("Resultados de la cadena del ejercicio 3: ");
            if(ej4.validarEjercicio4()) {
                System.out.println("La cadena esta correcta.");
            }
            else {
                System.out.println("Algo anda mal con tu cadena.");
            }
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Repetir? (1 = Si)"));
        } while(opcion==1);
        
        do {
            cadena = JOptionPane.showInputDialog(null,"Introduce la cadena a evaluar para el cuarto ejercicio: ");
        
            ej5.setCadena(cadena);
        
            System.out.println("Resultados de la cadena del ejercicio 4: ");
            if(ej5.validarEjercicio5()) {
                System.out.println("La cadena esta correcta.");
            }
            else {
                System.out.println("Algo anda mal con tu cadena.");
            }
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Repetir? (1 = Si)"));
        } while(opcion==1);
    }
}
