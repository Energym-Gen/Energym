CREATE DATABASE db_energym;

USE db_energym;

CREATE TABLE tb_usuario(
id_usuario BIGINT AUTO_INCREMENT NOT NULL,
nome VARCHAR (255) NOT NULL,
email VARCHAR (255) NOT NULL,
senha VARCHAR (255) NOT NULL,
PRIMARY KEY (id_usuario)
);

CREATE TABLE tb_tema(
id_tema BIGINT AUTO_INCREMENT NOT NULL,
equipamentos VARCHAR (255) NOT NULL,
ativo BOOLEAN NOT NULL,
economia FLOAT (255,2),
PRIMARY KEY (id_tema)
);

CREATE TABLE tb_postagem(
id_postagem BIGINT AUTO_INCREMENT NOT NULL,
fk_usuario BIGINT,
fk_tema BIGINT,
titulo VARCHAR (50) NOT NULL,
descricao VARCHAR (200) NOT NULL,
valor_economia FLOAT (255,2),
tempo_percorrido FLOAT (255,2),
PRIMARY KEY (id_postagem),
FOREIGN KEY (fk_usuario) REFERENCES tb_usuario (id_usuario),
FOREIGN KEY (fk_tema) REFERENCES tb_tema (id_tema)
);




