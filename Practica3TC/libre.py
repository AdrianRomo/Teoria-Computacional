#!/usr/bin/python
# -*- coding: utf-8 -*-

import re,runpy

#Definimos la funcion caracter
def caracter(character):
    global simbolo
    simbolo=""
    global Fin
    Lobo="L"
    Oveja="O"
    Paja="P"
    Hombre="G"
    Fin=""
    esc="e"

    if re.match(Hombre,character,re.IGNORECASE):
        simbolo = "Granjero"
        return 0
    else:
        if re.match(Lobo,character,re.IGNORECASE):
            simbolo = "  Lobo  "
            return 1
        else:
            if re.match(Oveja,character,re.IGNORECASE):
                simbolo = "  Oveja "
                return 2
            else:
                if re.match(Paja,character,re.IGNORECASE):
                    simbolo = "  Paja  "
                    return 3
                else:
                    if character == Fin:
                        return 4
        #Si no entra en ningún caso, da error
        print("Error, ",character,"no es valido")
        input("Presiona Enter para continuar...")
        file_globals = runpy.run_path("menu.py")


#Definimos a la funcion  encabezado
def encabezado():


    print("""|  Edo. Actual |  Simbolo  |Edo. Siguiente |""")

    body()

#Definimos la funcion contenido donde guarda cada valor despues de encontrarlo en un ciclo
def contenido(estadosig,simbolo,estado,lago):
    print("|      ",estadosig,"     |",simbolo," |     ",estado,"       |     ",lago,"     ")
    body()

#Linea que divide cada que se repite operacion entre estados
def body():
    print("+--------------+-----------+---------------+")

#MAIN
#Este es la tabla de transiciones del automata AFD
#[Granjero,Lobo,Oveja,Paja,Edo. Final]
tabla=[["Er","Er",1,"Er","Er"],[2,"Er",0,"Er","Er"],[1,4,"Er",3,"Er"],
       ["Er","Er",5,2,"Er"],[2,"Er",7,"Er","Er"],["Er",6,3,"Er","Er"],[8,5,"Er",7,"Er"],["Er","Er",4,6,"Er"],
       [6,"Er",9,"Er","Er"],["Er","Er",8,"Er","A"]]
#Se define un Edo. Inicial
estado = 0
print("""d) Acertijo del Granjero,lobo, la oveja y la paja.

En la orilla de un río se encuentra un hombre, junto con un lobo, una oveja y paja.
Hay un bote con la capacidad suficiente para llevar al hombre y a uno de los otros tres.
El hombre con la paja, y demás compañeros deben cruzar el río, y el hombre puede llevar a uno sólo a la vez.
Sin embargo, si el hombre deja solos al lobo y a la oveja en cualquier lado del río,
con toda seguridad que el lobo se comerá a la oveja.
Del mismo modo, si la oveja y la paja se quedan juntas, la oveja se comerá a la paja.

¿Es posible que se pueda cruzar el río sin que nadie sea comido?

Tenga en cuenta:
G = Granjero
O = Oveja
P = Paja
L = Lobo
      """)
lago = ""
x = 1
y = 0
while x == 1:
    if y== 0:
        print ("""+------------------------------------------+        A                 B
|    A quien deseas llevar al otro lado?   |     |LGOP|---------->|    |
+------------------------------------------+""")
    else:
                print ("""+------------------------------------------+
|    A quien deseas llevar al otro lado?   |
+------------------------------------------+""")
    cadena = input()
    cadena = cadena.replace(',', '')
    body()
    encabezado()

    #ciclo para recorrer la cadena
    for  character in cadena:
        y = 1
        estadosig = estado

        #llamamos al metodo para saber si es un caracter valido y el valor retornado se guarda en charcaracter
        charcaracter = caracter(character)

        #guardamos en estado el valor obtenido en la tabla segun las cordenadas que recibio anteriormente
        estado = tabla[estado][charcaracter]
        if estadosig != "ER":
            if estadosig == 0:
                lago=("""|LP|---OG--->| | El Granjero se lleva a Oveja de isla A
                                                      |LP|------>|GO| Granjero y Oveja llegan a isla B""")
            if estadosig == 1:
                lago=("""|LP|<---G---|O| El Granjero sale solo de isla B
                                                      |LPG|<------|O| Granjero Llega a isla A""")
            if estadosig == 2:
                lago=("""|L|---GP--->|O| El Granjero se lleva la Paja de isla A
                                                      |L|------>|GPO| Granjero y Paja llegan a isla B""")
            if estadosig == 3:
                lago=("""|L|<---GO---|P| El Granjero se lleva a la Oveja de isla B
                                                      |LGO|<------|P| Oveja y Granjero llegan a isla A""")
            if estadosig == 4:
                lago=("""|P|---GL--->|O| El Granjero se lleva al Lobo de isla A
                                                      |P|------>|GLO| Lobo y Granjero llegan a isla B""")
            if estadosig == 5:
                lago=("""|O|---GL--->|P| El Granjero se lleva al Lobo desde isla A
                                                      |O|------>|GLP| Lobo y Granjero llegan a isla B""")
            if estadosig == 6:
                lago=("""|O|<---G---|LP| Granjero sale solo de isla B
                                                      |GO|<------|LP| Granjero llega a isla A""")
            if estadosig == 7:
                lago=("""|P|<---GO---|L| Granjero se lleva a la Oveja de isla B
                                                      |PGO|<------|P| Granjero y Oveja llegan a isla A""")
            if estadosig == 8:
                lago=("""|  |---GO--->|LP| Granjero se lleva a la Oveja de isla A

                                                  |  |------>|LGOP| Oveja y Granjero llegan a isla B""")
        else:
            lago=""
        #Si el valor obtenido es una Er imprimimos cadena no valida
        if estado == "Er":
            print("|      ",estadosig,"     |",simbolo," |     ",estado,"      |          ")
            body()
            print("""|            Murió Alguien :(           |
+------------------------------------------+""")
            x = 2
            input("Presiona Enter para continuar...")

        contenido(estadosig,simbolo,estado,lago)
    if estado == 9:
        #lago=("||->|GLPO|")
        print("|     Estado Final:   ",estado,"                  |     ")
        body()
        print("""
+-----------------------------------------------------------------+""")
        print("""|             Felicidades! Todos pasaron bien :)                  |
+-----------------------------------------------------------------+""")
        input("Presiona Enter para continuar...")
        x = 2
    #al concluir si el estado no es el de aceptacion (A) imprimimos cadena no valida
