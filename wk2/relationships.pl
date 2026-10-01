female(mary). female(liz). female(mia). female(tina). female(ann). female(sue).% all females
male(mike). male(jack). male(fred). male(tom). male(joe). male(jim). % all males
parent(mary, mia). parent(mary, fred). parent(mary, tina). % all childern of mary
parent(mike, mia). parent(mike, fred). parent(mike, tina). % all children of mike
parent(liz, tom). parent(liz, joe). % allchildern of liz
parent(jack, tom). parent(jack, joe). % all childern of jack
parent(mia, ann). % all childern of mia
parent(tina, sue). parent(tina, jim). % all childern of tina
parent(tom, sue). parent(tom, jim). % all childern of tom

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

offspring(D, A) :-
    parent(A, D).
offspring(D, A) :-
    parent(P, D),
    offspring(P, A).
    
%a)
% father(X, jim).
% mother(X, jim).
% parent(mary, X).

%b)
% sibling(mia, fred).

%c)
% grandmother(X, ann).
% grandmother(liz, X).
% grandmother(X, jim).

%d) 
% offspring(ann, mary).
% offspring(sue, X).



%5)
%a)
% op(1150, xfx, mother).
% liz mother X.

%b)
% op(1150, xfx, offspring).
% ann offspring mike.

%6)
%a)
% X is 16 / 4 / 2.
% X=2, weil yfx linksassoziativ ist wird von links nach rechts gerechnet. 
% 16/4 = 4 und 4/2 = 2

%b) Y = 3, X = Y - 1.
% Y =3 und X = 3-1 weil gleichzeichen und nicht is genommen wurde rechnet es dies nicht zusammen. 
% mit Y = 3, X is Y - 1. wäre X = 2
