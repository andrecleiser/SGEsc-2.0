CREATE TABLE motivo_matricula (
  id integer NOT NULL,
  descricao varchar(50) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE doenca_pre_existente (
  id integer NOT NULL,
  descricao varchar(50) NOT NULL,

  PRIMARY KEY (id)
);

INSERT INTO doenca_pre_existente VALUES (1,'Não apresenta');
INSERT INTO doenca_pre_existente VALUES (2,'Hipertensão');
INSERT INTO doenca_pre_existente VALUES (3,'Colesterol alterado');
INSERT INTO doenca_pre_existente VALUES (4,'Osteoporose');
INSERT INTO doenca_pre_existente VALUES (5,'Artrose');
INSERT INTO doenca_pre_existente VALUES (6,'Desvios de coluna vertebral');
INSERT INTO doenca_pre_existente VALUES (7,'Bursite');
INSERT INTO doenca_pre_existente VALUES (8,'Tendinite');
INSERT INTO doenca_pre_existente VALUES (9,'Doenças no Sistema Nervoso');
INSERT INTO doenca_pre_existente VALUES (10,'Luxação em alguma articulação');

INSERT INTO motivo_matricula VALUES (1,'Indicação médica');
INSERT INTO motivo_matricula VALUES (2,'Lazer');
INSERT INTO motivo_matricula VALUES (3,'Aprendizagem');
INSERT INTO motivo_matricula VALUES (4,'Sociabilização');
INSERT INTO motivo_matricula VALUES (5,'Condicionamento Físico');
INSERT INTO motivo_matricula VALUES (6,'Concurso');
