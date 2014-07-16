(ns calculo-tributos.cofins-test
  (:require [clojure.test :refer :all]
            [calculo-tributos.cofins :refer :all]))

(deftest confins-test
  (testing "Is Appliable "
    (is (= (isAppliable 1 1 0) true))
  ))
