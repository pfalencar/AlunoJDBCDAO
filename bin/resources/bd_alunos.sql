create database db_alunos;
use db_alunos;

create table alunos (
  id int auto_increment not null,
  nome varchar(50) not null,
  endereco varchar(50),
  bairro varchar(30),
  primary key(id)
);


insert into alunos (nome, endereco, bairro) values ('Fernanda','Rua A','Jd. Flores');
insert into alunos (nome, endereco, bairro) values ('Patricia','Av. 2 2600','Jd.Nicolau');
insert into alunos (nome, endereco, bairro) values ('Patri','Av. 3, 260','Jd. Vitoria');
select * from alunos;
select * from alunos where nome = 'NR';

update alunos set nome = 'Patricia', endereco='Rua Chama' where id = 2;
update alunos set endereco='Rua Benjamin Franklin, 200' where id = 3;

delete from alunos where id= 3;

RENAME TABLE alunos TO aluno;
select * from aluno;

drop table aluno;