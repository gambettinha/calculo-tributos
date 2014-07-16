(ns calculo-tributos.cenario_produto)

(defstruct ProdutoItem :codigoProduto :descricaoComprador :precoUnitario :quantidade :frete :desconto :dataEntrega)
(defstruct IcmsSt :aliquota :valorPauta :redBC :dispositivoLegal :bcComposicao :cargaMedia :mva :mvaAjustado :valor)
(defstruct Icms :aliquota :valorPauta :dispositivoLegal :redBC :credito :bcComposicao :valor :creditoDispositivoLegal :indicadorCredito :cst)
(defstruct Ipi  :aliquota 
	            :credito 
	            :dispositivoLegal 
	            :cst 
	            :pRedBC 
	            :pRedAliq 
	            :pRedValImp 
	            :valor 
	            :creditoDispositivoLegal 
	            :indicadorCredito)
(defstruct Pis  :aliquota 
				:aliquotaEspecifica
	            :credito 
	            :dispositivoLegal 
	            :cst 
	            :pRedBC 
	            :valor 
	            :creditoDispositivoLegal 
	            :indicadorCredito)

(defstruct Cofins  	:aliquota 
				    :aliquotaEspecifica
	               	:credito 
	            	:dispositivoLegal 
	            	:cst 
	            	:pRedBC 
	            	:valor 
	            	:creditoDispositivoLegal 
	            	:indicadorCredito)

(defstruct Anticipacao :tipo :valorPauta :pRedBCInternaDest :aliqInternaDest :responsavel :mvaAjustado :percFixo :valor)
(defstruct CenarioProduto :idCenario :idProduto :icms :icmsSt :ipi :pis :cofins :antecipacao :ufOrigem :ufDestino :valor)
