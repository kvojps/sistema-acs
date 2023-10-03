# 2.3.2 Front

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
