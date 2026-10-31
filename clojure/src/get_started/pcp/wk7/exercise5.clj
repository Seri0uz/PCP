(for [a (range 1 101) 
      b (range 1 101) 
      c (range 1 101)
      :when (= (+ (* a a) (* b b)) (+ c c))]
  (list a b c)
  )