# 1.1.1 Usuário geral

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
                          