# 1.2 Requisitos Arquiteturais

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
