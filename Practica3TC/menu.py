#!/usr/bin/python
# -*- coding: utf-8 -*-
import runpy, os, glob, subprocess
import psutil
from PIL import Image
while 1:
    os.system('clear')
    print("                                               Practica 3")
    print("                                Buen día, eliga el inciso a calificar")
    print("")

    print("     a)   Automata en Imagen")
    print("     b)   a + ac(a+b)* + c(a+b+c)")
    print("     c)   Sandwich")
    print("     d)   Libre")

    print("""

            O digite "e" para Salir""")

    x = input()
    if x == "a" or x == "1":
        os.system('clear')
        path = '/users/documents/Teoria\ Computacional/Teoria\ Computacional\ 2/Practica3TC'
        # abre y muestra la imagen
        im = Image.open('automata.png')
        im.show()
        file_globals = runpy.run_path("automata.py")
        input("Presiona Enter para continuar...")
        subprocess.call(['osascript', '-e', 'tell application "Preview" to quit'])
    if x == "b" or x == "2":
        os.system('clear')
        print("b)   a + ac(a+b)* + c(a+b+c)*")
        file_globals = runpy.run_path("abc.py")
        input("Presiona Enter para continuar...")
    if x == "c" or x == "3":
        os.system('clear')
        file_globals = runpy.run_path("comida.py")
    if x == "d" or x == "4":
        os.system('clear')
        file_globals = runpy.run_path("libre.py")
    if x == "e" or x == "5":
        os.system('clear')
        exit()
