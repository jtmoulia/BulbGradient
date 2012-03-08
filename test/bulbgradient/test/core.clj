(ns bulbgradient.test.core
  (:use [bulbgradient.core])
  (:use [clojure.test])
  (:use (incanter core)))

(defn deg-to-rads [deg]
  (* (/ deg 360) (* 2 Math/PI)))

(def forty-five-rads (deg-to-rads 45))

(deftest rotate-point-test
  (is (=  (matrix (rotate-point [1 0] Math/PI))
          (matrix [-1 0])))
  (is (= (matrix (rotate-point [1 0] (/ Math/PI 2)))
         (matrix [0 1]))))
