from automata.tm.dtm import DTM
# DTM which matches all strings beginning with '0's, and followed by
# the same number of '1's
dtm = DTM(
    states={'q0', 'q1', 'q2', 'q3', 'q4'},
    input_symbols={'0', '1'},
    tape_symbols={'0', '1', 'x', 'y', '.'},
    transitions={
        'q0': {
            '0': ('q1', 'x', 'R'),
            'y': ('q3', 'y', 'R')
        },
        'q1': {
            '0': ('q1', '0', 'R'),
            '1': ('q2', 'y', 'L'),
            'y': ('q1', 'y', 'R')
        },
        'q2': {
            '0': ('q2', '0', 'L'),
            'x': ('q0', 'x', 'R'),
            'y': ('q2', 'y', 'L')
        },
        'q3': {
            'y': ('q3', 'y', 'R'),
            '.': ('q4', '.', 'R')
        }
    },
    initial_state='q0',
    blank_symbol='.',
    final_states={'q4'}
)
print(list(dtm.validate_input('00111', step=True)))
if True:
    print("Cadena valida")
    if False:
        print("Cadena no valida")
