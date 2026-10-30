(def start [3 4 3 1 2])

(defn schritt [start]
  (loop [remaining start result []]
    (if (empty? remaining)
      result
      (if (zero? (first remaining))
        (recur (rest remaining) (conj result 6 8))
        (recur (rest remaining) (conj result (dec (first remaining))))))))

  
(defn counter [zustand n]
  (if (zero? n)
    (count zustand)
    (recur (schritt zustand) (dec n))))

(counter start 80)
(counter start 256)
