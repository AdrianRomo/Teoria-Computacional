#!/usr/bin/python
# -*- coding: utf-8 -*-

import re,runpy

#Definimos la funcion caracter
def caracter(character):
    global simbolo
    simbolo=""
    global Fin
    Fin=""
    digito="[0-9]"
    operador="(\+|\-)"
    punto="(\.)"
    Letra="E"

    #comparamos si es digito u operador
    if(re.match(digito,character)):
        simbolo=" Digito "
        return 0
    else:
        if(re.match(operador,character)):
            simbolo="Operador"
            return 1
        else:
            if(re.match(punto,character)):
                simbolo=" Punto  "
                return 2
            else:
                if(re.match(Letra,character,re.IGNORECASE)):
                    simbolo=" Letra  "
                    return 3
                else:
                    if(character==Fin):
                        return 4

        #si no es ni un digito ni un operador entonces es un caracter no valido
        print("Error, ",character,"no es valido")
        exit()

#definimos a la funcion  encabezado
def encabezado():
    print("""|  Edo. Actual |Caracter |  Simbolo  |Edo. Siguiente |""")
    body()

#definimos la funcion contenido donde guarda cada valor despues de encontrarlo en un ciclo
def contenido(estadosig,character,simbolo,estado):
    print("|     ",estadosig,"      |  ",character,"    |",simbolo," |     ",estado,"       |")
    body()

#solo muestra la linea que se repetira cada vez que la mandemos a llamar
def body():
    print("+--------------+---------+-----------+---------------+")

#MAIN
#Este es la tabla de transiciones del automata AFD creado

#DIGITO/OPERADOR/./E/Final
tabla=[[1,1,1,1,1],[2,"Er","Er","Er","Er"],[2,"Er",3,5,"Er"],
       [4,"Er","Er","Er","Er"],[4,"Er","Er",5,"A"],[7,6,"Er","Er","Er"],[7,"Er","Er","Er","Er"],[7,"Er","Er","Er","A"]]
estado = 1

print ("""+-------------------------------------+
|    Ingrese una cadena a evaluar:    |
+-------------------------------------+""")
cadena = input()
body()
encabezado()

#ciclo para recorrer la cadena
for  character in cadena:
    estadosig=estado

    #llamamos al metodo para saber si es un caracter valido y el valor retornado se guarda en charcaracter
    charcaracter= caracter(character)

    #guardamos en estado el valor obtenido en la tabla segun las cordenadas que recibio anteriormente
    estado=tabla[estado][charcaracter]

    #Si el valor obtenido es Er imprimimos cadena no valida
    if (estado=="Er"):
        print("|     ",estadosig,"      |  ",character,"    |",simbolo," |     ",estado,"       |")
        body()
        print("""|              Cadena No Valida :(                   |
+----------------------------------------------------+""")

    contenido(estadosig,character,simbolo,estado)
if(estado == 4 or estado == 7):
    print("|     Estado Final:   ",estado,"                     ")
    body()
    print("""|                Cadena Valida :)                    |
+----------------------------------------------------+""")
else:
    if(estado != 4 or estado != 7):
        print("""|              Cadena No Valida :(                    |
+----------------------------------------------------+""")
