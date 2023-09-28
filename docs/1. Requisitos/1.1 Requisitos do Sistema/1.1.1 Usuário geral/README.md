# 1.1.1 Usuário geral

`/1. Requisitos/1.1 Requisitos do Sistema/1.1.1 Usuário geral`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [**1.1.1 Usuário geral**](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
    * [1.2 Requisitos Arquiteturais](../../../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1 Back](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1%20Back/README.md)
      * [2.3.2 Front](../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.2%20Front/README.md)
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
  * [4. Apêndices](../../../4.%20Ap%C3%AAndices/README.md)
    * [4.1 Reuniões](../../../4.%20Ap%C3%AAndices/4.1%20Reuni%C3%B5es/README.md)

---

## RF 001 - Realizar Cadastro Via Sistema
- **Descrição**: Um usuário deve ser capaz de se cadastrar no sistema, sendo importante destacar que, após o cadastro, 
o perfil do usuário é automaticamente definido como "aluno".
- **Atores**: Nenhum.
- **Prioridade**: Média.
- **Entrada**: Nome completo, CPF, matrícula, período, telefone, e-mail, senha, curso, CEP, complemento e número. 
A partir do CEP, espera-se que o sistema preencha automaticamente os campos de rua, bairro, cidade e estado (UF).
- **Pré-condições**: Fornecer um e-mail institucional válido, matrícula e período válidos. A senha deve conter 8 
caracteres, incluindo letras maiúsculas, minúsculas, caracteres especiais e números.
- **Saída**: Retorna os dados do usuário.
- **Pós-condições**: O usuário é redirecionado para a tela de login para efetuar o primeiro acesso.

## RF 002 - Realizar Login Via Sistema
- **Descrição**: Um usuário deve ser capaz de efetuar login no sistema.
- **Atores**: Usuário geral.
- **Prioridade**: Média.
- **Entrada**: E-mail e senha.
- **Pré-condições**: O usuário deve estar cadastrado.
- **Saída**: Retorna um token JWT do usuário.
- **Pós-condições**: O usuário é direcionado para a tela inicial do sistema após um login bem-sucedido.

## RF 003 - Sair do Sistema
- **Descrição**: O usuário deve ser capaz de sair do sistema.
- **Atores**: Usuário geral.
- **Prioridade**: Baixa.
- **Entrada**: Selecionar o botão de logoff na tela inicial do sistema.
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Não gera saída.
- **Pós-condições**: O usuário é redirecionado para a tela de login.

## RF 004 - Verificar Conta de Usuário Institucional
- **Descrição**: O usuário deve realizar um processo de verificação, no qual receberá um código via e-mail para 
confirmar se a conta é de fato uma conta institucional válida.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir o código recebido por e-mail na seção de verificação do usuário.
- **Pré-condições**: O usuário deve estar não verificado e deve estar logado.
- **Saída**: Não gera saída.
- **Pós-condições**: O usuário é redirecionado para a tela inicial do sistema após a verificação bem-sucedida.

## RF 005 - Alterar Senha
- **Descrição**: O usuário deve ser capaz de alterar sua própria senha.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir a senha antiga e a nova senha.
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Não gera saída.
- **Pós-condições**: O usuário recebe uma mensagem confirmando a alteração bem-sucedida da senha.

## RF 006 - Recuperar Senha
- **Descrição**: O usuário deve ser capaz de recuperar sua senha.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir o e-mail.
- **Pré-condições**: O usuário recebe um link de recuperação de senha por e-mail.
- **Saída**: Não gera saída.
- **Pós-condições**: O usuário recebe uma mensagem confirmando a alteração bem-sucedida da senha.

## RF 007 - Consultar Dados do Próprio Usuário
- **Descrição**: O usuário deve ser capaz de visualizar todos os seus dados, incluindo nome completo, CPF, matrícula, 
período, telefone, e-mail, senha, status de verificação, curso, período e endereço.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Não requer entrada de dados.
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Retorna os dados do usuário.
- **Pós-condições**: O usuário é direcionado para a página de perfil.

## RF 008 - Editar Dados do Próprio Usuário
- **Descrição**: O usuário deve ser capaz de editar seus dados, com exceção do e-mail, matrícula e CPF.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir os dados a serem alterados (nome completo, período, telefone, curso e endereço).
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Não gera saída.
- **Pós-condições**: O usuário recebe uma mensagem confirmando a alteração bem-sucedida dos dados.

## RF 009 - Apagar Dados do Usuário
- **Descrição**: O usuário deve ser capaz de solicitar a exclusão de todos os seus dados do sistema, desde que não 
tenha nenhuma requisição cadastrada. Caso contrário, a conta é apenas desativada.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir a senha do usuário para confirmar a exclusão.
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Não gera saída.
- **Pós-condições**: O usuário é redirecionado para a tela de login do sistema.
