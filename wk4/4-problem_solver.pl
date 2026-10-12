:-use_module(library(clpfd)).
:-use_module(library(http/http_client)).
:-use_module(library(http/http_json)).

%Relationships
female(mary). female(liz). female(mia). female(tina). female(ann). female(sue).% all females
male(mike). male(jack). male(fred). male(tom). male(joe). male(jim). % all males
parent(mary, mia). parent(mary, fred). parent(mary, tina). % all childern of mary
parent(mike, mia). parent(mike, fred). parent(mike, tina). % all children of mike
parent(liz, tom). parent(liz, joe). % allchildern of liz
parent(jack, tom). parent(jack, joe). % all childern of jack
parent(mia, ann). % all childern of mia
parent(tina, sue). parent(tina, jim). % all childern of tina
parent(tom, sue). parent(tom, jim). 
mother(M, X) :- 
    female(M),
    parent(M, X).
father(F, X) :-
    male(F),
    parent(F, X).
sibling(X, Y) :-
    parent(P, X),
    parent(P, Y).
grandmother(GM, GC) :-
    mother(GM, P),
    parent(P, GC).
grandfather(GF, GC) :-
    father(GF, P),
    parent(P, GC).
offspring(O, A) :-
    parent(A, O).
offspring(O, A) :-
    parent(P, O),
    offspring(P, A).

relationship(LIST, RESULT):-
    member(firstPerson=FIRST, LIST),
    member(relationship=RELATION, LIST),
    member(secondPerson=SECOND, LIST),
    ( call(RELATION, FIRST, SECOND), RESULT = true ; 
    \+ call(RELATION, FIRST, SECOND), RESULT = false).






%Sudoku
sudoku_solver(Rows) :-
  append(Rows, Vs), Vs ins 1..9,
  maplist(all_distinct, Rows),
  transpose(Rows, Columns),
  maplist(all_distinct, Columns),
  Rows = [A, B, C, D, E, F, G, H, I],
  blocks(A, B, C), blocks(D, E, F), blocks(G, H, I),
  maplist(label, Rows).

blocks([], [], []).
blocks([J, K, L | Bs1], [M, N, O | Bs2], [P, Q, R | Bs3]) :-
  all_distinct([J, K, L, M, N, O, P, Q, R]),
  blocks(Bs1, Bs2, Bs3).

replace_grid([], []).
replace_grid([ROW | REST], [NEWROW | NEWREST]) :-
    maplist(replace, ROW, NEWROW),
    replace_grid(REST, NEWREST).

replace(0,_).
replace(N,N) :-
    N \= 0.

sudoku(LIST, RESULT) :-
    member(sudoku=GRID, LIST),
    replace_grid(GRID, RESULT),
    sudoku_solver(RESULT).











solve(PROBLEM,ID) :-
    atomic_list_concat(['http://localhost:16316/problem/', PROBLEM],PostURL),
    atomic_list_concat([PostURL, '/', ID], GetURL),
    http_get(GetURL, json(LIST), []),
    call(PROBLEM,LIST,RESULT),
    ANSWER= json([solution=RESULT, id=ID]),
    http_post(PostURL,json(ANSWER), REPLY, []),
    writeln(RESULT),
    write('Resultat ist: '),
    write(REPLY).

