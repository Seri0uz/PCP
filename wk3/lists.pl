add_tail(X,[],[X]).
add_tail(X, [HEAD | TAIL], [HEAD | NEWTAIL]) :-
    add_tail(X, TAIL, NEWTAIL).

del([],_,[]).

del([X | TAIL],X, NEWTAIL) :-
    del(TAIL, X, NEWTAIL).

del([HEAD | TAIL], X, [HEAD | NEWTAIL]) :-
    del(TAIL, X, NEWTAIL). 


mem_d(X,L) :- del(L,X,R), dif(L,R).

rev_acc([],A,A).
rev_acc([HEAD | TAIL], A, R) :-
    rev_acc(TAIL, [HEAD | A], R).

rev(L,R) :- rev_acc(L,[],R).



%a) add_tail(x, [a, b, c], L).

%b) del([a, b, c, a, d, a], a, L).

%c) mem_d(a, [a, b, c]).
%   mem_d(x, [a, b, c]).  

%d) rev_acc([a, b, c, d], [], L).