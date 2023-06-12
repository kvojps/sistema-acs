## Requisitos funcionais

| **RF 001** | Realizar cadastro via sistema |
|----------|----------|
| **Descrição**  | Um usuário deve ser capaz de realizar cadastro no sistema, vale ressaltar que para todo cadastro feito é atribuído ao usuário o perfil de aluno. |
| **Atores**  | Nenhum.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: Nome completo, periodo, telefone, email, senha, cep, rua, bairro, cidade, UF, numero; Pré-condições: Email institucional, senha com 8 ou mais caracteres incluindo caracteres especiais, letras maiúsculas e minúsculas.   |
| **Saída e pós-condições**  | Saídas: Confirmação de cadastro; Pós-condições: O usuário será direcionado para tela perfil para certificar que é membro da instituição após um processo de verificação. |

| **RF 002** | Realizar login via sistema |
|----------|----------|
| **Descrição**  | Um usuário deve ser capaz de realizar login via sistema. Após a realização do login é retornado um JWT que identifica o usuário.|
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: E-mail e senha; Pré-condições: O usuário deve estar cadastrado.   |
| **Saída e pós-condições**  | Saídas: Confirmação de login; Pós-condições: O usuário será direcionado para tela inicial.  |

| **RF 003** | Realizar login via google |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de fazer login no aplicativo utilizando o serviço de SSO (Single Sign-On) do Google, o OAuth2.|
| **Atores**  | Nenhum.  |
| **Prioridade**  | Baixa.  |
| **Entrada e pré-condições**  | Entradas: Selecionar a conta do google; Pré-condições: Possuir uma conta google.  |
| **Saída e pós-condições**  | Saídas: Confirmação de login; Pós-condições: O usuário será direcionado para tela de perfil para completar os dados de cadastro.  |

| **RF 004** | Sair do sistema |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de sair do sistema.|
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Baixa.  |
| **Entrada e pré-condições**  | Entradas: Selecionar botão de logoff presente na tela inicial do sistema; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Confirmação de logoff; Pós-condições: O usuário será direcionado para tela de login.  |

| **RF 005** | Verificar usuário institucional |
|----------|----------|
| **Descrição**  | O usuário deve realizar o processo de verificação, o qual receberá um token via e-mail para confirmar se é uma conta institucional própria.|
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: Inserir token recebido por e-mail; Pré-condições: O usuário não pode ser verificado e deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Confirmação da verificação institucional do usuário; Pós-condições: O usuário será direcionado para tela inicial do sistema.  |

| **RF 006** | Alterar senha |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de alterar sua própria senha.|
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Baixa.  |
| **Entrada e pré-condições**  | Entradas: Inserir a senha antiga para ser possível realizar alteração da nova senha; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Confirmação da alteração da senha; Pós-condições: O usuário recebe uma mensagem informando que a senha foi alterada com sucesso.  |

| **RF 007** | Recuperar senha |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de recuperar sua senha.|
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Baixa.  |
| **Entrada e pré-condições**  | Entradas: Inserir nova senha; Pré-condições: O usuário deve estar logado e recebe o link de recuperação de senha por e-mail.  |
| **Saída e pós-condições**  | Saídas: Confirmação da alteração da senha; Pós-condições: O usuário recebe uma mensagem informando que a senha foi alterada com sucesso.  |

| **RF 008** | Consultar dados do próprio usuário |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de visualizar todos os seus dados. Sendo possível visualizar o nome completo, cpf, período, telefone, e-mail, senha oculta, status de verificação, curso e endereço.|
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Baixa.  |
| **Entrada e pré-condições**  | Entradas: Não possui entradas; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Não possuí saídas; Pós-condições: O usuário é direcionado para página de perfil.  |

