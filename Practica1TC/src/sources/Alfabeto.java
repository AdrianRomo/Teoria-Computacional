/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.util.ArrayList;

/**
 *
 * @author Adrian
 */


 //a) 1
public class Alfabeto {
    String[] caracteres = new String[14348910];
    public Alfabeto() {
    }

    public void insertarCaracteres1a1(String caracter) {
        for(int i=0; i<caracteres.length; i++) {
            if(caracteres[i]==null) {
                caracteres[i] = caracter;
                break;
            }
        }
    }
//a)2
    public void insertarCaracteresRango(String cadena) {
        char caracterInicial = cadena.charAt(0);
        char caracterFinal = cadena.charAt(2);
        int j=0;

        if(caracterFinal-caracterInicial==1) {
            System.out.println("No has introducido mas de 3 caracteres");
        }
        else {
            for(int i=caracterInicial; i<=caracterFinal; i++) {
                char caracter = (char) (caracterInicial+j);
                caracteres[j] = ""+caracter;
                j++;
            }
        }
    }


    public void imprimirAlfabeto() {
        for(int i=0; i<caracteres.length; i++) {
            if(caracteres[i]==null) {
                break;
            }
            System.out.println(caracteres[i]);
        }
    }
    //Potencias
    public Alfabeto alfabetoPotencia(int potencia) {
        Alfabeto potenciaActual = new Alfabeto();
        Alfabeto potenciaAnterior = new Alfabeto();

        for(int i=0; i<caracteres.length;i++) {
            if(caracteres[i]==null) {
                break;
            }
            potenciaAnterior.caracteres[i]=caracteres[i];
        }
        for(int i=2; i<=potencia; i++) {
            for(int j=0; j<caracteres.length; j++) {
                if(caracteres[j]==null) {
                    break;
                }
                for(int k=0; k<potenciaAnterior.caracteres.length;k++) {
                    if(potenciaAnterior.caracteres[k]==null) {
                        break;
                    }
                    potenciaActual.insertarCaracteres1a1("" + caracteres[j] + potenciaAnterior.caracteres[k]);
                }
            }
            for(int l=0; l<potenciaActual.caracteres.length; l++) {
                if(potenciaActual.caracteres[l]==null) {
                    break;
                }
                potenciaAnterior.caracteres[l]=potenciaActual.caracteres[l];
            }
            if(i!=potencia) {
                for(int m=0; m<potenciaActual.caracteres.length; m++) {
                    potenciaActual.caracteres[m]=null;
                }
            }
        }
        return potenciaActual;
    }
    public int longitudAlfabeto (Alfabeto a) {
        int contador = 0;
        while (a.caracteres[contador] != null){
            contador++;
        }
        return contador;
    }
    public String juntarCadenas(String cadena1, String cadena2) {
        return cadena1.concat(cadena2);
    }
        
    public String concatenarAlfabeto (Alfabeto a, Alfabeto b) {
        String z = new String();
        for(int i=0; i < longitudAlfabeto(a); i++){
            for(int j=0; j < longitudAlfabeto(b); j++){
                z = z +  a.caracteres[i] + b.caracteres[j] +",";
            }
        }
        return z;
    }
        public String concatenarAlfabetos (Alfabeto a, Alfabeto b, Alfabeto c) {
        String z = new String();
        for(int i=0; i < longitudAlfabeto(a); i++){
            for(int j=0; j < longitudAlfabeto(b); j++){
                for(int k=0; k < longitudAlfabeto(a); k++){
                z = z +  a.caracteres[i] + b.caracteres[j] + a.caracteres[k] +",";
                }
            }
        }
       for(int i=0; i < longitudAlfabeto(a); i++){
        c.caracteres[i]= z;
       }

        return z;
    }
}