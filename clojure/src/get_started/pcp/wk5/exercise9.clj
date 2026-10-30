;a) 3 10 5 16 8 4 2 
; 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 


;b) 
(defn algo [n]
  (if (> n 1)
    (do (println n)
        (if (even? n)
          (algo (/ n 2)) 
          (algo (+ (* 3 n) 1))))))
                 

(algo 3)
(algo 7)