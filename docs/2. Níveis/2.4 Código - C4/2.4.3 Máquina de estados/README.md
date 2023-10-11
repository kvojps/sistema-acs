# 2.4.3 Máquina de estados

`/2. Níveis/2.4 Código - C4/2.4.3 Máquina de estados`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
    * [1.2 Requisitos Arquiteturais](../../../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1 Back](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1%20Back/README.md)
      * [2.3.2 Front](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.2%20Front/README.md)
    * [2.4 Código - C4](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1 Atividades](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Atividades/README.md)
      * [2.4.2 Classes](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2%20Classes/README.md)
      * [**2.4.3 Máquina de estados**](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.4 Sequência](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/PL2zJWCn3DvFkdVmNAalm81wEdL7C78CRk8MInUxn8d4-p3qGVfYE41rfTqS-_lDnWhcKjCC8-N2UmuOjUzULs-mVeH1wDFVy023cGPkCqwIwQEoETIH5yYwmGyLSqI9EWZEREJ4bxfBR7R-qaaYmaAT96Y2iBYQYzq9kEesBMfR2PXOtZ6H58KZPeypgkP8WkUJk_JTWc-PdYbK--rmrH1QYR_3BMFKz9HrDrF2EnAtqCUPodyVhnw8owq9_YpxRaCI_Ok_0G00)

![diagram](https://www.plantuml.com/plantuml/svg/0/XP8nRiCm34Lt0xw3vWAvG8SYXU7EWTUc0oiH2G69J2NBGw_JeGV9nIfP3Y83hRjAxpz-ozo74VmOdLK3VaGATFs-VadRjCthmvlQFQdU3H1qvBEennkZGLJd2GoqJNM_c_5d1ai1En5la26pgs28xmv7AjbVuBN4KGYpeUSf3PGZNy23qil5oh6m6pNAOT6W_KEphi8Q7F4vPGvfS1-qMF2flS7QfsPTbKt6ZMIfEA2EFkHU1pIK90QFh8L7EA6RNtO1DXzselpHSF4otNv85Uk4jOrPVcSPJuNyfs6TVQ4y_JEXRNC_prJQaxmkUsIJrkW7)

Foi reiterado que a "Solicitação de contagem" deve incluir um status específico (como rascunho, em análise 
pela coordenação, em análise pela comissão, encaminhado para escolaridade, em recurso ou concluída). Além disso, foi 
ratificado que cada certificado possui o seu próprio status correspondente (anexado, aguardando análise, em análise, 
aceito, recusado ou com problema), acompanhado de observações pertinentes elaboradas pela comissão para melhor 
compreensão da análise. A Figura 1 representa o diagrama de máquina de estados do fluxo de certificados, enquanto a 
Figura 2 refere-se ao fluxo
de requisições.