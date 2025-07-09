-- liquibase formatted sql

-- changelog user:1
create table Recommendations(
id bigint,
useId uuid,
productName varchar,
product_Id uuid,
productText text


)

drop table recommendations
create table Recommendations(
id bigint,
use_id uuid,
product_name varchar,
product_Id uuid,
product_text text


)
select * from Recommendations

select * from requests

select * from request
-- changelog user:2





