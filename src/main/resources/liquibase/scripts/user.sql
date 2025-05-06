-- liquibase formatted sql

-- changelog user:1
drop table Requests

create table Requests(
id bigint,
query text[],
arguments text,
negate bool
)
select * from Requests
