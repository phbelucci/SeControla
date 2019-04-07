drop database secontrola;
create database secontrola;
use secontrola;

create table USUARIO
(
	COD_US int auto_increment primary key,
	NOME_US varchar(200),
	SENHA_US int(6),
	AVATAR_US longblob,
	COD_MOEDA int,
	COD_NIVEL_ACESSO int, 
	COD_US_ADM int

);

create table RECEITA
(
	COD_REC int auto_increment primary key,
	COD_US int,
	DATA datetime,
	COD_CAT int,
	COD_SUBCAT int,
	COMPROVANTE mediumblob, 
	VALOR double,
 	COD_CONTA int,
	COD_FORMA_PGTO int

);