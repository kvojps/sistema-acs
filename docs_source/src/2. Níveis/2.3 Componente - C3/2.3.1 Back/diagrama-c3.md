O diagrama de componentes em questão oferece uma representação visual dos componentes principais do sistema. Esses 
componentes são elementos fundamentais que desempenham papéis específicos no funcionamento do sistema como um todo.

# Back-end
## Convenções
Para promover a separação de responsabilidades, a coesão e a manutenção da arquitetura, são adotados padrões de nomenclatura
para pastas, arquivos, funções e variáveis. As pastas são organizadas para representar as diferentes camadas do software e são
nomeadas como "controlador", "serviço", "repositório" e "modelo". Os arquivos seguem a convenção de "nome da entidade + nome
da camada", por exemplo, "RequisicaoController". Em relação às funções e variáveis, é recomendado utilizar o camelCase,
pois isso melhora a legibilidade do código.

## Camadas
* **Controlador:** O Controlador atua como uma ponte entre a interface do usuário e a lógica de negócio da aplicação. 
Ele recebe os dados fornecidos pelo usuário, faz a validação sintática dos parâmetros de entrada e decide qual ação 
precisa ser tomada com base nas informações recebidas. Essa camada também é responsável por traduzir as respostas do 
serviço em uma representação adequada para a interface do usuário, como um JSON.
* **Serviço:** A camada Serviço, por sua vez, contém a lógica de negócio da aplicação. Ela é responsável por processar 
as requisições recebidas do Controller, realizar as operações necessárias e coordenar as interações entre diferentes 
componentes do sistema. O serviço encapsula as regras de negócio e pode fazer chamadas a outras camadas, como a camada 
de acesso a dados (Repositório), para buscar ou persistir informações no banco de dados.
* **Repositório:** O Repositório é a camada responsável pelo acesso aos dados. Ele fornece métodos para recuperar, 
armazenar e manipular informações no banco de dados ou em outros meios de armazenamento. Essa camada abstrai os detalhes
do acesso ao banco de dados, permitindo que o serviço trabalhe com objetos de domínio sem precisar conhecer os detalhes 
da implementação do banco de dados.
* **Modelo:** A camada Modelo representa os objetos de domínio da aplicação. Ela define as entidades e seus atributos,
bem como os relacionamentos entre elas. Os objetos de domínio são usados pelo serviço e pelo Repositório para manipular
as informações da aplicação de acordo com as regras de negócio.
* **Config:** Inclui várias classes de configuração, como as responsáveis pela autenticação e autorização, além das classes
de configuração do Swagger.
* **Utils:** Possui os utilitários do sistema (Classes de exceção).

## Configuração do ambiente

### Instalação do Java
Acesse o [link](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) para baixar o JDK 17
(Java SE Development Kit), recomenda-se baixar a versão mais recente.

### Instalação do Intellij IDEA
Para executar o projeto é interessante utilizar uma IDE, recomenda-se o [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/)

### Clonar repositorio
Para acessar o repositório navegue para este [link](https://github.com/upe-garanhuns/sistema-acs) e faça a configuração local do projeto.

![Imgur](https://i.imgur.com/xQFOwSw.png)

Escolha a forma de obter o projeto localmente, segue uma demonstração via Https:
```bash
git clone https://github.com/upe-garanhuns/sistema-acs.git
```
### Variáveis de ambientes
Antes de executar o projeto é necessário configurar as variaveis de ambiente abaixo:
```
DATABASE_URL
DATABASE_USER
DATABASE_PASSWORD
SECRET_KEY
SMTP_EMAIL
SMTP_PASSWORD
```

1. No Intellij, acesse "Edit Configurations":
 
![Edit Configurations](https://i.imgur.com/ZIO781u.png)

2. Acesse "Modify options" e selecione "Environment variables":

![Run/Debug configurations](https://i.imgur.com/C4FLxs7.png)

3. Adicione os valores das variáveis de ambiente:

![Environment Variables](https://i.imgur.com/bl2hOWI.png)

## Novos casos de uso
Para implementar novos casos de uso na API, siga o passo-a-passo abaixo:

* Crie o **modelo** para a entidade em questão, definindo seus atributos.
* Crie o **repositório** responsável pela camada de acesso aos dados da entidade.
* Crie o **serviço** que irá implementar a lógica de negócio relacionada à entidade.
* Crie o **controlador** responsável por receber as requisições relacionadas à entidade e retornar as respostas 
correspondentes.