;a
(defn letter-frequencies [string]
  (let [counts (frequencies (clojure.string/upper-case string))]
    (map (fn [letter] (get counts letter 0)) "ABCDEFGHIJKLMNOPQRSTUVWXYZ")))

(letter-frequencies "aBBcCc")

;b
(defn cosine-similarity [vec1 vec2]
  (let [lenght1 (Math/sqrt (reduce + 0 (map #(* % %) vec1)))
        lenght2 (Math/sqrt (reduce + 0 (map #(* % %) vec2)))
        scalarproduct (reduce + 0 (map * vec1 vec2))]
    (/ scalarproduct (* lenght1 lenght2))))

(cosine-similarity [1 2 3 4] [4 3 2 1])
(cosine-similarity [1 2 3 4] [1 2 3 4])
(cosine-similarity [0 1 0 0] [1 0 0 0])

;c
(def de [6.51 1.89 3.06 5.08 17.40 1.66 3.01 4.76 7.55
         0.27 1.21 3.44 2.53  9.78 2.51 0.79 0.02 7.00
         7.27 6.15 4.35 0.67  1.89 0.03 0.04 1.13])
(def en [8.17 1.48 2.78 4.25 12.70 2.23 2.02 6.09 6.97
         0.15 0.77 4.03 2.41  6.75 7.51 1.93 0.10 5.99
         6.33 9.06 2.76 0.98  2.36 0.15 1.97 0.07])
(def fr [7.64 0.90 3.26 3.67 14.00 1.07 0.87 0.74 7.53
         0.55 0.05 5.46 2.97  7.10 5.38 3.02 1.36 6.55
         7.95 7.24 6.31 1.63  0.11 0.39 0.31 0.14])

(defn rec-language [text]
  (let [text-freq (letter-frequencies text)
        similarity-de (cosine-similarity text-freq de)
        similarity-en (cosine-similarity text-freq en)
        similarity-fr (cosine-similarity text-freq fr)]
    (cond (and (>= similarity-de similarity-en)
               (>= similarity-de similarity-fr))
          "de"
          (>= similarity-en similarity-fr)
           "en"
          :else
          "fr")))

(rec-language "Die Programmiersprache Clojure ist eine funktionale Programmiersprache mit vielen Klammern.")

(rec-language "The programming language Clojure is a functional programming language with many parentheses.")

(rec-language "Le langage de programmation Clojure est un langage de programmation fonctionnel avec beaucoup de parenthèses.")
