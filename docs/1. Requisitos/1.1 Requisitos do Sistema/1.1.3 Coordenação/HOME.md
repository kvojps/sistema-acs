# 1.1.3 Coordenação

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