#By: Adrian Nava, Teoria Computacional.

#La funcion FSM toma el input del texto leido anteriormente y determina:
#Orden del Input en .txt (Q, Sigma, Delta, q0, F)
#Donde Q = Estados, Sigma = Alfabeto,
#Delta = Funciones de transicion, q0 = Estado Inicial, y F = Estado(s) Final(es).
def FSM(Q, Sigma, Delt, Q0, F, sInput):
    currentState = epsTrans(q0, Delt)

    #Estado Actual = Q0
    for x in sInput:
        nextState = set() #inicia vacio
        for y in currentState: #Encuentra numero de transiciones
            trans = 0
            for z in Delt:
                if (z[0] == y and z[1] == x):
                    trans = trans + 1
                    for a in range(len(z))[2:]: #agrega numero de iteraciones o estados...
                        nextState.add(z[a])
            if(trans == 0): #si no existen transiciones pasa al siguiente estado
                nextState.add(y)
        currentState = nextState
        currentState = epsTrans(currentState, Delt) #agrega epsilon para iniciar siguiente estado
    if (len(currentState.intersection(F))>0): #si es estado final:
        return True
    else:
        return False

#Crea Epsilon
def epsTrans(q0, Delt):
        done = True
        curStates = q0
        while(done):
            nextState = set();
            for y in curStates:
                for z in Delt:
                    if (z[0] == y and z[1] == '.'):
                        for a in range(len(z))[2:]:
                            nextState.add(z[a])
            prevState = set()
            prevState.update(curStates)
            curStates.update(nextState) #Agrega estados al estado actual
            if (curStates == prevState):
                done = False #Cuando acaba rompe el loop
        return curStates

#Aqui se lee el .txt y separa en 5 lineas respectivamente:D
def readFSM(fileName):
    f = open(fileName, 'r')
    inpLines = []
    for line in f:
        inpLines.append(line.rstrip('\n'))

    count = 0
    for x in inpLines:
        if count == 0:
            q.clear()
            for a in inpLines[count]:
                q.add(a)
        elif count == 1:
            S.clear()
            for a in inpLines[count]:
                S.add(a)
        elif count == 2:
            delt.clear()
            s = ""
            for a in inpLines[count]:
                if a != ',':
                    s = s + a
                else:
                    tempTuple = ()
                    for t in s:
                        temp = (t,)
                        tempTuple = tempTuple + temp
                    delt.append(tempTuple)
                    s = ""
        elif count == 3:
            q0.clear()
            for a in inpLines[count]:
                q0.add(a)
        elif count == 4:
            F.clear()
            for a in inpLines[count]:
                F.add(a)
        count = count + 1

#Initialize the Variables for the FSM
q = set()
S = set()
delt = []
q0 = set()
F = set()

#Tests

print("\tProblem 1")
readFSM("prob1.txt")
print ("Problem 1: input '00'")
print (FSM(q, S, delt, q0, F, "00")) #true
print ("Problem 1: input '001100'")
print (FSM(q, S, delt, q0, F, "001100"))#true
print ("Problem 1: input '00110011'")
print (FSM(q, S, delt, q0, F, "00110011"))#true
print ("Problem 1: input '11001100'")
print (FSM(q, S, delt, q0, F, "11001100"))#true
print ("Problem 1: input '1100110011'")
print (FSM(q, S, delt, q0, F, "1100110011"))#true
print ("Problem 1: input '01'")
print (FSM(q, S, delt, q0, F, "01"))#false              LISTO
print ("Problem 1: input '0'")
print (FSM(q, S, delt, q0, F, "0"))#false
print ("Problem 1: input '101010'")
print (FSM(q, S, delt, q0, F, "10"))#false
print ("Problem 1: input '1010101010101010'")
print (FSM(q, S, delt, q0, F, "10"))#false
print ("Problem 1: input '10'")
print (FSM(q, S, delt, q0, F, "10"))#false


print("\tProblem 2")
readFSM("prob2..txt")
print ("Problem 2: input '111'")
print (FSM(q, S, delt, q0, F, "111"))#true
print ("Problem 2: input '0'")
print (FSM(q, S, delt, q0, F, "0"))#true
print ("Problem 2: input '100'")
print (FSM(q, S, delt, q0, F, "100"))#true
print ("Problem 2: input '01010'")
print (FSM(q, S, delt, q0, F, "01010"))#true
print ("Problem 2: input ''")
print (FSM(q, S, delt, q0, F, " "))#TRUE            LISTO
print ("Problem 2: input '01'")
print (FSM(q, S, delt, q0, F, "01"))#FALSE
print ("Problem 2: input '101'")
print (FSM(q, S, delt, q0, F, "101"))#FALSE
print ("Problem 2: input '110011'")
print (FSM(q, S, delt, q0, F, "110011"))#FALSE
print ("Problem 2: input '000111'")
print (FSM(q, S, delt, q0, F, "000111"))#FALSE
print ("Problem 2: input '0111'")
print (FSM(q, S, delt, q0, F, "0111"))#FALSE

print("\tProblem 3")
readFSM("prob3.txt")
print ("Problem 3: input '1011'")
print (FSM(q, S, delt, q0, F, "1011"))#TRUE
print ("Problem 3: input '1001011'")
print (FSM(q, S, delt, q0, F, "1001011"))#TRUE
print ("Problem 3: input '1100101100'")
print (FSM(q, S, delt, q0, F, "1000110"))#TRUE
print ("Problem 3: input '1000110'")
print (FSM(q, S, delt, q0, F, "10000110"))#TRUE
print ("Problem 3: input '10000110'")
print (FSM(q, S, delt, q0, F, "10000000110"))#TRUE     Faltan
print ("Problem 3: input '10000000110'")
print (FSM(q, S, delt, q0, F, ""))#False
print ("Problem 3: input '1'")
print (FSM(q, S, delt, q0, F, "1"))#False
print ("Problem 3: input '0'")
print (FSM(q, S, delt, q0, F, "0"))#False
print ("Problem 3: input '11111'")
print (FSM(q, S, delt, q0, F, "11111"))#False
print ("Problem 3: input '00000'")
print (FSM(q, S, delt, q0, F, "00000"))#False

print("\tProblem 4")
readFSM("prob4.txt")
print ("Problem 4: input 'abcab'")
print (FSM(q, S, delt, q0, F, "abcab"))#TRUE
print ("Problem 4: input 'abccbbc'")
print (FSM(q, S, delt, q0, F, "abccbbc"))#TRUE
print ("Problem 4: input 'abbccaaca'")
print (FSM(q, S, delt, q0, F, "abbccaaca"))#TRUE
print ("Problem 4: input 'abbbab'")
print (FSM(q, S, delt, q0, F, "abbbab"))#TRUE
print ("Problem 4: input 'abcabcabcab'")
print (FSM(q, S, delt, q0, F, "abcabcabcab"))#TRUE          LISTO
print ("Problem 4: input 'aaaaaaa'")
print (FSM(q, S, delt, q0, F, "aaaaaaa"))#False
print ("Problem 4: input 'bbbbb'")
print (FSM(q, S, delt, q0, F, "bbbbb"))#False
print ("Problem 4: input 'cccccc'")
print (FSM(q, S, delt, q0, F, "cccccc"))#False
print ("Problem 4: input 'caaaaaa'")
print (FSM(q, S, delt, q0, F, "caaaaaa"))#False
print ("Problem 4: input 'cacacaaaa'")
print (FSM(q, S, delt, q0, F, "cacacaaaa"))#False
