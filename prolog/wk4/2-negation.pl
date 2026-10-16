set_difference([],_,[]).

set_difference([HEAD | TAIL],L1,[HEAD | NEWTAIL]) :-
    \+ member(HEAD, L1),
    set_difference(TAIL,L1,NEWTAIL).

set_difference([HEAD | TAIL], L1, NEWTAIL) :-
    member(HEAD, L1),
    set_difference(TAIL, L1, NEWTAIL).


% set_difference([a, b, c, d], [b, d, e, f], [a, c]).

% set_difference([1, 2, 3, 4, 5, 6], [2, 4, 6], L).