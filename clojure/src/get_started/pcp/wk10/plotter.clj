(ns wk10.plotter
  (:require
   [wk10.parser :refer [parse]]
   [wk10.expreval :refer [eval-expr]])
  (:import
   (java.awt BorderLayout Color Dimension)
   (java.awt.event ActionListener)
   (javax.swing JButton JFrame JPanel JTextField)))

(def width 800)
(def height 800)

(defn plot [g func]
  ; hier wird die Funktion gezeichnet
  ; g ist das Graphics-Objekt

  ; ------------------------------------------------------
  ; TODO Zeichne die Funktion, die in func gespeichert ist
  ; benutze dazu die eval-expr-Funktion aus expreval.clj
  ; um Funktionswerte zu berechnen
  ; ------------------------------------------------------

  ; Achtung, die Zeichenfunktion erwartet Integer-Werte, nicht Long! 
  (doseq [x (range -10 10 0.1)]
  (let [y1 (eval-expr func {"x" x}) 
        y2 (eval-expr func {"x" (+ x 0.1)})] 
    (when (and (Double/isFinite (double y1)) (Double/isFinite (double y2)) (<= -10 y1 10) (<= -10 y2 10)) 
        (.drawLine g (int (+ 400 (* x 40))) (int (- 400 (* y1 40))) (int (+ 400 (* (+ x 0.1) 40))) (int (- 400 (* y2 40))))))))

(defn build-plot-panel [func]
  (proxy [JPanel] []
    ; paintComponent überschreiben, um die Funktion zu zeichnen  
    (paintComponent [g]
      (proxy-super paintComponent g)

      ; --------------------------------
      ; TODO zeichne weissen Hintergrund
      (.setColor g Color/WHITE)
      (.fillRect g (int 0) (int 0) (int 800) (int 800))
      ; ...

      ; TODO zeichne x und y-Achse
      ; ...
      (.setColor g Color/BLACK)
      (.drawLine g (int 0) (int 400) (int 800) (int 400))
      (.drawLine g (int 400) (int 0) (int 400) (int 800))

      ; TODO plotte die Funktion (siehe plot-Funktion)
      ; --------------------------------
      (.setColor g Color/BLUE)
      (plot g @func))

    (getPreferredSize []
      (Dimension. width height))))

(defn plot-frame
  "Create a JFrame with a plot area and a text field for input."
  []
  (let
   [function (atom (parse "x^2"))          ; Atom für die Funktion
    plot-area (build-plot-panel function)  ; Panel für die Funktion
    text-field (JTextField. "x^2")         ; Textfeld für die Eingabe
    button (JButton. "Plot")               ; Button zum Zeichnen
    input-panel (JPanel.)                  ; Panel für Button und Textfeld

    ; erstelle JFrame
    ; und implementiere ActionListener
    ; für den Button
    frame (proxy [JFrame ActionListener] ["Function plotter"]
            (actionPerformed [e]
              ; --------------------------------------------
              ; TODO Funktion aus Textfeld lesen, parsen und 
              ; Atom aktualisieren, sodass die Funktion neu 
              ; gezeichnet wird
              ; --------------------------------------------
              (println "Plot wurde geklickt")
              (reset! function (parse (.getText text-field)))
              (.repaint plot-area)))]

    (doto button
      ; Button mit ActionListener verbinden
      (.addActionListener frame)
      (.setFocusable true))

    (doto input-panel
      ; Button und Textfeld in Input-Panel hinzufügen
      (.setLayout (BorderLayout.))
      (.add text-field BorderLayout/CENTER)
      (.add button BorderLayout/EAST))

    (doto frame
      ; JFrame einrichten und anzeigen
      (.setLayout (BorderLayout.))
      (.setResizable false)
      (.add plot-area BorderLayout/CENTER)
      (.add input-panel BorderLayout/SOUTH)
      (.pack)
      (.setVisible true))))

; Fenster anzeigen (startet evtl. im Hintergrund, je nach IDE, ggf. in den Vordergrund holen)
(plot-frame)

