/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

/**
 *
 * @author Adrian
 */
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
    
    public int numeroDeCaracteres() {
        int n=0;
        for (int i=0; i<caracteres.length; i++) {
            if(caracteres[i]==null) {
                break;
            }
            n++;
        }
        return n;
    }
    
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
}
