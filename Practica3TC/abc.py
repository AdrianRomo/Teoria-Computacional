#!/usr/bin/python
# -*- coding: utf-8 -*-

import re,runpy

#Definimos la funcion caracter
def caracter(character):
    global simbolo
    simbolo=""
    global Fin
    Fin=""
    #Detectamos si es a,b o c, cada valor que regresa es la posicion que tendrá en el en vector.
    if re.match("a",character):
        simbolo="   a    "
        return 0
    else:
        if re.match("b",character):
            simbolo="   b    "
            return 1
        else:
            if re.match("c",character):
                simbolo="   c    "
                return 2

            else:
                if character==Fin:
                    return 3

        #Si no entra en ningún caso, da error
        print("Error, ",character,"no es valido")
        file_globals = runpy.run_path("menu.py")


#definimos a la funcion  encabezado
def encabezado():


    print("""|  Edo. Actual |  Simbolo  |Edo. Siguiente |""")
    body()

#Definimos la funcion contenido donde guarda cada valor despues de encontrarlo en un ciclo
def contenido(estadosig,simbolo,estado):
    print("|      ",estadosig,"     |",simbolo," |     ",estado,"       |")
    body()

#Linea que divide cada que se repite operacion entre estados
def body():
    print("+--------------+-----------+---------------+")

#MAIN
#Este es la tabla de transiciones del automata AFD
#[a,b,c,Edo. Final]
tabla=[[1,"Er",2,"Er"],["Er","Er",3,"A"],[4,6,5,"A"],
       [7,8,"Er","A"],[4,6,5,"A"],[4,6,5,"A"],[4,6,5,"A"],[7,8,"Er","A"],
       [7,8,"Er","A"]]
#Se define un Edo. Inicial
estado = 0

print ("""+-------------------------------------+
|    Ingrese una cadena a evaluar:    |
+-------------------------------------+""")
cadena = input()
cadena = cadena.replace(',', '')
body()
encabezado()

#ciclo para recorrer la cadena
for  character in cadena:
    estadosig=estado

    #llamamos al metodo para saber si es un caracter valido y el valor retornado se guarda en charcaracter
    charcaracter= caracter(character)

    #guardamos en estado el valor obtenido en la tabla segun las cordenadas que recibio anteriormente
    estado=tabla[estado][charcaracter]

    #Si el valor obtenido es una Er imprimimos cadena no valida
    if estado=="Er":
        print("|      ",estadosig,"     |",simbolo," |     ",estado,"      |")
        body()
        print("""|            Cadena NO Valida :(           |
+------------------------------------------+""")
        input("Presiona Enter para continuar...")
        file_globals = runpy.run_path("menu.py")


    contenido(estadosig,simbolo,estado)
if estado != 0:
    print("|     Estado Final:   ",estado,"                     ")
    body()
    print("""|             Cadena Valida :)             |
+------------------------------------------+""")
    input("Presiona Enter para continuar...")
    file_globals = runpy.run_path("menu.py")
else:
    if estado == 0:
        print("""|            Cadena NO Valida :(          |
+------------------------------------------+""")
        input("Presiona Enter para continuar...")
        file_globals = runpy.run_path("menu.py")


#al concluir si el estado no es el de aceptacion (A) imprimimos cadena no valida
