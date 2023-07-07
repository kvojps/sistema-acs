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
| **Descrição:** O usuário deve ser capaz de visualizar informações com: o status da solicitação (que pode estar em trânsito, aceito ou negado), a quantidade de rascunhos e o quantitativo de horas já obtidos com divisão entre os quatro pilares de ACs .     |
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

