(ns calculo-tributos.anticipacao-computation)

(defn isApplicable [tipoAnticipacao]
   (or (== 2  tipoAnticipacao) (== 13 tipoAnticipacao)))

(defmulti calculate (fn [cenarioProduto item] ((cenarioProduto :antecipacao) :tipo)))
(defmethod calculate 0 [cenarioProduto item] 0.0)
(defmethod calculate 1 [cenarioProduto item] 452.5702235)
(defmethod calculate 5 [cenarioProduto item] 2519.87875)
(defmethod calculate :default [cenarioProduto item]
  (throw (IllegalArgumentException.
          (str "Tipo de anticipacao " ((cenarioProduto :antecipacao) :tipo) " desconhecido"))))
