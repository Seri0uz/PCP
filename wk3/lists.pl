add_tail(X,[],[X]).
add_tail(X, [HEAD | TAIL], [HEAD | NEWTAIL]) :-
    add_tail(X, TAIL, NEWTAIL).

del([X | TAIL],X, TAIL).
del([HEAD | TAIL], X, [HEAD | NEWTAIL]) :-
    del(TAIL, X, NEWTAIL). 

mem_d(X,L) :- del(L,X,_).

rev_acc([],A,A).
rev_acc([HEAD | TAIL], A, R) :-
    rev_acc(TAIL, [HEAD | A], R).

rev(L,R) :- rev_acc(L,[],R).
