# 2.1 Contexto - C1

`/2. Níveis/2.1 Contexto - C1`

* [Sistema ACS | Docs](../../README.md)
  * [1. Requisitos](../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
    * [1.2 Requisitos Arquiteturais](../../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../2.%20N%C3%ADveis/README.md)
    * [**2.1 Contexto - C1**](../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1 Back](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1%20Back/README.md)
      * [2.3.2 Front](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.2%20Front/README.md)
    * [2.4 Código - C4](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1 Atividades](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Atividades/README.md)
      * [2.4.2 Classes](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2%20Classes/README.md)
      * [2.4.3 Máquina de estados](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.4 Sequência](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/TLAxJWCn4Epz5QjB7IbqG85o2Yaea285qPuMUnDP-15vVGI4-1Z4f-J7sCjTY0F4ZJqx8tjdrbFEc7Bh7TnQN2Vq2Fe2ng1ZoFIQe-9d6pOe1A3ECItpcoF0BN7qf5GYdJ6ifLGjAAqiWo5ekTrz9Xkv0kGEOGVU5SZQNmArQqE4KVV2zPDhgQ1cqLlctTTPEYP30OsS_nNKnjjWEQVVae-oMnO5UMnGSzTZjUmnr3DfUhIQcCkhoOcxkIDF8KS6kP1I6Cpr05r3FSyms5mB0EsiRDImpvlzCxE-0ClxXqLL25yiDffwpQEL4SYvNjnLXQyvw-WaI8EIyAcjKyjZ4xTXV5CcfShKZlmGj3f6Vk3syr67oVsKYzIKAYCy2Fx4eQOKZFokRm00)

## Objetivo do Diagrama de Contexto no Modelo C4

O principal objetivo do diagrama de contexto, conforme definido pelo modelo C4, é proporcionar uma visão geral e 
simplificada da arquitetura de um sistema, enfatizando seus vínculos com o ambiente externo. Nesse diagrama, o sistema 
central em foco é representado como uma única caixa central, cercada por elementos externos, como usuários, sistemas 
externos e outras entidades com as quais o sistema interage.

Este diagrama desempenha um papel crucial na comunicação clara e concisa da função e propósito do sistema, bem como na 
ilustração de sua interação com o ambiente circundante. Ele oferece uma representação de alto nível da arquitetura, 
permitindo que as partes interessadas identifiquem facilmente as partes envolvidas e compreendam a extensão do sistema.
Além disso, o diagrama de contexto serve como uma base sólida para a criação de diagramas mais detalhados, servindo como
ponto de partida para a decomposição do sistema em componentes menores. Isso auxilia na definição dos limites e na 
identificação das interfaces do sistema, tornando-se uma ferramenta essencial para a compreensão inicial da arquitetura 
em um nível mais amplo.

**Escopo:** O diagrama de contexto se aplica a um único sistema de software.

**Elementos principais:** O elemento central é o sistema de software em questão.

**Elementos de suporte:** Incluem pessoas (como usuários, atores, funções ou personas) e sistemas de software (
dependências externas) que têm conexões diretas com o sistema de software em foco.

**Público-alvo:** Este diagrama é destinado a todas as partes interessadas, sejam elas técnicas ou não, dentro e fora 
da equipe de desenvolvimento de software. Ele desempenha um papel fundamental na comunicação eficaz da arquitetura do 
sistema.


## Principais elementos
### Personas
Cada usuário é obrigatoriamente associado a um perfil que define os níveis de autorização no sistema. É fundamental 
ressaltar que somente membros da Universidade de Pernambuco têm permissão para acessar o sistema.
- **Aluno:** Este perfil é designado aos usuários que têm acesso ao sistema para submeter requisições juntamente com suas
atividades complementares.
- **Comissão:** Os usuários com perfil de comissão desempenham um papel crítico na avaliação das requisições de atividades
complementares. Sua responsabilidade principal é a verificação dos dados da requisição e dos certificados apresentados. 
Além disso, cabe a eles atribuir a quantidade de horas correspondente às atividades e determinar o status da requisição
como deferido ou indeferido, com base nas informações fornecidas e nos critérios estabelecidos.
- **Coordenação:** Os responsáveis pelo gerenciamento das requisições são atribuídos ao perfil de coordenação. Eles são
os primeiros a receber as requisições e conduzem as validações iniciais, com a autoridade para indeferir uma requisição
sem a necessidade de envolvê-la com a comissão responsável. Somente usuários com este perfil têm autoridade para concluir
o fluxo da requisição. A função da coordenação é crucial na triagem inicial, assegurando que apenas as requisições válidas
e apropriadas prossigam para a avaliação da comissão.
- **Administrador:** O perfil de administrador é responsável por atribuir os perfis de comissão e coordenação. Para
realizar essa atribuição, é necessário enviar um e-mail para a conta de administração, solicitando o cadastro de usuários
com esses perfis específicos. Esse procedimento garante que apenas usuários autorizados tenham os privilégios necessários
para desempenhar as funções de comissão e coordenação, mantendo, assim, a segurança e organização do sistema.

#### Personas Externas
- **Escolaridade:** Este ator não interage diretamente com o sistema, mas desempenha um papel crucial ao receber e-mails
durante o processo de cadastro das requisições. Ele é notificado quando um aluno realiza o cadastro de uma requisição e 
também quando a requisição é concluída. Sua responsabilidade é inserir as informações das atividades complementares no 
Siga, garantindo que os registros sejam atualizados adequadamente. Embora não esteja diretamente envolvido no sistema,
esse ator desempenha uma função indispensável para o fluxo de trabalho eficiente e preciso.

### Sistema principal
- **Sistema ACs-UPE:** Esta plataforma web é um sistema que proporciona aos alunos a capacidade de cadastrar requisições,
ao mesmo tempo em que permite o gerenciamento dessas requisições pela coordenação e comissão. Trata-se de um ambiente 
centralizado que simplifica o processo de solicitação de atividades complementares, fomentando uma comunicação eficiente
entre os alunos e as equipes responsáveis pela avaliação e aprovação das requisições. A plataforma oferece recursos que 
permitem aos alunos inserir os dados necessários para as requisições, enquanto a coordenação e a comissão podem acessar 
e administrar essas requisições de forma organizada, efetiva e segura.

### Sistema externos
- **Cliente SMTP:** Este componente é responsável pelo envio de e-mails automáticos relacionados às requisições, 
notificações entre os atores do sistema e e-mails associados às etapas de configuração de contas de usuário. Desempenha 
um papel crucial na comunicação efetiva do sistema, assegurando que as partes relevantes sejam informadas sobre o status
das requisições, atualizações e outras informações importantes. Os e-mails automáticos são acionados com base em eventos
específicos, otimizando o fluxo de trabalho e mantendo os usuários informados de maneira oportuna.
- **API do Via CEP:** Este recurso permite a obtenção automática de dados de endereço do usuário simplesmente informando
o CEP. Com essa funcionalidade, é possível simplificar e agilizar o processo de preenchimento de informações de endereço,
eliminando a necessidade de inserir manualmente cada campo. Ao inserir o CEP, o sistema realiza uma busca em uma base de
dados atualizada e recupera automaticamente as informações de rua, número, bairro, cidade e estado associados ao CEP 
fornecido. Isso proporciona uma experiência mais conveniente para o usuário, reduzindo erros de digitação e economizando
tempo ao preencher formulários ou realizar transações online que requerem informações de endereço.