| **RF 009** | Editar dados do próprio usuário |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de editar seus dados exceto e-mail, matrícula e CPF.|
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Baixa.  |
| **Entrada e pré-condições**  | Entradas: Inserir dados a serem alterados; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Confirmação da alteração dos dados; Pós-condições: O usuário recebe uma mensagem informando que seus dados foram alterados com sucesso.  |

| **RF 010** | Solicitar apagar dados do usuário |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de solicitar que todos os seus dados sejam apagados do sistema.|
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: Inserir senha do usuário para confirmação da exclusão; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Confirmação da exclusão dos dados; Pós-condições: O usuário é redirecionado para a tela de login do sistema.  |

### Perfil Aluno

| **RF 011** | Cadastrar requisição |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de cadastrar uma requisição com o intuito de ratificar uma determinada quantidade de horas das suas atividades complementares. |
| **Atores**  | Aluno.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: É necessário inserir informações da requisição como o semestre e a quantidade de certificados. Para cada certificado é necessário informar título, descrição, data, horas e a atividade. Além dessas informações é necessário enviar os arquivos de certificados.o; Pré-condições: O usuário deve deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Confirmação da envio da requisição; Pós-condições: O usuário é redirecionado para a tela específica da requisição enviada e a coordenação recebe a notificação por e-mail.  |

| **RF 012** | Consultar lista de requisições |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de visualizar sua lista de requisições.|
| **Atores**  | Aluno.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: Não possui entradas; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Não possuí saídas; Pós-condições: Caso selecione alguma requisição, o usuário é redirecionado para tela de requisição selecionada.  |

| **RF 013** | Buscar requisição específica |
|----------|----------|
| **Descrição**  | O usuário deve ser capaz de visualizar uma requisição em específico.|
| **Atores**  | Aluno.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: Não possui entradas; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Não possuí saídas; Pós-condições: O usuário é redirecionado para tela de requisição selecionada.  |

| **RF 014** | Receber alerta após mudança de status de uma requisição |
|----------|----------|
| **Descrição**  | O usuário deve receber um alerta via e-mail após haver uma mudança no status da requisição.|
| **Atores**  | Aluno.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: Não possui entradas; Pré-condições: Quando o status de uma requisição associada a um determinado aluno for alterada.  |
| **Saída e pós-condições**  | Saídas: Não possuí saídas; Pós-condições: O usuário recebe um e-mail com as informações daquela requisição e o seu respectivo status.  |

| **RF 015** | Baixar arquivo PDF referente à requisição |
|----------|----------|
| **Descrição**  | O usuário deve ter a opção de fazer o download da requisição em formato PDF. |
| **Atores**  | Aluno.  |
| **Prioridade**  | Baixa.  |
| **Entrada e pré-condições**  | Entradas: Não possui entradas; Pré-condições: O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF.  |
| **Saída e pós-condições**  | Saídas: Confirmação do download do arquivo; Pós-condições: O usuário vê o arquivo baixado na pasta selecionada.  |

| **RF 016** | Visualizar indicadores sobre as requisições enviadas |
|----------|----------|
| **Descrição**  | Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. |
| **Atores**  | Usuário com perfil de aluno.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: Em construção; Pré-condições: Em construção.  |
| **Saída e pós-condições**  | Saídas: Em construção; Pós-condições: Em construção.  |

### Perfil Coordenador

| **RF 017** | Solicitar permissões de coordenação |
|----------|----------|
| **Descrição**  | O usuário pode solicitar ao administrador o perfil de coordenação, é necessário validar se o usuário é docente e faz parte da coordenação de um determinado curso. |
| **Atores**  | Usuário geral.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: O usuário deve enviar alguma documentação que confirme a veracidade da sua posição; Pré-condições: O usuário deve estar logado no sistema.  |
| **Saída e pós-condições**  | Saídas: Confirmação da solicitação de autorização; Pós-condições: O usuário deve receber por e-mail um retorno sobre a sua solicitação.  |

