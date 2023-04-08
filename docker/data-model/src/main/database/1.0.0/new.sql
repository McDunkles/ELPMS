/*
 
Schema creation example:
psql -h 0.0.0.0 -d saltbrook -p 5532 -U postgres -a -v tenant=some_tenant -v tenant_password="'some_tenant_pwd'" -f ./new.sql
 
*/

create user :tenant with password :tenant_password;

create schema authorization :tenant;


create table :tenant.account_v2 (
   id varchar(255) not null,
   name varchar(255),
   type varchar(255),
   sub_type varchar(255),
   billing_address varchar(255),
   billing_city varchar(255),
   billing_state varchar(255),
   billing_postal_code varchar(255),
   comments varchar(255),
   primary key (id)
);

create table :tenant.building_v2 (
   id varchar(255) not null,
   name varchar(255) not null,
   vanity_name varchar(255),
   tenant_count int4,
   address varchar(255),
   city varchar(255),
   state varchar(255),
   postal_code varchar(255),
   type varchar(255),
   sub_type varchar(255),
   status varchar(255),
   location public.GEOMETRY,
   owner_id varchar(255),
   total_area float4,
   construction_type varchar(255),
   comments varchar(255),
   primary key (id)
);

create table :tenant.loader_job (
   id  bigserial not null,
   job_id UUID not null,
   type varchar(255) not null,
   status varchar(255) not null,
   start_time TIMESTAMP WITH TIME ZONE not null,
   end_time TIMESTAMP WITH TIME ZONE,
   details varchar(255),
   primary key (id)
);

create table :tenant.recurring_expense_v2 (
   id varchar(255) not null,
   name varchar(255) not null,
   expense_type varchar(255),
   amount float4 not null,
   create_date date not null,
   charge_month date not null,
   bandwidth float4,
   asset_id varchar(255),
   account_id varchar(255),
   primary key (id)
);

create table :tenant.recurring_revenue (
   id varchar(255) not null,
   name varchar(255) not null,
   service_type varchar(255),
   amount float4 not null,
   create_date date not null,
   charge_month date not null,
   asset_id varchar(255),
   account_id varchar(255),
   primary key (id)
);

create table :tenant.marketing (
   id bigserial not null,
   building_id text not null,
   penetration_planned real,
   penetration_actual real,
   cancelled_customers integer
);

create table :tenant.revenue (
   id bigserial not null,
   building_id text not null,
   arpu_planned real,
   arpu_actual real,
   irr_planned real,
   irr_actual real,
   capex_planned real,
   capex_actual real,
   mrr_planned real,
   mrr_actual real
);

create table :tenant.utilization (
   id bigserial not null,
   building_id text not null,
   bandwidth real,
   percent_utilization_avg real,
   vendor_name text
);

create table :tenant.threshold_config (
   id bigserial not null,
   metric text not null,
   red real,
   yellow real,
   green real,
   red_ranges text,
   yellow_ranges text,
   green_ranges text,
   reverse boolean default false
);

create table :tenant.update_info (
   id serial not null,
   version varchar(50) not null,
   update_time TIMESTAMP WITH TIME ZONE not null,
   
   details varchar(255)
);

alter table :tenant.loader_job
   add constraint uk_loader_job unique (job_id);
   
alter table :tenant.update_info
   add constraint uk_update_info unique (version);   
   
   
start transaction;
   
insert into :tenant.update_info(version, update_time, details) 
   values('1.0.0', current_timestamp, 'Fresh schema');
   
commit;


grant select on all tables in schema :tenant to :tenant;

