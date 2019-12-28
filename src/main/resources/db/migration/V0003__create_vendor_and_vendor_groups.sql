CREATE TABLE vendor_group (
    id                      BIGINT PRIMARY KEY,
    uuid                    VARCHAR(200) NOT NULL UNIQUE,
    group_name              VARCHAR(200) NOT NULL,
    aangemaakt_op           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    gewijzigd_op            TIMESTAMP
);

CREATE INDEX idx_vendor_group_uuid
    ON vendor_group (uuid);

CREATE SEQUENCE vendor_group_seq;

CREATE TABLE vendor (
    id                      BIGINT PRIMARY KEY,
    uuid                    VARCHAR(200) NOT NULL UNIQUE,
    vendor_name             VARCHAR(200) NOT NULL,
    aangemaakt_op           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    gewijzigd_op            TIMESTAMP
);

CREATE INDEX idx_vendor_uuid
    ON vendor (uuid);

CREATE SEQUENCE vendor_seq;

CREATE TABLE vendor_vendorgroup (
    vendor_uuid             VARCHAR(200),
    vendor_group_uuid       VARCHAR(200),
    CONSTRAINT vendor_fk FOREIGN KEY (vendor_uuid) REFERENCES vendor (uuid),
    CONSTRAINT vendor_group_fk FOREIGN KEY (vendor_group_uuid) REFERENCES vendor_group (uuid)
);