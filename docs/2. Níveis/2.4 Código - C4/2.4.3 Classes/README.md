# 2.4.3 Classes

`/2. Níveis/2.4 Código - C4/2.4.3 Classes`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
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
      * [**2.4.3 Classes**](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20Classes/README.md)
      * [2.4.4 Máquina de estados](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.5 Sequência](../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.5%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)
  * [4. Apêndices](../../../4.%20Ap%C3%AAndices/README.md)
    * [4.1 Reuniões](../../../4.%20Ap%C3%AAndices/4.1%20Reuni%C3%B5es/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/hLTBJnin4BxpAonEVOX8lQuG9GffLObMg9HU48U9FG4NhntisJI8yj_hNVRbNMysQSaXiMV6u_4tus-SKqTWAKiLumgSGtV0_ASOiod9jHGWa5rV_u8r90ixoLOu0UucgH6e9hN5pGrxAbRcdoCf4dPkz6qZGRan2PlxxxdEqaOkq74hENZb9LdPNiBlli96ff0mgQaGFn-qWfkX9RdqIuKfjoxLJTH7HoViyDrXO9emtipSQ_YxHMe9t9kt0qw7C6pPZA58aZ8LWMeBYWB88tW6X8tipbXm3Qm3Q9VY7uP0TQLDo0bRF19Ut_GJz1qVCkdog48ysvWKY7uuRDicpDQJQ2sEEcjC4mRL-3K2yvbkva6U_p4wxx2UXdMJMRUbOdBjMAreas9G3hibfzYuAlHeMap04LSk0oktUgbC4fQzZDp_1T9AWuybm6sk1Lhamz1L1cFeSLprxvBDe2zSWBGsHbz5LllogqzzcQT4p7r4YIwAS7tGdK3UruL7k9o4yBRIC0HmOp86SOoP7AReo6A7Rnv8j2cseoLpZpgIhJgIgVMZjPaw9pK822ZhPLi2obmJUfk3BWjTtRN6KzC2gRhplUJqhlgOXnShtxpotrswLjV7pcrmht3otfSF1vlUVZ5jQwNxOzrKSTJHK0MN-h1yd_8IaVoPERGIr4-qJXfzzUKiOIgewZWHpqowKaWncbWj-yALtyG8qwrpLBWqEi8fc89KVR53VHTXB6w4l3N-20NEqLV3kbGM_TqOXQ23w9RvTXV5R_2UUvztj8py0qEIpBavOJEZ57BoQ1r_PBWXrCAnpnOqeQXC7qy23nS-JR-D5VdoJcJlYwIYrP1YJ2tTb7EJQVfcz7opaXOBBzqp17RdXjyFcisy1zJaS-v6NSurB5HV6r16pRf17LSrMHLnRPKmB8VRxsZNmH1V3BNROFrkdN_la_ZKLRF8OsUduqJv9dAc_7lyND67XBzolgw18ylhx0p9NoqNE6xBZ_zC9jKc1wS-L_wVr5y0)

A imagem acima denota as principais entidades que compõem o sistema e os seus relacionamentos. O diagrama de classes UML é uma representação visual que ilustra a estrutura estática de um sistema, exibindo as classes, seus atributos, métodos, relacionamentos e associações. Ele desempenha um papel fundamental na modelagem orientada a objetos, permitindo uma visualização clara e organizada da organização e composição das classes em um sistema de software. Além de fornecer uma visão estrutural, o diagrama de classes pode ser expandido para mostrar a implementação de cada componente por meio de diagramas como UML (Linguagem de Modelagem Unificada), diagramas de entidade-relacionamento ou outros similares. No entanto, é importante destacar que esse nível de detalhe é opcional e geralmente disponível mediante solicitação em ferramentas como IDEs (Ambientes de Desenvolvimento Integrado).

Idealmente, os diagramas detalhados seriam gerados automaticamente por meio de ferramentas especializadas, como uma ferramenta de modelagem UML ou IDE, simplificando o processo de criação e atualização dos diagramas. Ao criar esses diagramas, é recomendável mostrar apenas os atributos e métodos relevantes para transmitir a história ou a narrativa desejada, evitando informações excessivas que possam dificultar a compreensão.

Portanto, é aconselhável aplicar esse nível de detalhe apenas aos componentes mais importantes ou complexos, a fim de manter a clareza e a concisão do diagrama de classes. Essa abordagem ajuda a comunicar efetivamente a estrutura do sistema, facilitando o trabalho de desenvolvedores, arquitetos e outras partes interessadas na compreensão do sistema de software em questão.

* **Escopo:** Um único componente.
* **Elementos primários:** Elementos de código (por exemplo, classes, interfaces, objetos, funções, tabelas de banco de dados, etc.) dentro do componente no escopo.
*  **Elementos de suporte:** Containers (dentro do sistema de software em escopo) mais pessoas e sistemas de software diretamente conectados aos componentes.
*  **Público Alvo:** Arquitetos e desenvolvedores de software.