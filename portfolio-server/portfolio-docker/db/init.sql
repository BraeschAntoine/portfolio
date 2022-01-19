create database portfolio_db;
create user portfolio_user with encrypted password 'admin';
grant all privileges on database portfolio_db to portfolio_user;

create database keycloak_db;
create user keycloak_user with encrypted password 'keycloak_pwd';
grant all privileges on database keycloak_db to keycloak_user;
