
(defn let-example []
  (let [a 1 b 2 c 3]
  (let [b c]
    (println b c)
    (let [a b]
      (let [c a]
        [a b c])))))

(let-example)

;1. a = 1, b = 2, c = 3
;2. b bekommt den Wert von c (3)
;3. a bekommt den Wert von b (3)
;4. c bekommt den Wert von a (3)
; Ausgabe a b c (3 3 3)