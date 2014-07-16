(ns calculo-tributos.anticipacao-computation-test
   (:require [clojure.test :refer :all]
             [calculo-tributos.anticipacao-computation :refer :all]
             [calculo-tributos.cenario-produto :refer :all]))

(def defaultIcms (struct Icms 1.0 3.0 "" 1.0 1.0 1))
(def defaultIcmst (struct IcmsSt 1.0 3.0 5.0  ""  1  7.0  9.0  11.0))
(def defaultIpi (struct Ipi 1.0  1.0  ""  50  10.0  5.0  7.0))
(def defaultPis (struct Pis 0.0 3.0 1.0 "" 1 5.0))
(def defaultCofins (struct Cofins 1.0 3.0 1.0 "" 1 5.0))
(def defaultAntecipacao (struct Anticipacao 1 3.0 5.0 7.0 "" 9.0 11.0))
(def defaultProdutoItem (struct ProdutoItem "0" "" 100.0" 1 "0" 0" ""))

(deftest Antecipacao-Valor
  (testing  "Calculate Antecipacao valor - Default"
    (is 0.0
        (calculate
           (struct CenarioProduto "1" "2" defaultIcms defaultIcmst defaultIpi defaultPis defaultCofins (struct Anticipacao 0 2.0 10.0 5.0 "" 20.0 25.0) "SP" "SP")
           defaultProdutoItem))))

(deftest Antecipacao-Valor-isApplicable
  (testing "is application with tipo anticipacao 12"
    (is (= false (isApplicable 12))))
  (testing "is application with tipo anticipacao 12"
    (is (= true (isApplicable 13))))
  (testing "is application with tipo anticipacao 12"
    (is (= true (isApplicable 2)))))
