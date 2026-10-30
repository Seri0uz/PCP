;a 
(defn chf2euro [chf] (* chf 1.0788))

(chf2euro 5)

;b
(defn cel2fa [cel] (+(* cel 1.8) 32))

(cel2fa 23)

;c
(defn scale [x1 x2 y1 y2 x] 
  (+ y1 (* (/ (- x x1) (- x2 x1))
           (- y2 y1))))

;Währungen funktionieren auch