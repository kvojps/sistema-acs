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

---

O aluno possui acesso ao sistema para enviar requisições juntamente com suas atividades complementares. Além de obter informações sobre o progresso da validação da sua requisição, permitindo que você acompanhe em qual etapa do processo ela se encontra.

| RF 011 - Cadastrar requisição                                                                                                                                                                     |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de cadastrar uma requisição com o intuito de ratificar uma determinada quantidade de horas das suas atividades complementares.                            |
| **Atores:** Aluno.                                                                                                                                                                                |
| **Prioridade:** Alta.                                                                                                                                                                             |
| **Entrada:** Inserir informações da requisição, como semestre e quantidade de certificados. Para cada certificado, fornecer título, descrição, data, horas, atividade e o arquivo no formato PDF. |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                   |
| **Saída:** Confirmação do envio da requisição.                                                                                                                                                    |
| **Pós-condições:** O usuário é redirecionado para a tela específica da requisição enviada, e a coordenação recebe a notificação por e-mail.                                                       |

| RF 012 - Consultar lista de requisições                                                                               |
| --------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar sua lista de requisições.                                       |
| **Atores:** Aluno.                                                                                                    |
| **Prioridade:** Alta.                                                                                                 |
| **Entrada:** Não possui entradas.                                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                                       |
| **Saída:** Não possui saídas.                                                                                         |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada. |

| RF 013 - Buscar requisição específica                                               |
| ----------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar uma requisição específica.    |
| **Atores:** Aluno.                                                                  |
| **Prioridade:** Média.                                                              |
| **Entrada:** Não possui entradas.                                                   |
| **Pré-condições:** O usuário deve estar logado.                                     |
| **Saída:** Não possui saídas.                                                       |
| **Pós-condições:** O usuário é redirecionado para a tela da requisição selecionada. |

| RF 014 - Receber alerta após mudança de status de uma requisição                                               |
| -------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve receber um alerta via e-mail após haver uma mudança no status da requisição.     |
| **Atores:** Aluno.                                                                                             |
| **Prioridade:** Alta.                                                                                          |
| **Entrada:** Não possui entradas.                                                                              |
| **Pré-condições:** Quando o status de uma requisição associada a um determinado aluno for alterada.            |
| **Saída:** Não possui saídas.                                                                                  |
| **Pós-condições:** O usuário recebe um e-mail com as informações daquela requisição e o seu respectivo status. |

| RF 015 - Baixar arquivo PDF referente à requisição                                                       |
| -------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter a opção de fazer o download da requisição em formato PDF.              |
| **Atores:** Aluno.                                                                                       |
| **Prioridade:** Baixa.                                                                                   |
| **Entrada:** Não possui entradas.                                                                        |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF. |
| **Saída:** Confirmação do download do arquivo.                                                           |
| **Pós-condições:** O usuário vê o arquivo baixado na pasta selecionada.                                  |

| RF 016 - Visualizar indicadores sobre as requisições enviadas |
| ------------------------------------------------------------- |
| **Descrição:** Em construção.                                 |
| **Atores:** Aluno.                                            |
| **Prioridade:** Média.                                        |
| **Entrada:** Em construção.                                   |
| **Pré-condições:** Em construção.                             |
| **Saída:** Em construção.                                     |
| **Pós-condições:** Em construção.