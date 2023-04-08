#!/bin/bash
set -x
mkdir -p $HOME/signals
source $HOME/scripts/init_vars.sh
if [[ ! -f $HOME/signals/${TENANT}.db-init.finished ]]; then
    echo "Check time is $(date +%Y%m%d_%H%M)"
    echo "#-----------------------------"
    echo "# DB init script modification"
    echo "#-----------------------------"
    file=$HOME/${CI_PROJECT_NAME}/src/main/database/1.0.0/new.sql
    echo "\set tenant ${TENANT}" | cat - $file > temp && mv temp $file
    sed -i "s/\:tenant_password/\'$TENANT_PASSWORD\'/g" $file
    echo "DB init script execution"
    touch $HOME/signals/${TENANT}.db-init.log
    psql --host ${DBHOSTADDR} --username ${DBUSER} --dbname ${DBNAME} -v ON_ERROR_STOP=1 -f $file < $HOME/signals/${TENANT}.db-init.log > $HOME/signals/${TENANT}.db-init.log 2>&1
    status=$(grep -i "ERROR" $HOME/signals/${TENANT}.db-init.log | wc -l)
    [ $status -eq 0 ] && echo "DB init was successful" && touch $HOME/signals/${TENANT}.db-init.finished || return 1
elif [[ ! -f $HOME/signals/${TENANT}.db-update.${VERSION}.finished ]]; then
    echo "Check time is $(date +%Y%m%d_%H%M)"
    echo "#----------------------------------"
    echo "# DB schema backup prior to update"
    echo "#----------------------------------"
    psql --host ${DBHOSTADDR} --username ${DBUSER} --dbname ${DBNAME}  --port=5432 --command "DROP SCHEMA IF EXISTS ${TENANT}_backup CASCADE;"
    PGPASSWORD=${PGPASSWORD} psql --port=5432 "dbname=${DBNAME} user=${DBUSER} hostaddr=${DBHOSTADDR}" --command "CREATE ROLE ${TENANT}_backup WITH LOGIN ENCRYPTED PASSWORD '${TENANT_PASSWORD}';"
    pg_dump --host ${DBHOSTADDR} --username ${DBUSER} --schema=${TENANT} ${DBNAME} | sed "s/${TENANT}/${TENANT}_backup/g" | psql --host ${DBHOSTADDR} --username ${DBNAME}
    echo "DB ${VERSION} script modification"
    file=$HOME/${CI_PROJECT_NAME}/src/main/database/${VERSION}/update.sql
    echo "\set tenant ${TENANT}" | cat - $file > temp && mv temp $file
    sed -i "s/\:tenant_password/\'$TENANT_PASSWORD\'/g" $file
    touch $HOME/signals/${TENANT}.db-update.${VERSION}.log
    psql --host ${DBHOSTADDR} --username ${DBUSER} --dbname ${DBNAME} -v ON_ERROR_STOP=1 -f $file < $HOME/signals/${TENANT}.db-update.${VERSION}.log > $HOME/signals/${TENANT}.db-update.${VERSION}.log 2>&1
    status=$(grep "ERROR" $HOME/signals/${TENANT}.db-update.${VERSION}.log | wc -l)
    [ $status -eq 0 ] && echo "DB ${VERSION} update was successful" && touch $HOME/signals/${TENANT}.db-update.${VERSION}.finished || return 1
else
    echo "DB init and DB ${VERSION} updates already completed"
fi