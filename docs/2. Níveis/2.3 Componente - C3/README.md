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
      * [2.4.1 Atividades](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Atividades/README.md)
      * [2.4.2 Classes](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2%20Classes/README.md)
      * [2.4.3 Máquina de estados](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.4 Sequência](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

Nos diagramas de componentes do modelo C4, o objetivo principal é apresentar a estrutura interna dos contêineres do 
sistema e como eles se compõem de diferentes componentes. Esses diagramas oferecem uma visão detalhada dos blocos de 
construção fundamentais do sistema e de suas interações essenciais.

Os diagramas de componentes são ferramentas essenciais para compreender a arquitetura do software em um nível granular,
permitindo a identificação dos componentes individuais e de suas responsabilidades específicas. Eles destacam as relações
entre esses componentes, revelando suas dependências e ilustrando como colaboram para oferecer as funcionalidades do 
sistema. Em resumo, esses diagramas ajudam a desvendar os detalhes da estrutura interna, permitindo uma compreensão mais
profunda e clara da arquitetura do sistema.

* **Escopo:** Um único contêiner.
* **Elementos primários:** Componentes dentro do contêiner no escopo.
* **Público alvo:** Arquitetos e desenvolvedores de software.
****

## Restrições e metas arquiteturais
* As tecnologias de desenvolvimento utilizadas são: 
  * Front-end: TypeScript associado aos frameworks React + NextJs.
  * Back-end: Java associado ao framework Spring boot.
* O projeto não possui nenhuma espécie de orçamento, tornando a aquisição de serviços de terceiros um custo pessoal, 
portanto os serviços utilizados devem ser gratuitos e o servidor pessoal ou da instituição;
* A aplicação será disponibilizada como página web.
* O sistema deve permanecer online 24 horas por dia, 7 dias por semana, com tolerância a interrupções de no máximo 2 horas
em situações excepcionais para manutenções ou atualizações planejadas.