/******************************************************************************
Requisitos para testar: Rodar todos os scripts de Views previamente.
*******************************************************************************/
USE DB_SECONTROLA;
/*
A tela inicial apresentará um gráfico comparativo contendo o total de receitas e despesas lançadas no mês corrente:
*Obs: contendo como filtro, além do mês corrente, o grupo familiar
*/
SELECT SUM(VALOR) AS 'RECEITA MENSAL TOTAL' FROM TODAS_RECEITAS 
	WHERE `GRUPO DOMESTICO`  = 2 AND MONTH(`DATA`) = MONTH(CURDATE());
SELECT SUM(VALOR) AS 'RECEITA MENSAL TOTAL' FROM TODAS_DESPESAS 
	WHERE `GRUPO DOMESTICO`  = 2 AND MONTH(`DATA`) = MONTH(CURDATE());


/*
Receitas de um determinado grupo doméstico no mês
*/
SELECT CATEGORIA, SUBCATEGORIA ,NOME AS RESPONSAVEL ,`DATA`, VALOR FROM TODAS_RECEITAS
	WHERE `GRUPO DOMESTICO`  = 2 AND MONTH(`DATA`) = MONTH(CURDATE());
/*
Despesas de um determinado grupo doméstico no mês
*/
SELECT CATEGORIA, SUBCATEGORIA ,NOME AS RESPONSAVEL ,`DATA`, VALOR FROM TODAS_DESPESAS
	WHERE `GRUPO DOMESTICO`  = 2 AND MONTH(`DATA`) = MONTH(CURDATE());

/*
Lista de Despesas do mês por usuário - Cada usuário poderá acessar o que gastou de forma detalhada
*/
SELECT CATEGORIA, SUBCATEGORIA,`DATA`, VALOR, `CONTA DEBITADA`,`FORMA DE PAGAMENTO` FROM TODAS_DESPESAS
	WHERE `GRUPO DOMESTICO`  = 2 AND NOME LIKE '%FRANCISLAUDO%';

/*
Lista de Receitas do mês por usuário - Cada usuário poderá acessar o que ganhou de forma detalhada
*/
SELECT CATEGORIA, SUBCATEGORIA,`DATA`, VALOR, `CONTA CREDITADA`,`FORMA DE PAGAMENTO` FROM TODAS_RECEITAS
	WHERE `GRUPO DOMESTICO`  = 2 AND NOME LIKE '%FRANCISLAUDO%';


/*
Lista de Categorias por Despesa - Ao clicar para lançar uma Despesa, será exibida a relação de categorias ao usuário
*/
SELECT DISTINCT  CATEGORIAS  FROM LISTA_CAT_E_SUBCAT  WHERE  TIPO = 'DESPESA';
/*
Lista de Categorias por Receita - Ao clicar para lançar uma receita, será exibida a relação de categorias ao usuário
*/
SELECT DISTINCT  CATEGORIAS  FROM LISTA_CAT_E_SUBCAT  WHERE  TIPO = 'RECEITA';

/*
Lista de Subcategorias por Categoria - Ao selecionar uma categoria, o usuário tem a opção de associar (ou não) uma subcategoria Ex: ALIMENTACAO (cat.) -> ACOUGUE (subcat.)
Obs: a categoria para filtro será selecionada previamente pelo usuário no aplicativo. Exemplos:
*/
-- Exemplo - para Despesas:
SELECT  SUBCATEGORIAS  FROM LISTA_CAT_E_SUBCAT  WHERE  CATEGORIAS = 'ALIMENTACAO';
SELECT  SUBCATEGORIAS  FROM LISTA_CAT_E_SUBCAT  WHERE  CATEGORIAS = 'TRANSPORTE';
SELECT  SUBCATEGORIAS  FROM LISTA_CAT_E_SUBCAT  WHERE  CATEGORIAS = 'EDUCACAO';

-- Exemplo - para Receitas:
SELECT  SUBCATEGORIAS  FROM LISTA_CAT_E_SUBCAT  WHERE  CATEGORIAS = 'INVESTIMENTOS';
