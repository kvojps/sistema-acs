-- Insert de usuário (todo usuário registrado é configurado para ser aluno)
INSERT INTO aluno (id, nome_completo, cpf, telefone, email, senha, curso_id, periodo, matricula, codigo_verificacao, horas_ensino, horas_extensao, horas_gestao, horas_pesquisa, verificado, endereco_id)
VALUES (1, 'EMILIO GABRIEL OLIVEIRA BEZERRA', '132.779.394-64', '(87) 9914-7449', 'emilio.gabriel@upe.br', '$2a$10$i0d33Hzs908pSLprJdi5Q.tTmZ8QYRUGgTjOm3C8kMNffA8MP0jei', 20, 0, 'MAT123', 'ABC123', 0, 0, 0, 0, false, 1);

--Insert de usuário( Tipo de usuário coordenador)
INSERT INTO coordenador (id, nome_Completo, cpf, telefone, email, senha, curso_id)
VALUES (1, 'Helaine Barreiros', '119.071.080-33', '(81) 3504-2483', 'coordenador@example.com', 'senha', 20);

--Insert de usuário( Tipo de usuário comissão)
INSERT INTO comissao (id, nome_Completo, cpf, telefone, email, senha, curso_id)
VALUES (1,'ComissãoTeste', '021.566.700-05', '(87) 2215-4848', 'comissao@example.com', 'senha', 20);

--Insert de usuário( Tipo de usuário admnistrador)
INSERT INTO administrador (id, nome_Completo, cpf, telefone, email, senha)
VALUES (1, 'AdministradorTeste', '900.838.500-74', '(87) 3822-2272', 'administrador@example.com', 'senha');
