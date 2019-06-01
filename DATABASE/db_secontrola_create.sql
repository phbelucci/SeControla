drop database if exists db_secontrola;
create database db_secontrola;
use db_secontrola;

create table MOEDA
(
	COD_MOEDA int auto_increment primary key,
	DESCR_MOEDA varchar(30) not null,
	COTACAO_REAIS real not null

);

create table LOGIN
(
	COD_US int auto_increment primary key,
	NOME_US varchar(200) not null,
	SENHA_US varchar(20) not null
);

create table GRUPO_FAMILIAR(
	COD_GRUPO int auto_increment primary key,
	COD_ADM_GRUPO int,
	COD_MOEDA_PADRAO int default 1
);

create table USUARIO
(
	COD_US int primary key,
	AVATAR_US longblob,
	COD_NIVEL_ACESSO int not null, 
	COD_GRUPO int default null,

	constraint foreign key FK_US_LOGIN(COD_US) references LOGIN(COD_US) on delete cascade,
	constraint foreign key FK_GRUPO(COD_GRUPO) references GRUPO_FAMILIAR(COD_GRUPO) on delete cascade
);

create table CATEGORIA
(
	COD_CAT int auto_increment primary key,
	TIPO_LANC_ENUM varchar(20) not null,
	DESCR_CAT varchar(20) not null
);


create table SUBCATEGORIAS
(
	COD_SUBCAT int auto_increment primary key,
	COD_CAT int not null,
	DESCR_SUBCAT varchar(40) not null,
	
    constraint foreign key FK_CAT(COD_CAT) references CATEGORIA(COD_CAT) on delete cascade
);

create table CONTA_BANCO
(
	COD_CONTA int auto_increment primary key,
	COD_GRUPO int not null,
	NUM_CONTA int not null,
	NUM_AGENCIA int not null,
	COD_MOEDA int default 1,
	SALDO real default 0.00,
    
    constraint foreign key FK_BANC_GRUPO(COD_GRUPO) references GRUPO_FAMILIAR(COD_GRUPO) on delete cascade
);

create table LANCAMENTO
(
	COD_LANC int auto_increment primary key,
	COD_US int not null,
	COD_GRUPO int not null,
	TIPO_LANC_ENUM varchar(20) not null,
	DATA_LANC datetime not null,
	COD_CAT int not null,
	COD_SUBCAT int default null,
	COMPROVANTE mediumblob , 
	VALOR real not null,
 	COD_CONTA int default null,
	COD_FORMA_PGTO int default null,
	COD_MOEDA int default 1,

	constraint foreign key FK_LANC_US(COD_US) references USUARIO(COD_US) on delete cascade,
	constraint foreign key FK_LANC_GRUPO(COD_GRUPO) references GRUPO_FAMILIAR(COD_GRUPO) on delete cascade,
    constraint foreign key FK_LANC_CAT(COD_CAT) references CATEGORIA(COD_CAT) on delete cascade,
    constraint foreign key FK_LANC_SUBCAT(COD_SUBCAT) references SUBCATEGORIAS(COD_SUBCAT) on delete cascade,
    constraint foreign key FK_LANC_CONTA(COD_CONTA) references CONTA_BANCO(COD_CONTA) on delete cascade,
	constraint foreign key FK_LANC_MOEDA(COD_MOEDA) references MOEDA(COD_MOEDA) on delete cascade
);


