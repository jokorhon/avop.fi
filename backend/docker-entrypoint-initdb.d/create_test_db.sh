#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE USER avopfi-test;
    CREATE DATABASE avopfi-test;
    GRANT ALL PRIVILEGES ON DATABASE avopfi-test TO avopfi-test;
EOSQL