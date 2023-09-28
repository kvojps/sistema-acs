O aluno possui acesso ao sistema para enviar requisições. Além de obter informações sobre o progresso da validação da 
sua requisição, permitindo que você acompanhe em qual etapa do processo ela se encontra.

## RF 011 - Cadastrar requisição
- **Descrição**: O aluno deve cadastrar uma requisição, ao cadastrá-la é atribuido o status de rascunho.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não possui entradas.
- **Pré-condições**: O aluno deve estar logado e pode possuir até 2 requisições cadastradas.
- **Saída**: Retornar o id da requisição.
- **Pós-condições**: O aluno é redirecionado para a tela da requisição rascunho.

## RF 012 - Adicionar certificado PDF
- **Descrição**: O aluno deve adicionar o PDF do certificado a requisição, ao cadastrá-lo o status fica como rascunho.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Inserir o PDF do certificado.
- **Pré-condições**: O aluno deve estar logado.
- **Saída**: Retornar os dados sobre o certificado.
- **Pós-condições**: O aluno é redirecionado para a tela do certificado.

## RF 013 - Adicionar informações do certificado
- **Descrição**: O aluno deve adicionar as informações sobre o PDF do certificado adicionado.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Inserir título, data inicial, data final, quantidade de horas e atividade.
- **Pré-condições**: O aluno deve estar logado.
- **Saída**: Retorna os dados sobre o certificado.
- **Pós-condições**: O aluno é redirecionado para a tela do certificado.

## RF 014 - Submeter requisição
- **Descrição**: O aluno pode submeter uma requisição para ser avaliada, após a submissão o status é alterado para
"em trânsito".
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não possui entradas.
- **Pré-condições**: O aluno deve estar logado e a requisição ser do tipo rascunho.
- **Saída**: Não há saída.
- **Pós-condições**: O aluno é redirecionado para a tela inicial.

## RF 015 - Consultar lista de requisições
- **Descrição**: O aluno pode visualizar sua lista de requisições.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não possui entradas.
- **Pré-condições**: O aluno deve estar logado.
- **Saída**: Retorna as requisições do aluno.
- **Pós-condições**: O aluno é redirecionado para a tela de requisições.

## RF 016 - Buscar requisição específica
- **Descrição**: O aluno pode visualizar uma requisição específica.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não possui entradas.
- **Pré-condições**: O aluno deve estar autenticado.
- **Saída**: Retorna os dados sobre a requisição.
- **Pós-condições**: O aluno é redirecionado para a tela da requisição selecionada.

## RF 017 - Receber alerta após mudança de status de uma requisição
- **Descrição**: O aluno deve receber um e-mail quando houver uma mudança no status da requisição.
- **Atores**: Aluno.
- **Prioridade**: Baixa.
- **Entrada**: Não possui entradas.
- **Pré-condições**: Quando o status de uma requisição associada a um aluno for alterado.
- **Saída**: Não há saída.
- **Pós-condições**: O aluno recebe um e-mail com as informações da requisição e seu novo status.

## RF 018 - Baixar arquivo PDF referente à requisição
- **Descrição**: O aluno pode baixar a requisição em formato PDF.
- **Atores**: Aluno.
- **Prioridade**: Baixa.
- **Entrada**: Não possui entradas.
- **Pré-condições**: O aluno deve estar autenticado e selecionar a opção de fazer o download do arquivo em PDF.
- **Saída**: Confirmação do download do arquivo.
- **Pós-condições**: O arquivo é baixado para a pasta selecionada do aluno.

## RF 019 - Visualizar indicadores sobre as requisições
- **Descrição**: O aluno pode visualizar a quantidade de horas aceitas em cada eixo das suas requisições. 
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não possui entradas.
- **Pré-condições**: O aluno estar logado e possuir requisições.
- **Saída**: Retorna as horas aceitas do usuário por eixo.
- **Pós-condições**: O aluno é redirecionado para a dashboard.
