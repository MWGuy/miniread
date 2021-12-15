ALTER TABLE chapter
    ADD created_at TIMESTAMP WITHOUT TIME ZONE default current_timestamp;

ALTER TABLE chapter
    ALTER COLUMN created_at SET NOT NULL;
