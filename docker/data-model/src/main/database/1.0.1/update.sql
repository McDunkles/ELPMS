/*

Schema update example:
psql -h 0.0.0.0 -d saltbrook -p 5532 -U postgres -a -v tenant=some_tenant -f ./update.sql
  
*/

drop table if exists :tenant.account cascade;

create table :tenant.account 
   as select * from :tenant.account_v2;

drop table if exists :tenant.building cascade;   
   
create table :tenant.building 
   as select * from :tenant.building_v2;

drop table if exists :tenant.recurring_expense cascade;   
   
create table :tenant.recurring_expense 
   as select * from :tenant.recurring_expense_v2;
   

start transaction;
   
insert into :tenant.update_info(version, update_time, details) 
   values('1.0.1', current_timestamp, 'Copied _v2 tables and saved without version suffix');
   
commit;


grant select on all tables in schema :tenant to :tenant;

