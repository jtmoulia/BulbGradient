(ns bulbgradient.test.core
  (:use [bulbgradient.core])
  (:use [clojure.test])
  (:use (incanter core)))

(defn deg-to-rads [deg]
  (* (/ deg 360) (* 2 Math/PI)))

(def 45deg (deg-to-rads 45))

(deftest rotate-pt
  (is (= (rotate-pt [1 0] Math/PI) [-1 0])))
