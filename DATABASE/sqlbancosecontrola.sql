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
	COD_US_ADM varchar(20),

	constraint foreign key FK_MOEDA(COD_MOEDA) references COTACAO(COD_MOEDA)

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

create table DESPESA
(
	COD_DESP int auto_increment primary key,
	COD_US int,
	DATA datetime,
	COD_CAT int,
	COD_SUBCAT int,
	COMPROVANTE mediumblob, 
	VALOR double,
 	COD_CONTA int,
	COD_FORMA_PGTO int

);

create table CATEGORIA
(
	COD_CAT int auto_increment primary key,
	TIPO_CAT varchar(20),
	DESCR_CAT varchar(20)

);

create table COTACAO
(
	COD_MOEDA int auto_increment primary key,
	DESCR_MOEDA varchar(10),
	VALOR_EM_REAIS double

);

create table NIVEL_ACESSO
(
	COD_NIVEL_AC int auto_increment primary key,
	DESCR_NIVEL_AC varchar(20)

);

create table SUBCATEGORIAS
(
	COD_SUBCAT int auto_increment primary key,
	COD_CAT int,
	DESCR_SUBCAT varchar(20)

);

create table CONTA_BANCO
(
	COD_CONTA int auto_increment primary key,
	COD_US int,
	NUM_CONTA int,
	NUM_AGENCIA int,
	SALDO double
);

create table FORMA_PAGTO
(
	COD_FORMA_PGTO int auto_increment primary key,
	DESCR_FORMA_PAGTO varchar(20)

);






