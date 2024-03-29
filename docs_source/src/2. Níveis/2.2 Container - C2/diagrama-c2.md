Após compreender como o sistema de Atividades Complementares (ACs) se encaixa no ambiente geral de Tecnologia da 
Informação (TI), a próxima etapa consiste em ampliar os limites do sistema por meio de um diagrama de contêiner. 
Ao representar esses contêineres em um diagrama, é possível visualizar a estrutura e as interações entre eles. Isso 
proporciona uma visão clara da arquitetura do sistema, identificando os componentes principais e suas dependências. O 
diagrama de contêiner ajuda a compreender como essas entidades autônomas colaboram para fornecer funcionalidades do 
sistema de ACs e como se relacionam com outros sistemas e recursos de TI. Esse diagrama é uma ferramenta valiosa para
comunicar a arquitetura do sistema, permitindo que as equipes de desenvolvimento, gerentes de projeto e outras partes
interessadas tenham uma visão abrangente da estrutura do sistema e das tecnologias envolvidas. Ele serve como base para 
a análise, aprimoramento e manutenção contínua da arquitetura, facilitando o entendimento do sistema e auxiliando 
na tomada de decisões técnicas.

- **Escopo:** Um único sistema de software.
- **Elementos Principais:** Os componentes de contêineres contidos no sistema.
- **Público-Alvo:** Destinado a técnicos, tanto internos quanto externos à equipe de desenvolvimento de software,
incluindo arquitetos de software, desenvolvedores e membros da equipe de operações e suporte.
- **Observações:** Importante ressaltar que este diagrama não aborda tópicos relacionados a cenários de implantação,
clustering, replicação, failover, entre outros aspectos. Seu foco está na representação dos componentes de contêineres
e em suas interações dentro do sistema.

## Principais elementos
### Containers
* **Aplicação web:** 
  * A plataforma web foi desenvolvida utilizando o framework React e Next.js, juntamente com a linguagem TypeScript.
  * Ao utilizar o framework React, a plataforma se beneficia de uma arquitetura de componentes reutilizáveis, o que 
  facilita a criação e a manutenção de uma interface consistente e escalável. O Next.js oferece recursos avançados, como
  renderização do lado do servidor e roteamento simplificado, que aprimoram o desempenho e a experiência do usuário.
  * A integração com a API é essencial para garantir a funcionalidade completa da plataforma. Por meio de comunicação 
  eficiente com a API, a interface pode enviar e receber dados de forma transparente, permitindo que os usuários realizem
  ações e obtenham informações atualizadas em tempo real.
  * Essa abordagem de desenvolvimento, utilizando React, Next.js e TypeScript, resulta em uma plataforma web moderna,
  robusta e escalável, que oferece aos usuários uma experiência interativa e completa. A combinação dessas tecnologias
  possibilita a criação de interfaces de usuário atraentes e funcionais, ao mesmo tempo em que facilita a integração 
  eficiente com os dados do sistema.
* **API:**
  * A API de backend desempenha um papel central no sistema, sendo desenvolvida com as tecnologias Java e Spring Boot. 
  Essa combinação tecnológica é altamente adequada para lidar com o processamento de solicitações dos usuários, gerenciar
  a lógica de negócios e facilitar a integração com bancos de dados, sistemas externos e serviços.
  * Ao utilizar Java e Spring Boot, a API se beneficia de recursos avançados e padrões de desenvolvimento estabelecidos.
  O Java é uma linguagem amplamente adotada, conhecida por sua estabilidade, desempenho e suporte à orientação a objetos.
  O Spring Boot, por sua vez, é um framework que simplifica o desenvolvimento de aplicativos Java, oferecendo recursos 
  integrados, configuração automática e uma arquitetura baseada em convenções.
  * Essa escolha tecnológica permite que a API seja robusta, escalável e segura. O Java e o Spring Boot fornecem um 
  ambiente confiável para o processamento de solicitações, garantindo que o sistema possa lidar com um grande volume de
  tráfego e oferecer desempenho consistente. Além disso, o ecossistema do Spring Boot oferece recursos de segurança a
  brangentes, como autenticação e autorização, que podem ser facilmente implementados.
  * Por meio dessa combinação de Java e Spring Boot, a API de backend se torna uma solução eficiente e confiável para
  o sistema, capaz de atender às necessidades de processamento de dados, gerenciamento de lógica de negócios e integração
  com outros componentes do sistema.