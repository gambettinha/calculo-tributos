(ns calculo-tributos.anticipacao-computation)

(defn isApplicable [tipoAnticipacao]
   (or (== 2  tipoAnticipacao) (== 13 tipoAnticipacao)))

(defn calculate [cenarioProduto item]
  0.0)
