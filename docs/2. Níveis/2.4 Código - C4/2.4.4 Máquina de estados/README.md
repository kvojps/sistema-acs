# 2.4.4 Máquina de estados

`\2. Níveis\2.4 Código - C4\2.4.4 Máquina de estados`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
      * [1.1.3 Coordenação](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.3%20Coordena%C3%A7%C3%A3o/README.md)
      * [1.1.4 Comissão](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.4%20Comiss%C3%A3o/README.md)
    * [1.2 Requisitos Arquiteturais](../../../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1 Back](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1%20Back/README.md)
      * [2.3.2 Front](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.2%20Front/README.md)
    * [2.4 Código - C4](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1 Casos de uso](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/README.md)
        * [2.4.1 Usuário geral](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.1%20Usu%C3%A1rio%20geral/README.md)
        * [2.4.2 Aluno](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.2%20Aluno/README.md)
        * [2.4.3 Coordenador](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.3%20Coordenador/README.md)
        * [2.4.4 Comissão](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.4%20Comiss%C3%A3o/README.md)
      * [2.4.2 Atividades](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2%20Atividades/README.md)
      * [2.4.3 Classes](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20Classes/README.md)
      * [**2.4.4 Máquina de estados**](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.5 Sequência](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.5%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)
  * [4. Apêndices](../../../4.%20Ap%C3%AAndices/README.md)
    * [4.1 Reuniões](../../../4.%20Ap%C3%AAndices/4.1%20Reuni%C3%B5es/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/VP5DJWCn38Nt8yqTlAuq5s21EXegiIvBXeL9t1AfiKkSIAZNOS51UZ6SbchApx2BdjxtOZylDMFA9UvWe9J39ZZqqZPjyxXuWkuMUgOtK-06UbLneRvnv4Il9QYPpNknTDM-BPWyifUUSHUK37mepp6e7jzbP8ymeICxYU2cVzN2VWLOwjLegpW5hzXX3Fo2aJWBx37PP8D8yiHu_B0Fs-PFr2BNv8gU5xkos71VyZpPEmhv9uSdSHuQX3DkATxHlIJKVxQmXjRdXauRZ0orf6_7cGthvhkwCB09LJkWnthb9R6tuty2)

![diagram](https://www.plantuml.com/plantuml/svg/0/XP8nRiCm34Lt0xw3vWAvG8SYXU7EWJis7LY9I0H8P29P7dAT33r8BbR9QcmvI9jDeDx_-XIvzZsuFbWZEZm6xVNb-tBckgghZwTFiNeHhUt0oq1x5izNHWABncbGK5V5_Mh4tyENrTx33UzZ6NkT9JCpIbu9ZFROC3k51F9MYoJ1Qjh71xTq00T2pcZoksEmD9uIjJJ4t3pPv8k5nyDakPXTqFpXKYH9JbC7l8aFjrwo0HT_Gs5fs2pQ-aUJlxf36PnFaJQej6AXS4kIgOSTsd4qly2zoGmwdU3WUBWEig0R9cb2yfnPmbqc7mGhjMywzNQAQ5tDzKJ5_KfhjaPISVr-0000)

Foi reiterado que a "Solicitação de contagem" deve incluir um status específico (como rascunho, submetida, em análise pela coordenação, em análise pela comissão, em despacho pela coordenação, concluída ou em recurso). Além disso, foi ratificado que cada certificado possui o seu próprio status correspondente (anexado, aguardando análise, em análise, aceito ou recusado), acompanhado de observações pertinentes elaboradas pela comissão para melhor compreensão da análise. A Figura 1 representa o diagrama de máquina de estados do fluxo de certificados, enquanto a Figura 2 refere-se ao fluxo de requisições.