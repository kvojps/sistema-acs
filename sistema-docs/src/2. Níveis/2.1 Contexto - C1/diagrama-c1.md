Um diagrama de contexto do sistema é um bom ponto de partida para diagramar e documentar um sistema de software, permitindo retroceder e visualizar o quadro geral. O diagrama mostra o sistema como uma caixa no centro, cercada por seus usuários e outros sistemas com os quais ele interage.

Os detalhes não são importantes aqui, pois esta é a visualização com zoom reduzido, mostrando uma visão geral da paisagem do sistema. O foco deve estar nas pessoas (atores, papéis, personas, etc.) e sistemas de software, em vez de tecnologias, protocolos e outros detalhes de baixo nível. É o tipo de diagrama se pode mostrar para pessoas não técnicas.

* **Escopo:** Um único sistema de software.
* **Elementos primários:**  O sistema de software no escopo.
* **Elementos de suporte:** Pessoas (por exemplo, usuários, atores, funções ou personas) e sistemas de software (dependências externas) que estão diretamente conectados ao sistema de software no escopo.
* **Público alvo:** Todos, técnicos e não técnicos, dentro e fora da equipe de desenvolvimento de software.

## Principais elementos
### Personas
Cada usuário possui obrigatoriamente um perfil, que define os níveis de autorização no sistema.
* **Aluno:** Esse usuário representa aqueles que têm acesso ao sistema para enviar requisições com suas atividades complementares. Apenas os membros da Universidade de Pernambuco possuem permissão para acessar o sistema.
* **Comissão:** Esse usuário desempenha o papel de avaliar as requisições de atividades complementares. Sua responsabilidade envolve a verificação dos dados da requisição e dos certificados apresentados. Além disso, ele é responsável por atribuir a quantidade de horas correspondente e definir o status da requisição como deferido ou indeferido.
* **Coordenação:** O usuário responsável pelo gerenciamento das requisições é conhecido como coordenador. Ele é o primeiro a receber as requisições e realiza validações iniciais, tendo o poder de indeferir uma requisição sem envolvê-la com a comissão. Somente um usuário com esse perfil possui a autoridade para finalizar o fluxo da requisição.
* **Administrador:** Esse usuário tem a responsabilidade de atribuir os perfis de comissão e coordenação. Para isso, é necessário enviar um e-mail para a conta de administração, a fim de cadastrar usuários com esses perfis.
#### Personas Externas
* **Escolaridade:** Esse ator não possui participação direta no sistema, mas desempenha um papel importante ao receber e-mails durante o fluxo de cadastro das requisições. Ele é notificado quando um aluno cadastra uma requisição e quando a requisição é finalizada, pois é responsável por inserir as informações das atividades complementares no Siga.

### Sistema principal
* **Sistema ACs-UPE:** Essa plataforma web representa um sistema que possibilita o cadastro de requisições pelos alunos, bem como o gerenciamento dessas requisições pela coordenação e comissão.

### Sistema externos
* **Sistema de e-mail:** Responsável pelo envio de emails automáticos para a escolaridade relacionados as requisições, além de e-mails relacionados a etapas de configuração de contas do usuário.
* **Sistema de autenticação:** Permite aos usuários utilizar suas credenciais do Google para fazer login em diversos serviços e aplicativos. 
* **API do Via CEP:** Permite receber os dados de endereço do usuário apenas informando o CEP.