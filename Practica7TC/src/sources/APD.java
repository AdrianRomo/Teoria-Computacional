/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.util.Stack;

/**
 *
 * @author Adrian
 */
public class APD {
    Stack<String> pila = new Stack();
    String cadena;

    public APD(String cadena) {
        this.cadena = cadena;
    }

    public APD() {
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    public boolean validarEjercicio1() {
        int estado=0;
        pila.push("Z");
        for(int i=0;i<cadena.length();i++) {  
            if(cadena.charAt(i)=='a') {
                if(estado==0) {
                    if(pila.lastElement().equals("Z")) {
                        pila.push("X");
                        estado=0;
                    }
                    else if(pila.lastElement().equals("X")) {
                        pila.push("X");
                        estado=0;
                    }
                    else if(pila.lastElement().equals("Y")) {
                        pila.push("X");
                        estado=0;
                    }
                }
                if(estado==1) {
                   if(pila.lastElement().equals("X")) {
                        pila.pop();
                    }
                   else {
                       estado=3;
                   }
                }
            }
            else if(cadena.charAt(i)=='b') {
                if(estado==0) {
                    if(pila.lastElement().equals("Z")) {
                        pila.push("Y");
                        estado=0;
                    }
                    else if(pila.lastElement().equals("X")) {
                        pila.push("Y");
                        estado=0;
                    }
                    else if(pila.lastElement().equals("Y")) {
                        pila.push("Y");
                        estado=0;
                    }
                }
                else if(estado==1) {
                    if(pila.lastElement().equals("Y")) {
                        pila.pop();
                    } 
                    else {
                        estado=3;
                    }
                }
            }
            else if(cadena.charAt(i)=='c') {
                if(estado==0) {
                    estado=1;
                }
            }
            else {
                estado=3;
            }
        }
        
        if(estado==1 && pila.lastElement().equals("Z")) {
            estado=2;
        }
        
        if(estado==2) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean validarEjercicio2() {
        int estado=0;
        pila.push("Z");
        for(int i=0;i<cadena.length();i++) {
            if(cadena.charAt(i)=='a') {
                if(estado==0) {
                    if(pila.lastElement().equals("Z")) {
                        pila.push("I");
                        estado=1;
                    }
                }
                else if(estado==1) {
                    if(pila.lastElement().equals("I")) {
                        pila.push("I");
                        estado=1;
                    }
                }
                else {
                    estado=5;
                }
            }
            else if(cadena.charAt(i)=='b') {
                if(estado==1) {
                    if(pila.lastElement().equals("I")) {
                        estado=2;
                    }
                }
                else {
                    estado=5;
                }
            }
            else if(cadena.charAt(i)=='c') {
                if(estado==2) {
                    if(pila.lastElement().equals("I")) {
                        pila.pop();
                        estado=3;
                    }
                }
                else if(estado==3) {
                    if(pila.lastElement().equals("I")) {
                        pila.pop();
                        estado=3;
                    }
                    else if(pila.lastElement().equals("Z")) {
                        estado=4;
                    }
                }
                else if(estado==4) {
                    if(pila.lastElement().equals("Z")) {
                        estado=4;
                    }
                }
                else {
                    estado=5;
                }
            }
            else {
                estado=5;
            }
        }
        if(estado==4){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean validarEjercicio3() {
        int estado=0;
        pila.push("Z");
        
        for(int i=0;i<cadena.length();i++) {
            if(cadena.charAt(i)=='0') {
                if(estado==0) {
                    if(pila.lastElement().equals("Z")|| pila.lastElement().equals("I")) {
                        pila.push("I");
                        estado=0;
                    }
                }
                else {
                    estado=4;
                }
            }
            else if(cadena.charAt(i)=='1') {
                if(estado==0) {
                    if(pila.lastElement().equals("Z")) {
                        pila.push("K");
                        estado=1;
                    }
                    else if(pila.lastElement().equals("I")) {
                        pila.pop();
                        estado=1;
                    }
                    else {
                        estado=4;
                    }
                }
                else if(estado==1) {
                    if(pila.lastElement().equals("I")) {
                        pila.pop();
                        estado=1;
                    }
                    else if(pila.lastElement().equals("Z") ||pila.lastElement().equals("K") ) {
                        pila.push("K");
                        estado=1;
                    }
                    else {
                        estado=4;
                    }
                }
                else {
                    estado=4;
                }
            }
            else if(cadena.charAt(i)=='2') {
                if(estado==1 || estado==2) {
                    if(pila.lastElement().equals("K")) {
                        pila.pop();
                        estado=2;
                    }
                    else {
                        estado=4;
                    }
                }
                else {
                    estado=4;
                }
            }
            else if(cadena.charAt(i)=='3') {
                if(estado==0 ||estado==1 || estado==2|| estado==3) {
                    if(pila.lastElement().equals("Z")) {
                        estado=3;
                    }
                    else {
                        estado=4;
                    }
                }
            }
            else {
                estado=4;
            }
        }
        if(estado==3) {
            return true;
        }
        else{
            return false;
        }
    }
}
