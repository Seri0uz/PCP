(mapcat (fn [x] (map #(+ x %) (range 3))) (range 3))

(for [bereich [[0 2] [1 3] [2 4]] 
  :let [[from to] bereich]
  i (range from (inc to))]
  i)




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