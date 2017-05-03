show processlist;

SET SQL_SAFE_UPDATES=0;

/*Saber as informações de variaveis do mysql e alterar as mesmas*/
SHOW VARIABLES;
SET nome_da_variavel = novo_valor;

insert into TB_TP_USUARIO values (1,'ADMINISTRADOR');


insert into TB_USUARIO values (1,'Administrador Sistema','ALex',' XXXXXX',sysdate(),null,sysdate(),0,'000.000.000.00','4200000',1,'21321321','23132123');
insert into TB_USER values (1,'financeiro@centraldarevendedora.com.br','e10adc3949ba59abbe56e057f20f883e',1);

insert into TB_USUARIO values (2,'Usuaria','Alicia','Maria Gomes',sysdate(),null,sysdate(),0,'000.000.000.00','0000000',1,'000000','00000');
insert into TB_USER values (2,'amaria@centraldarevendedora.com.br','e10adc3949ba59abbe56e057f20f883e',1);

insert into TB_USUARIO values (3,'Usuaria','Mayara','Ferreira Lanzetti',sysdate(),null,sysdate(),0,'000.000.000.00','0000000',1,'000000','00000');
insert into TB_USER values (3,'mferreira@centraldarevendedora.com.br','e10adc3949ba59abbe56e057f20f883e',1);

insert into TB_USUARIO values (4,'Usuaria','Thaynara','Duarte Custodio',sysdate(),null,sysdate(),0,'000.000.000.00','0000000',1,'000000','00000');
insert into TB_USER values (4,'tduarte@centraldarevendedora.com.br','e10adc3949ba59abbe56e057f20f883e',1);

insert into TB_USUARIO values (5,'Usuaria','Jhenifer','Silva Inicecio',sysdate(),null,sysdate(),0,'000.000.000.00','0000000',1,'000000','00000');
insert into TB_USER values (5,'jsilva@centraldarevendedora.com.br','e10adc3949ba59abbe56e057f20f883e',1);


insert into TB_MENU values (1,'Painel','../sistema/painelCentral.faces',1);
insert into TB_MENU values (2,'Pedidos','../sistema/listaRevendedores.faces',1);
insert into TB_MENU values (3,'Alterar Senha','../sistema/alterarSenha.faces',1);
insert into TB_MENU values (4,'Incluir Pedido','../sistema/alterar_pedido.faces',1);
insert into TB_MENU values (5,'Alterar Data Entrega','../sistema/cadastroEntregaPedido.faces',1);
insert into TB_MENU values (6,'Catalogos','../sistema/cadastroCatalogoVirtual.faces',1);




update cadastro set cpf = replace (cpf,'.','');
update cadastro set cpf = replace (cpf,'-','');

update cadastro set rg = replace (rg,'.','');
update cadastro set rg = replace (rg,'-','');


insert into status values (1,'EM ANALISE');
insert into status values (2,'PEDIDO SITE');
insert into status values (3,'APROVADO');
insert into status values (4,'REPROVADO');
insert into status values (5,'FINALIZADO');
insert into status values (6,'AGUARD. CONTATO');

insert into status values (7,'APROV. ENVIO');
insert into status values (8,'REPROV. ENVIO');
insert into status values (9,'CAT. ENVIADO');
insert into status values (10,'CAT. RECEBIDO');


insert TB_ESTADO_DATA value (1,'15/10/2016','SÃO PAULO','15/09/2016','30/09/2016')
insert TB_ESTADO_DATA value (2,'15/10/2016','SP (litoral)','15/09/2016','30/09/2016')
insert TB_ESTADO_DATA value (3,'15/10/2016','Minas-Gerais','15/09/2016','05/10/2016')
insert TB_ESTADO_DATA value (4,'20/10/2016','Rio de Janeiro','19/09/2016','10/10/2016')
insert TB_ESTADO_DATA value (5,'15/10/2016','Espírito Santo','15/09/2016','05/10/2016')

select * from cadastro t where  data Between '2016-08-07' and '2016-08-24' and statusItem_status_id in (1); 


select count(t.cpf), t.cpf 
  from cadastro t 
  group by t.cpf 
  HAVING COUNT(*)>1; 

/* Executar a carga de duas planilhas 
 * cpf´s
 * produtos
 * */
  
  
  
  ALTER TABLE `centrald_prod`.`cadastro` 
CHANGE COLUMN `status` `status` VARCHAR(1) NULL DEFAULT 'G' ,
CHANGE COLUMN `complemento` `complemento` VARCHAR(120) NULL ,
CHANGE COLUMN `referencia` `referencia` VARCHAR(120) NULL ,
CHANGE COLUMN `catalogo_pedido` `catalogo_pedido` DATE NULL ,
CHANGE COLUMN `catalogo_pedido_status` `catalogo_pedido_status` VARCHAR(1) NULL DEFAULT 'N' ,
CHANGE COLUMN `catalogo_envio_status` `catalogo_envio_status` VARCHAR(1) NULL DEFAULT 'N' ,
CHANGE COLUMN `limite_credito` `limite_credito` DOUBLE NULL DEFAULT '500' ,
CHANGE COLUMN `observacao` `observacao` TEXT NULL ,
CHANGE COLUMN `cod_executiva` `cod_executiva` VARCHAR(6) NULL ,
CHANGE COLUMN `cod_executiva_x` `cod_executiva_x` VARCHAR(6) NULL ;


select CONCAT( 'update cadastro set nome = ''' , convert(cast(convert(nome using latin1) as binary) using utf8),'''' , ' where id = ' ,id, ';' )from cadastro;

