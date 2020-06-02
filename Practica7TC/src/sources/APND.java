/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Adrian
 */
public class APND {
    String cadena;
    Stack<String> pila1 = new Stack();
    Stack<String> pila2 = new Stack();

    public APND() {
    }

    public APND(String cadena) {
        this.cadena = cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }
    
    public boolean validarEjercicio5() {
        ArrayList<Integer> estados = new ArrayList();
        estados.add(0);
        pila1.push("Z");
        pila2.push("Z");
        for(int i=0;i<cadena.length();i++) {
            for(int j=0;j<estados.size();j++) {
                if(cadena.charAt(i)=='a') {
                    if(estados.get(j)==0) {
                        if(pila1.lastElement().equals("Z")) {
                            pila1.push("A");
                            estados.set(j, 1);
                        }
                        if(pila2.lastElement().equals("Z")) {
                            pila2.push("A");
                            estados.add(5);
                            break;
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==1) {
                        if(pila1.lastElement().equals("A")) {
                            pila1.push("A");
                            estados.set(j, 1);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if (estados.get(j)==5) {
                        if(pila2.lastElement().equals("A")) {
                            pila2.push("A");
                            estados.set(j, 5);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else {
                        estados.set(j,9);
                    }
                }
                else if(cadena.charAt(i)=='b') {
                    if(estados.get(j)==1) {
                        if(pila1.lastElement().equals("A")) {
                            pila1.push("B");
                            estados.set(j,2);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==2) {
                        if(pila1.lastElement().equals("B")) {
                            pila1.push("B");
                            estados.set(j,2);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==5) {
                        if(pila2.lastElement().equals("A")) {
                            estados.set(j,6);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==6) {
                        if(pila2.lastElement().equals("A")) {
                            pila2.pop();
                            estados.set(j,7);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==7) {
                        if(pila2.lastElement().equals("A")) {
                            estados.set(j,6);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else {
                        estados.set(j,9);
                    }
                }
                else if(cadena.charAt(i)=='c') {
                    if(estados.get(j)==2) {
                        if(pila1.lastElement().equals("B")) {
                            pila1.pop();
                            estados.set(j,3);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==3) {
                        if(pila1.lastElement().equals("B")) {
                            pila1.pop();
                            estados.set(j,3);
                        }
                        else if(pila1.lastElement().equals("A")) {
                            pila1.pop();
                            estados.set(j,4);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==4) {
                        if(pila1.lastElement().equals("A")) {
                            pila1.pop();
                            estados.set(j,4);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else {
                        estados.set(j,9);
                    }
                }
                else {
                    estados.set(j,9);
                }
            }
        }
        if((estados.contains(4) && pila1.lastElement().equals("Z")) || (estados.contains(7) && pila2.lastElement().equals("Z"))) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean validarEjercicio4() {
        ArrayList<Integer> estados = new ArrayList();
        estados.add(0);
        pila1.push("Z");
        pila2.push("Z");
        for(int i=0;i<cadena.length();i++) {
            for(int j=0;j<estados.size();j++) {
                if(cadena.charAt(i)=='a') {
                    if(estados.get(j)==0) {
                        if(pila1.lastElement().equals("Z")) {
                            pila1.push("A");
                            estados.set(j, 1);
                        }
                        if(pila2.lastElement().equals("Z")) {
                            pila2.push("A");
                            estados.add(5);
                            break;
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==1) {
                        if(pila1.lastElement().equals("A")) {
                            pila1.push("A");
                            estados.set(j, 1);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if (estados.get(j)==5) {
                        if(pila2.lastElement().equals("A")) {
                            estados.set(j, 6);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if (estados.get(j)==6) {
                        if(pila2.lastElement().equals("A")) {
                            pila2.push("A");
                            estados.set(j, 5);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else {
                        estados.set(j,9);
                    }
                }
                else if(cadena.charAt(i)=='b') {
                    if(estados.get(j)==1) {
                        if(pila1.lastElement().equals("A")) {
                            pila1.push("B");
                            estados.set(j,2);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==2) {
                        if(pila1.lastElement().equals("B")) {
                            pila1.push("B");
                            estados.set(j,2);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==6) {
                        if(pila2.lastElement().equals("A")) {
                            pila2.pop();
                            estados.set(j,7);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==7) {
                        if(pila2.lastElement().equals("A")) {
                            pila2.pop();
                            estados.set(j,7);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else {
                        estados.set(j,9);
                    }
                }
                else if(cadena.charAt(i)=='c') {
                    if(estados.get(j)==2) {
                        if(pila1.lastElement().equals("B")) {
                            pila1.pop();
                            estados.set(j,3);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==3) {
                        if(pila1.lastElement().equals("B")) {
                            pila1.pop();
                            estados.set(j,3);
                        }
                        else if(pila1.lastElement().equals("A")) {
                            pila1.pop();
                            estados.set(j,4);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else if(estados.get(j)==4) {
                        if(pila1.lastElement().equals("A")) {
                            pila1.pop();
                            estados.set(j,4);
                        }
                        else {
                            estados.set(j,9);
                        }
                    }
                    else {
                        estados.set(j,9);
                    }
                }
                else {
                    estados.set(j,9);
                }
            }
        }
        if((estados.contains(4) && pila1.lastElement().equals("Z")) || (estados.contains(7) && pila2.lastElement().equals("Z"))) {
            return true;
        }
        else {
            return false;
        }
    }
}
