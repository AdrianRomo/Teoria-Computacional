/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adrian
 */
public class Lenguaje {
    public ArrayList<Palabra> palabras = new ArrayList();

    public Lenguaje() {
    }
    
    public String generarCadena(Alfabeto a, int longitud) {
        Random rAlfabeto = new Random();
        String cadena="";
        for(int i=0; i<longitud; i++) {
            int numeroAleatorio = rAlfabeto.nextInt(a.numeroDeCaracteres());
            cadena = cadena+a.caracteres[numeroAleatorio];
        }
        return cadena;
    }
    
    public boolean existaPalabra(Palabra w) {
        for(int i=0; i<palabras.size();i++) {
            if(palabras.get(i).cadena.equals(w.cadena)) {
                return true;
            }
        }
            return false;
    }
    
    public void generarLenguaje(Alfabeto a, int elementos, int longitud) {
        String cadena;
        Palabra w;
        
        for(int i=0; i<elementos; i++) {
            cadena = generarCadena(a,longitud);
            w = new Palabra(cadena);
            while(existaPalabra(w)) {
                cadena = generarCadena(a,longitud);
                w = new Palabra(cadena);
            }
            palabras.add(w);
        }
    }
    
    public void imprimirLenguaje() {
        for(int i=0; i<palabras.size();i++) {
            System.out.println(palabras.get(i));
        }
    }
    
    public Lenguaje union (Lenguaje l2) {
        Lenguaje u = new Lenguaje();
        for(int i=0; i<palabras.size();i++) {
            u.palabras.add(palabras.get(i));
        }
        for(int i=0; i<l2.palabras.size();i++) {
            if(u.existaPalabra(l2.palabras.get(i))) {
                
            }
            else {
                u.palabras.add(l2.palabras.get(i));
            }
        }
        return u;
    }
    
    public String juntarCadenas(String cadena1, String cadena2) {
        return cadena1.concat(cadena2);
    }
    
    public Lenguaje concatenacion(Lenguaje l2) {
        Lenguaje c = new Lenguaje();
        Palabra w;
        for(int i=0; i<palabras.size(); i++) {
            for(int j=0; j<l2.palabras.size();j++) {
                String cadena = juntarCadenas(palabras.get(i).cadena, l2.palabras.get(j).cadena);
                w = new Palabra(cadena);
                c.palabras.add(w);
            }
        }
        return c;
    }
    
    public void borrarPalabra(Palabra w) {
        for(int i=0;i<palabras.size();i++) {
            if(palabras.get(i).cadena.equals(w.cadena)) {
                palabras.remove(i);
            }
        }
    }
    
    public Lenguaje diferencia(Lenguaje l2) {
        Lenguaje d = new Lenguaje();
        for(int i=0; i<palabras.size();i++) {
            d.palabras.add(palabras.get(i));
        }
        for(int i=0; i<l2.palabras.size();i++) {
            if(d.existaPalabra(l2.palabras.get(i))) {
                d.borrarPalabra(l2.palabras.get(i));
            }
        }
        return d;
        
    }
    
    public Lenguaje invertirLenguaje() {
        Lenguaje inv = new Lenguaje();
        Palabra w;
        for(int i=0;i<palabras.size();i++) {
            w = new Palabra(palabras.get(i).invertir(palabras.get(i).cadena));
            inv.palabras.add(w);
        }
        return inv;
    }
    
    public Lenguaje potencia(int n) {
        Lenguaje aux = new Lenguaje();
        Lenguaje p = new Lenguaje();
        for(int i=0;i<palabras.size();i++) {
            aux.palabras.add(palabras.get(i));
            p.palabras.add(palabras.get(i));
        }
        if(n<-5 || n>5) {
            System.out.println("No es una potencia valida");
            return null;
        }
        else {
            if(n==0) {
                return null;
            }
            else if(n==1) {
                return aux;
            }
            else if(n>1) {
                for(int i=2;i<=n;i++) {
                    p = p.concatenacion(aux);
                }
            }
            else {
                int pot = -1 * n;
                for(int i=2;i<=pot;i++) {
                    p = p.concatenacion(aux);
                }
                p = p.invertirLenguaje();
            }
        }
        return p;
    }
    
    public Palabra tomarPalabraDelLenguaje() {
        Random r = new Random();
        Palabra w;
        int n = r.nextInt(palabras.size());
        
        w = new Palabra(palabras.get(n).cadena);
        return w;
    }
}
