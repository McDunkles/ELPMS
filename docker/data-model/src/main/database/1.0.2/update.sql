/*

Schema update example:
psql -h 0.0.0.0 -d saltbrook -p 5532 -U postgres -a -v tenant=some_tenant -f ./update.sql
  
*/

create table :tenant.gis_biz_data_layer (
   id  bigserial not null,
   url varchar(512) not null,
   primary key (id)
);
   
create table :tenant.gis_building_height_layer (
   id  bigserial not null,
   url varchar(512) not null,
   primary key (id)
);

alter table :tenant.gis_biz_data_layer
   add constraint uk_gis_biz_data_layer unique (url);   

alter table :tenant.gis_building_height_layer
   add constraint uk_gis_building_height_layer unique (url);   

   
start transaction;

insert into :tenant.gis_building_height_layer(url)
	values('https://services8.arcgis.com/j712QaNqwKR5YFkP/arcgis/rest/services/3db_US_Philadelphia_02/FeatureServer/0');
insert into :tenant.gis_building_height_layer(url)
	values('https://services8.arcgis.com/j712QaNqwKR5YFkP/arcgis/rest/services/LA_Buildings/FeatureServer/0');
   

insert into :tenant.update_info(version, update_time, details) 
   values('1.0.2', current_timestamp, 'Added GIS_BIZ_DATA_LAYER, GIS_BUILDING_HEIGHT_LAYER tables');
   
commit;


grant select on all tables in schema :tenant to :tenant;

