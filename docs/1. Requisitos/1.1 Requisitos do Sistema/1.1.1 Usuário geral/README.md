# 1.1.1 Usuário geral

`/1. Requisitos/1.1 Requisitos do Sistema/1.1.1 Usuário geral`

* [Sistema ACS | Docs](../../../README.md)
  * [1. Requisitos](../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [**1.1.1 Usuário geral**](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
      * [1.1.3 Coordenação](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.3%20Coordena%C3%A7%C3%A3o/README.md)
      * [1.1.4 Comissão](../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.4%20Comiss%C3%A3o/README.md)
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

## RF 001 - Realizar cadastro via sistema
- **Descrição**: Um usuário deve ser capaz de realizar cadastro no sistema, vale ressaltar que para todo cadastro feito 
é atribuído ao usuário o perfil de aluno.
- **Atores**: Nenhum.
- **Prioridade**: Média.
- **Entrada**: Inserir nome completo, CPF, matrícula, período, telefone, email, senha, curso, cep, complemento e número. 
A partir do Cep é esperado que o sistema complete os dados rua, bairro, cidade e uf.
- **Pré condições**: Inserir e-mail institucional, matrícula e período válidos. A senha deve conter 8 caracteres
incluindo maiúsculos, minúsculos, especial e numérico.
- **Saída**: Retornar os dados do usuário.
- **Pós-condições**: O usuário será redirecionado para a tela de login, para realizar o primeiro login.

## RF 002 - Realizar login via sistema
- **Descrição**: Um usuário deve ser capaz de realizar login no sistema.
- **Atores**: Usuário geral.
- **Prioridade**: Média.
- **Entrada**: Inserir e-mail e senha.
- **Pré-condições**: O usuário deve estar cadastrado.
- **Saída**: Retornar token JWT do usuário.
- **Pós-condições**: O usuário será direcionado para a tela inicial do sistema após login bem-sucedido.

## RF 003 - Sair do sistema
- **Descrição**: O usuário deve ser capaz de sair do sistema.
- **Atores**: Usuário geral.
- **Prioridade**: Baixa.
- **Entrada**: Selecionar o botão de logoff presente na tela inicial do sistema.
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Não há saída.
- **Pós-condições**: O usuário será direcionado para a tela de login.

## RF 004 - Verificar usuário institucional
- **Descrição**: O usuário deve realizar o processo de verificação, o qual receberá um código via e-mail para confirmar 
se é uma conta institucional própria.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir código recebido por e-mail na seção de verificação do usuário.
- **Pré-condições**: O usuário não pode ser verificado e deve estar logado.
- **Saída**: Não há saída.
- **Pós-condições**: O usuário será direcionado para a tela inicial do sistema.

## RF 005 - Alterar senha
- **Descrição**: O usuário deve ser capaz de alterar sua própria senha.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir a senha antiga e a nova.
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Não há saída.
- **Pós-condições**: O usuário recebe uma mensagem informando que a senha foi alterada com sucesso.

## RF 006 - Recuperar senha
- **Descrição**: O usuário deve ser capaz de recuperar sua senha.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir e-mail.
- **Pré-condições**: Recebe o link de recuperação de senha por e-mail.
- **Saída**: Não há saída.
- **Pós-condições**: O usuário recebe uma mensagem informando que a senha foi alterada com sucesso.

## RF 007 - Consultar dados do próprio usuário
- **Descrição**: O usuário deve ser capaz de visualizar todos os seus dados. Sendo possível visualizar o nome completo,
cpf, matrícula, período, telefone, e-mail, senha, status de verificação, curso, período e endereço.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Não possui entradas.
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Retornar os dados do usuário.
- **Pós-condições**: O usuário é direcionado para a página de perfil.

## RF 008 - Editar dados do próprio usuário
- **Descrição**: O usuário deve ser capaz de editar seus dados exceto e-mail, matrícula e CPF.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir dados a serem alterados (nome completo, período, telefone, curso e endereço).
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Não há saída.
- **Pós-condições**: O usuário recebe uma mensagem informando que os seus dados foram alterados com sucesso.

## RF 009 - Apagar dados do usuário
- **Descrição**: O usuário deve ser capaz de solicitar que todos os seus dados sejam apagados do sistema, apenas é
possível se não possuir nenhuma requisição cadastrada, caso contrário a conta é apenas desativada.
- **Atores**: Usuário geral.
- **Prioridade**: Alta.
- **Entrada**: Inserir senha do usuário para confirmação da exclusão.
- **Pré-condições**: O usuário deve estar logado.
- **Saída**: Não há saída.
- **Pós-condições**: O usuário é redirecionado para a tela de login do sistema.
                          