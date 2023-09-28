CREATE TABLE IF NOT EXISTS atividade
(
    id                       BIGINT  NOT NULL,
    ch_maxima                INTEGER NOT NULL,
    ch_por_certificado       INTEGER,
    criterios_para_avaliacao VARCHAR(255),
    descricao                VARCHAR(255),
    eixo                     VARCHAR(255),
    CONSTRAINT atividade_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS certificado
(
    id                 BIGINT NOT NULL,
    carga_horaria      FLOAT4 NOT NULL,
    certificado        BYTEA,
    data_final         date,
    data_inicial       date,
    observacao         TEXT,
    status_certificado VARCHAR(255),
    titulo             VARCHAR(255),
    atividade_id       BIGINT,
    requisicao_id      BIGINT,
    CONSTRAINT certificado_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS requisicao
(
    id                          BIGINT  NOT NULL,
    arquivada                   BOOLEAN NOT NULL,
    criacao                     date,
    data_de_submissao           date,
    id_requisicao               VARCHAR(255),
    observacao                  TEXT,
    requisicao_arquivo_assinada BYTEA,
    status_requisicao           VARCHAR(255),
    token                       VARCHAR(255),
    curso_id                    BIGINT,
    usuario_id                  BIGINT,
    CONSTRAINT requisicao_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS usuario
(
    id                 BIGINT  NOT NULL,
    codigo_verificacao VARCHAR(255),
    cpf                VARCHAR(255),
    email              VARCHAR(255),
    enabled            BOOLEAN NOT NULL,
    horas_ensino       FLOAT4  NOT NULL,
    horas_extensao     FLOAT4  NOT NULL,
    horas_gestao       FLOAT4  NOT NULL,
    horas_pesquisa     FLOAT4  NOT NULL,
    is_verificado      BOOLEAN NOT NULL,
    matricula          VARCHAR(255),
    nome_completo      VARCHAR(255),
    perfil             VARCHAR(255),
    periodo            INTEGER NOT NULL,
    senha              VARCHAR(255),
    telefone           VARCHAR(255),
    curso_id           BIGINT,
    endereco_id        BIGINT,
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS curso
(
    id                   BIGINT  NOT NULL,
    horas_complementares INTEGER NOT NULL,
    nome                 VARCHAR(255),
    sigla                VARCHAR(255),
    CONSTRAINT curso_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS endereco
(
    id          BIGINT  NOT NULL,
    uf          VARCHAR(255),
    bairro      VARCHAR(255),
    cep         VARCHAR(255),
    cidade      VARCHAR(255),
    complemento VARCHAR(255),
    numero      INTEGER NOT NULL,
    rua         VARCHAR(255),
    CONSTRAINT endereco_pkey PRIMARY KEY (id)
);