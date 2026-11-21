(mapcat (fn [x] (map #(+ x %) (range 3))) (range 3))

(for [zahl1 (range 10)
      zahl2 (range 10)]
  (+ zahl1 zahl2))



(map #(list % %) (filter #(== (mod % 3) 0) (range 10)))

(for [zahl (range 10)
      :when (== (mod zahl 3) 0)]
  (list zahl zahl))



(filter #(> (second %) (first %))
        (mapcat (fn [x] (map #(list x %) (range 4))) (range 4))) 

(for [zahl1 (range 4) 
      zahl2 (range 4)
      :when (> zahl2 zahl1)]
  (list zahl1 zahl2))