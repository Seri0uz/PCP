:- use_module(library(clpr)). 

fib_clp(N, F) :- { N = 0, F = 0 }. 
fib_clp(N, F) :- { N = 1, F = 1 }. 
fib_clp(N, F) :- 
    { N >= 2, 
    F >= N-1, 
    F = F1+F2, 
    N1 = N-1, 
    N2 = N-2 }, 
    fib_clp(N1, F1), 
    fib_clp(N2, F2).

% a) Das Programm hängt sich auf -> stack limit exceeded

%b) Weil Prolog immer weitere Möglichkeiten sucht, da die Variable unbekannt ist

%c) Ich muss die Suche begrenzen und mit F>= N-1 somit dass die Fibo Nummer nur bis 1 über der Fibo Zahl gesucht wird
   %z.B. bei fib_clp(X, 14). sucht er nur Fib Nummern bis 15 und bricht dann ab. 

