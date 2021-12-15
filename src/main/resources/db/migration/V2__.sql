CREATE TABLE branch
(
    id       UUID NOT NULL,
    manga_id UUID NOT NULL,
    CONSTRAINT pk_branch PRIMARY KEY (id)
);

CREATE TABLE branch_teams
(
    branch_id UUID NOT NULL,
    teams_id  UUID NOT NULL,
    CONSTRAINT pk_branch_teams PRIMARY KEY (branch_id, teams_id)
);

CREATE TABLE chapter
(
    id        UUID    NOT NULL,
    name      VARCHAR(255),
    volume    INTEGER NOT NULL,
    number    INTEGER,
    branch_id UUID    NOT NULL,
    CONSTRAINT pk_chapter PRIMARY KEY (id)
);

CREATE TABLE page
(
    id         UUID         NOT NULL,
    image      VARCHAR(255) NOT NULL,
    chapter_id UUID         NOT NULL,
    CONSTRAINT pk_page PRIMARY KEY (id)
);

CREATE TABLE team
(
    id          UUID         NOT NULL,
    slug        VARCHAR(255) NOT NULL,
    name        HSTORE       NOT NULL,
    poster      VARCHAR(255) NOT NULL,
    description TEXT,
    CONSTRAINT pk_team PRIMARY KEY (id)
);

ALTER TABLE team
    ADD CONSTRAINT uc_team_slug UNIQUE (slug);

ALTER TABLE branch
    ADD CONSTRAINT FK_BRANCH_ON_MANGA FOREIGN KEY (manga_id) REFERENCES manga (id);

CREATE INDEX idx_branch_manga_id ON branch (manga_id);

ALTER TABLE chapter
    ADD CONSTRAINT FK_CHAPTER_ON_BRANCH FOREIGN KEY (branch_id) REFERENCES branch (id);

CREATE INDEX idx_chapter_branch_id ON chapter (branch_id);

ALTER TABLE page
    ADD CONSTRAINT FK_PAGE_ON_CHAPTER FOREIGN KEY (chapter_id) REFERENCES chapter (id);

CREATE INDEX idx_page_chapter_id ON page (chapter_id);

ALTER TABLE branch_teams
    ADD CONSTRAINT fk_bratea_on_branch FOREIGN KEY (branch_id) REFERENCES branch (id);

ALTER TABLE branch_teams
    ADD CONSTRAINT fk_bratea_on_team FOREIGN KEY (teams_id) REFERENCES team (id);
