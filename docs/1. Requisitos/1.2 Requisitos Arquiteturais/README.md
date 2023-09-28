# 1.2 Requisitos Arquiteturais

`/1. Requisitos/1.2 Requisitos Arquiteturais`

* [Sistema ACS | Docs](../../README.md)
  * [1. Requisitos](../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
    * [**1.2 Requisitos Arquiteturais**](../../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
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

## RA 001 - Fluxo de Requisição

- **Referência:** RF 011, 012, 013, 014, 018.
- **Descrição:** Este requisito desempenha um papel fundamental na arquitetura, pois é responsável pelo encaminhamento 
das solicitações que envolvem alunos, coordenação e comissão.
- **Prioridade:** Essencial.
- **Decisão Arquitetural:** Utilização de estratégias no backend para realizar o fluxo de cadastro e avaliação da 
requisição.
- **Atributo de Qualidade:** Performance.

## RA 002 - Desempenho

- **Referência:** RNF 001, 002.
- **Descrição:** Este requisito tem um impacto significativo na percepção das informações e no carregamento de telas 
pelo usuário.
- **Prioridade:** Importante.
- **Decisão Arquitetural:** Utilização de estratégias no backend e frontend para evitar o carregamento de informações 
desnecessárias que podem aumentar o tempo de resposta.
- **Atributo de Qualidade:** Performance.

## RA 003 - Disponibilidade

- **Referência:** RNF 003.
- **Descrição:** Este requisito influencia diretamente a disponibilidade do sistema para que os usuários possam realizar
suas atividades.
- **Prioridade:** Essencial.
- **Decisão Arquitetural:** Utilização de servidor pessoal de um dos membros da equipe para disponibilizar a API.
- **Atributo de Qualidade:** Disponibilidade.

## RA 004 - Segurança

- **Referência:** RNF 005, 006.
- **Descrição:** Este requisito desempenha um papel fundamental na segurança do sistema, sendo crucial para preservar a 
privacidade dos usuários e garantir sua segurança.
- **Prioridade:** Importante.
- **Decisão Arquitetural:** Utilização do protocolo HTTPS (Hyper Text Transfer Protocol Secure) e 
autenticação/autorização via sistema e OAuth2.
- **Atributo de Qualidade:** Segurança.

## RA 005 - Documentação

- **Referência:** RNF 007.
- **Descrição:** Este requisito tem um impacto significativo na capacidade de realizar manutenções no sistema, sendo 
essencial para um bom entendimento do webservice.
- **Prioridade:** Importante.
- **Decisão Arquitetural:** Utilização da ferramenta Swagger para gerar documentação dos endpoints da API.
- **Atributo de Qualidade:** Manutenabilidade.
