CREATE TABLE activities
(
    id                   BIGINT  NOT NULL,
    axle                 VARCHAR(255),
    description          VARCHAR(255),
    evaluation_methods   VARCHAR(255),
    workload_certificate INTEGER,
    workload_max         INTEGER NOT NULL,
    CONSTRAINT activities_pkey PRIMARY KEY (id)
);

CREATE TABLE certificates
(
    id          BIGINT NOT NULL,
    certificate BYTEA,
    end_date    date,
    note        TEXT,
    start_date  date,
    status      VARCHAR(255),
    title       VARCHAR(255),
    workload    FLOAT4 NOT NULL,
    activity_id BIGINT,
    request_id  BIGINT,
    CONSTRAINT certificates_pkey PRIMARY KEY (id)
);

CREATE TABLE requests
(
    id          BIGINT  NOT NULL,
    archived    BOOLEAN NOT NULL,
    create_at   date,
    semantic_id  VARCHAR(255),
    note        TEXT,
    sent_at     date,
    signed_file BYTEA,
    status      VARCHAR(255),
    token       VARCHAR(255),
    user_id     BIGINT,
    CONSTRAINT requests_pkey PRIMARY KEY (id)
);

CREATE TABLE users
(
    id                BIGINT  NOT NULL,
    cpf               VARCHAR(255),
    email             VARCHAR(255),
    enabled           BOOLEAN NOT NULL,
    enrollment        VARCHAR(255),
    full_name         VARCHAR(255),
    hours_ensino      FLOAT4  NOT NULL,
    hours_extensao    FLOAT4  NOT NULL,
    hours_gestao      FLOAT4  NOT NULL,
    hours_pesquisa    FLOAT4  NOT NULL,
    password          VARCHAR(255),
    period INTEGER NOT NULL,
    role              VARCHAR(255),
    phone         VARCHAR(255),
    verification_code VARCHAR(255),
    verified          BOOLEAN NOT NULL,
    address_id        BIGINT,
    course_id         BIGINT,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE addresses
(
    id         BIGINT  NOT NULL,
    cep        VARCHAR(255),
    city       VARCHAR(255),
    complement VARCHAR(255),
    district   VARCHAR(255),
    number     INTEGER NOT NULL,
    street     VARCHAR(255),
    uf         VARCHAR(255),
    CONSTRAINT addresses_pkey PRIMARY KEY (id)
);

CREATE TABLE courses
(
    id               BIGINT  NOT NULL,
    acronym          VARCHAR(255),
    additional_hours INTEGER NOT NULL,
    name             VARCHAR(255),
    CONSTRAINT courses_pkey PRIMARY KEY (id)
);