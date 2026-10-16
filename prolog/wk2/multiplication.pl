mult(_, 0, 0).
mult(0, _, 0).
mult(X, 1, X).
mult(1, Y, Y).
mult(X, Y, R) :-
    Y > 0, %b) nur bei positiven Y weiterrechnen, somit keinen unendliches suchen
    Y1 is Y - 1,
    mult(X, Y1, R1),
    R is R1 + X.