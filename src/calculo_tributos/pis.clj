(ns calculo-tributos.pis)

(defn calculate
  "..."
  [cst]
  (let [vbc 2.0]
  (if (contains? #{1 3 4 5 6} cst) 
  	(* vbc (/ 2.0 100))
  	(if (= cst 2) (* vbc (/ 3.0 100)) 0.0))))