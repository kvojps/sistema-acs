## RF 011 - Cadastrar Requisição
- **Descrição**: O aluno deve ser capaz de criar uma nova requisição. Após a criação, a requisição recebe o status de 
rascunho.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não requer entrada de dados.
- **Pré-condições**: O aluno deve estar autenticado e pode ter no máximo duas requisições em rascunho.
- **Saída**: Retorna o ID da requisição criada.
- **Pós-condições**: O aluno é redirecionado para a tela de rascunho da requisição.

## RF 012 - Anexar Certificado em Formato PDF
- **Descrição**: O aluno deve anexar um arquivo PDF de seu certificado à requisição. Após a anexação, a requisição 
permanece no status de rascunho.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Inserir o arquivo PDF do certificado.
- **Pré-condições**: O aluno deve estar autenticado.
- **Saída**: Retorna os detalhes do certificado.
- **Pós-condições**: O aluno é redirecionado para a tela de informações do certificado.

## RF 013 - Adicionar Informações do Certificado
- **Descrição**: O aluno deve adicionar as informações sobre o PDF do certificado adicionado.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Inserir título, data inicial, data final, quantidade de horas e atividade.
- **Pré-condições**: O aluno deve estar autenticado.
- **Saída**: Retorna os detalhes do certificado.
- **Pós-condições**: O aluno é redirecionado para a tela de informações do certificado.

## RF 014 - Submeter Requisição
- **Descrição**: O aluno pode submeter uma requisição para avaliação, e após a submissão, o status é alterado para 
"em trânsito".
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não requer entrada de dados.
- **Pré-condições**: O aluno deve estar autenticado, e a requisição deve estar no status de rascunho.
- **Saída**: Não há saída.
- **Pós-condições**: O aluno é redirecionado para a tela inicial.

## RF 015 - Consultar Lista de Requisições
- **Descrição**: O aluno pode visualizar sua lista de requisições.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não requer entrada de dados.
- **Pré-condições**: O aluno deve estar autenticado.
- **Saída**: Retorna a lista de requisições do aluno.
- **Pós-condições**: O aluno é redirecionado para a tela de requisições.

## RF 016 - Buscar Requisição Específica
- **Descrição**: O aluno pode visualizar uma requisição específica.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não requer entrada de dados.
- **Pré-condições**: O aluno deve estar autenticado.
- **Saída**: Retorna os detalhes da requisição selecionada.
- **Pós-condições**: O aluno é redirecionado para a tela da requisição selecionada.

## RF 017 - Receber Alerta Após Mudança de Status de Uma Requisição
- **Descrição**: O aluno deve receber um e-mail quando houver uma mudança no status da requisição.
- **Atores**: Aluno.
- **Prioridade**: Baixa.
- **Entrada**: Não requer entrada de dados.
- **Pré-condições**: Quando o status de uma requisição associada a um aluno for alterado.
- **Saída**: Não há saída.
- **Pós-condições**: O aluno recebe um e-mail com as informações da requisição e seu novo status.

## RF 018 - Baixar Arquivo PDF Referente à Requisição
- **Descrição**: O aluno pode baixar a requisição em formato PDF.
- **Atores**: Aluno.
- **Prioridade**: Baixa.
- **Entrada**: Não requer entrada de dados.
- **Pré-condições**: O aluno deve estar autenticado e selecionar a opção de fazer o download do arquivo em PDF.
- **Saída**: Confirmação do download do arquivo.
- **Pós-condições**: O arquivo é baixado para a pasta selecionada do aluno.

## RF 019 - Visualizar Indicadores Sobre as Requisições
- **Descrição**: O aluno pode visualizar a quantidade de horas aceitas em cada eixo de suas requisições.
- **Atores**: Aluno.
- **Prioridade**: Alta.
- **Entrada**: Não requer entrada de dados.
- **Pré-condições**: O aluno deve estar autenticado e ter pelo menos uma requisição.
- **Saída**: Retorna as horas aceitas pelo usuário em cada eixo.
- **Pós-condições**: O aluno é redirecionado para o painel de aluno(dashboard).