| **RF 018** | Consultar lista de requisições |
|----------|----------|
| **Descrição**  | O coordenador deve ser capaz de visualizar a listas de requisições encaminhadas para a coordenação e comissão do seu respectivo curso.Também deve ser possível filtrar as requisições por campos de interesse, como: data, semestre, status da requisição e aluno. |
| **Atores**  | Coordenador.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: Nenhuma; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Não possuí saídas; Pós-condições: Caso selecione alguma requisição, o usuário é redirecionado para tela de requisição selecionada.  |

| **RF 019** | Encaminhar requisição para a comissão |
|----------|----------|
| **Descrição**  | O coordenador deve ser capaz de encaminhar a requisição para a comissão do seu curso.|
| **Atores**  | Coordenador.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: Não possui entradas; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Confirmação de encaminhamento de requisição; Pós-condições: O coordenador recebe uma mensagem informando que a requisição foi encaminhada com sucesso e a comissão recebe por e-mail a notificação;  |

| **RF 020** | Assinar documento requisição  |
|----------|----------|
| **Descrição**  | Antes de deferir ou indeferir uma requisição, o coordenador deve ser capaz de baixar o documento da requisição na sua máquina e submetê-lo assinado ao sistema.|
| **Atores**  | Coordenador.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: O usuário deve submeter o documento assinado; Pré-condições:  O usuário deve estar logado e  selecionar a opção de fazer download do arquivo em PDF, assiná-lo e realizar a submissão.  |
| **Saída e pós-condições**  | Saídas: Confirmação de submissão do documento assinado; Pós-condições: O coordenador recebe uma mensagem informando que a requisição foi assinada com sucesso;  |

| **RF 021** | Ratificar requisição  |
|----------|----------|
| **Descrição**  | O coordenador deve ser capaz de finalizar o fluxo da requisição, deferindo-a ou indeferindo-a.|
| **Atores**  | Coordenador.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: Nenhuma; Pré-condições:  O usuário deve estar logado e em casos de aprovação a requisição deve ter passado pela comissão.  |
| **Saída e pós-condições**  | Saídas: Confirmação da ratificação da requisição; Pós-condições: O coordenador recebe uma mensagem informando que a requisição foi ratificada e encaminhada para a escolaridade;  |

| **RF 022** | Atribuir perfil para a comissão |
|----------|----------|
| **Descrição**  | O coordenador pode atribuir perfis de comissão para os usuários da sua escolha. |
| **Atores**  | Coordenador.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: Informar o usuário que deseja adicionar as permissões de comissão; Pré-condições: O usuário deve estar logado no sistema.  |
| **Saída e pós-condições**  | Saídas: Confirmação da atribuição do perfil; Pós-condições: O usuário que recebeu as permissões deve receber por e-mail a notificação.  |

| **RF 023** | Visualizar indicadores sobre as requisições enviadas |
|----------|----------|
| **Descrição**  | Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. |
| **Atores**  | Coordenador.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: Em construção; Pré-condições: Em construção.  |
| **Saída e pós-condições**  | Saídas: Em construção; Pós-condições: Em construção.  |

### Comissão

| **RF 024** | Consultar lista de requisições |
|----------|----------|
| **Descrição**  | A comissão deve ser capaz de visualizar a listas de requisições encaminhadas para a comissão do seu respectivo curso. Também deve ser possível filtrar as requisições por campos de interesse, como: data, semestre e aluno. |
| **Atores**  | Comissão.  |
| **Prioridade**  | Média.  |
| **Entrada e pré-condições**  | Entradas: Nenhuma; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Não possuí saídas; Pós-condições: Caso selecione alguma requisição, o usuário é redirecionado para tela de requisição selecionada.  |

| **RF 025** | Adicionar quantidade de horas nas atividades complementares |
|----------|----------|
| **Descrição**  | A comissão deve ser capaz de adicionar a quantidade de horas por certificados de uma requisição. |
| **Atores**  | Comissão.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: Inserir quantidade de horas para o certificado; Pré-condições: O usuário deve estar logado.  |
| **Saída e pós-condições**  | Saídas: Confirmação da inserção das horas dos certificados; Pós-condições: O usuário retorna para a tela da requisição. |

