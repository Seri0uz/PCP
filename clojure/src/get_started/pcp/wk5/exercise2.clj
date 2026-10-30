

; a) rectangle  
(def length 3)
(def width 5)
(def square (fn [x] (* x x)))

(* length width) ; Fläche
(* (+ length width ) 2) ;Umfang
(Math/sqrt (+ (square length ) (square width ))) ;Diagonale

; b) quadrat
(def q_length 2 )
(def q_width 3 )
(def q_height 4 )

(* q_length q_width q_height) ;Volumen
(* 2 (+ (* q_length q_width) (* q_length q_height) (* q_width q_height))) ;Oberfläche

; c) 
(defn area [width length] (* length width))
(defn perimeter [width length] (* (+ length width) 2))
(defn q_volume [width length height] (* length width height))
(defn q_surface [width length height] (* 2 (+ (* length width) (* length height) (* width height))))

(area 2 4)
(perimeter 2 4)
(q_volume 2 4 6)
(q_surface 2 4 6)