(defn scale [x1 x2 y1 y2 x]
  (+ y1 (* (/ (- x x1) (- x2 x1))
           (- y2 y1))))

(def chf2euro
  (partial scale 0 1 0 1.08))

(chf2euro 5)


(def cel2fa 
  (partial scale 0 1 32 33.8))

(cel2fa 1)