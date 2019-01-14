CREATE SEQUENCE aluno_id_seq;
CREATE SEQUENCE endereco_id_seq;
CREATE SEQUENCE telefone_id_seq;
CREATE SEQUENCE responsavel_id_seq;

CREATE TABLE telefone (
  id integer NOT NULL DEFAULT nextval('telefone_id_seq'),
  residencial varchar(11),
  celular varchar(11),
  trabalho varchar(11),
  ramal_trabalho varchar(4),

  PRIMARY KEY (id)
);

ALTER SEQUENCE telefone_id_seq OWNED BY telefone.id;

CREATE TABLE responsavel (
  id integer NOT NULL DEFAULT nextval('responsavel_id_seq') PRIMARY KEY,
  nome varchar(70) NOT NULL,
  email varchar(40) NOT NULL,
  cpf varchar(11) NOT NULL,
  rg varchar(11) DEFAULT NULL,
  fk_telefone_id integer,
  
  FOREIGN KEY (fk_telefone_id) REFERENCES telefone (id)
);

ALTER SEQUENCE responsavel_id_seq OWNED BY responsavel.id;

CREATE INDEX ON responsavel (nome);

CREATE TABLE endereco (
  id integer NOT NULL DEFAULT nextval('endereco_id_seq'),
  rua varchar(60) DEFAULT NULL,
  complemento varchar(20),
  bairro varchar(30),
  cidade varchar(50),
  estado varchar(2),
  cep varchar(8),
  
  PRIMARY KEY (id)
);

ALTER SEQUENCE endereco_id_seq OWNED BY endereco.id;

CREATE TABLE aluno (
  id integer NOT NULL DEFAULT nextval('aluno_id_seq'),
  nome varchar(70) NOT NULL,
  data_nascimento date NOT NULL,
  fk_endereco_id integer,
  fk_telefone_id integer,
  fk_responsavel_id integer,
  nome_pai varchar(70),
  nome_mae varchar(70),
  data_cadastramento date NOT NULL DEFAULT CURRENT_DATE,
  data_inativacao date,
  observacao varchar(200),
  cd_motivo_matricula integer NOT NULL,
  cd_doenca_pre_existente integer NOT NULL,
  dia_vencimento numeric(2) NOT NULL,
  
  PRIMARY KEY (id),
  
  FOREIGN KEY (fk_endereco_id) REFERENCES endereco (id),
  FOREIGN KEY (fk_responsavel_id) REFERENCES responsavel (id),
  FOREIGN KEY (fk_telefone_id) REFERENCES telefone (id)
);

CREATE INDEX ON aluno (nome);

ALTER SEQUENCE aluno_id_seq OWNED BY aluno.id;
