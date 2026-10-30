
(defn diskriminante [a b c] (- (* b b) (* 4 a c)))

(defn d-validation [a b c]  (>= (diskriminante a b c) 0))

(defn d-result-count [a b c] 
  (cond
   (> (diskriminante a b c) 0) 2
   (= (diskriminante a b c) 0) 1
   :else 0))                                                 

(defn loesungen [a b c]
  (cond
    (< (diskriminante a b c) 0)
    []

    (= (diskriminante a b c) 0)
    [(/ (- b) (* 2 a))]

    :else
    [(/ (+ (- b) (Math/sqrt (diskriminante a b c)))
        (* 2 a))
     (/ (- (- b) (Math/sqrt (diskriminante a b c)))
        (* 2 a))]))


(loesungen 1 2 5)
(loesungen 1 -6 9)
(loesungen 1 -5 6)