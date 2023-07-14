# 1.1.2 Aluno

`\1. Requisitos\1.1 Requisitos do Sistema\1.1.2 Aluno`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [**1.1.2 Aluno**](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
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
      * [2.4.4 Máquina de estados](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.5 Sequência](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.5%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)
  * [4. Apêndices](../../../4.%20Ap%C3%AAndices/README.md)
    * [4.1 Reuniões](../../../4.%20Ap%C3%AAndices/4.1%20Reuni%C3%B5es/README.md)

---

O aluno possui acesso ao sistema para enviar requisições juntamente com suas atividades complementares. Além de obter informações sobre o progresso da validação da sua requisição, permitindo que você acompanhe em qual etapa do processo ela se encontra.


| RF 013 - Cadastrar Requisição                                                                                          |
| -----------------------------------------------------------------------------------------------------------------------|
| **Descrição:** O usuário deve ser capaz de cadastrar uma requisição com o intuito de ratificar uma determinada quantidade de horas das suas atividades complementares. Para cadastrar a requisição é preciso que o discente acesse o barema   disponibilizado no dashboard principal para responder todas as informações necessárias.                                  |
| **Atores:** Discente.                                                                                                  |
| **Prioridade:** Alta.                                                                                                  |
| **Entrada:** Inserir informações da requisição, como semestre e quantidade de certificados. Para cada certificado, fornecer título, descrição, data, horas, atividade em que se enquadra de acordo com o barema e o arquivo no formato PDF. |
| **Pré-condições:** O usuário deve estar logado.                                                                        |
| **Saída:** Confirmação do envio da requisição.                                                                         |
| **Pós-condições:** O usuário é redirecionado para a tela específica da requisição enviada, e a coordenação recebe a notificação por e-mail.                                                                                                  |

| RF 014 - Consultar lista de requisições                                                                               |
| --------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar sua lista de requisições.                                       |
| **Atores:** Discente.                                                                                                 |
| **Prioridade:** Alta.                                                                                                 |
| **Entrada:** Não possui entradas.                                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                                       |
| **Saída:** Não possui saídas.                                                                                         |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada. |

| RF 015 - Buscar requisição específica                                               |
| ----------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar uma requisição específica.    |
| **Atores:** Discente.                                                               |
| **Prioridade:** Média.                                                              |
| **Entrada:** Não possui entradas.                                                   |
| **Pré-condições:** O usuário deve estar logado.                                     |
| **Saída:** Não possui saídas.                                                       |
| **Pós-condições:** O usuário é redirecionado para a tela da requisição selecionada. |

| RF 016 - Baixar arquivo PDF referente à requisição                                                       |
| -------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter a opção de fazer o download da requisição em formato PDF.              |
| **Atores:** Discente.                                                                                    |
| **Prioridade:** Baixa.                                                                                   |
| **Entrada:** Não possui entradas.                                                                        |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF. |
| **Saída:** Confirmação do download do arquivo.                                                           |
| **Pós-condições:** O usuário vê o arquivo baixado na pasta selecionada.                                  |

| RF 017 - Visualizar indicadores sobre as requisições enviadas                                          |
| ------------------------------------------------------------------------------------------------------ |
| **Descrição:** O usuário deve ser capaz de visualizar informações com: o status da solicitação (que pode estar em trânsito, aceito ou negado), a quantidade de rascunhos e o quantitativo de horas já obtidos com divisão entre os quatro pilares -- Ensino, Pesquisa, Extensão e Gestão -- de ACs.     |
| **Atores:** Discente.                                                                                  |
| **Prioridade:** Média.                                                                                 |
| **Entrada:** Não possui.                                                                               |
| **Pré-condições:** Possuir solicitações enviadas.                                                      |
| **Saída:** Resultado do veredito da requisição.                                                        |
| **Pós-condições:** Não possui.                                                                         |

| RF 018 - Criar rascunhos de requisições                                                            |
| -------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter o poder de salvar as informações de uma solicitação, junto de documentos anexos, que ainda possa estar incompleta. Nesse caso, é feito um rascunho da requisição que será encaminhado para a coordenação somente após o usuário solicitá-lo.                                                                          |
| **Atores:** Discente.                                                                              |
| **Prioridade:** Alta.                                                                              |
| **Entrada:** Inserir dados de requerimento: Título, Data Inicial/Data Final, Eixo de Ensino, Atividade, Quantidade de Horas, Anexar Certificado.                                                                           |
| **Pré-condições:** Ter preenchido o requerimento com parte das informações solicitadas.            |
| **Saída:** Confirmação de requisição em rascunho.                                                  |
| **Pós-condições:** O usuário é redirecionado para a dashboard atualizada com a fila de rascunhos.  |

| RF 019 - Deletar rascunhos de requisições                                                    |
| -------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve poder apagar um rascunho de requisição caso ache necessário.   |
| **Atores:** Discente.                                                                        |
| **Prioridade:** Alta.                                                                        |
| **Entrada:** Não possui.                                                                     |
| **Pré-condições:** Ter um rascunho salvo.                                                    |
| **Saída:** Rascunho apagado.                                                                 |
| **Pós-condições:** A fila de requisição atualizada com o rascunho apagado.                   |

| RF 020 - Alterar rascunhos de requisições                                                                           |
| ------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve poder alterar dados de uma requisição em situação de rascunho quando achar necessário.|
| **Atores:** Discente.                                                                                               |
| **Prioridade:** Alta.                                                                                               |
| **Entrada:** Inserir ou alterar os dados de requerimento: Título, Data Inicial/Data Final, Eixo de Ensino, Atividade, Quantidade de Horas, Anexar Certificado.                                                                              |
| **Pré-condições:** Ter requerimento em rascunho.                                                                    |
| **Saída:** Rascunho atualizado.                                                                                     |
| **Pós-condições:** A fila de requisição atualizada com o rascunho também atualizado.                                |

| RF 021 - Enviar solicitação à coordenação                     |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve poder fazer o envio da solicitação completa criada anteriormente para o próximo ator do fluxo dentro do sistema.                                        |
| **Atores:** Discente.                                         |
| **Prioridade:** Alta.                                         |
| **Entrada:** Não possui.                                      |
| **Pré-condições:** Ter solicitação de contagem já  criada.    |
| **Saída:** Enviado para o coordenador.                        |
| **Pós-condições:** Usuário é redirecionado pra o dashboard.   |

| RF 022 - Alterar solicitação                                                           |
| -------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve poder alterar dados de uma solicitação já enviada caso esta não tenha alcançado uma fase muito avançada da requisição.                                                            |
| **Atores:** Discente.                                                                  |
| **Prioridade:** Média.                                                                 |
| **Entrada:** Alterar dados da solicitação do requerimento.                             |
| **Pré-condições:** Ter uma solicitação encaminhada para a coordenação e não entregue.  |
| **Saída:** Solicitação enviada atualizada.                                             |
| **Pós-condições:** Redirecionamento para o dashboard do usuário.                       |

| RF 023 - Visualizar dados do discente                         |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve ter acesso em parte especificada no sistema a um quantitativo de horas cumpridas, junto de poder conferir um extrato de horas, apenas visualização.        |
| **Atores:** Discente.                                         |
| **Prioridade:** Importante.                                   |
| **Entrada:** Não possui.                                      |
| **Pré-condições:** Não possui.                                |
| **Saída:** Não possui.                                        |
| **Pós-condições:** Não possui.                                |

| RF 024 - Visualizar fluxo de requisição                        |
| -------------------------------------------------------------- |
| **Descrição:** O usuário deve, caso tenha requisições enviadas, poder conferir o andamento de seu requerimento, com uma análise de trânsito visível e atualizada. (Apenas visualização)  |
| **Atores:** Discente.                                          |
| **Prioridade:** Baixo.                                         |
| **Entrada:** Não possui.                                       |
| **Pré-condições:** Ter requisição enviada.                     |
| **Saída:** Não possui.                                         |
| **Pós-condições:** Não possui.                                 |

| RF 025 - Visualizar Modal Lateral                              |
| -------------------------------------------------------------- |
| **Descrição:** O usuário deve possuir um modal lateral (barra lateral) que faz parte do sistema fora em conjunto com o dashboard, mas como uma funcionalidade a mais, a qual vai ter funções integradas de notificação, lixeira, logout e visualização de perfil. (Estas serão melhor detalhadas em outros requisitos). |
| **Atores:** Discente.                                          |
| **Prioridade:** Importante                                     |
| **Entrada:** Não possui.                                       |
| **Pré-condições:** Estar logado no sistema.                    |
| **Saída:** Não possui.                                         |
| **Pós-condições:** Não possui.                                 |

| RF 026 - Visualização de Perfil                                |
| -------------------------------------------------------------- |
| **Descrição:** O usuário deve possuir um modal para a visualização de ser perfil; visualizando foto, nome de usuário e e-mail institucional.                          |
| **Atores:** Discente.                                          |
| **Prioridade:** Importante.                                    |
| **Entrada:** Não possui.                                       |
| **Pré-condições:** Estar logado no sistema e ter pressionado o modal na parte de perfil                                                           |
| **Saída:** Foto de perfil, nome e e-mail institucional.        |
| **Pós-condições:** Será mostrado foto, nome e e-mail em um modal de perfil.                                                          |
