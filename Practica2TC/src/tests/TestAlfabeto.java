/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javax.swing.JOptionPane;
import sources.Alfabeto;
import sources.Palabra;
import sources.Lenguaje;

/**
 *
 * @author Adrian
 */
public class TestAlfabeto {
    public static void main(String[] args) {
        Alfabeto a = new Alfabeto();
        String simbolo;
        JOptionPane.showMessageDialog(null,"Practica 2 \nTeoría Computacional");
        JOptionPane.showMessageDialog(null,"Por favor, inserta un alfabeto, puedes hacerlo de dos formas:");
        int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null, "\n 1 = Simbolo a simbolo \n 2 = Por rango \n" ));
        if(opcion1 == 1) {
            int i=0;
            boolean cond=true;
            do {
                simbolo = JOptionPane.showInputDialog(null, "Introduce un simbolo, para finalizar escribe \"Fin\": ");
                if(simbolo.equals("Fin") && i<3) {
                    JOptionPane.showMessageDialog(null, "No has introducido 3 o mas simbolos, por favor, introduce mas");
                }
                else if(simbolo.equals("Fin") && i>=3) {
                    cond=false;
                }
                else {
                    a.insertarCaracteres1a1(simbolo);
                    i++;
                }
            } while(cond);
        }
        else if(opcion1 == 2) {
            String caracteres = JOptionPane.showInputDialog(null, "Introduce el rango: (ej. A-Z, a-z, 0-9)");
            a.insertarCaracteresRango(caracteres);
        }
        else {
            JOptionPane.showMessageDialog(null,"No has introducido una opcion valida, intentalo de nuevo");
        }
        
        Lenguaje l1 = new Lenguaje();
        Lenguaje l2 = new Lenguaje();
        int longitudl1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la longitud de las palabras a crear para el L1: "));
        int numerol1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de palabras a crear para el L1: "));
        int longitudl2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la longitud de las palabras a crear para el L2: "));
        int numerol2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de palabras a crear para el L2: "));
        
        l1.generarLenguaje(a, numerol1, longitudl1);
        l2.generarLenguaje(a, numerol2, longitudl2);
        System.out.println("Lenguaje 1: ");
        l1.imprimirLenguaje();
        System.out.println("Lenguaje 2: ");
        l2.imprimirLenguaje();
        
        System.out.println("La union de tus lenguajes: ");
        Lenguaje lu = l1.union(l2);
        lu.imprimirLenguaje();
        
        System.out.println("La concatenacion de tus lenguajes: ");
        Lenguaje lc = l1.concatenacion(l2);
        lc.imprimirLenguaje();
        
        System.out.println("L1 - L2: ");
        Lenguaje ldif = l1.diferencia(l2);
        ldif.imprimirLenguaje();
        
        System.out.println("L2 - L1: ");
        ldif = l2.diferencia(l1);
        ldif.imprimirLenguaje();
        
        opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce 1 para elegir el L1 o 2 para L2: "));
        int potencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la potencia a elevar el lenguaje (entre -5 y 5): "));
        Lenguaje lp;
        if(opcion1==1) {
            lp = l1.potencia(potencia);
            System.out.println("Lenguaje 1 a la " + potencia + " potencia: ");
            lp.imprimirLenguaje();
        }
        else if(opcion1==2) {
             lp = l2.potencia(potencia);
            System.out.println("Lenguaje 2 a la " + potencia + " potencia: ");
            lp.imprimirLenguaje();
        }
        
        System.out.println("Generacion de Matriculas: ");
        Lenguaje le = new Lenguaje();
        Palabra w;
        le.palabras.add(w = new Palabra("AS"));
        le.palabras.add(w = new Palabra("MS"));
        le.palabras.add(w = new Palabra("BC"));
        le.palabras.add(w = new Palabra("NT"));
        le.palabras.add(w = new Palabra("BS"));
        le.palabras.add(w = new Palabra("NL"));
        le.palabras.add(w = new Palabra("OC"));
        le.palabras.add(w = new Palabra("CC"));
        le.palabras.add(w = new Palabra("CL"));
        le.palabras.add(w = new Palabra("PL"));
        le.palabras.add(w = new Palabra("CM"));
        le.palabras.add(w = new Palabra("QT"));
        le.palabras.add(w = new Palabra("CS"));
        le.palabras.add(w = new Palabra("QR"));
        le.palabras.add(w = new Palabra("CH"));
        le.palabras.add(w = new Palabra("SP"));
        le.palabras.add(w = new Palabra("DF"));
        le.palabras.add(w = new Palabra("SL"));
        le.palabras.add(w = new Palabra("SR"));
        le.palabras.add(w = new Palabra("TC"));
        le.palabras.add(w = new Palabra("TS"));
        le.palabras.add(w = new Palabra("HG"));
        le.palabras.add(w = new Palabra("TL"));
        le.palabras.add(w = new Palabra("JC"));
        le.palabras.add(w = new Palabra("VZ"));
        le.palabras.add(w = new Palabra("MC"));
        le.palabras.add(w = new Palabra("YN"));
        le.palabras.add(w = new Palabra("MN"));
        le.palabras.add(w = new Palabra("ZS"));
        
        Lenguaje ld = new Lenguaje();
        Alfabeto digitos = new Alfabeto();
        digitos.insertarCaracteresRango("0-9");
        ld.generarLenguaje(digitos, 10, 1);
        
        Lenguaje ll = new Lenguaje();
        Alfabeto letras = new Alfabeto();
        letras.insertarCaracteresRango("A-Z");
        ll.generarLenguaje(letras, 26, 1);
        Lenguaje lg = new Lenguaje();
        lg.palabras.add(w = new Palabra("-"));
        
        
        Palabra matriculaAntigua = le.tomarPalabraDelLenguaje().concatenarPalabras(lg.tomarPalabraDelLenguaje()).concatenarPalabras((ld.potencia(5).tomarPalabraDelLenguaje()));
        System.out.println("Una matricula antigua es: ");
        System.out.println(matriculaAntigua);
        
        Palabra matriculaNueva = le.tomarPalabraDelLenguaje().concatenarPalabras(lg.tomarPalabraDelLenguaje()).concatenarPalabras(ld.potencia(4).tomarPalabraDelLenguaje().concatenarPalabras(lg.tomarPalabraDelLenguaje()).concatenarPalabras(ll.union(ll.potencia(2)).tomarPalabraDelLenguaje()));
        System.out.println("Una matricula nueva es: ");
        System.out.println(matriculaNueva);
    }
}
