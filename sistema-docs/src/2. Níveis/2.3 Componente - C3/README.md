É possível ampliar e decompor cada contêiner ainda mais para identificar os principais blocos de construção estruturais e suas interações.

O diagrama de Componentes mostra como um contêiner é composto por vários "componentes", o que são cada um desses componentes, suas responsabilidades e os detalhes de tecnologia/implementação.

* **Escopo:** Um único contêiner.
* **Elementos primários:** Componentes dentro do contêiner no escopo.
* **Público alvo:** Arquitetos e desenvolvedores de software.
****
## Convenções Back-end
Antes de entrarmos definitivamente no C3 é importante ressaltar que são utilizados algumas convenções que corroboram com a arquitetura proposta. São eles:
*  Convenção de nomenclaturas de arquivos e diretórios ([Oracle](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html))
*  Convenção de fluxo de trabalho Git - com adapatações e aderência parcial ([Gitflow](https://danielkummer.github.io/git-flow-cheatsheet/))
*  Convenção de commits ([Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/))

## Convenções Front-end
⚒️🏗️

## Restrições e metas arquiteturais
* As tecnologias de desenvolvimento utilizadas são: 
  * Front-end: TypeScript associado aos frameworks React + NextJs.
  * Back-end: Java associado ao framework Spring boot.
* O projeto não possui nenhuma espécie de orçamento, tornando a aquisição de serviços de terceiros um custo pessoal, portanto os serviços utilizados devem ser gratuitos e o servidor pessoal ou da instituição;.
* A aplicação será disponibilizada como página web.
* O sistema deve permanecer online 24 horas por dia, 7 dias por semana, com tolerância a interrupções de no máximo 2 horas em situações excepcionais para manutenções ou atualizações planejadas.
* O serviço de API deve ser criado com um banco de dados completo, com gerenciamento de concorrência e maior capacidade de armazenamento, dado que o sistema será desenvolvido com foco em manter múltiplos usuários acessando concorrentemente.

