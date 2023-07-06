# 1.1.3 Coordenação

`\1. Requisitos\1.1 Requisitos do Sistema\1.1.3 Coordenação`

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

O coordenador é responsável pelo gerenciamento das requisições. Ele é o primeiro a receber as requisições e realiza validações iniciais, tendo autoridade para indeferir uma requisição sem envolvê-la com a comissão responsável. Somente um coordenador com esse perfil possui a autoridade para concluir o fluxo da requisição.

| RF 017 - Visualizar as requisições recebidas                                                                                                                                  |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz visualizar todas as solicitações submetidas pelos alunos do seu respectivo curso. Também deve ser possível filtrar as solicitações com base em critérios como status , data de submissão,  período,  nome do aluno, número de matrícula e CPF. Além disso, deve ter a opção de ordenar as requisições por diferentes campos, como data de submissão crescente ou decrescente, ordem alfabética e período. |
| **Atores:** Coordenador.                                                                                                                                                |
| **Prioridade:** Alta.                                                                                                                                                          |
| **Entrada:** O coordenador pode inserir filtros para especificar sua busca.                                                                                  |
| **Pré-condições:** O coordenador deve estar logado.                                                                                                                      |
| **Saída:** Exibição da lista de requisições.                                                                                                                             |
| **Pós-condições:** Nenhuma.                                                                                          |

| RF 018 - Detalhar uma requisição                                                                                                                                                                                                                                         |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de acessar informações detalhadas sobre uma requisição específica de um determinado aluno. |
| **Atores:** Coordenador.                                                                                                                                                                                                                                                         |
| **Prioridade:** Alta.                                                                                                                                                                                                                                                         |
| **Entrada:** O coordenador deve selecionar uma requisição.                                                                                                                                                                                                                                                            |
| **Pré-condições:** O coordenador deve estar logado.                                                                                                                                                                                                                                  |
| **Saída:**   O coordenador é redirecionado para tela da requisição em específico.                                                                                                                                                                                                                                                    |
| **Pós-condições:** Nenhuma.                                                                                                                                                              |

| RF 019 - Buscar requisição por id ou token                                                                                                         |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de buscar uma requisição por id ou token (identificadores únicos).                                                     |
| **Atores:** Coordenador.                                                                                                                                   |
| **Prioridade:** Média.                                                                                                                                      |
| **Entrada:** O coordenador deve inserir o id ou token da requisição.                                                                                                                          |
| **Pré-condições:** O coordenador deve estar logado.                                                                                                            |
| **Saída:** O coordenador é redirecionado para tela da requisição em específico.                                                                                                    |
| **Pós-condições:** Nenhuma. |

| RF 020 - Pesquisar informações do aluno                                                                                                                                         |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Descrição:** O coordenador deve ser capaz de pesquisar e acessar as informações específicas de um aluno registrado no sistema. Vale ressaltar que, o histórico de atividades complementares está incluso nestas informações. |
| **Atores:** Coordenador.                                                                                                                                                       |
| **Prioridade:** Média.                                                                                                                                                          |
| **Entrada:** O coordenador deve inserir as informações do aluno.                                                                                                                     |
| **Pré-condições:** O coordenador deve estar logado.                                    |
| **Saída:** O coordenador é redirecionado para a tela com informações do aluno.                                                                                                                    |
| **Pós-condições:** Nenhuma.                                                                    |

| RF 021 - Visualizar histórico de atividades complementares da turma.                                                                                                     |
| ---------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de visualizar o histórico completo das atividades complementares de uma turma específica.                   |
| **Atores:** Coordenador.                                                                                                            |
| **Prioridade:** Média.                                                                                                             |
| **Entrada:** Nenhuma                                                                                                               |
| **Pré-condições:** O coordenador deve estar logado.              |
| **Saída:** O coordenador é redirecionado para a tela com informações do histórico de atividades complementares.                                                                               |
| **Pós-condições:** Nenhuma. |