| **RF 026** | Validar requisição |
|----------|----------|
| **Descrição**  | A comissão deve ser capaz de finalizar o fluxo da requisição, deferindo-a ou indeferindo-a. Após isso é submetido para a coordenação realizar a validação final.|
| **Atores**  | Comissão.  |
| **Prioridade**  | Alta.  |
| **Entrada e pré-condições**  | Entradas: Nenhuma; Pré-condições:  O usuário deve estar logado e em casos de aprovação a requisição deve ser enviada para a coordenação.  |
| **Saída e pós-condições**  | Saídas: Confirmação da ratificação da requisição; Pós-condições: O coordenador recebe um e-mail informando que a requisição foi finalizada pela comissão;  |

## Requisitos não funcionais
### Desempenho
Esta área define as métricas de desempenho que deverão ser atingidas para que o sistema tenha uma boa usabilidade e não afete a experiência do usuário.

| RNF 001 | Tempo de Resposta |
|----------|----------|
| Descrição: | 	O aplicativo deverá apresentar tempos de resposta inferiores a 1000 ms, de forma a apresentar um carregamento suficientemente rápido. |
| Prioridade: | Alta |

| RNF 002 | Usuários online |
|----------|----------|
| Descrição: | 	O aplicativo deve ser altamente eficiente e capaz de gerenciar perfeitamente a conexão de até 100 usuários online simultaneamente, proporcionando uma experiência fluida e sem interrupções para todos os usuários.  |
| Prioridade: | Alta |

### Disponibilidade

| RNF 003 | Período ativo |
|----------|----------|
| Descrição: | 	O aplicativo deve permanecer online 24 horas por dia, 7 dias por semana, com tolerância a interrupções de no máximo 2 horas em situações excepcionais para manutenções ou atualizações planejadas. |
| Prioridade: | Média |

### Hardware

| RNF 004 | Compatibilidade |
|----------|----------|
| Descrição: | 	Para o perfeito funcionamento do sistema, é necessário apenas possuir um navegador com acesso à internet. Essa simplicidade na exigência de recursos garante que o aplicativo seja facilmente acessível e utilizado por uma ampla variedade de usuários. |
| Prioridade: | Alta |

### Segurança

| RNF 005 | Criptografia |
|----------|----------|
| Descrição: | 	O sistema deve priorizar a segurança dos dados e a proteção da privacidade dos usuários, adotando o uso do protocolo HTTPS (Hyper Text Transfer Protocol Secure) como uma camada de criptografia confiável. Ao utilizar o HTTPS, todas as informações transmitidas entre o aplicativo e os usuários serão criptografadas, garantindo a confidencialidade e a integridade dos dados durante a comunicação. |
| Prioridade: | Baixa |

| RNF 006 | Autenticação |
|----------|----------|
| Descrição: | 	O usuário deve ser capaz de realizar login através de sua conta Google utilizando o serviço SSO (Single Sign-On) da Google além de poder fazer pelo próprio sistema utilizando a lógica de autenticação com Spring security e JWT. |
| Prioridade: | Alta |

### Documentação

| RNF 007 | Documentação APIs REST |
|----------|----------|
| Descrição: | É fundamental que o endpoint do aplicativo seja cuidadosamente documentado, a fim de facilitar integrações futuras com outros sistemas e permitir correções eficientes de implementações no front-end. Nesse sentido, o uso da ferramenta Swagger desempenha um papel crucial. O Swagger proporciona uma abordagem estruturada e padronizada para documentação de API, permitindo que os desenvolvedores compreendam facilmente a funcionalidade e os parâmetros do endpoint. |
| Prioridade: | Alta |

