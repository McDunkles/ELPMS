psql -d saltbrook -p 5532 -U postgres -a -v tenant=fyrefish -v tenant_password="postgres" -f 1.0.0/new.sql

psql -d saltbrook -p 5532 -U postgres -a -v tenant=fyrefish -f 1.0.1/update.sql

psql -d saltbrook -p 5532 -U postgres -a -v tenant=fyrefish -f 1.0.2/update.sql

psql -d saltbrook -p 5532 -U postgres -a -v tenant=fyrefish -f 1.0.3/update.sql

psql -d saltbrook -p 5532 -U postgres -a -v tenant=fyrefish -f 1.0.4/update.sql