| RF 022 - Visualizar o extrato de horas de atividade complementares por discente                                                   |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve visualizar o extrato de horas das atividades complementares. A seleção pode ser feita com base no nome do discente, CPF ou número de matrícula. |
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Alta.                                                                        |
| **Entrada:** O coordenador pode inserir informações relacionadas ao aluno para realizar a busca.                |
| **Pré-condições:** O coordenador deve estar logado no sistema.                                     |
| **Saída:** O coordenador é redirecionado para a tela com as informações do extrato de horas.                                                |
| **Pós-condições:** Nenhuma.  |

| RF 023 - Alertar o discente sobre poucas solicitações realizadas                                                   |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve alertar o(s) discente(s) de maneira detalhada sobre a baixa quantidade de solicitações em um momento crítico. Este alerta é enviado por e-mail de maneira automática pelo sistema.|
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Baixa.                                                                     |
| **Entrada:** O coordenador deve selecionar o aluno para enviar o alerta.                |
| **Pré-condições:** O coordenador deve estar logado no sistema.                                     |
| **Saída:** O coordenador recebe uma mensagem de confirmação do envio do alerta.                                               |
| **Pós-condições:** O sistema envia um e-mail para o aluno que informa sobre a baixa quantidade de solicitações.  |

| RF 024 - Encaminhar requisição para a comissão                                                   |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de enviar uma requisição ou conjunto de requisições para serem analisadas pela comissão. É necessário que a comissão seja notificada por e-mail sobre o que foi recebido pela coordenação.|
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Alta.                                                                        |
| **Entrada:** O coordenador deve selecionar as requisições do aluno.                |
| **Pré-condições:** O coordenador deve estar logado no sistema.                                     |
| **Saída:** O coordenador recebe uma mensagem de confirmação do envio das requisições.                                               |
| **Pós-condições:** O sistema troca o status da requisição e envia um e-mail para a comissão.  |

| RF 025 - Modificar a composição da contagem das horas de atividades complementares                                                 |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** Após a avaliação da comissão, a coordenação pode ajustar a composição das horas atribuídas às atividades complementares de um aluno.|
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Média.                                                                        |
| **Entrada:** O coordenador deve selecionar a requisição.               |
| **Pré-condições:** O coordenador deve estar logado no sistema.                                     |
| **Saída:** O coordenador recebe uma mensagem de confirmação da alteração de composição das horas.                                               |
| **Pós-condições:** O sistema envia um e-mail para a comissão informando sobre a alteração na composição de horas.  |

| RF 026 - Rejeitar uma avaliação de requisição feita pela comissão                                                  |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de rejeitar uma requisição avaliada pela comissão.|
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Média.                                                                        |
| **Entrada:** O coordenador deve selecionar a requisição.               |
| **Pré-condições:** O coordenador deve estar logado no sistema.                                     |
| **Saída:** O coordenador recebe uma mensagem de confirmação da rejeição da requisição.                                              |
| **Pós-condições:** O sistema envia um e-mail para a comissão informando sobre a rejeição da avaliação da requisição.  |

| RF 027 - Assinar o documento referente a requisição                                          |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** Após uma requisição ser avaliada, o coordenador deve ser capaz de assinar digitalmente o documento da requisição antes do encaminhamento para a escolaridade.|
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Média.                                                                        |
| **Entrada:** O coordenador deve selecionar a requisição.               |
| **Pré-condições:** O coordenador deve estar logado no sistema.                                     |
| **Saída:** O coordenador recebe uma mensagem de confirmação da assinatura.                                              |
| **Pós-condições:** Nenhuma.  |

| RF 028 - Ratificar requisição                                                  |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** Após uma requisição ser avaliada, o coordenador deve ser capaz  de ratificá-la. Ao realizar esta ação, é necessário que o status da requisição seja alterado para “Encaminhado  à escolaridade”.|
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Alta.                                                                      |
| **Entrada:** O coordenador deve selecionar a requisição.               |
| **Pré-condições:** O coordenador deve estar logado no sistema.                                     |
| **Saída:** O coordenador recebe uma mensagem de confirmação da ratificação.                                             |
| **Pós-condições:** O sistema envia um e-mail para a escolaridade com a avaliação final da requisição.   |