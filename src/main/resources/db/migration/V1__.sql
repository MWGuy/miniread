CREATE EXTENSION IF NOT EXISTS hstore;

CREATE TABLE manga
(
    id          UUID         NOT NULL,
    slug        VARCHAR(255) NOT NULL,
    name        HSTORE       NOT NULL,
    poster      VARCHAR(255) NOT NULL,
    description TEXT,
    CONSTRAINT pk_manga PRIMARY KEY (id)
);

ALTER TABLE manga
    ADD CONSTRAINT uc_manga_slug UNIQUE (slug);
