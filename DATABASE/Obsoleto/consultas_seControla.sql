use db_secontrola;
-- Total de despesa do grupo Domético no mês(Tela inicial)
SELECT sum(d.valor) FROM despesa d, usuario u WHERE d.cod_us=u.cod_us AND u.cod_us_grupo=2 and month(d.data_desp) = month(curdate());

-- Lista de todas as despesas do grupo familia I
SELECT u.nome_us, d.data_desp, d.valor, d.cod_conta FROM despesa d, usuario u WHERE d.cod_us=u.cod_us AND u.cod_us_grupo=2 AND MONTH(d.data_desp) = MONTH(CURDATE());
-- Seleciona todas as despesas do grupo familia II
SELECT u.nome_us, d.data_desp, d.valor, d.cod_conta FROM despesa d, usuario u WHERE d.cod_us=u.cod_us AND u.cod_us_grupo=5;


-- Total de receita do grupo Domético no mês(Tela inicial)
-- Seleciona todas as receitas do grupo familia I
SELECT u.nome_us, r.data_rec, r.valor, r.cod_conta FROM receita r, usuario u WHERE r.cod_us=u.cod_us AND u.cod_us_grupo=2;
-- , usuario u WHERE u.COD_US_GRUPO=r.COD_US AND COD_DESP=1;
-- Seleciona todas as receitas do grupo familia II
SELECT u.nome_us, r.data_rec, r.valor, r.cod_conta FROM receita r, usuario u WHERE r.cod_us=u.cod_us AND u.cod_us_grupo=5;

-- Lista de Despesas do mês por usuário
SELECT u.nome_us, d.data_desp, c.DESCR_CAT ,d.valor  FROM despesa d, usuario u, categoria c  WHERE d.cod_us=u.cod_us AND d.cod_us=2;
SELECT u.nome_us, d.data_desp, c.DESCR_CAT ,d.valor  FROM despesa d, usuario u, categoria c  WHERE d.cod_us=u.cod_us AND d.cod_us=3;
SELECT u.nome_us, d.data_desp, c.DESCR_CAT ,d.valor  FROM despesa d, usuario u, categoria c  WHERE d.cod_us=u.cod_us AND d.cod_us=4;
SELECT u.nome_us, d.data_desp, c.DESCR_CAT ,d.valor  FROM despesa d, usuario u, categoria c  WHERE d.cod_us=u.cod_us AND d.cod_us=6;

-- Lista de Receitas do mês por usuário
SELECT u.nome_us, r.data_rec, r.valor, r.cod_conta FROM receita r, usuario u WHERE r.cod_us=u.cod_us AND u.cod_us=2;
SELECT u.nome_us, r.data_rec, r.valor, r.cod_conta FROM receita r, usuario u WHERE r.cod_us=u.cod_us AND u.cod_us=5;

-- Lista de Categorias por Receita
SELECT * FROM categoria c WHERE c.tipo_cat = 'RECEITA';

-- Lista de Categorias por Despesa
SELECT * FROM categoria c WHERE c.tipo_cat = 'DESPESA';

-- Lista de Subcategorias por Categoria
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 1;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 2;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 3;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 4;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 5;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 6;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 7;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 8;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 9;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 13;
SELECT s.cod_subcat, s.descr_subcat FROM subcategorias s WHERE s.cod_cat = 18;

-- Ranking de gastos por categoria do grupo familiar (Do maior para o menor);
SELECT u.nome_us, d.data_desp, d.valor, d.cod_conta FROM despesa d, usuario u WHERE d.cod_us=u.cod_us AND u.cod_us_grupo=2 ORDER BY d.valor DESC;
SELECT u.nome_us, d.data_desp, d.valor, d.cod_conta FROM despesa d, usuario u WHERE d.cod_us=u.cod_us AND u.cod_us_grupo=5 ORDER BY d.valor DESC;

-- Inflação doméstica por período
-- inflação de usuário por período
-- inflação de categoria por período
SELECT * FROM despesa d ;


