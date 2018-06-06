/*
Arquivo de Insersao no banco de dados.
*/


/*
Insert de Paises
*/
INSERT INTO `tbpais` (`idpais`,`nomepais`) VALUES (1,'Brasil');
INSERT INTO `tbpais` (`idpais`,`nomepais`) VALUES (2,'Argentina');

/*
Insert de Estados
*/
INSERT INTO `tbestado` (`idestado`,`nomeEstado`,`tbpais_idpais`) VALUES (1,'Rio Grande do Sul',1);
INSERT INTO `tbestado` (`idestado`,`nomeEstado`,`tbpais_idpais`) VALUES (2,'Buenos Aires',2);
INSERT INTO `tbestado` (`idestado`,`nomeEstado`,`tbpais_idpais`) VALUES (3,'Santa Catarina',1);
INSERT INTO `tbestado` (`idestado`,`nomeEstado`,`tbpais_idpais`) VALUES (4,'Catamarca',2);
INSERT INTO `tbestado` (`idestado`,`nomeEstado`,`tbpais_idpais`) VALUES (15,'Rio de Janeiro',1);
INSERT INTO `tbestado` (`idestado`,`nomeEstado`,`tbpais_idpais`) VALUES (16,'São Paulo',1);

/*
Insert de Cidades
*/

INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (1,'Pelotas',1);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (2,'Rio Grande',1);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (3,'Buenos Aires',2);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (4,'San Martín',2);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (5,'Ribeirão Preto',16);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (6,'San Antonio',4);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (7,'Andalgala',4);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (9,'Florianopolis',3);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (10,'Bombinhas',3);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (11,'Serrana',16);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (12,'Rio de Janeiro',15);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (13,'Piratini',1);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (14,'Bagé',1);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (15,'São José',3);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (16,'Blumenau',3);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (17,'Timbó',3);
INSERT INTO `tbcidade` (`idcidade`,`nomecidade`,`tbestado_idestado`) VALUES (18,'Osasco',16);

/*
Insert de Empregados
*/
INSERT INTO `tbempregado` (`idempregado`,`nome`,`sobrenome`,`endereco`,`codigoArea`,`telefone`,`tbpais_idpais`,`tbestado_idestado`,`tbcidade_idcidade`) VALUES (1,'Josesclei','Borges','Rua das Orquides','053','32717561',1,1,1);