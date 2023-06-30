| RF 001 - Realizar cadastro via sistema                                                                                                                            |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:**   Um usuário deve ser capaz de realizar cadastro no sistema, vale ressaltar que para todo cadastro feito é atribuído ao usuário o perfil de aluno. |
| **Atores:**   Nenhum.                                                                                                                                             |
| **Prioridade:**   Média.                                                                                                                                          |
| **Entrada:**  Inserir nome completo, período, telefone, email, senha, cep, rua, bairro, cidade, UF, número.                                                       |
| **Pré-condições:** Cadastar-se com email institucional, senha com 8 ou mais caracteres incluindo caracteres especiais, letras maiúsculas e minúsculas.            |
| **Saída:** Confirmação de cadastro.                                                                                                                               |
| **Pós-condições:** O usuário será direcionado para a tela de perfil para certificar que é membro da instituição, passando por um processo de verificação.         |

| RF 002 - Realizar login via sistema                                                                                                      |
| ---------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** Um usuário deve ser capaz de realizar login via sistema.                                                                  |
| **Atores:** Usuário geral.                                                                                                               |
| **Prioridade:** Média.                                                                                                                   |
| **Entrada:** Inserir e-mail e senha.                                                                                                     |
| **Pré-condições:** O usuário deve estar cadastrado.                                                                                      |
| **Saída:** Confirmação de login.                                                                                                         |
| **Pós-condições:** O usuário será direcionado para a tela inicial do sistema, caso informe as credenciais corretamente (e-mail e senha). |

| RF 003 - Realizar login via Google                                                                                                     |
| -------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de fazer login no aplicativo utilizando o serviço de SSO (Single Sign-On) do Google, o OAuth2. |
| **Atores:** Nenhum.                                                                                                                    |
| **Prioridade:** Baixa.                                                                                                                 |
| **Entrada:** Selecionar a conta do Google.                                                                                             |
| **Pré-condições:** Possuir uma conta Google.                                                                                           |
| **Saída:** Confirmação de login.                                                                                                       |
| **Pós-condições:** O usuário será direcionado para a tela de perfil para completar os dados de cadastro.                               |

| RF 004 - Sair do sistema                                                       |
| ------------------------------------------------------------------------------ |
| **Descrição:** O usuário deve ser capaz de sair do sistema.                    |
| **Atores:** Usuário geral.                                                     |
| **Prioridade:** Baixa.                                                         |
| **Entrada:** Selecionar o botão de logoff presente na tela inicial do sistema. |
| **Pré-condições:** O usuário deve estar logado.                                |
| **Saída:** Confirmação de logoff.                                              |
| **Pós-condições:** O usuário será direcionado para a tela de login.            |

| RF 005 - Verificar usuário institucional                                                                                                                   |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve realizar o processo de verificação, o qual receberá um token via e-mail para confirmar se é uma conta institucional própria. |
| **Atores:** Usuário geral.                                                                                                                                 |
| **Prioridade:** Alta.                                                                                                                                      |
| **Entrada:** Inserir token recebido por e-mail.                                                                                                            |
| **Pré-condições:** O usuário não pode ser verificado e deve estar logado.                                                                                  |
| **Saída:** Saídas: Confirmação da verificação institucional do usuário.                                                                                    |
| **Pós-condições:** O usuário será direcionado para a tela inicial do sistema.                                                                              |

| RF 006 - Alterar senha                                                                            |
| ------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de alterar sua própria senha.                             |
| **Atores:** Usuário geral.                                                                        |
| **Prioridade:** Baixa.                                                                            |
| **Entrada:** Inserir a senha antiga para ser possível realizar a alteração da nova senha.         |
| **Pré-condições:** O usuário deve estar logado.                                                   |
| **Saída:** Confirmação da alteração da senha.                                                     |
| **Pós-condições:** O usuário recebe uma mensagem informando que a senha foi alterada com sucesso. |

| RF 007 - Recuperar senha                                                                          |
| ------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de recuperar sua senha.                                   |
| **Atores:** Usuário geral.                                                                        |
| **Prioridade:** Baixa.                                                                            |
| **Entrada:** Recuperar senha.                                                                     |
| **Pré-condições:** Recebe o link de recuperação de senha por e-mail.                              |
| **Saída:** Confirmação da alteração da senha.                                                     |
| **Pós-condições:** O usuário recebe uma mensagem informando que a senha foi alterada com sucesso. |

| RF 008 - Consultar dados do próprio usuário                                                                                                                                                                  |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Descrição:** O usuário deve ser capaz de visualizar todos os seus dados. Sendo possível visualizar o nome completo, cpf, período, telefone, e-mail, senha oculta, status de verificação, curso e endereço. |
| **Atores:** Usuário geral.                                                                                                                                                                                   |
| **Prioridade:** Baixa.                                                                                                                                                                                       |
| **Entrada:** Não possui entradas.                                                                                                                                                                            |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                              |
| **Saída:** Não possui saídas.                                                                                                                                                                                |
| **Pós-condições:** O usuário é direcionado para a página de perfil.                                                                                                                                          |

| RF 009 - Editar dados do próprio usuário                                                                |
| ------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de editar seus dados exceto e-mail, matrícula e CPF.            |
| **Atores:** Usuário geral.                                                                              |
| **Prioridade:** Baixa.                                                                                  |
| **Entrada:** Inserir dados a serem alterados.                                                           |
| **Pré-condições:** O usuário deve estar logado.                                                         |
| **Saída:** Confirmação da alteração dos dados.                                                          |
| **Pós-condições:** O usuário recebe uma mensagem informando que seus dados foram alterados com sucesso. |

| RF 010 - Apagar dados do usuário                                                                        |
| ------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de solicitar que todos os seus dados sejam apagados do sistema. |
| **Atores:** Usuário geral.                                                                              |
| **Prioridade:** Média.                                                                                  |
| **Entrada:** Inserir senha do usuário para confirmação da exclusão.                                     |
| **Pré-condições:** O usuário deve estar logado.                                                         |
| **Saída:** Confirmação da exclusão dos dados.                                                           |
| **Pós-condições:** O usuário é redirecionado para a tela de login do sistema.                           |                             |