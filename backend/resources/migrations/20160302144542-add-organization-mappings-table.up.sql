CREATE TABLE organization_mappings
(id SERIAL PRIMARY KEY,
 domain VARCHAR(255) UNIQUE,
 code VARCHAR(255));