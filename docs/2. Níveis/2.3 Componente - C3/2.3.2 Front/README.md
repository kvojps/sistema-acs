# 2.3.2 Front

`/2. Níveis/2.3 Componente - C3/2.3.2 Front`

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
      * [**2.3.2 Front**](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.2%20Front/README.md)
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

1. **Não está sendo utilizada a arquitetura de app router:**
  - Mesmo com a adoção da versão 13, a arquitetura de app router não está em uso, a qual, por padrão, emprega componentes
de servidor.
  - Em vez disso, está sendo empregada a arquitetura de pages router.

   ![Imagem](https://i.imgur.com/TX6QvBB.png)

2. **Foi decidido utilizar o Tailwind em vez do Styled Components, devido a problemas de SSR, nos quais o estilo era a
plicado somente após a renderização da página.**
3. **A organização das pastas atualmente está dividida da seguinte forma:**
  - `components`:
    - São armazenados componentes que podem ser reutilizados por outras páginas.
  - `context`:
    - Este diretório é reservado para separar os hooks de useContext.
  - `functions`:
    - Aqui se encontram funções auxiliares utilizadas para fins de utilidade, como formatação de data, truncamento de 
  texto, entre outros.
  - `pages`:
    - Neste diretório são definidas as rotas; cada pasta é considerada um diretório de URL, por exemplo, 
    [localhost/dashboard](http://localhost/dashboard), e, portanto, o nome da pasta é `dashboard`.

![Imagem](https://i.imgur.com/qRFYLZA.png)

1. **A ideia por trás dessa nova arquitetura é permitir que ela evolua de acordo com as necessidades do projeto, 
contribuindo para a redução da complexidade no processo de desenvolvimento.**
  - É recomendável que a comunicação entre as pastas siga o seguinte padrão: o contexto se comunica exclusivamente com 
as páginas, as funções se comunicam apenas com os componentes, e os componentes se relacionam com ambas as páginas e funções.

   ![Imagem](https://i.imgur.com/Xx4XiFi.png)

  - As boas práticas continuam inalteradas.
  - Deve-se prestar atenção às convenções de nomenclatura ao criar diretórios/arquivos.
    - Camel Case será utilizado nas pastas de functions, lib, services, styles e types. Um exemplo de função seria 
  `converterHoraMs()`.
    - Pascal Case será utilizado para nomear componentes, como um componente de formulário chamado `FormLogin`.
    - Snake Case será empregado em casos de declaração de variáveis de ambiente, tais como `API_URL` e `KEY_JWT`.
  - **NÃO REPRODUZA ELEMENTOS JÁ EXISTENTES:**
    - Existem componentes padronizados para todo o sistema, portanto, não há necessidade de recriar o que já está 
    disponível. Por exemplo, se já existe um componente de `input`, não é necessário criar um novo.
    - Em situações excepcionais de recriação, isso deve ser comunicado.
  - Sempre avalie a necessidade de criar um novo componente e adotaremos o conceito de 
[componentes atômicos](https://atomicdesign.bradfrost.com/chapter-2/#:~:text=Atoms%20are%20the%20basic%20building,are%20the%20smallest%20functional%20unit.).
  - Utilize adequadamente as estruturas de pastas. Se houver uma pasta específica para realizar requisições, evite fazer
uma requisição diretamente no componente/página.
  - A linguagem a ser utilizada será o inglês, a fim de evitar confusões para os desenvolvedores, visto que os hooks e 
alguns códigos de biblioteca são convencionalmente em inglês.
  - Adote commits convencionais (conventional commits).
