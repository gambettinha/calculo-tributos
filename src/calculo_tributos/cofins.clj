(ns calculo-tributos.cofins)

(defn calculateCofins
  "..."
  []
  (println ""))

(defn isApplicable
  "Checks if the tributo should be calculated"
  [indicadorCredito, aliquota, credito]
  (if (= indicadorCredito 1) (> aliquota 0) (> credito 0)))

(defn typeOfCalculation
  "Generates a flag related to the calculation type [TODO: is it really needed?]"
  [indicadorCredito, aliquota, credito]
  (if (= indicadorCredito 1) (if (> aliquota 0) -1 0) (if (> credito 0) -1 0)))

(defn calculate
  "..."
  []
  (println ""))

(defn calculateVbc
  "Calculates VBC for Cofins"
  [cst, precoUnitarioItem, quantidadeItem, frete, desconto, pRedBC]
  (if (contains? #{1 2 3 4 5 6} cst) 
  	(* 
  		(- (+ (* precoUnitarioItem quantidadeItem) frete) desconto) 
  		(- 1 (/ pRedBC 100))) 
  	0)

)
