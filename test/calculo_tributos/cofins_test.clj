(ns calculo-tributos.cofins-test
  (:require [clojure.test :refer :all]
            [calculo-tributos.cofins :refer :all]))

(defn verifyIsApplicable
  [indicadorCredito aliquota credito expected]
  (is (= (isApplicable indicadorCredito aliquota credito) expected)))

(defn verifyTypeOfCalculation
  [indicadorCredito aliquota credito expected]
  (is (= (typeOfCalculation indicadorCredito aliquota credito) expected)))


(deftest cofins-is-appliable-test
  (testing "Is Applicable - indicadorCredito 1, with aliquota > zero"
  	(let [indicadorCredito 1 aliquota 1 credito 0]
  		(verifyIsApplicable indicadorCredito aliquota credito true)))

  (testing "Is NOT Applicable  - indicadorCredito 1, with aliquota <= zero"
  	(let [indicadorCredito 1 aliquota 0 credito 0]
  		(verifyIsApplicable indicadorCredito aliquota credito false)))

  (testing "Is Applicable - indicadorCredito 0, with credito > zero"
  	(let [indicadorCredito 0 aliquota 1 credito 1]
  		(verifyIsApplicable indicadorCredito aliquota credito true)))

  (testing "Is NOT Applicable  - indicadorCredito 0, with credito <= zero"
  	(let [indicadorCredito 0 aliquota 0 credito 0]
  		(verifyIsApplicable indicadorCredito aliquota credito false))))


(deftest cofins-type-of-calculation-test
  (testing "typeOfCalculation - indicadorCredito 1, with aliquota > zero"
  	(let [indicadorCredito 1 aliquota 1 credito 0]
  		(verifyTypeOfCalculation indicadorCredito aliquota credito -1)))

  (testing "typeOfCalculation - indicadorCredito 1, with aliquota <= zero"
  	(let [indicadorCredito 1 aliquota 0 credito 0]
  		(verifyTypeOfCalculation indicadorCredito aliquota credito 0)))

  (testing "typeOfCalculation - indicadorCredito 0, with credito > zero"
  	(let [indicadorCredito 0 aliquota 0 credito 1]
  		(verifyTypeOfCalculation indicadorCredito aliquota credito -1)))

  (testing "typeOfCalculation - indicadorCredito 0, with credito <= zero"
  	(let [indicadorCredito 0 aliquota 0 credito 0]
  		(verifyTypeOfCalculation indicadorCredito aliquota credito 0))))

(comment
(deftest cofins-calculate-vbc-test
  (testing "calculateVbc - Invalid CST code"
  	(let [cst 9 precoUnitarioItem 0 quantidadeItem 0 frete 0 desconto 0 pRedBC 0]
  		(is (= (calculateVbc cst precoUnitarioItem quantidadeItem frete desconto pRedBC) 0))))

  (testing "calculateVbc - Valid CST code"
  	(let [cst 1 precoUnitarioItem 0 quantidadeItem 0 frete 0 desconto 0 pRedBC 0]
  		(is (= (calculateVbc cst precoUnitarioItem quantidadeItem frete desconto pRedBC) 1))))

))

    
