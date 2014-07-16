(ns calculo-tributos.cofins)

(defn calculateCofins
  "..."
  []
  (println "")
)

(defn isAppliable
  "Checks if the tributo should be calculated"
  [indicadorCredito, aliquota, credito]
  (if (= indicadorCredito 1) (> aliquota 0) (> credito 0))
)

(defn typeOfCalculation
  "..."
  []
  (println "")
)

(defn calculate
  "..."
  []
  (println "")
)

(defn calculateVbc
  "..."
  []
  (println "")
)
