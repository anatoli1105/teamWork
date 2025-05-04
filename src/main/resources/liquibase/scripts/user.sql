-- liquibase formatted sql

-- changelog user:1
create table Requests(
id serial,
query text,
arguments text,
negate BOOL

)

select * from Requests
