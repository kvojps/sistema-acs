# 2.3 Componente - C3

`/2. Níveis/2.3 Componente - C3`

* [Sistema ACS | Docs](../../README.md)
  * [1. Requisitos](../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
    * [1.2 Requisitos Arquiteturais](../../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [**2.3 Componente - C3**](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1 Back](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1%20Back/README.md)
      * [2.3.2 Front](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.2%20Front/README.md)
    * [2.4 Código - C4](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1 Casos de uso](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/README.md)
        * [2.4.1 Usuário geral](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.1%20Usu%C3%A1rio%20geral/README.md)
        * [2.4.2 Aluno](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.2%20Aluno/README.md)
        * [2.4.3 Coordenador](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.3%20Coordenador/README.md)
        * [2.4.4 Comissão](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.4%20Comiss%C3%A3o/README.md)
      * [2.4.2 Atividades](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2%20Atividades/README.md)
      * [2.4.3 Classes](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20Classes/README.md)
      * [2.4.4 Máquina de estados](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.5 Sequência](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.5%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)
  * [4. Apêndices](../../4.%20Ap%C3%AAndices/README.md)
    * [4.1 Reuniões](../../4.%20Ap%C3%AAndices/4.1%20Reuni%C3%B5es/README.md)

---

O objetivo principal dos diagramas de componentes no C4 Model é mostrar a estrutura interna dos contêineres do sistema e como eles são compostos por diferentes componentes. Os diagramas de componentes fornecem uma visão detalhada dos principais blocos de construção estruturais do sistema e suas interações. Esses diagramas ajudam a entender a arquitetura de um sistema de software em um nível mais granular, identificando os componentes individuais e suas responsabilidades. Eles mostram como os componentes se relacionam entre si, quais são as dependências e como eles colaboram para fornecer as funcionalidades do sistema.

* **Escopo:** Um único contêiner.
* **Elementos primários:** Componentes dentro do contêiner no escopo.
* **Público alvo:** Arquitetos e desenvolvedores de software.
****

## Restrições e metas arquiteturais
* As tecnologias de desenvolvimento utilizadas são: 
  * Front-end: TypeScript associado aos frameworks React + NextJs.
  * Back-end: Java associado ao framework Spring boot.
* O projeto não possui nenhuma espécie de orçamento, tornando a aquisição de serviços de terceiros um custo pessoal, portanto os serviços utilizados devem ser gratuitos e o servidor pessoal ou da instituição;.
* A aplicação será disponibilizada como página web.
* O sistema deve permanecer online 24 horas por dia, 7 dias por semana, com tolerância a interrupções de no máximo 2 horas em situações excepcionais para manutenções ou atualizações planejadas.
* O serviço de API deve ser criado com um banco de dados completo, com gerenciamento de concorrência e maior capacidade de armazenamento, dado que o sistema será desenvolvido com foco em manter múltiplos usuários acessando concorrentemente.