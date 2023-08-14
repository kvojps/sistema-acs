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

| RF 015 - Filtrar Requisições                                              |
| ----------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar requisições específicas ao utilizar a aba de filtro da tela, que delimita as requisições de acordo com os quatro pilares (Ensino, Pesquisa, Extensão e Gestão).  |
| **Atores:** Discente.                                                               |
| **Prioridade:** Média.                                                              |
| **Entrada:** Clicar no botão de filtrar e escolher entre os eixos Ensino, Pesquisa, Extensão e Gestão.                                                   |
| **Pré-condições:** O usuário deve estar logado.                                     |
| **Saída:** Não possui saídas.                                                       |
| **Pós-condições:** O usuário é redirecionado para a tela principal atualizada com as requisições do eixo buscado. |

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
| **Descrição:** O usuário deve ser capaz de visualizar informações como: o status da solicitação (que pode estar em trânsito, aceito ou negado), a quantidade de rascunhos e o quantitativo de horas já obtidos com divisão entre os quatro pilares -- Ensino, Pesquisa, Extensão e Gestão -- de ACs.     |
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
| **Prioridade:** Médio.                                   |
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
| **Prioridade:** Médio.                                     |
| **Entrada:** Não possui.                                       |
| **Pré-condições:** Estar logado no sistema.                    |
| **Saída:** Não possui.                                         |
| **Pós-condições:** Não possui.                                 |

| RF 026 - Visualização de Perfil                                |
| -------------------------------------------------------------- |
| **Descrição:** O usuário deve possuir um modal para a visualização de seu perfil; visualizando foto, nome de usuário e e-mail institucional.                          |
| **Atores:** Discente.                                          |
| **Prioridade:** Médio.                                    |
| **Entrada:** Não possui.                                       |
| **Pré-condições:** Estar logado no sistema e ter pressionado o modal na parte de perfil                                                           |
| **Saída:** Foto de perfil, nome e e-mail institucional.        |
| **Pós-condições:** Será mostrado foto, nome e e-mail em um modal de perfil.                                                          |

| RF 027 - Arquivar Solicitação                                                                              |
| ---------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter a habilidade de arquivar requisições caso seja viável -- como no caso de requisições negadas -- para limpar a tela inicial.                                                                       |
| **Atores:** Discente.                                                                                      |
| **Prioridade:** Médio.                                                                                     |
| **Entrada:** Abrir modal de detalhes da requisição.                                                        |
| **Pré-condições:** Ter requisição fora do modo de rascunho.                                                |
| **Saída:** Requisição ser realocada para a aba de Arquivados.                                              |
| **Pós-condições:** O usuário é direcionado para a página agora atualizada.                                 |

| RF 028 - Deletar Solicitação                                                                              |
| ---------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter a habilidade de deletar requisições caso seja viável -- como no caso de requisições negadas ou com erros visíveis -- para limpar a tela inicial.                                                                       |
| **Atores:** Discente.                                                                                      |
| **Prioridade:** Médio.                                                                                     |
| **Entrada:** Abrir modal de detalhes da requisição.                                                        |
| **Pré-condições:** Ter requisição fora do modo de rascunho.                                                |
| **Saída:** Requisição ser realocada para a aba de Lixeira.                                              |
| **Pós-condições:** O usuário é direcionado para a página agora atualizada.                                 |

| RF 029 - Visualizar Modal de anexar arquivos                                    |
| --------------------------------------------------------------                  |
| **Descrição:** O usuário deve, na aba de preenchimento da requisição, ter acesso ao modal que comanda o ato de anexar arquivos como certificados.                              |
| **Atores:** Discente.                                                           |
| **Prioridade:** Alto.                                                           |
| **Entrada:** Não possui.                                                        |
| **Pré-condições:** Estar na aba de preenchimento de informações.                |
| **Saída:** Arquivos anexados no requerimento.                                   |
| **Pós-condições:** Não possui.                                                  |

| RF 030 - Modal de Lixeira                                                                |
| --------------------------------------------------------------                           |
| **Descrição:** O usuário deve possuir um modal de Lixeira anexado para visualização no modal de barra lateral, onde tem acesso às requisições deletadas                                    |
| **Atores:** Discente.                                                                    |
| **Prioridade:** Médio.                                                                   |
| **Entrada:** Não possui.                                                                 |
| **Pré-condições:** Ter requisição no momento arquivadas ou enviadas.                     |
| **Saída:** Requisição deletada.                                                          |
| **Pós-condições:** Não possui.                                                           |

| RF 031 - Solicitar Recontagem de Solicitação                                                                |
| --------------------------------------------------------------                           |
| **Descrição:** O usuário deve ter a oportunidade de pedir recontagem de solicitação quando negada caso queira conferir se nenhuma informação foi ignorada ou vista de forma superficial.              |
| **Atores:** Discente.                                                                    |
| **Prioridade:** Médio.                                                                   |
| **Entrada:** Não possui.                                                               |
| **Pré-condições:** Ter requisição negada ou com horas aceitas.                   |
| **Saída:** Pedido de recontagem solictado.                                                          |
| **Pós-condições:** Não possui.                                                           |

| RF 032 - Cancelar Recontagem de Solicitação                                                                |
| --------------------------------------------------------------                           |
| **Descrição:** O usuário deve ter a oportunidade de cancelar recontagem de solicitação caso não ache mais necessário análise.             |
| **Atores:** Discente.                                                                    |
| **Prioridade:** Médio.                                                                   |
| **Entrada:** Não possui.                                                            |
| **Pré-condições:** Ter pedido de recontagem solicitado.                   |
| **Saída:** Pedido de recontagem cancelado.                                                          |
| **Pós-condições:** Não possui.                                                           |
