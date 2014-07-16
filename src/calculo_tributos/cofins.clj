(ns calculo-tributos.cofins)

(defn calculateCofins
  "..."
  []
  (println "")
)

(defn isApplicable
  "Checks if the tributo should be calculated"
  [indicadorCredito, aliquota, credito]
  (if (= indicadorCredito 1) (> aliquota 0) (> credito 0))
)

(defn typeOfCalculation
  "..."
  [indicadorCredito, aliquota, credito]
  (if (= indicadorCredito 1) (if (> aliquota 0) -1 0) (if (> credito 0) -1 0))
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
