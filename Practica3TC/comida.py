#!/usr/bin/python
# -*- coding: utf-8 -*-

import re
import numpy as np
#Definimos la funcion caracter
def caracter(character):
    global simbolo
    simbolo = ""
    global Fin
    Fin = ""
    Mon10 = "1"
    Mon5 = "5"
    Mon2 = "2"
    #Comparamos si es moneda de 10,5 o 2
    if re.match(Mon10,character):
            simbolo = " Moneda de 10 "
            return 2
    else:
        if re.match(Mon5,character):
            simbolo = " Moneda de 5  "
            return 1
        else:
            if re.match(Mon2,character):
                simbolo = " Moneda de 2  "
                return 0

            else:
                if character == Fin and f == 0:
                    return 3

        #Si no es ninguna clase de moneda mencionada, entonces no es valida
        print ("Error, ",character,"no es valido")



#Definimos a la funcion  encabezado
def encabezado():
    print("""|  Edo. Actual |       Simbolo       |Edo. Siguiente |   Faltante   |""")
    body()

#Definimos la funcion contenido donde guarda cada valor despues de encontrarlo en un ciclo
def contenido(estadosig,simbolo,estado,faltante):
    print("|     ",estadosig,"      |   ",simbolo,"  |     ",estado,"       |     ",faltante,"       |")
    body()
    return faltante

#Solo muestra la linea que se repetira cada vez que la mandemos a llamar
def body():
    print("+--------------+---------+-----------+---------------+---------------+")

#MAIN
#Este es la tabla de transiciones del automata AFD con el siguiente orden:
        #[Moneda2/Moneda5/Moneda10/Edo.Final]
tabla=[[1,7,5,"Er"],[2,8,6,"Er"],[3,9,6,"Er"],
       [4,10,6,"Er"],[5,6,6,"Er"],[6,6,6,"Er"],[6,6,6,"A"],[8,5,6,"Er"],
       [9,6,6,"Er"],[10,6,6,"Er"],[6,6,6,"Er"]]
estado = 0

print("""c) AFD para una máquina vendedora de sándwich.

El sándwich cuesta $12.0 pesos, y la máquina sólo acepta monedas de las siguientes denominaciones: $10, $5, $2.
La máquina entrega el sándwich sólo si se ha ingresado una cantidad igual o mayor que $12 pesos.

      Nota 1: La máquina no entrega el sándwich si la  cantidad es menor que $12.00
      Nota 2: La máquina no devuelve cambio.
      """)

print("         MONEDA DE 10 = 1")
print("         MONEDA DE 5 = 5")
print("         MONEDA DE 2 = 2")
print ("""+-------------------------------------------------------+
|          Ingrese una Moneda, NO tenemos cambio        |
+-------------------------------------------------------+""")
faltante = 12
#Loop para pedir de moneda en moneda
x=1
while x==1:
    cadena = input()
    cadena = cadena.replace(',', '')
    body()
    encabezado()

    #Ciclo para recorrer la cadena
    for  character in cadena:
        estadosig = estado
        #Se calcula el monto faltante para mostrarlo al usuario, el automata hace el calculo mediante la tabla anterior
        if int(character) == 1:
            faltante = faltante-10
        else:
            faltante = faltante-int(character)
        #Llamamos al metodo para saber si es un caracter valido y el valor retornado se guarda en charcaracter
        charcaracter = caracter(character)
        #Guardamos en estado el valor obtenido en la tabla segun las cordenadas que recibio anteriormente
        estado = tabla[estado][charcaracter]

        #Si el Estado final es una "Er" imprimimos cadena no valida
        if estado == "Er":
            print("|     ",estadosig,"      |   ",simbolo,"  |     ",estado,"      |     ",faltante,"       |")
            body()
            print("""|                      Saldo Insuficiente                            |
+--------------------------------------------------------------------+""")
            input("Presiona Enter para continuar...")

        contenido(estadosig,simbolo,estado,faltante)
    if estado == 6 and faltante < 0:
        body()
        print("""|         Tome su Sandwich, le dijimos que no había cambio           |
+--------------------------------------------------------------------+""")
        input("Presiona Enter para continuar...")
        x = 2

    if estado == 6 and faltante == 0:
        body()
        print("""|                        Tome su Sandwich :)                         |
+--------------------------------------------------------------------+""")
        input("Presiona Enter para continuar...")
        x = 2
    else:
        if estado != 6:
            print("""|                      Saldo Insuficiente                            |
+--------------------------------------------------------------------+""")
