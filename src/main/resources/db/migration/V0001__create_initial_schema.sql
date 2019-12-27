CREATE TABLE account (
    id                      BIGINT PRIMARY KEY,
    uuid                    VARCHAR(200) NOT NULL UNIQUE,
    user_name               VARCHAR(200) NOT NULL,
    aangemaakt_op           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    gewijzigd_op            TIMESTAMP
);

CREATE INDEX idx_account_uuid
    ON account (uuid);

CREATE SEQUENCE account_seq;

CREATE TABLE user_profile (
    id                      BIGINT PRIMARY KEY,
    uuid                    VARCHAR(200) NOT NULL UNIQUE,
    account_uuid            VARCHAR(200) NOT NULL,
    email                   VARCHAR(200) NOT NULL,
    total_adults            INTEGER NOT NULL,
    total_children          INTEGER NOT NULL,
    is_primary              BOOLEAN,
    profile_type            VARCHAR(15) NOT NULL,
    aangemaakt_op           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    gewijzigd_op            TIMESTAMP,
    versie                  INTEGER DEFAULT 0,
    CONSTRAINT user_profile_account_fk FOREIGN KEY (account_uuid) REFERENCES account (uuid)
);

CREATE INDEX idx_user_profile_uuid
    ON user_profile (uuid);

CREATE SEQUENCE user_profile_seq;