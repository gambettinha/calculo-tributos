(ns calculo-tributos.pis)

(defn calculateVbc
  "Calculates VBC for PIS"
  [cst, precoUnitarioItem, quantidadeItem, frete, desconto, pRedBC]
  (double (if (contains? #{1 2 3 4 5 6} cst) 
  	(* 
  		(- (+ (* precoUnitarioItem quantidadeItem) frete) desconto) 
  		(- 1 (/ pRedBC 100))) 
  	0)))

(defn calculate
  "Calculates the value of PIS"
  [cst, precoUnitarioItem, quantidadeItem, frete, desconto, pRedBC, aliquota, aliquotaEspecifica]
  (let [vbc (calculateVbc cst precoUnitarioItem quantidadeItem frete desconto pRedBC)]
  (double (if (contains? #{1 3 4 5 6} cst) 
  	(* vbc (/ aliquota 100))
  	(if (= cst 2) (* vbc (/ aliquotaEspecifica 100)) 0.0)))))