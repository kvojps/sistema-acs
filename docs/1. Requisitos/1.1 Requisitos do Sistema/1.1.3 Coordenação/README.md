# 1.1.3 Coordenação

`/1. Requisitos/1.1 Requisitos do Sistema/1.1.3 Coordenação`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
      * [**1.1.3 Coordenação**](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.3%20Coordena%C3%A7%C3%A3o/README.md)
      * [1.1.4 Comissão](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.4%20Comiss%C3%A3o/README.md)
    * [1.2 Requisitos Arquiteturais](../../../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1 Back](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1%20Back/README.md)
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

O coordenador é responsável pelo gerenciamento das requisições. Ele é o primeiro a receber as requisições e realiza validações iniciais, tendo autoridade para indeferir uma requisição sem envolvê-la com a comissão responsável. Somente um usuário com esse perfil possui a autoridade para concluir o fluxo da requisição.

| RF 017 - Solicitar permissões de coordenação                                                                                                                                      |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário pode solicitar ao administrador o perfil de coordenação, é necessário validar se o usuário é docente e faz parte da coordenação de um determinado curso. |
| **Atores:** Usuário geral.                                                                                                                                                        |
| **Prioridade:** Média.                                                                                                                                                            |
| **Entrada:** O usuário deve enviar alguma documentação que confirme a veracidade da sua posição.                                                                                  |
| **Pré-condições:** O usuário deve estar logado no sistema.                                                                                                                        |
| **Saída:** Confirmação da solicitação de autorização.                                                                                                                             |
| **Pós-condições:** O usuário deve receber por e-mail um retorno sobre a sua solicitação.                                                                                          |

| RF 018 - Consultar lista de requisições                                                                                                                                                                                                                                          |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de visualizar a lista de requisições encaminhadas para a coordenação e comissão do seu respectivo curso. Também deve ser possível filtrar as requisições por campos de interesse, como data, semestre, status da requisição e aluno. |
| **Atores:** Coordenador.                                                                                                                                                                                                                                                         |
| **Prioridade:** Média.                                                                                                                                                                                                                                                           |
| **Entrada:** Nenhuma.                                                                                                                                                                                                                                                            |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                                                                                                  |
| **Saída:** Não possui saídas.                                                                                                                                                                                                                                                    |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para tela de requisição selecionada.                                                                                                                                                              |

| RF 019 - Encaminhar requisição para a comissão                                                                                                             |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de encaminhar a requisição para a comissão do seu curso.                                                       |
| **Atores:** Coordenador.                                                                                                                                   |
| **Prioridade:** Alta.                                                                                                                                      |
| **Entrada:** Não possui entradas.                                                                                                                          |
| **Pré-condições:** O usuário deve estar logado.                                                                                                            |
| **Saída:** Confirmação de encaminhamento de requisição.                                                                                                    |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi encaminhada com sucesso e a comissão recebe por e-mail a notificação. |

| RF 020 - Assinar documento requisição                                                                                                                                          |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Descrição:** Antes de deferir ou indeferir uma requisição, o coordenador deve ser capaz de baixar o documento da requisição em sua máquina e submetê-lo assinado ao sistema. |
| **Atores:** Coordenador.                                                                                                                                                       |
| **Prioridade:** Alta.                                                                                                                                                          |
| **Entrada:** O usuário deve submeter o documento assinado.                                                                                                                     |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF, assiná-lo e realizar a submissão.                                     |
| **Saída:** Confirmação de submissão do documento assinado.                                                                                                                     |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi assinada com sucesso.                                                                     |

| RF 021 - Ratificar requisição                                                                                                      |
| ---------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de finalizar o fluxo da requisição, deferindo-a ou indeferindo-a.                      |
| **Atores:** Coordenador                                                                                                            |
| **Prioridade:** Alta                                                                                                               |
| **Entrada:** Nenhuma                                                                                                               |
| **Pré-condições:** O usuário deve estar logado e, em casos de aprovação, a requisição deve ter passado pela comissão.              |
| **Saída:** Confirmação da ratificação da requisição                                                                                |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi ratificada e encaminhada para a escolaridade. |

| RF 022 - Atribuir perfil para a comissão                                                       |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador pode atribuir perfis de comissão para os usuários da sua escolha. |
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Média.                                                                         |
| **Entrada:** Informar o usuário que deseja adicionar as permissões de comissão.                |
| **Pré-condições:** O usuário deve estar logado no sistema.                                     |
| **Saída:** Confirmação da atribuição do perfil.                                                |
| **Pós-condições:** O usuário que recebeu as permissões deve receber por e-mail a notificação.  |

| RF 016 - Visualizar indicadores sobre as requisições enviadas |
| ------------------------------------------------------------- |
| **Descrição:** Em construção.                                 |
| **Atores:** Coordenador.                                      |
| **Prioridade:** Média.                                        |
| **Entrada:** Em construção.                                   |
| **Pré-condições:** Em construção.                             |
| **Saída:** Em construção.                                     |
| **Pós-condições:** Em construção.                             |