#By: Adrian Nava
#Made in: Python3
#To run correctly please install Lark (read the grammar) and Pydot (to graphic)

#Operadores: +,-,*,/,%, =
#Parentesis:(,).
#Digitos: 0...9
#Variables: abc_9
#Log:  log()
#Trig: sen() / sin()
#      cos()
#      tan()

import sys
from lark import Lark, tree

grammar = """
    sentence: variable igual expresion    -> exp

    expresion: dig+
             | dig ope dig
             | variable ope variable
             | variable ope dig+
             | dig+ ope variable
             | dig+
             | variable
             | parentesis expresion parentesis
             | log
             | trig
             | expresion ope expresion

    dig: DIG
    ope: OPE
    variable: var+
    parentesis: P
    | Q
    var: VAR+                       ->letra
        | DIG+                     ->digito
        | GUION DIG? VAR?          ->guion
    log: LOG parentesis expresion parentesis
    trig: SEN parentesis expresion parentesis
          |COS parentesis expresion parentesis
          |TAN parentesis expresion parentesis
    igual: IGUAL


    OPE: ("+"|"-"|"*"|"/"|"%")
    DIG: /[0-9]/
    VAR: /[a-z]+/
        |/[A-Z]+/
    LOG: "log("
        | "Log"
        | "LOG"
        | "Ln"
        | "LN"
        | "ln"
    SEN: "sin"
        |"SIN"
        |"Sin"
        |"sen"
        |"Sen"
        |"SEN"
    COS: "cos"
        |"Cos"
        |"COS"
    TAN: "tan"
        | "Tan"
        | "TAN"
        | "tg"
        | "TG"
        | "Tg"
    GUION: "_"
    IGUAL: "="
    P:"("
    Q:")"


    %import common.WS
    %ignore WS
    %ignore " "
"""
parser = Lark(grammar, start='sentence', lexer = 'dynamic_complete')
parser1 = Lark(grammar, start='sentence', lexer = 'dynamic', ambiguity='explicit')

while True:

    sentence = input("Inserte expresion a validar\n\t")
    if sentence.find("=") == -1:
        print ("cadena invalida")
    else:
        def make_png(filename):
            tree.pydot__tree_to_png( parser.parse(sentence), filename +".png")
            tree.pydot__tree_to_png( parser1.parse(sentence), filename + " ambiguo.png")
        if __name__ == '__main__':
            print(parser.parse(sentence).pretty())
            make_png(sys.argv[1])
            exit()
