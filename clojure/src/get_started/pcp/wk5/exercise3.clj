(+ (* 2 3) (/ 3 4)) ; (2*3) + (3/4) = 6 + 0.75 = 6.75  number
(+ - * /) ; Mehrere Operatoren ohne zahlen
'(+ - * /) ; wird noch nicht ausgerechnet darum kein Fehler
(str 1.0 2 true) ; String 1.02 true 
(+ (parse-long "123") (parse-double "0.45")) ;123 + 0.45 = 123.45 double
(or "this" "is" "crazy") ; this wird ausgegeben als erstes Argument 
(and "this" "is" "crazy") ;crazy wird ausgegeben als letztes Argument 
(not "this" "is" "crazy")  ;Arity Exception, not erlaubt nur ein Argument
((fn [x] (/ 1 x)) (/ 5 2)) ; 2 / 5 
(int? 3000000000) ;true ist eine Ganzzahl, long
