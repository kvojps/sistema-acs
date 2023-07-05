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