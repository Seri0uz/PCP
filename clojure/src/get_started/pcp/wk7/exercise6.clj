(ns wk7.exercise6
  (:require [wk7.parser :refer [parse]] 
            [wk6.exercise6 :refer [run-program]])
  (:import [wk7.parser Op Val]))

; Beispiel: Baum für (2+3) * 4
(def expr1 (Op. * (Op. + (Val. 2) (Val. 3)) (Val. 4)))

; Beispiel: Baum für (2+3) * 4, aber mit parse
(def expr2 (parse "(2+3) * 4"))

(= expr1 expr2) ; sollte true ergeben

(def expr3 (Op. * (Op. + (Op. - (Val. 4) (Val. 2)) (Op. / (Val. 6) (Val. 3))) (Val. 2)))
(def expr4 (parse "2 * (4-2) + (6/3)"))
(= expr3 expr4)

(def expr3-r (Op. + (Op. * (Val. 2) (Op. - (Val. 4) (Val. 2))) (Op. / (Val. 6) (Val. 3))))
(= expr3-r expr4)

; ------------------------------------------------
; TODO - Implementieren Sie die Funktion eval-expr
; 
; Tipp: Im Input wurde gezeigt, wie man nach Typ
; verzweigen kann (Folie 20)
; 
; In dieser Aufgabe brauchen Sie nur die Typen
; Op und Val. Sie können davon ausgehen, dass
; nur mit Ganzahlen gerechnet wird, die Division
; ist also auch immer ganzzahlig.
; ------------------------------------------------

(defn eval-expr [expr] 
  (cond
    (instance? Val expr) 
    (:value expr)

    (instance? Op expr) 
    (let [left-value (eval-expr (:left expr))
          right-value (eval-expr (:right expr))
          operation (:op expr)]
      (operation left-value right-value))))
  
(eval-expr (parse "2 * (4-2) + (6/3)"))

; ------------------------------------------------
; TODO: Compilieren Sie eine Expression für unsere
; Stackmaschine aus der letzten Übung
; ------------------------------------------------
(defn compile-expr [expr]
  (cond 
    (instance? Val expr)
    [(str "LOAD " (:value expr))]

    (instance? Op expr)
    (let [left-value (compile-expr (:left expr))
          right-value (compile-expr (:right expr))
          operation (get {+ "ADD", - "SUB", * "MUL", / "DIV"} (:op expr))]
      (concat left-value right-value [operation]))))

(compile-expr (parse "2 * (4-2) + (6/3)"))
(compile-expr (parse "3 * (2 + 2)"))
; ------------------------------------------------
; TODO: Testen Sie an einem Ausdruck, ob die
; Stack-Maschine das gleiche Ergebnis liefert
; wie die eval-expr-Funktion
; ------------------------------------------------


; (run-program (compile-expr ...))
(run-program ["LOAD 3" "LOAD 2" "LOAD 2" "ADD" "MUL"])
(run-program (compile-expr (parse "3 * (2 + 2)")))