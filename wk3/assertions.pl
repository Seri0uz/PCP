:- dynamic fak_as/2.
fak(N,F) :- 
    fak_as(N,F),
    !,
    write('(Hinweis: Fakultät von '), 
    write(N), 
    write(' war gespeichert.)').
fak(0, 1). % simple case
fak(N, F) :- % general case
    N > 0, % argument test
    N1 is N - 1, % evaluate N-1
    fak(N1, F1), % recursive call
    F is N * F1, % sum up
    asserta(fak_as(N,F)). % assert new fact

fak_clear :- 
    retractall(fak_as(_,_)), 
    write('(Hinweis: alle gespeicherten Werte wurden gelöscht.)').
