# 1.1.2 Aluno

O aluno possui acesso ao sistema para enviar requisições juntamente com suas atividades complementares. Além de obter informações sobre o progresso da validação da sua requisição, permitindo que você acompanhe em qual etapa do processo ela se encontra.


| RF 013 - Dashboard do Discente|
| -------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter uma tela inicial para centralizar todas as operações relacionadas ao requerimento. |
| **Atores:** Discente.                                                                                                |
| **Prioridade:** Alta.                                                                                                |
| **Entrada:** Não possui.                                                                                             |
| **Pré-condições:** Estar logado no sistema.                                                                          |
| **Saída:** Acesso ao dashboard.                                                                                      |
| **Pós-condições:** Não possui.                                                                                       |

| RF 014 - Cadastrar Requisição                                                                                          |
| -----------------------------------------------------------------------------------------------------------------------|
| **Descrição:** O usuário deve ser capaz de cadastrar uma requisição com o intuito de ratificar uma determinada quantidade de horas das suas atividades complementares. Para cadastrar a requisição é preciso que o discente acesse o barema   disponibilizado no dashboard principal para responder todas as informações necessárias.                                  |
| **Atores:** Discente.                                                                                                  |
| **Prioridade:** Alta.                                                                                                  |
| **Entrada:** Inserir informações da requisição, como semestre e quantidade de certificados. Para cada certificado, fornecer título, descrição, data, horas, atividade em que se enquadra de acordo com o barema e o arquivo no formato PDF. |
| **Pré-condições:** O usuário deve estar logado.                                                                        |
| **Saída:** Confirmação do envio da requisição.                                                                         |
| **Pós-condições:** O usuário é redirecionado para a tela específica da requisição enviada, e a coordenação recebe a notificação por e-mail.                                                                                                  |

| RF 015 - Consultar lista de requisições                                                                               |
| --------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar sua lista de requisições.                                       |
| **Atores:** Discente.                                                                                                 |
| **Prioridade:** Alta.                                                                                                 |
| **Entrada:** Não possui entradas.                                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                                       |
| **Saída:** Não possui saídas.                                                                                         |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada. |

| RF 016 - Buscar requisição específica                                               |
| ----------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar uma requisição específica.    |
| **Atores:** Discente.                                                               |
| **Prioridade:** Média.                                                              |
| **Entrada:** Não possui entradas.                                                   |
| **Pré-condições:** O usuário deve estar logado.                                     |
| **Saída:** Não possui saídas.                                                       |
| **Pós-condições:** O usuário é redirecionado para a tela da requisição selecionada. |

| RF 017 - Baixar arquivo PDF referente à requisição                                                       |
| -------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter a opção de fazer o download da requisição em formato PDF.              |
| **Atores:** Discente.                                                                                    |
| **Prioridade:** Baixa.                                                                                   |
| **Entrada:** Não possui entradas.                                                                        |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF. |
| **Saída:** Confirmação do download do arquivo.                                                           |
| **Pós-condições:** O usuário vê o arquivo baixado na pasta selecionada.                                  |

| RF 018 - Visualizar indicadores sobre as requisições enviadas                                          |
| ------------------------------------------------------------------------------------------------------ |
| **Descrição:** O usuário deve ser capaz de visualizar o status da solicitação em ACEITO ou NEGADO.     |
| **Atores:** Discente.                                                                                  |
| **Prioridade:** Média.                                                                                 |
| **Entrada:** Não possui.                                                                               |
| **Pré-condições:** Possuir solicitações enviadas.                                                      |
| **Saída:** Resultado do veredito da requisição.                                                        |
| **Pós-condições:** Não possui.                                                                         |

| RF 019 - Criar rascunhos de requisições                                                            |
| -------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter o poder de salvar as informações de uma solicitação, junto de documentos anexos, que ainda possa estar incompleta. Nesse caso, é feito um rascunho da requisição que será encaminhado para a coordenação somente após o usuário solicitá-lo.                                                                          |
| **Atores:** Discente.                                                                              |
| **Prioridade:** Alta.                                                                              |
| **Entrada:** Inserir dados de requerimento: Título, Data Inicial/Data Final, Eixo de Ensino, Atividade, Quantidade de Horas, Anexar Certificado.                                                                           |
| **Pré-condições:** Ter preenchido o requerimento com parte das informações solicitadas.            |
| **Saída:** Confirmação de requisição em rascunho.                                                  |
| **Pós-condições:** O usuário é redirecionado para a dashboard atualizada com a fila de rascunhos.  |

| RF 020 - Deletar rascunhos de requisições                                                    |
| -------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve poder apagar um rascunho de requisição caso ache necessário.   |
| **Atores:** Discente.                                                                        |
| **Prioridade:** Alta.                                                                        |
| **Entrada:** Não possui.                                                                     |
| **Pré-condições:** Ter um rascunho salvo.                                                    |
| **Saída:** Rascunho apagado.                                                                 |
| **Pós-condições:** A fila de requisição atualizada com o rascunho apagado.                   |

