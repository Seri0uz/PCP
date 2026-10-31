(take 30 (iterate (partial + 2) 2))

(take 20 (iterate (partial * 3) 3))

(take 20 (iterate (fn [x] (+ (* x 2) 1)) 1))

(take 20 (map first (iterate (fn [[x y]] (vector y (+ x y))) [1 1])))
