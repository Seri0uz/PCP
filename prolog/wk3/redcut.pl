L = [_, _, _], member(a, L) , member(b, L), member(c, L), !.
% Wenn der Cut Operator ganz am Ende steht, hört prolog nach einer erfolgreichen Lösung auf weil dann der Cut Operator kommt

L = [_, _, _], member(a, L) , member(b, L),! ,member(c, L).
% A und B sind schon gesetzt, somit kann es nur eine Lösung geben.


%b): Lösungen werden aktiv abgeschnitten und somit greifen wir aktiv in den Lösungsraum ein. 