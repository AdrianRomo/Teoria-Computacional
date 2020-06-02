/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import javax.swing.JOptionPane;


/**
 *
 * @author Adrian
 */
public class Palabra {
    String cadena;

    public Palabra(String cadena) {
        this.cadena = cadena;
    }

    public boolean validarPalabra(Alfabeto a) {
        int i;
        int tamañoDeSimbolo=0;
        for(int j=0; j<cadena.length();j=j+tamañoDeSimbolo) {
            for(i=0; i<a.caracteres.length;i++) {
                if(a.caracteres[i]== null) {
                    JOptionPane.showMessageDialog(null,"Cadena incorrecta!");
                    return false;
                }
                else {
                    tamañoDeSimbolo = a.caracteres[i].length();
                    if(cadena.substring(j, j+tamañoDeSimbolo).contains(a.caracteres[i])) {
                    break;
                    }
                }
            }
        }
        return true;
    }
    //Alfabeto1 . Alfabeto2
    public Palabra concatenarPalabras(Palabra w2) {
        Palabra nP = new Palabra(cadena.concat(w2.cadena));
        return nP;
    }
    



    public Palabra potencia(int n) {
        Palabra nP= new Palabra(cadena);
        Palabra pal= new Palabra(cadena);
        if(n==0) {
            return nP = null;
        }
        else if(n<0) {
            int pot = -1*n;
            nP.cadena= invertir(cadena);
            pal.cadena= invertir(cadena);
            if(pot==1) {
                return nP;
            }
            else {
                for(int i=2; i<=pot; i++) {
                    nP = nP.concatenarPalabras(pal);
                }
                return nP;
            }
        }
        else if(n== 1) {
            return nP;
        }
        else {
            for(int i=2; i<=n; i++) {
                nP = nP.concatenarPalabras(pal);
            }
            return nP;
        }

    }

    public String invertir(String cad) {
        String aux="";
        for(int i=cad.length()-1; i>=0;i--) {
            aux += cad.charAt(i);
        }
        return aux;
    }

    public int longitud(Alfabeto a) {
        int i, contador=0;
        int tamañoDeSimbolo= a.caracteres[0].length();

        for(i=0; i<cadena.length(); i=i+tamañoDeSimbolo) {
            contador++;
        }

        return contador;
    }

    public int repeticionSimbolo(String simbolo, Alfabeto a) {
        int contador=0;
        int tamañoDeSimbolo= simbolo.length();

        for(int i=0; i<cadena.length();  i=i+tamañoDeSimbolo) {
            if(cadena.substring(i, i+tamañoDeSimbolo).contains(simbolo)) {
                contador++;
            }
        }
        return contador;
    }

    public boolean esPrefijo(String cad) {
        int tamañoCadena = cad.length();
        if(cad.equals(cadena)) {
            return true;
        }
        else if(cadena.substring(0, tamañoCadena).equals(cad)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean esPrefijoPropio(String cad) {
        int tamañoCadena = cad.length();
        if(cad.equals(cadena)) {
            return false;
        }
        else if(cadena.substring(0, tamañoCadena).equals(cad)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean esSufijo(String cad) {
        int tamañoCadena = cad.length();
        if(cad.equals(cadena)) {
            return true;
        }
        else if(cadena.substring((cadena.length()-tamañoCadena), cadena.length()).equals(cad)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean esSufijoPropio(String cad) {
        int tamañoCadena = cad.length();
        if(cad.equals(cadena)) {
            return false;
        }
        else if(cadena.substring((cadena.length()-tamañoCadena), cadena.length()).equals(cad)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean esSubcadena(String cad) {
        Palabra nP = new Palabra(cadena);
        if(cadena.contains(cad) && !nP.esPrefijo(cad) && !nP.esSufijo(cad)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Palabra{" + cadena + '}';
    }


}
