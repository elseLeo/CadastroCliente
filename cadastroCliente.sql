USE cadastroCliente
create table cliente (
cod_cliente int (50) primary key,
nome char (50),
sobrenome char (50),
profissao char (50),
telefone char (50))
select * from cliente