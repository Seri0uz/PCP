(ns wk6.exercise6)

(def stack [])

(defn LOAD [stack x]
  (if (>= x 0)
    (do
      (println x "(LOAD)")
      (conj stack x))
    stack))
  
(defn ADD [stack]
  (println (+ (peek stack) (peek (pop stack))) "(ADD)")
  (conj (pop (pop stack))
        (+ (peek stack) (peek (pop stack)))))

(defn MUL [stack]
  (println (* (peek stack) (peek (pop stack))) "(MUL)")
  (conj (pop (pop stack))
        (* (peek stack) (peek (pop stack)))))


(MUL (LOAD (ADD (LOAD (LOAD stack 2) 3))4))

(MUL (ADD (LOAD (LOAD (ADD (LOAD (LOAD stack 4)5))2)3)))



(defn run-command [stack command]
  (let [[op x] (read-string (str "[" command "]"))
        stack (apply list stack)]
    (case op 
      LOAD (LOAD stack x)
      ADD  (ADD stack)
      MUL  (MUL stack))))
  
(run-command [] "LOAD 1")
(run-command [1 2] "LOAD 3")
(run-command [1 2 9 9 9] "ADD")
(run-command [2 3 9 9 9] "MUL")





(defn SUB [stack]
  (println (- (peek (pop stack)) (peek stack)) "(SUB)")
  (conj (pop (pop stack))
        (- (peek (pop stack)) (peek stack))))

(defn DIV [stack]
  (println (quot (peek (pop stack)) (peek stack)) "(DIV)")
  (conj (pop (pop stack)) 
        (quot (peek (pop stack)) (peek stack))))


(defn run-command2 [stack command]
  (let [[op x] (read-string (str "[" command "]"))
        stack (apply list stack)]
    (case op
      LOAD (LOAD stack x)
      ADD  (ADD stack)
      MUL  (MUL stack)
      SUB  (SUB stack)
      DIV  (DIV stack))))

(run-command2 [4 7 9 9 9] "SUB")
(run-command2 [4 7 9 9 9] "DIV")




(defn run-program [commands]
  (peek (reduce run-command2 '() commands)))

(run-program ["LOAD 2" "LOAD 3" "ADD" "LOAD 4" "MUL"])