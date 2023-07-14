-- Inicie a transação
BEGIN;

-- Declare uma variável para armazenar o conteúdo do arquivo PDF
DO $$
DECLARE
   pdf_data bytea;
BEGIN
   -- Atribua o valor em base64 para a variável pdf_data
   pdf_data := decode('JVBERi0xLjQNJeLjz9MNCjYgMCBvYmoNPDwvTGluZWFyaXplZCAxL0wgMTA1MjcvTyA4L0UgNjM5MC9OIDEvVCAxMDM2Ni9IIFsgNTU2IDE2MF0+Pg1lbmRvYmoNICAgICAgICAgICAgICAgICAgICAgIA14cmVmDTYgMTMNMDAwMDAwMDAxNiAwMDAwMCBuDQowMDAwMDAwNzE2IDAwMDAwIG4NCjAwMDAwMDA3OTMgMDAwMDAgbg0KMDAwMDAwMDk4MyAwMDAwMCBuDQowMDAwMDAxMTAzIDAwMDAwIG4NCjAwMDAwMDE0NjUgMDAwMDAgbg0KMDAwMDAwMTUwMCAwMDAwMCBuDQowMDAwMDAyMDExIDAwMDAwIG4NCjAwMDAwMDQ3MDMgMDAwMDAgbg0KMDAwMDAwNTk5MiAwMDAwMCBuDQowMDAwMDA2MjM3IDAwMDAwIG4NCjAwMDAwMDYzMTQgMDAwMDAgbg0KMDAwMDAwMDU1NiAwMDAwMCBuDQp0cmFpbGVyDTw8L1NpemUgMTkvUHJldiAxMDM1OC9Sb290IDcgMCBSL0luZm8gNSAwIFIvSURbPDJBNUYyNDY1QTAzOEU4MTNGNENCODJCRkUyNjVCMjlDPjw5MEJDMTM1M0JCNEI0RURGQTZCNEEzQ0ZFQUI0NkY0RT5dPj4Nc3RhcnR4cmVmDTANJSVFT0YNICAgICAgICAgICAgICAgICAgICAgICAgDTE4IDAgb2JqDTw8L0xlbmd0aCA3Ny9GaWx0ZXIvRmxhdGVEZWNvZGUvSSA5NS9MIDc5L1MgMzg+PnN0cmVhbQ0KeNpiYGDgYmBgqmQAAtG7DKiACYhZGDgakMW4oJiBQZmBh3NDqEgBg+ypRL+ES0wLNMHCjAwMEmFQzc5AzMrAoM4NEWc4DRBgALNcCSUNZW5kc3RyZWFtDWVuZG9iag03IDAgb2JqDTw8L01ldGFkYXRhIDQgMCBSL1BhZ2VzIDMgMCBSL1R5cGUvQ2F0YWxvZy9QYWdlTGFiZWxzIDEgMCBSPj4NZW5kb2JqDTggMCBvYmoNPDwvQ3JvcEJveFswIDAgNjEyIDc5Ml0vUGFyZW50IDMgMCBSL0NvbnRlbnRzIDEyIDAgUi9Sb3RhdGUgMC9CbGVlZEJveFsyMi40MDkgNDAgNTg5LjU5MSA3NzRdL01lZGlh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MC4wMj4+DWVuZG9iag0xNyAwIG9iag08PC9PUE0gMS9PUCBmYWxzZS9vcCBmYWxzZS9UeXBlL0V4dEdTdGF0ZS9TQSB0cnVlL1NNIDAuMDI+Pg1lbmRvYmoNMSAwIG9iag08PC9OdW1zWzAgMiAwIFJdPj4NZW5kb2JqDTIgMCBvYmoNPDwvUChQYWdlICkvUy9EPj4NZW5kb2JqDTMgMCBvYmoNPDwvQ291bnQgMS9UeXBlL1BhZ2VzL0tpZHNbOCAwIFJdPj4NZW5kb2JqDTQgMCBvYmoNPDwvU3VidHlwZS9YTUwvTGVuZ3RoIDM1NzEvVHlwZS9NZXRhZGF0YT4+c3RyZWFtDQo8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/Pgo8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA0LjAtYzMxNiA0NC4yNTM5MjEsIFN1biBPY3QgMDEgMjAwNiAxNzowODoyMyI+CiAgIDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+CiAgICAgIDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiCiAgICAgICAgICAgIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyI+CiAgICAgICAgIDxkYzpmb3JtYXQ+YXBwbGljYXRpb24vcGRmPC9kYzpmb3JtYXQ+CiAgICAgICAgIDxkYzp0aXRsZT4KICAgICAgICAgICAgPHJkZjpBbHQ+CiAgICAgICAgICAgICAgIDxyZGY6bGkgeG1sOmxhbmc9IngtZGVmYXVsdCI+cGRmX2phbmVsYTwvcmRmOmxpPgogICAgICAgICAgICA8L3JkZjpBbHQ+CiAgICAgICAgIDwvZGM6dGl0bGU+CiAgICAgICAgIDxkYzpjcmVhdG9yPgogICAgICAgICAgICA8cmRmOlNlcT4KICAgICAgICAgICAgICAgPHJkZjpsaT5NYXVybyBNYW5nYXM8L3JkZjpsaT4KICAgICAgICAgICAgPC9yZGY6U2VxPgogICAgICAgICA8L2RjOmNyZWF0b3I+CiAgICAgIDwvcmRmOkRlc2NyaXB0aW9uPgogICAgICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIgogICAgICAgICAgICB4bWxuczp4YXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iPgogICAgICAgICA8eGFwOkNyZWF0ZURhdGU+MjAwOS0wMS0yMVQxNDo1ODowOFo8L3hhcDpDcmVhdGVEYXRlPgogICAgICAgICA8eGFwOk1vZGlmeURhdGU+MjAwOS0wMS0yMVQxNDo1ODowOFo8L3hhcDpNb2RpZnlEYXRlPgogICAgICAgICA8eGFwOkNyZWF0b3JUb29sPkFkb2JlIElsbHVzdHJhdG9yKFIpIDEzLjA8L3hhcDpDcmVhdG9yVG9vbD4KICAgICAgPC9yZGY6RGVzY3JpcHRpb24+CiAgICAgIDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiCiAgICAgICAgICAgIHhtbG5zOnBkZj0iaHR0cDovL25zLmFkb2JlLmNvbS9wZGYvMS4zLyI+CiAgICAgICAgIDxwZGY6UHJvZHVjZXI+QWNyb2JhdCBEaXN0aWxsZXIgOC4xLjAgKE1hY2ludG9zaCk8L3BkZjpQcm9kdWNlcj4KICAgICAgPC9yZGY6RGVzY3JpcHRpb24+CiAgICAgIDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiCiAgICAgICAgICAgIHhtbG5zOnhhcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIj4KICAgICAgICAgPHhhcE1NOkRvY3VtZW50SUQ+dXVpZDo4ZDI3Zjk2MS1hMWFmLTZmNGEtOWIyOS1hODkwOGM0MDkzZWE8L3hhcE1NOkRvY3VtZW50SUQ+CiAgICAgICAgIDx4YXBNTTpJbnN0YW5jZUlEPnV1aWQ6OTBhMGUyYTEtZGIwZS1jYzQxLTk2MTctMWJlYWJkOGVlMmI5PC94YXBNTTpJbnN0YW5jZUlEPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgIAo8P3hwYWNrZXQgZW5kPSJ3Ij8+DWVuZHN0cmVhbQ1lbmRvYmoNNSAwIG9iag08PC9DcmVhdGlvbkRhdGUoRDoyMDA5MDEyMTE0NTgwOFopL0F1dGhvcihNYXVybyBNYW5nYXMpL0NyZWF0b3IoQWRvYmUgSWxsdXN0cmF0b3JcKFJcKSAxMy4wKS9Qcm9kdWNlcihBY3JvYmF0IERpc3RpbGxlciA4LjEuMCBcKE1hY2ludG9zaFwpKS9Nb2REYXRlKEQ6MjAwOTAxMjExNDU4MDhaKS9UaXRsZShwZGZfamFuZWxhKT4+DWVuZG9iag14cmVmDTAgNg0wMDAwMDAwMDAwIDY1NTM1IGYNCjAwMDAwMDYzOTAgMDAwMDAgbg0KMDAwMDAwNjQyNCAwMDAwMCBuDQowMDAwMDA2NDU3IDAwMDAwIG4NCjAwMDAwMDY1MDggMDAwMDAgbg0KMDAwMDAxMDE1NSAwMDAwMCBuDQp0cmFpbGVyDTw8L1NpemUgNj4+DXN0YXJ0eHJlZg0xMTYNJSVFT0YN', 'base64');

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (1, '2023-07-01', 1, 3, 'Disciplinas concluídas com carga horária mínima de 30h', 'token1', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (2, '2023-07-02', 2, 2, 'Cursos de capacitação profissional concluídos', 'token2', pdf_data, 'ENCAMINHADO_COMISSAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (3, '2023-07-03', 1, 1, 'Certificado de LIBRAS', 'token3', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (4, '2023-07-04', 2, 4, 'Atividade de monitoria acadêmica', 'token4', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (5, '2023-07-05', 1, 2, 'Cursos de informática, língua estrangeira e LIBRAS', 'token5', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (6, '2023-07-06', 2, 3, 'Estágios curriculares não obrigatórios', 'token6', pdf_data, 'ENCAMINHADO_COMISSAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (7, '2023-07-07', 1, 1, 'Disciplinas concluídas em cursos de lato sensu', 'token7', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (8, '2023-07-08', 2, 5, 'Premiações em trabalhos desenvolvidos na área de ensino', 'token8', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (9, '2023-07-09', 1, 2, 'Certificado de Participação em Atléticas', 'token9', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (10, '2023-07-10', 2, 3, 'Certificado de Participação em Atividades de Iniciação Científica', 'token10', pdf_data, 'ENCAMINHADO_COMISSAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (11, '2023-07-11', 1, 1, 'Participação como membro do Diretório Acadêmico', 'token11', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (12, '2023-07-12', 2, 60, 'Capítulo de livro publicado', 'token12', pdf_data, 'ENCAMINHADO_COMISSAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (13, '2023-07-13', 1, 90, 'Artigo publicado ou aceito com classificação de B2 para cima', 'token13', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (14, '2023-07-14', 2, 20, 'Participação em defesas públicas, como ouvinte, de trabalhos de mestrado ou doutorado (stricto sensu)', 'token14', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (15, '2023-07-15', 1, 20, 'Membro de Laboratório ou Grupo de Pesquisa registrado na Propegi', 'token15', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (16, '2023-07-16', 2, 40, 'Participação em Ligas Acadêmicas', 'token16', pdf_data, 'ENCAMINHADO_COMISSAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (17, '2023-07-17', 1, 60, 'Mediação em mesa-redonda de eventos científicos', 'token17', pdf_data, 'ENCAMINHADO_COMISSAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (18, '2023-07-18', 2, 40, 'Apresentação de trabalhos em congressos, seminários, semanas acadêmicas ou outros eventos na área.', 'token18', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (19, '2023-07-19', 1, 10, 'Participação em eventos acadêmicos - reflexivos promovidos por órgãos de política estudantil do ensino superior como a UNE e DCEs.', 'token19', pdf_data, 'ENCAMINHADO_COMISSAO', 1, 20);

   INSERT INTO requisicao (id, data, semestre, qtd_certificados, observacao, token, requisicao_arquivo_assinada, status_requisicao, aluno_id, curso_id)
   VALUES (20, '2023-07-20', 2, 10, 'Participação voluntária em ações e campanhas humanitárias promovidas por órgãos representativos da sociedade civil organizada.', 'token20', pdf_data, 'ENCAMINHADO_COORDENACAO', 1, 20);

END;
$$;

-- Confirme a transação
COMMIT;