| RF 021 - Alterar rascunhos de requisições                                                                           |
| ------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve poder alterar dados de uma requisição em situação de rascunho quando achar necessário.|
| **Atores:** Discente.                                                                                               |
| **Prioridade:** Alta.                                                                                               |
| **Entrada:** Inserir ou alterar os dados de requerimento: Título, Data Inicial/Data Final, Eixo de Ensino, Atividade, Quantidade de Horas, Anexar Certificado.                                                                              |
| **Pré-condições:** Ter requerimento em rascunho.                                                                    |
| **Saída:** Rascunho atualizado.                                                                                     |
| **Pós-condições:** A fila de requisição atualizada com o rascunho também atualizado.                                |

| RF 022 - Enviar solicitação à coordenação                     |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve poder fazer o envio da solicitação completa criada anteriormente para o próximo ator do fluxo dentro do sistema.                                        |
| **Atores:** Discente.                                         |
| **Prioridade:** Alta.                                         |
| **Entrada:** Não possui.                                      |
| **Pré-condições:** Ter solicitação de contagem já  criada.    |
| **Saída:** Enviado para o coordenador.                        |
| **Pós-condições:** Usuário é redirecionado pra o dashboard.   |

| RF 023 - Alterar solicitação                                                           |
| -------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve poder alterar dados de uma solicitação já enviada caso esta não tenha alcançado uma fase muito avançada da requisição.                                                            |
| **Atores:** Discente.                                                                  |
| **Prioridade:** Média.                                                                 |
| **Entrada:** Alterar dados da solicitação do requerimento.                             |
| **Pré-condições:** Ter uma solicitação encaminhada para a coordenação e não entregue.  |
| **Saída:** Solicitação enviada atualizada.                                             |
| **Pós-condições:** Redirecionamento para o dashboard do usuário.                       |

| RF 024 - Visualizar dados do discente                         |
| ------------------------------------------------------------- |
| **Descrição:** O usuário deve ter acesso em parte especificada no sistema a um quantitativo de horas cumpridas, junto de poder conferir um extrato de horas, apenas visualização.        |
| **Atores:** Discente.                                         |
| **Prioridade:** Importante.                                   |
| **Entrada:** Não possui.                                      |
| **Pré-condições:** Não possui.                                |
| **Saída:** Não possui.                                        |
| **Pós-condições:** Não possui.                                |

| RF 025 - Visualizar fluxo de requisição                        |
| -------------------------------------------------------------- |
| **Descrição:** O usuário deve, caso tenha requisições enviadas, poder conferir o andamento de seu requerimento, com uma análise de trânsito visível e atualizada. (Apenas visualização)  |
| **Atores:** Discente.                                          |
| **Prioridade:** Baixo.                                         |
| **Entrada:** Não possui.                                       |
| **Pré-condições:** Ter requisição enviada.                     |
| **Saída:** Não possui.                                         |
| **Pós-condições:** Não possui.                                 |

### Perfil Coordenador

O coordenador é responsável pelo gerenciamento das requisições. Ele é o primeiro a receber as requisições e realiza validações iniciais, tendo autoridade para indeferir uma requisição sem envolvê-la com a comissão responsável. Somente um usuário com esse perfil possui a autoridade para concluir o fluxo da requisição.

| RF 026 - Solicitar permissões de coordenação                                                                           |
| ---------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário pode solicitar ao administrador o perfil de coordenação, é necessário validar se o usuário é docente e faz parte da coordenação de um determinado curso.                                                              |
| **Atores:** Usuário geral.                                                                                             |
| **Prioridade:** Média.                                                                                                 |
| **Entrada:** O usuário deve enviar alguma documentação que confirme a veracidade da sua posição.                       |
| **Pré-condições:** O usuário deve estar logado no sistema.                                                             |
| **Saída:** Confirmação da solicitação de autorização.                                                                  |
| **Pós-condições:** O usuário deve receber por e-mail um retorno sobre a sua solicitação.                               |

| RF 027 - Consultar lista de requisições                                                                              |
| -------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de visualizar a lista de requisições encaminhadas para a coordenação e comissão do seu respectivo curso. Também deve ser possível filtrar as requisições por campos de interesse, como data, semestre, status da requisição e aluno.                                                                                |
| **Atores:** Coordenador.                                                                                             |
| **Prioridade:** Média.                                                                                               |
| **Entrada:** Nenhuma.                                                                                                |
| **Pré-condições:** O usuário deve estar logado.                                                                      |     
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para tela de requisição selecionada.  |

| RF 028 - Encaminhar requisição para a comissão                                                        |
| ----------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de encaminhar a requisição para a comissão do seu curso.  |
| **Atores:** Coordenador.                                                                              |
| **Prioridade:** Alta.                                                                                 |
| **Entrada:** Não possui entradas.                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                       |
| **Saída:** Confirmação de encaminhamento de requisição.                                               |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi encaminhada com sucesso e a comissão recebe por e-mail a notificação.                                                                        |

