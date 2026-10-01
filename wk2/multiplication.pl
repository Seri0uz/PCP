mult(_, 0, 0).
mult(X, Y, R) :-
    Y > 0, %b) nur bei positiven Y weiterrechnen, somit keine unendlichen lösungen 
    Y1 is Y - 1,
    mult(X, Y1, R1),
    R is R1 + X.