((ns get-started.pcp.wk5.wk5))

(+ 1 (* 2 8) (* 4 4) (* 8 2) (* 1 16))

(* (+ 10 (- 11 1)) (/ 35 7))

(*
 (+ 10
    (- 11 1))
 (/ 35 7))


(* (+ 1 4) (+ 2 5) 8 9)

(/(* (+ 5 9) 3) 6)

(*(/ 14 7)(- 37 33))


(def a 1)
a


(def PI 3.141592) 
(defn square [x] (* x x)) 
(defn area-of-disk [r] (* PI (square r)))
(defn area-of-ring [outer inner] 
  (- (area-of-disk outer) (area-of-disk inner)))

(area-of-ring 5 3)



(defn countdown [n] 
  (if (> n 0)  
    (do print)
    (println n) 
    (countdown (dec n))))

(countdown 10)