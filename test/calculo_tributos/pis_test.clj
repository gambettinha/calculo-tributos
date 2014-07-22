(ns calculo-tributos.pis-test
  (:require [clojure.test :refer :all]
            [calculo-tributos.pis :refer :all]))

(deftest cofins-calculate-vbc-test
  (testing "calculateVbc - Invalid CST code"
  	(let [cst 9 precoUnitarioItem 0 quantidadeItem 0 frete 0 desconto 0 pRedBC 0]
  		(is (= (calculateVbc cst precoUnitarioItem quantidadeItem frete desconto pRedBC) 0.0))))

  (testing "calculateVbc - Valid CST code"
  	(let [cst 1 precoUnitarioItem 2 quantidadeItem 1 frete 0 desconto 0 pRedBC 0]
  		(is (= (calculateVbc cst precoUnitarioItem quantidadeItem frete desconto pRedBC) 2.0))))

  (testing "calculateVbc - Valid CST code with desconto"
  	(let [cst 1 precoUnitarioItem 10 quantidadeItem 2 frete 0 desconto 5 pRedBC 0]
  		(is (= (calculateVbc cst precoUnitarioItem quantidadeItem frete desconto pRedBC) 15.0))))

  (testing "calculateVbc - Valid CST code with desconto and frete"
  	(let [cst 1 precoUnitarioItem 10 quantidadeItem 2 frete 5 desconto 5 pRedBC 0]
  		(is (= (calculateVbc cst precoUnitarioItem quantidadeItem frete desconto pRedBC) 20.0))))

  (testing "calculateVbc - Valid CST code with desconto, frete and pRedBC"
  	(let [cst 1 precoUnitarioItem 10 quantidadeItem 2 frete 5 desconto 5 pRedBC 10]
  		(is (= (calculateVbc cst precoUnitarioItem quantidadeItem frete desconto pRedBC) 18.0)))))

(deftest pis-calculate-test
  (testing "Calculate - cst 1, aliquota 2 returns 0.04"
  	(let [cst 1 precoUnitarioItem 2 quantidadeItem 1 frete 0 desconto 0 pRedBC 0 aliquota 2 aliquotaEspecifica 3]
  		(is (= (calculate cst precoUnitarioItem quantidadeItem frete desconto pRedBC aliquota aliquotaEspecifica) 0.04))))

  (testing "Calculate - cst 2, aliquotaEspecifica 3 returns 0.06"
  	(let [cst 2 precoUnitarioItem 2 quantidadeItem 1 frete 0 desconto 0 pRedBC 0 aliquota 2 aliquotaEspecifica 3]
  		(is (= (calculate cst precoUnitarioItem quantidadeItem frete desconto pRedBC aliquota aliquotaEspecifica) 0.06))))

  (testing "Calculate - cst 2, aliquotaEspecifica 3 returns 0.06 with more itens"
  	(let [cst 2 precoUnitarioItem 2 quantidadeItem 2 frete 0 desconto 0 pRedBC 0 aliquota 2 aliquotaEspecifica 3]
  		(is (= (calculate cst precoUnitarioItem quantidadeItem frete desconto pRedBC aliquota aliquotaEspecifica) 0.12))))

  (testing "Calculate - cst 99, returns 0.0"
  	(let [cst 99 precoUnitarioItem 2 quantidadeItem 1 frete 0 desconto 0 pRedBC 0 aliquota 2 aliquotaEspecifica 3]
  		(is (= (calculate cst precoUnitarioItem quantidadeItem frete desconto pRedBC aliquota aliquotaEspecifica) 0.0)))))