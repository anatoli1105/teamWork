-- liquibase formatted sql

-- changelog user:1

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


select * from Recommendations
alter table recommendation add FOREIGN KEY
('product_name')
REFERENCES Request('Recommendations_product_name')

select * from recommendations










