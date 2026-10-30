; a)
(def temperatur 28)

(cond
  (> temperatur 15) "mittel"
  (> temperatur 35) "heiss"
  (> temperatur 25) "warm" 
  :else "kalt")

;hier darf man nicht vertauschen, weil nur der erste Fall genommen wird und dann abgebrochen wird

;b) 
(def zahl 15)

(cond
  (zero? (rem zahl 3)) "durch 3 teilbar"
  (zero? (rem zahl 2)) "durch 2 teilbar" 
  :else "weder durch 2 noch durch 3 teilbar")

; hier darf man nicht vertauschen, weil nur der erste Fall genommen wird und dann abgebrochen wird

;c) 
(if (> temperatur 35) 
  "heiss" 
    (if (> temperatur 25) 
      "warm" 
      (if (> temperatur 15) 
        "mittel"
        "kalt")))

;d) Nein, weil case auf konkrete Werte prüft

