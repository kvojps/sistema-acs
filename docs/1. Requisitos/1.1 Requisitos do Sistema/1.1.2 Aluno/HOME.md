# 1.1.2 Aluno

O aluno possui acesso ao sistema para enviar requisições juntamente com suas atividades complementares. Além de obter informações sobre o progresso da validação da sua requisição, permitindo que você acompanhe em qual etapa do processo ela se encontra.

| RF 011 - Cadastrar requisição                                                                                                                                                                     |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de cadastrar uma requisição com o intuito de ratificar uma determinada quantidade de horas das suas atividades complementares.                            |
| **Atores:** Aluno.                                                                                                                                                                                |
| **Prioridade:** Alta.                                                                                                                                                                             |
| **Entrada:** Inserir informações da requisição, como semestre e quantidade de certificados. Para cada certificado, fornecer título, descrição, data, horas, atividade e o arquivo no formato PDF. |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                   |
| **Saída:** Confirmação do envio da requisição.                                                                                                                                                    |
| **Pós-condições:** O usuário é redirecionado para a tela específica da requisição enviada, e a coordenação recebe a notificação por e-mail.                                                       |

| RF 012 - Consultar lista de requisições                                                                               |
| --------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar sua lista de requisições.                                       |
| **Atores:** Aluno.                                                                                                    |
| **Prioridade:** Alta.                                                                                                 |
| **Entrada:** Não possui entradas.                                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                                       |
| **Saída:** Não possui saídas.                                                                                         |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada. |

| RF 013 - Buscar requisição específica                                               |
| ----------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar uma requisição específica.    |
| **Atores:** Aluno.                                                                  |
| **Prioridade:** Média.                                                              |
| **Entrada:** Não possui entradas.                                                   |
| **Pré-condições:** O usuário deve estar logado.                                     |
| **Saída:** Não possui saídas.                                                       |
| **Pós-condições:** O usuário é redirecionado para a tela da requisição selecionada. |

| RF 014 - Receber alerta após mudança de status de uma requisição                                               |
| -------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve receber um alerta via e-mail após haver uma mudança no status da requisição.     |
| **Atores:** Aluno.                                                                                             |
| **Prioridade:** Alta.                                                                                          |
| **Entrada:** Não possui entradas.                                                                              |
| **Pré-condições:** Quando o status de uma requisição associada a um determinado aluno for alterada.            |
| **Saída:** Não possui saídas.                                                                                  |
| **Pós-condições:** O usuário recebe um e-mail com as informações daquela requisição e o seu respectivo status. |

| RF 015 - Baixar arquivo PDF referente à requisição                                                       |
| -------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter a opção de fazer o download da requisição em formato PDF.              |
| **Atores:** Aluno.                                                                                       |
| **Prioridade:** Baixa.                                                                                   |
| **Entrada:** Não possui entradas.                                                                        |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF. |
| **Saída:** Confirmação do download do arquivo.                                                           |
| **Pós-condições:** O usuário vê o arquivo baixado na pasta selecionada.                                  |

| RF 016 - Visualizar indicadores sobre as requisições enviadas |
| ------------------------------------------------------------- |
| **Descrição:** Em construção.                                 |
| **Atores:** Aluno.                                            |
| **Prioridade:** Média.                                        |
| **Entrada:** Em construção.                                   |
| **Pré-condições:** Em construção.                             |
| **Saída:** Em construção.                                     |
| **Pós-condições:** Em construção.