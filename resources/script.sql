create database agenda;

create table contatos(
    id not null integer primary key autoincrement,
    nome varchar(100),
    telefone varchar(100),
    register_date date
);