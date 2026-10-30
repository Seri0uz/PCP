;a)
(defn filterEven [list]
  (if (empty? list)
    list
    (if (even? (first list)) 
      (cons (first list) (filterEven (rest list)))
       (filterEven (rest list))))) 
   
(filterEven [1 2 3 4 5 6])


(defn filterOdd [list]
  (if (empty? list)
    list
    (if (odd? (first list))
        (cons (first list) (filterOdd (rest list)))
        (filterOdd (rest list))))) 

(filterOdd [1 2 3 4 5 6])


;b)
(defn filter-s [f list]
  (loop [local-list list result []]
    (if (empty? local-list)
      result
      (if (f (first local-list))
        (recur (rest local-list)
               (conj result (first local-list)))
        (recur (rest local-list)
               result)))))

(filter-s even? [1 2 3 4 5 6])

(filter-s odd? [1 2 3 4 5 6])