;a

;b
(map (fn [x] [x x]) [1 2 3])
(mapcat (fn [x] [x x]) [1 2 3])

;c
(defn mapcat2map [f coll]
  (mapcat (fn [x] (vector (f x))) coll))

(mapcat2map vector [1 2 3])
(map vector [1 2 3])

;d
(defn mapcat2filter [f coll]
  (mapcat (fn [x] 
            (if (f x)
              [x])) coll))

(mapcat2filter even? [1 2 3 4 5])
(filter even? [1 2 3 4 5])


