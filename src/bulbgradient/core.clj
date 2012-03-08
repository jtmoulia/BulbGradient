(ns bulbgradient.core
  (:use [clojure.string :only [split split-lines]]
        (incanter core io))
  (:import (java.lang Double)))

(defn create-rotate-matrix [rads]
  (matrix
   [[(cos rads) (- (sin rads))]
    [(sin rads) (cos rads)]]))

(defn rotate-point [pt rads]
  (let [rot-mat (create-rotate-matrix rads)]
    (mmult rot-mat pt)))

(defn angle-from-vertical [pt1 pt2]
  (let [[dx dy] (minus pt1 pt2)]
    (atan (/ dx dy))))

(defn translate-pt [pt dxdy]
  (plus pt dxdy))

(defn calc-bulb-center [pt1 pt2]
  (let [diff (/ 2 3)]
    (plus pt1 (mult (minus pt1 pt2)))))

;; Not as abstract...
(defn glom-data-to-map [data]
  (let [rec-to-map (fn [rec]
                     {:index (nth rec 0)
                      :pt (matrix [(nth rec 1) (nth rec 2)])
                      :mean (nth rec 3)})]
    (map rec-to-map data)))




;; (defn test-run []
;;   (-main "data/example-ypts.csv" "data/example-data.csv"))

;; (defn -main [y-axis-file glomeruli-file & args]
;;   (let [[ypt1 ypt2] (to-matrix (read-dataset y-axis-file :header false))
;;         glom-data (glom-data-to-map
;;                    (to-matrix (read-dataset glomeruli-file :header false)))]
;;     (let [rot-rads (- (angle-from-vertical ypt1 ypt2))
;;           rot-ypt1 (rotate-point (trans ypt1) rot-rads)
;;           rot-ypt2 (rotate-point (trans ypt2) rot-rads)
;;           center (calc-bulb-center rot-ypt1 rot-ypt2)]
;;       [rot-rads rot-ypt1 rot-ypt2 center])))
