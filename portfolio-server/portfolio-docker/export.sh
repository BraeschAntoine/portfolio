bin/standalone.sh -Dkeycloak.migration.action=export -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.realmName=DefaultRealm -Dkeycloak.migration.usersExportStrategy=defaultrealm-realm.json -Dkeycloak.migration.file=/import/defaultrealm-realm.json -Djboss.socket.binding.port-offset=99