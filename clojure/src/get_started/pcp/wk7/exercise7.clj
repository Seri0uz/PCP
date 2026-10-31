;a 
; Werte können hinzugefügt werden und somit können zu unterschiedlichen Zeitpunkten andere Resultate zurückgeben werden



(def my-phone-dir
  (atom
   [{:name "Anna" :phone 1234}
    {:name "Ben" :phone 5678}]))



;b
(defn look-at [directory name]
  (:phone (first (filter (fn [person]
            (= name (:name person)))
          @directory))))

(look-at my-phone-dir "Anna")


;c
(defn add-entry [directory name phone]
  (swap! directory conj {:name name :phone phone}))

(add-entry my-phone-dir "Alex" 2468)




(look-at my-phone-dir "Anna")
(look-at my-phone-dir "Ben")
(look-at my-phone-dir "Alex")
(add-entry my-phone-dir "Alex" 2468)
(look-at my-phone-dir "Alex")