(ns calculo-tributos.pis-test
  (:require [clojure.test :refer :all]
            [calculo-tributos.pis :refer :all]))

(deftest pis-calculate-test
  (testing "Calculate - cst 1, returns 0.04"
  	(let [cst 1]
  		(is (= (calculate cst) 0.04))))

  (testing "Calculate - cst 2, returns 0.06"
  	(let [cst 2]
  		(is (= (calculate cst) 0.06))))

  (testing "Calculate - cst 99, returns 0.0"
  	(let [cst 99]
  		(is (= (calculate cst) 0.0)))))