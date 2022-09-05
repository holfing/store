USE `store`;
CREATE TABLE produto (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 titulo varchar(250) DEFAULT NULL,
 descricao varchar(400) DEFAULT NULL,
 preco  decimal(19,2) NOT NULL,
 imagem LONGBLOB DEFAULT NULL,
PRIMARY KEY (id)
);