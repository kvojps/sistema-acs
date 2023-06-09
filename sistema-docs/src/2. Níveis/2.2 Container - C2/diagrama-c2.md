Após compreender como o sistema de ACs (Atividades complementares) se encaixa no ambiente geral de TI, a próxima etapa consiste em expandir os limites do sistema por meio de um diagrama de contêiner. Um "contêiner" pode ser entendido como uma entidade autônoma, como um aplicativo da web do lado do servidor, um aplicativo de página única, um aplicativo desktop, um aplicativo móvel, um esquema de banco de dados, um sistema de arquivos ou uma API, entre outros exemplos. Em essência, um contêiner é uma unidade executável ou implantável independente que opera em seu próprio espaço de processo, executando código ou armazenando dados.

O diagrama de contêiner ilustra a arquitetura de software de forma abrangente, demonstrando a distribuição das responsabilidades. Além disso, destaca as principais tecnologias utilizadas e a comunicação entre os contêineres. Trata-se de um diagrama simples e de alto nível, como foco na tecnologia, sendo uma ferramenta valiosa tanto para desenvolvedores de software quanto para equipes de suporte e operações.

* **Escopo:** Um único sistema de software.
* **Elementos primários:** Contêineres dentro do sistema de software no escopo.
* **Público alvo:** Técnicos dentro e fora da equipe de desenvolvimento de software, incluindo arquitetos de software, desenvolvedores e equipe de operações/suporte.
* **Observações:** Este diagrama não diz nada sobre cenários de implantação, clustering, replicação e failover etc.

## Principais elementos
### Containers
* **Aplicação web:** A plataforma web foi desenvolvida utilizando o framework React e Next.js associado a linguagem TypeScript. Essa plataforma oferece aos usuários uma interface interativa que permite a interação com todas as funcionalidades do sistema. Para isso, ela se conecta e se comunica com a API, garantindo uma integração eficiente entre a interface e os dados.
* **API:** A API de backend representa o componente central do sistema, sendo desenvolvida com Java e Spring Boot. Essa combinação tecnológica permite o processamento de solicitações dos usuários, gerenciamento da lógica de negócios e integração com bancos de dados, sistemas externos e serviços. Através do uso do Java e Spring Boot, a API aproveita recursos avançados e padrões de desenvolvimento para garantir a robustez, escalabilidade e segurança necessárias, resultando em uma solução eficiente para o sistema.