CREATE SEQUENCE tbhospede_codigo_seq;

-- Table: tbhospede

-- DROP TABLE tbhospede;

CREATE TABLE tbhospede
(
  nome text NOT NULL,
  documento text NOT NULL,
  telefone text NOT NULL,
  codigo integer NOT NULL DEFAULT nextval('tbhospede_codigo_seq'::regclass),
  CONSTRAINT tbhospede_pkey PRIMARY KEY (codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbhospede
  OWNER TO postgres;


-- Table: tbregistrocheckin

-- DROP TABLE tbregistrocheckin;
CREATE SEQUENCE tbregistrocheckin_codigo_seq;

CREATE TABLE tbregistrocheckin
(
  codigo integer NOT NULL DEFAULT nextval('tbregistrocheckin_codigo_seq'::regclass),
  adicional_veiculo boolean,
  hospede integer NOT NULL,
  data_entrada date,
  data_saida date,
  valor_estadia bigint,
  CONSTRAINT tbregistrocheckin_pkey PRIMARY KEY (codigo),
  CONSTRAINT registrochekin_possui_hospedei FOREIGN KEY (hospede)
      REFERENCES tbhospede (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbregistrocheckin
  OWNER TO postgres;