| RF 029 - Assinar documento requisição                                                                          |
| -------------------------------------------------------------------------------------------------------------- |
| **Descrição:** Antes de deferir ou indeferir uma requisição, o coordenador deve ser capaz de baixar o documento da requisição em sua máquina e submetê-lo assinado ao sistema.                                                      |
| **Atores:** Coordenador.                                                                                       |
| **Prioridade:** Alta.                                                                                          |
| **Entrada:** O usuário deve submeter o documento assinado.                                                     |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF, assiná-lo e realizar a submissão.                                                                                            |
| **Saída:** Confirmação de submissão do documento assinado.                                                     |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi assinada com sucesso.     |

| RF 030 - Ratificar requisição                                                                                        |
| ---------------------------------------------------------------------------------------------------------------------|
| **Descrição:** O coordenador deve ser capaz de finalizar o fluxo da requisição, deferindo-a ou indeferindo-a.        |
| **Atores:** Coordenador                                                                                              |
| **Prioridade:** Alta                                                                                                 |
| **Entrada:** Nenhuma                                                                                                 |
| **Pré-condições:** O usuário deve estar logado e, em casos de aprovação, a requisição deve ter passado pela comissão.|
| **Saída:** Confirmação da ratificação da requisição                                                                  |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi ratificada e encaminhada para a escolaridade.                                                                                                          |

| RF 031 - Atribuir perfil para a comissão                                                       |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador pode atribuir perfis de comissão para os usuários da sua escolha. |
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Média.                                                                         |
| **Entrada:** Informar o usuário que deseja adicionar as permissões de comissão.                |
| **Pré-condições:** O usuário deve estar logado no sistema.                                     |
| **Saída:** Confirmação da atribuição do perfil.                                                |
| **Pós-condições:** O usuário que recebeu as permissões deve receber por e-mail a notificação.  |

| RF 032 - Visualizar indicadores sobre as requisições enviadas |
| ------------------------------------------------------------- |
| **Descrição:** Em construção.                                 |
| **Atores:** Coordenador.                                      |
| **Prioridade:** Média.                                        |
| **Entrada:** Em construção.                                   |
| **Pré-condições:** Em construção.                             |
| **Saída:** Em construção.                                     |
| **Pós-condições:** Em construção.                             |

### Perfil Comissão

A comissão desempenha um papel fundamental na avaliação das requisições de atividades complementares. Sua responsabilidade principal é verificar cuidadosamente os dados da requisição e os certificados apresentados. Além disso, é sua responsabilidade atribuir a quantidade de horas correspondente às atividades e definir o status da requisição como deferido ou indeferido, com base nas informações fornecidas e nos critérios estabelecidos.

| RF 033 - Consultar lista de requisições                                                                                 |
| ----------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** A comissão deve ser capaz de visualizar a lista de requisições encaminhadas para a comissão do seu respectivo curso. Também deve ser possível filtrar as requisições por campos de interesse, como data, semestre e aluno.   |
| **Atores:** Comissão.                                                                                                   |
| **Prioridade:** Média.                                                                                                  |
| **Entrada:** Nenhuma.                                                                                                   |
| **Pré-condições:** O usuário deve estar logado.                                                                         |
| **Saída:** Não possui saídas.                                                                                           |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela de requisição selecionada.   |

| RF 034 - Adicionar quantidade de horas nas atividades complementares                                            |
| --------------------------------------------------------------------------------------------------------------- |
| **Descrição:** A comissão deve ser capaz de adicionar a quantidade de horas por certificados de uma requisição. |
| **Atores:** Comissão                                                                                            |
| **Prioridade:** Alta                                                                                            |
| **Entrada:** Inserir quantidade de horas para o certificado                                                     |
| **Pré-condições:** O usuário deve estar logado                                                                  |
| **Saída:** Confirmação da inserção das horas dos certificados                                                   |
| **Pós-condições:** O usuário retorna para a tela da requisição                                                  |

| RF 035 - Validar requisição                                                                                  |
| ------------------------------------------------------------------------------------------------------------ |
| **Descrição:** A comissão deve ser capaz de finalizar o fluxo da requisição, deferindo-a ou indeferindo-a. Após isso, é submetido para a coordenação realizar a validação final.                                                       |
| **Atores:** Comissão.                                                                                        |
| **Prioridade:** Alta.                                                                                        |
| **Entrada:** Nenhuma.                                                                                        |
| **Pré-condições:** O usuário deve estar logado e, em casos de aprovação, a requisição deve ser enviada para a coordenação.                                                                                                   |
| **Saída:** Confirmação da ratificação da requisição.                                                         |
| **Pós-condições:** O coordenador recebe um e-mail informando que a requisição foi finalizada pela comissão.  |
