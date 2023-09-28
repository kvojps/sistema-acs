# 1.1 Requisitos do Sistema

## Requisitos Funcionais

Os requisitos funcionais desempenham um papel fundamental no desenvolvimento de um sistema ou software, pois eles 
definem as funcionalidades e comportamentos esperados do sistema. Eles descrevem o que o sistema deve ser capaz de 
fazer, quais tarefas deve executar e como deve responder a determinados inputs do usuário ou do ambiente. O papel dos 
requisitos funcionais é estabelecer uma base clara para o projeto, implementação e teste do sistema. Eles servem como 
um contrato entre os stakeholders (partes interessadas) e os desenvolvedores, garantindo que todas as partes envolvidas
tenham uma compreensão comum das funcionalidades esperadas.

## Prioridade dos Requisitos

No processo de priorização dos requisitos, adotamos uma técnica baseada no uso de tags classificadoras, sendo elas: 
Alta, Média e Baixa. A prioridade alta é atribuída aos requisitos indispensáveis para o sistema. Esses requisitos são
essenciais e sua ausência resultaria na interrupção do funcionamento adequado do sistema, impedindo o cumprimento de
seus objetivos. Portanto, é imperativo que esses requisitos sejam implementados obrigatoriamente e de forma 
impreterível. A prioridade média é atribuída aos requisitos que são extremamente relevantes para o sistema. A ausência
desses requisitos não impede que o sistema seja executado, porém, pode resultar no cumprimento parcial de seus objetivos
ou procedimentos, geralmente de maneira insatisfatória. Esses requisitos devem ser implementados, mas caso não sejam, o
sistema pode ser implantado em sua forma atual. A prioridade baixa é atribuída aos requisitos que não comprometem as
funcionalidades básicas do sistema, permitindo sua execução de forma satisfatória. Esses requisitos podem ser deixados 
para versões futuras do software, sendo introduzidos como recursos adicionais em um pacote de atualização. Ao utilizar
essa técnica de classificação, é possível estabelecer uma hierarquia de importância para os requisitos, permitindo uma
melhor alocação de recursos e garantindo que os aspectos essenciais do sistema sejam tratados prioritariamente. Isso
ajuda a orientar o desenvolvimento de acordo com as necessidades críticas do projeto, enquanto permite o planejamento
de implementações futuras para requisitos de menor prioridade.

## Requisitos Não Funcionais

Os requisitos não funcionais fornecem diretrizes e critérios para avaliar a qualidade do sistema ou software, além de
definir os padrões e metas a serem alcançados em relação a essas características. Eles desempenham um papel fundamental
na satisfação dos usuários finais, garantindo que o sistema ou software atenda aos requisitos e expectativas não apenas
em termos de funcionalidade, mas também em relação a outros atributos que afetam sua usabilidade, desempenho e segurança.

### Desempenho

A velocidade de resposta, a capacidade de processamento e a eficiência são fatores críticos que influenciam diretamente 
a experiência do usuário e o sucesso de um sistema. Logo, os requisitos abaixo definem as métricas de desempenho que 
deverão ser atingidas para alcançar uma boa usabilidade e experiência do usuário.

#### RNF 001 - Tempo de Resposta
- **Descrição**: O aplicativo deve apresentar tempos de resposta inferiores a 1000 ms, garantindo um carregamento rápido.
- **Prioridade**: Alta.

#### RNF 002 - Usuários Online
- **Descrição**: O aplicativo deve ser altamente eficiente e capaz de gerenciar até 100 usuários online simultaneamente,
proporcionando uma experiência fluída e sem interrupções para todos os usuários.
- **Prioridade**: Alta.

### Disponibilidade

A disponibilidade é um fator crítico para a confiabilidade e eficácia de um sistema, especialmente em ambientes onde a 
interrupção de serviços pode resultar em perdas financeiras, danos à reputação e insatisfação dos usuários. Os requisitos
a seguir estabelecem métricas que determinam o nível de disponibilidade do sistema, ou seja, a capacidade do sistema de
estar prontamente disponível para executar um serviço solicitado por um usuário.

#### RNF 003 - Período Ativo
- **Descrição**: O aplicativo deve permanecer online 24 horas por dia, 7 dias por semana, com tolerância a interrupções
de no máximo 2 horas em situações excepcionais para manutenções ou atualizações planejadas.
- **Prioridade**: Média.

### Hardware

É fundamental considerar as características e limitações do hardware que será utilizado, para permitir que os 
desenvolvedores entendam claramente quais requisitos são necessários para garantir o desempenho, a compatibilidade e a 
estabilidade do sistema.

#### RNF 004 - Compatibilidade
- **Descrição**: Para o perfeito funcionamento do sistema, é necessário apenas possuir um navegador com acesso à 
internet. Essa simplicidade na exigência de recursos garante que o aplicativo seja facilmente acessível e utilizado por
uma ampla variedade de usuários.
- **Prioridade**: Alta.

### Segurança

São descritas as medidas necessárias para proteger o sistema contra ameaças internas e externas, garantindo a 
confidencialidade, integridade e disponibilidade dos dados. Com isso, garantir que os desenvolvedores compreendam 
claramente os desafios e requisitos de segurança envolvidos no projeto, fornecendo diretrizes claras para a 
implementação de medidas de proteção eficazes.

#### RNF 005 - Criptografia
- **Descrição**: O sistema deve priorizar a segurança dos dados e a proteção da privacidade dos usuários, adotando o uso
do protocolo HTTPS (Hyper Text Transfer Protocol Secure) como uma camada de criptografia confiável. Ao utilizar o 
HTTPS, todas as informações transmitidas entre o aplicativo e os usuários serão criptografadas, garantindo a 
confidencialidade e a integridade dos dados durante a comunicação.
- **Prioridade**: Baixa.

#### RNF 006 - Autenticação
- **Descrição**: O usuário deve ser capaz de realizar  login pelo próprio sistema utilizando a lógica de autenticação 
com Spring Security e JWT.
- **Prioridade**: Alta.

### Documentação

A documentação de sistemas desempenha um papel fundamental no desenvolvimento, implementação e manutenção eficazes de um
software ou sistema. A importância de documentar sistemas reside em fornecer um registro completo e estruturado de 
informações essenciais sobre o sistema, suas funcionalidades, configurações, requisitos, fluxos de trabalho e outras 
características relevantes.

#### RNF 007 - Documentação de APIs REST
- **Descrição**: É fundamental que o endpoint do aplicativo seja cuidadosamente documentado, a fim de facilitar 
integrações futuras com outros sistemas e permitir correções eficientes de implementações no front-end. Nesse sentido,
o uso da ferramenta Swagger desempenha um papel crucial. O Swagger proporciona uma abordagem estruturada e padronizada
para documentação de API, permitindo que os desenvolvedores compreendam facilmente a funcionalidade e os parâmetros do
endpoint.
- **Prioridade**: Alta.
