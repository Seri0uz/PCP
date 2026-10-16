n(yellow,red).  n(yellow,green).
n(red,yellow).  n(red,green).
n(green,yellow).   n(green,red).

colors(LU, NW, OW, SZ, UR, ZG) :-
    UR = yellow,
    SZ = red,
    n(UR,OW), n(UR,NW), n(UR,SZ),
    n(SZ,NW), n(SZ,ZG), n(SZ,LU),
    n(ZG,LU),
    n(LU,NW), n(LU, OW),
    n(NW, OW).

%colors(LU, NW, OW, SZ, UR, ZG).
