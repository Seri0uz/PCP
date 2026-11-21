(for [a (range 1 101) 
      b (range a 101) 
      c (range b 101)
      :when (= (+ (* a a) (* b b)) (* c c))]
  (list a b c)
  )