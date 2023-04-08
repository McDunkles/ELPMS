/*

Schema update example:
psql -h 0.0.0.0 -d saltbrook -p 5532 -U postgres -a -v tenant=some_tenant -f ./update.sql
  
*/

   
start transaction;

insert into :tenant.gis_biz_data_layer(url)
	values('https://services8.arcgis.com/j712QaNqwKR5YFkP/arcgis/rest/services/biz_data_MO_MN_IA_KS_NE_SD_ND/FeatureServer/0');
	
insert into :tenant.gis_building_height_layer(url)
	values('https://services8.arcgis.com/j712QaNqwKR5YFkP/arcgis/rest/services/3db_US_Minneapolis/FeatureServer/0');
	
insert into :tenant.update_info(version, update_time, details) 
   values('1.0.4', current_timestamp, 'Updated GIS_BIZ_DATA_LAYER, GIS_BUILDING_HEIGHT_LAYER tables');
   
commit;

