# 2. Níveis

`/2. Níveis`

* [Sistema ACS | Docs](../README.md)
  * [1. Requisitos](../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
    * [1.2 Requisitos Arquiteturais](../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [**2. Níveis**](../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1 Back](../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1%20Back/README.md)
      * [2.3.2 Front](../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.2%20Front/README.md)
    * [2.4 Código - C4](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1 Casos de uso](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/README.md)
        * [2.4.1 Usuário geral](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.1%20Usu%C3%A1rio%20geral/README.md)
        * [2.4.2 Aluno](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.2%20Aluno/README.md)
        * [2.4.3 Coordenador](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.3%20Coordenador/README.md)
        * [2.4.4 Comissão](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.4%20Comiss%C3%A3o/README.md)
      * [2.4.2 Atividades](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2%20Atividades/README.md)
      * [2.4.3 Classes](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20Classes/README.md)
      * [2.4.4 Máquina de estados](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.5 Sequência](../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.5%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

O modelo C4 é uma abordagem acessível e de fácil compreensão para a criação de diagramas de arquitetura de software. 
Ao elaborar esses diagramas de forma eficaz, desempenha-se um papel fundamental na promoção da comunicação 
eficiente, tanto internamente, entre equipes de desenvolvimento e de produtos de software, quanto externamente, com 
outros stakeholders. Esses diagramas representam ferramentas para facilitar a integração eficaz de novos membros da equipe,
proporcionando uma visão clara e concisa da estrutura e das interações do sistema. Além disso, eles simplificam análises
detalhadas da arquitetura, permitindo a identificação de pontos fortes e fracos, bem como oportunidades de melhoria.

Por meio dos diagramas de arquitetura de software é posssível identificar potenciais riscos, através da representação 
clara das dependências e interações entre os componentes do sistema. Isso viabiliza a adoção de medidas preventivas e a 
elaboração de estratégias para mitigar os riscos identificados. Com isso, desempenham um papel importante na modelagem 
de ameaças, possibilitando a visualização de possíveis vulnerabilidades e a definição de medidas de segurança adequadas.
Com um profundo entendimento da arquitetura do sistema, é possível tomar decisões informadas para garantir a proteção 
adequada dos dados e a segurança geral do sistema.

## Nível 1: Diagrama de contexto do sistema
O diagrama de contexto de um sistema é um recurso valioso ao planejar e documentar software, pois oferece uma visão geral
simplificada. Nesse tipo de diagrama, o sistema é representado como uma caixa central, cercada por seus usuários e outros
sistemas com os quais interage. A criação desse diagrama proporciona uma compreensão mais clara e abrangente do sistema,
permitindo uma análise completa de suas interações com o ambiente ao seu redor.

Nesse contexto, detalhes minuciosos não são prioritários, pois o foco recai sobre uma visão ampla que apresenta uma 
imagem abrangente da paisagem do sistema. O enfoque principal está nas pessoas (atores, funções, personas, etc.) e nos 
sistemas de software, ao invés de se ater a tecnologias, protocolos e outros pormenores de baixo nível. Esse é o tipo 
de diagrama que pode ser compartilhado com pessoas não técnicas, proporcionando uma compreensão acessível e esclarecedora
do sistema em discussão.

## Nível 2: Diagrama de contêiner
Após obter uma compreensão de como o seu sistema se encaixa no cenário de tecnologia da informação, uma etapa útil é a 
expansão dos limites do sistema por meio de um diagrama de contêiner. Um "contêiner" pode ser entendido como um componente,
como um aplicativo web no lado do servidor, um aplicativo de página única, um aplicativo de desktop, um aplicativo móvel,
um esquema de banco de dados, um sistema de arquivos, entre outros. 

Em essência, um contêiner é uma unidade autônoma e implantável independentemente, assemelhando-se a um espaço de processo
isolado capaz de executar código ou armazenar dados de forma independente. Este diagrama oferece uma visão mais detalhada
e escalável do sistema, destacando as unidades autônomas que compõem a arquitetura. Isso facilita a compreensão das relações
e interações entre os diversos componentes do sistema, sendo uma ferramenta valiosa para a análise e o planejamento da 
arquitetura de software.


## Nível 3: Diagrama de componentes
É possível expandir e decompor cada contêiner de forma mais detalhada, a fim de identificar os principais blocos de 
construção estruturais e suas interações. O diagrama de componentes oferece uma visão clara de como um contêiner é 
composto por diversos "componentes", fornecendo informações sobre a natureza de cada um desses componentes, suas 
responsabilidades e os detalhes relacionados à tecnologia e implementação utilizada. Esse tipo de diagrama permite uma 
compreensão mais aprofundada da estrutura do sistema, destacando os elementos fundamentais que o compõem e como eles 
se relacionam entre si.

## Nível 4: Diagrama de código
Por fim, é possível aprofundar cada componente para exibir como é implementado em forma de código, utilizando diagramas 
de classe UML, diagramas de entidade-relacionamento ou técnicas similares. Esses diagramas fornecem uma representação 
visual das relações entre as classes, entidades ou componentes, destacando seus atributos, métodos e associações. 
Ao utilizar tais diagramas, você pode comunicar de forma eficaz os detalhes técnicos da implementação do sistema e 
evidenciar o funcionamento interno de cada componente.

Este é um nível de detalhe opcional e, normalmente, pode ser acessado sob demanda por meio de ferramentas como IDEs.
Idealmente, esse tipo de diagrama deveria ser gerado automaticamente utilizando ferramentas como uma IDE de modelagem 
ou UML. Ao criar esses diagramas, é importante considerar mostrar apenas os atributos e métodos relevantes que ajudem a
contar a história desejada. É importante ressaltar que esse nível de detalhe não é recomendado para todos os componentes,
sendo mais adequado para destacar os componentes mais importantes ou complexos.