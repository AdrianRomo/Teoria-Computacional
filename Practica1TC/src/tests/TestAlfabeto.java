/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javax.swing.JOptionPane;
import sources.Alfabeto;
import sources.Palabra;
/**
 *
 * @author Adrian
 */
public class TestAlfabeto {
    public static void main(String[] args) {
        Alfabeto a = new Alfabeto();
        Alfabeto b = new Alfabeto();
        Alfabeto c = new Alfabeto();
        Alfabeto d = new Alfabeto();

        String simbolo=null;
        Palabra w1;
        Palabra w2;
        int x=0;

        JOptionPane.showMessageDialog(null,"Teoría Computacional\n        Practica 1 ");
        if(x==0){
            x=1;
            JOptionPane.showMessageDialog(null,"Por favor, inserta alfabeto 1, puedes hacerlo de dos formas: ");
            int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null, "1 = Simbolo a simbolo \n2 = Por  rango"));
            switch(opcion1){
                case 1:
                    int i=0;
                    boolean cond=true;
                    do {
                        simbolo = JOptionPane.showInputDialog(null, "Introduce un simbolo, para finalizar escribe \"Fin\": ");
                        if(simbolo.equals("Fin") && i<3) {
                            JOptionPane.showMessageDialog(null, "No has introducido 3 o mas simbolos, por favor, introduce mas simbolos");
                        }
                        else if(simbolo.equals("Fin") && i>=3) {
                            cond=false;
                        }
                        else {
                            a.insertarCaracteres1a1(simbolo);
                            i++;
                        }
                    } while(cond);
                    break;
                case 2:
                    String caracteres = JOptionPane.showInputDialog(null, "Introduce el rango: (ej. A-Z, a-z, 0-9)");
                    a.insertarCaracteresRango(caracteres);
                    break;
            }
        }
        if(x==1){
            JOptionPane.showMessageDialog(null,"Por favor, inserta alfabeto 2, puedes hacerlo de dos formas: ");
            int opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, "1 = Simbolo a simbolo \n2 = Por  rango"));
            switch(opcion2){
                case 1:
                    int i=0;
                    boolean cond=true;
                    do {
                        simbolo = JOptionPane.showInputDialog(null, "Introduce un simbolo, para finalizar escribe \"Fin\": ");
                        if(simbolo.equals("Fin") && i<3) {
                            JOptionPane.showMessageDialog(null, "No has introducido 3 o mas simbolos, por favor, introduce mas simbolos");
                        }
                        else if(simbolo.equals("Fin") && i>=3) {
                            cond=false;
                        }
                        else {
                            b.insertarCaracteres1a1(simbolo);
                            i++;
                        }
                    } while(cond);
                    break;
                case 2:
                    String caracteres = JOptionPane.showInputDialog(null, "Introduce el rango: (ej. A-Z, a-z, 0-9)");
                    b.insertarCaracteresRango(caracteres);
                    break;
            } 
        }

        do {
            w1 = new Palabra(JOptionPane.showInputDialog(null, "Introduce una palabra: "));
        } while(w1.validarPalabra(a)==false);
        do {
            w2 = new Palabra(JOptionPane.showInputDialog(null, "Introduce otra palabra: "));
        } while(w2.validarPalabra(a)==false);  
        
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce una potencia: "));
        System.out.println(w1.concatenarPalabras(w2).potencia(n));
        System.out.println("Longitud de (w1w2)^n: "+w1.concatenarPalabras(w2).potencia(n).longitud(a));
        
        simbolo=JOptionPane.showInputDialog(null, "Introduce un simbolo a buscar dentro de la palabra 1: ");
        System.out.println("La palabra 1 tiene " + w1.repeticionSimbolo(simbolo, a)+ " " + simbolo + "'s");
        
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce una potencia: "));
        System.out.println(w1.potencia(n));
        
        String cadena = JOptionPane.showInputDialog(null, "Introduce una cadena para indicarte prefijos, sufijos, subcadenas, etc: ");
        System.out.println(w1.toString());
        System.out.println(cadena + " es prefijo? " + w1.esPrefijo(cadena));
        System.out.println(cadena + " es prefijo propio? " + w1.esPrefijoPropio(cadena));
        System.out.println(cadena + " es sufijo? " + w1.esSufijo(cadena));
        System.out.println(cadena + " es sufijo propio? " + w1.esSufijoPropio(cadena));
        System.out.println(cadena + " es subcadena? " + w1.esSubcadena(cadena));
        
        System.out.println(w2.toString());
        System.out.println(cadena + " es prefijo? " + w2.esPrefijo(cadena));
        System.out.println(cadena + " es prefijo propio? " + w2.esPrefijoPropio(cadena));
        System.out.println(cadena + " es sufijo? " + w2.esSufijo(cadena));
        System.out.println(cadena + " es sufijo propio? " + w2.esSufijoPropio(cadena));
        System.out.println(cadena + " es subcadena? " + w2.esSubcadena(cadena));
        
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce una potencia para elevar el alfabeto: "));
        a.alfabetoPotencia(n).imprimirAlfabeto();
        
        System.out.println("∑1 ∙ ∑2");
        System.out.println(c.concatenarAlfabeto(a,b));
        System.out.println("∑1 ∙ ∑2 ∙ ∑1");
        System.out.println(d.concatenarAlfabetos(a,b,a));

    }
}
