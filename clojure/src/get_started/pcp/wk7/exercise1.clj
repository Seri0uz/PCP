(defn sum-numbers [nums]
  (map println nums) ; println wird nie ausgeführt 
  (reduce + nums))

(sum-numbers [1 2 3 4])

;Weil map lazy ist, println wird erst aufgerufen wenn die nums aufgefordert werden

(defn sum-numbers1 [nums]
  (doall (map println nums)) 
  (reduce + nums))

(sum-numbers1 [1 2 3 4])


(defn sum-numbers2 [nums]
  (run! println nums)
  (reduce + nums))

(sum-numbers2 [1 2 3 4])