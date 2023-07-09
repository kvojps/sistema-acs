# 1.1.4 Comissão

`/1. Requisitos/1.1 Requisitos do Sistema/1.1.4 Comissão`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
      * [1.1.3 Coordenação](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.3%20Coordena%C3%A7%C3%A3o/README.md)
      * [**1.1.4 Comissão**](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.4%20Comiss%C3%A3o/README.md)
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
      * [2.4.4 Máquina de estados](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.5 Sequência](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.5%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)
  * [4. Apêndices](../../../4.%20Ap%C3%AAndices/README.md)
    * [4.1 Reuniões](../../../4.%20Ap%C3%AAndices/4.1%20Reuni%C3%B5es/README.md)

---

A comissão desempenha um papel fundamental na avaliação das requisições de atividades complementares. Sua responsabilidade principal é verificar cuidadosamente os dados da requisição e os certificados apresentados. Além disso, é sua responsabilidade atribuir a quantidade de horas correspondente às atividades e definir o status da requisição como deferido ou indeferido, com base nas informações fornecidas e nos critérios estabelecidos.

| RF 029 - Consultar lista de requisições                                                                                                                                                                                                   |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** A comissão deve ser capaz de visualizar a lista de requisições encaminhadas para a comissão do seu respectivo curso. Também deve ser possível filtrar as requisições por campos de interesse, como data, semestre e aluno. |
| **Atores:** Comissão.                                                                                                                                                                                                                     |
| **Prioridade:** Média.                                                                                                                                                                                                                    |
| **Entrada:** Nenhuma.                                                                                                                                                                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                                                           |
| **Saída:** Não possui saídas.                                                                                                                                                                                                             |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela de requisição selecionada.                                                                                                                     |

| RF 030 - Adicionar quantidade de horas nas atividades complementares                                            |
| --------------------------------------------------------------------------------------------------------------- |
| **Descrição:** A comissão deve ser capaz de adicionar a quantidade de horas por certificados de uma requisição. |
| **Atores:** Comissão                                                                                            |
| **Prioridade:** Alta                                                                                            |
| **Entrada:** Inserir quantidade de horas para o certificado                                                     |
| **Pré-condições:** O usuário deve estar logado                                                                  |
| **Saída:** Confirmação da inserção das horas dos certificados                                                   |
| **Pós-condições:** O usuário retorna para a tela da requisição                                                  |

| RF 031 - Validar requisição                                                                                                                                                      |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** A comissão deve ser capaz de finalizar o fluxo da requisição, deferindo-a ou indeferindo-a. Após isso, é submetido para a coordenação realizar a validação final. |
| **Atores:** Comissão.                                                                                                                                                            |
| **Prioridade:** Alta.                                                                                                                                                            |
| **Entrada:** Nenhuma.                                                                                                                                                            |
| **Pré-condições:** O usuário deve estar logado e, em casos de aprovação, a requisição deve ser enviada para a coordenação.                                                       |
| **Saída:** Confirmação da ratificação da requisição.                                                                                                                             |
| **Pós-condições:** O coordenador recebe um e-mail informando que a requisição foi finalizada pela comissão.                                                                      |