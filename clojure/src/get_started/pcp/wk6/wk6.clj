(loop [i 0] 
  (when (< 10)
    (println i) 
    (recur (inc i))))
   
(loop [i 1
       d 1]
  (when (<= i 46)
    (println i)
    (recur (+ i d) (inc d))))



(defn binary-search [v x]
  (loop [low 0
         high (dec (count v))]
    (if (<= low high)
      (let [mid (quot (+ low high) 2)
            mid-val (get v mid)]
        (cond
          (< mid-val x) (recur (inc mid) high)
          (> mid-val x) (recur low (dec mid))
          :else
          true))
      false)))





(defn find-sums [nums target path] 
  (cond
    (zero? target) [path] 
    (empty? nums) []
    (neg? target) []
    :else
    (concat
       (find-sums (rest nums) 
                  (- target (first nums)) 
                  (conj path (first nums)))
       (find-sums (rest nums) 
                  target 
                  path))))

(find-sums [1 2 3 4 5 6 7 8 9] 12 [])


; Funktionen höherer Ordnung
(defn apply-twice [f x]
  (f (f x)))

(defn square [x] (* x x))

(apply-twice inc 1)
(apply-twice square 2)



; jedes Element einer Sammlung quadrieren 
(defn square-list [coll] 
  (if (empty? coll) () 
      (cons (square (first coll)) 
            (square-list (rest coll))))) 
            
; jedes Listen-Element inkrementieren 
(defn inc-list [coll] 
  (if (empty? coll) () 
      (cons (inc (first coll)) 
            (inc-list (rest coll))))) 


(square-list [1 2 3 4 5]) ; (1 4 9 16 25) 
(inc-list [1 2 3 4 5]) ; (2 3 4 5 6)

(map square [1 2 3 4 5])

(map count ["hallo" "test" "x"])

(reduce + [1 2 3 4 5])