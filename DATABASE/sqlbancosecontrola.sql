drop database secontrola;
create database secontrola;
use secontrola;

create table COTACAO
(
	COD_MOEDA int auto_increment primary key,
	DESCR_MOEDA varchar(10) not null,
	VALOR_EM_REAIS real not null

);

create table NIVEL_ACESSO
(
	COD_NIVEL_AC int auto_increment primary key,
	DESCR_NIVEL_AC varchar(20) not null

);

create table USUARIO
(
	COD_US int auto_increment primary key,
	NOME_US varchar(200) not null,
	SENHA_US varchar(20) not null,
	AVATAR_US longblob,
	COD_MOEDA int default 1 not null,
	COD_NIVEL_ACESSO int not null, 
	COD_US_GRUPO int default null,

	constraint foreign key FK_MOEDA(COD_MOEDA) references COTACAO(COD_MOEDA),
    constraint foreign key FK_NIVEL_AC(COD_NIVEL_ACESSO) references NIVEL_ACESSO(COD_NIVEL_AC),
	constraint foreign key FK_US_GRUPO(COD_US_GRUPO) references USUARIO(COD_US)
);

create table CATEGORIA
(
	COD_CAT int auto_increment primary key,
	TIPO_CAT varchar(20) not null,
	DESCR_CAT varchar(20) not null

);


create table SUBCATEGORIAS
(
	COD_SUBCAT int auto_increment primary key,
	COD_CAT int not null,
	DESCR_SUBCAT varchar(40) not null,
	
    constraint foreign key FK_CAT(COD_CAT) references CATEGORIA(COD_CAT)
);

create table CONTA_BANCO
(
	COD_CONTA int auto_increment primary key,
	COD_US int not null,
	NUM_CONTA int not null,
	NUM_AGENCIA int not null,
	SALDO real default 0.00,
    
    constraint foreign key FK_BANC_US(COD_US) references USUARIO(COD_US)
);

create table FORMA_PGTO
(
	COD_FORMA_PGTO int auto_increment primary key,
	DESCR_FORMA_PGTO varchar(20) not null

);

create table RECEITA
(
	COD_REC int auto_increment primary key,
	COD_US int not null,
	DATA_REC datetime not null,
	COD_CAT int not null,
	COD_SUBCAT int default null,
	COMPROVANTE mediumblob , 
	VALOR real not null,
 	COD_CONTA int default null,
	COD_FORMA_PGTO int default null,

	constraint foreign key FK_REC_US(COD_US) references USUARIO(COD_US),
    constraint foreign key FK_REC_CAT(COD_CAT) references CATEGORIA(COD_CAT),
    constraint foreign key FK_REC_SUBCAT(COD_SUBCAT) references SUBCATEGORIAS(COD_SUBCAT),
    constraint foreign key FK_REC_CONTA(COD_CONTA) references CONTA_BANCO(COD_CONTA),
    constraint foreign key FK_REC_FORMA_PGTO(COD_FORMA_PGTO) references FORMA_PGTO(COD_FORMA_PGTO)
);

create table DESPESA
(
	COD_DESP int auto_increment primary key,
	COD_US int not null,
	DATA_DESP datetime not null,
	COD_CAT int not null,
	COD_SUBCAT int default null,
	COMPROVANTE mediumblob , 
	VALOR real not null,
 	COD_CONTA int default null,
	COD_FORMA_PGTO int default null,

	constraint foreign key FK_DESP_USUARIO(COD_US) references USUARIO(COD_US),
    constraint foreign key FK_DESP_CAT(COD_CAT) references CATEGORIA(COD_CAT),
    constraint foreign key FK_DESP_SUBCAT(COD_SUBCAT) references SUBCATEGORIAS(COD_SUBCAT),
    constraint foreign key FK_DESP_CONTA(COD_CONTA) references CONTA_BANCO(COD_CONTA),
    constraint foreign key FK_DESP_FORMA_PGTO(COD_FORMA_PGTO) references FORMA_PGTO(COD_FORMA_PGTO)
);




