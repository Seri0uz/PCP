;a
(defn my-map [f collection]
  (loop [local-collection collection acc []]
    (if (empty? local-collection)
      acc
      (recur (rest local-collection) (conj acc (f (first local-collection)))))))

(my-map (fn [x] (* x 2)) (list 1 2))

;b
(defn my-reduce [f coll]
  (loop [local-coll (rest coll) acc (first coll)]
    (if (empty? local-coll)
      acc
      (recur (rest local-coll) (f acc (first local-coll))))))

(my-reduce + [1 2 3 4 5]) ; 15
(my-reduce * [1 2 3 4 5]) ; 120

;c
(defn my-map-reduce [f collection]
  (reduce (fn [acc x] (conj acc (f x)))
          [] collection))

(my-map-reduce (fn [x] (* x 2)) (list 1 2))

;d
(defn multi-map [col1 col2] 
  (map vector col1 col2))  ;list würde auch gehen

(multi-map [1 2 3] [4 5 6])

;e
(defn revert-map [col]
  [(map first col)
  (map second col)])

(revert-map [[1 4] [2 5] [3 6]])