INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (1, 'Certificado de Disciplinas Concluídas', 'Disciplinas concluídas pelo acadêmico com carga horária mínima de 30h em cursos de graduação de IES credenciadas pelo MEC (presencial ou EAD)', 'Disciplinas concluídas com carga horária mínima de 30h', '2023-07-01', 30, 30, 30, NULL, 'ENCAMINHADO_COORDENACAO', 1, (SELECT id FROM atividade WHERE id = 36));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas,ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (2, 'Certificado de Cursos de Capacitação', 'Cursos de capacitação profissional', 'Cursos de capacitação profissional concluídos', '2023-07-02', 15, 30, 30, NULL, 'ENCAMINHADO_COORDENACAO', 2, (SELECT id FROM atividade WHERE id = 37));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (3, 'Certificado de LIBRAS', 'LIBRAS (Língua Brasileira de Sinais)', '', '2023-07-03', 60, 60, 60, NULL, 'ENCAMINHADO_COORDENACAO', 3, (SELECT id FROM atividade WHERE id = 38));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (4, 'Certificado de Monitoria Acadêmica', 'Atividade de monitoria Acadêmica', '', '2023-07-04', 60, 60, 60, NULL, 'ENCAMINHADO_COORDENACAO', 4, (SELECT id FROM atividade WHERE id = 39));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (5, 'Certificado de Cursos de Informática, Língua Estrangeira e LIBRAS', 'Cursos de informática, língua estrangeira e LIBRAS, realizados em estabelecimentos reconhecidos pela Comissão de Validação das atividades complementares ou de nível superior', '', '2023-07-05', 20, 20, 20, NULL, 'ENCAMINHADO_COORDENACAO', 5, (SELECT id FROM atividade WHERE id = 40));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (6, 'Certificado de Estágios Curriculares', 'Estágios curriculares não obrigatórios', '', '2023-07-06', 60, 60, 60, NULL, 'CONCLUIDO', 6, (SELECT id FROM atividade WHERE id = 41));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (7, 'Certificado de Disciplinas em Cursos de Lato Sensu', 'Disciplinas concluídas em cursos de lato sensu em áreas afins durante o curso da graduação', 'Disciplinas concluídas em cursos de pós-graduação lato sensu', '2023-07-07', 15, 30, 30, NULL, 'ENCAMINHADO_COORDENACAO', 7, (SELECT id FROM atividade WHERE id = 42));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (8, 'Certificado de Premiações na Área de Ensino', 'Premiações em trabalhos desenvolvidos na área de ensino', 'Premiações em trabalhos na área de ensino recebidas.', '2023-07-08', 8, 20, 20, NULL, 'ENCAMINHADO_COORDENACAO', 8, (SELECT id FROM atividade WHERE id = 43));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (9, 'Certificado de Participação em Atléticas', 'Participação em Atléticas', '', '2023-07-09', 30, 30, 30, NULL, 'ENCAMINHADO_COMISSAO', 9, (SELECT id FROM atividade WHERE id = 44));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (10, 'Certificado de Participação em Atividades de Iniciação Científica', 'Participação de atividades de iniciação científica', '', '2023-07-10', 60, 60, 60, NULL, 'ENCAMINHADO_ESCOLARIDADE', 10, (SELECT id FROM atividade WHERE id = 45));


-----------------------

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (11, 'Certificado de Participação como Membro do Diretório Acadêmico', 'Participação como membro do Diretório Acadêmico', '', '2023-07-11', 60, 60, 60, NULL, 'ENCAMINHADO_COORDENACAO', 11, 68);

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (12, 'Certificado de Capítulo de Livro Publicado', 'Capítulo de livro publicado', '', '2023-07-12', 60, 60, 60, NULL, 'ENCAMINHADO_COORDENACAO', 12, (SELECT id FROM atividade WHERE id = 46));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (13, 'Certificado de Artigo Publicado', 'Artigo publicado ou aceito com classificação de B2 para cima', '', '2023-07-13', 90, 90, 90, NULL, 'ENCAMINHADO_COORDENACAO', 13, (SELECT id FROM atividade WHERE id = 48));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (14, 'Certificado de Participação em Defesas Públicas', 'Participação em defesas públicas, como ouvinte, de trabalhos de mestrado ou doutorado (stricto sensu)', '', '2023-07-14', 20, 20, 20, NULL, 'ENCAMINHADO_COORDENACAO', 14, (SELECT id FROM atividade WHERE id = 50));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (15, 'Certificado de Membro de Laboratório ou Grupo de Pesquisa', 'Membro de Laboratório ou Grupo de Pesquisa registrado na Propegi', '', '2023-07-15', 20, 20, 20, NULL, 'ENCAMINHADO_COORDENACAO', 15, (SELECT id FROM atividade WHERE id = 54));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (16, 'Certificado de Participação em Ligas Acadêmicas', 'Participação em Ligas Acadêmicas', '', '2023-07-16', 40, 40, 40, NULL, 'ENCAMINHADO_COORDENACAO', 16, (SELECT id FROM atividade WHERE id = 55));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (17, 'Certificado de Mediação em Mesa-Redonda', 'Mediação em mesa-redonda de eventos científicos', '', '2023-07-17', 60, 60, 60, NULL, 'ENCAMINHADO_COORDENACAO', 17, (SELECT id FROM atividade WHERE id = 58));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (18, 'Certificado de Apresentação de Trabalhos', 'Apresentação de trabalhos em congressos, seminários, semanas acadêmicas ou outros eventos na área.', '', '2023-07-18', 40, 40, 40, NULL, 'ENCAMINHADO_COORDENACAO', 18, (SELECT id FROM atividade WHERE id = 60));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (19, 'Certificado de Participação em Eventos Acadêmicos', 'Participação em eventos acadêmicos - reflexivos promovidos por órgãos de política estudantil do ensino superior como a UNE e DCEs.', '', '2023-07-19', 10, 10, 10, NULL, 'ENCAMINHADO_COORDENACAO', 19, (SELECT id FROM atividade WHERE id = 63));

INSERT INTO certificado (id, titulo, descricao, observacao, data, horas, ch_maxima, ch_total, certificado, status_certificado, requisicao_id, atividade_id)
VALUES (20, 'Certificado de Participação em Ações Humanitárias', 'Participação voluntária em ações e campanhas humanitárias promovidas por órgãos representativos da sociedade civil organizada.', '', '2023-07-20', 10, 10, 10, NULL, 'ENCAMINHADO_COORDENACAO', 20, (SELECT id FROM atividade WHERE id = 64));
