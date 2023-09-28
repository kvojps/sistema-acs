# 1.1.2 Aluno

`/1. Requisitos/1.1 Requisitos do Sistema/1.1.2 Aluno`

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
