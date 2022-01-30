CREATE SCHEMA IF NOT EXISTS portfolio;

CREATE TABLE portfolio.company
(
    id       UUID NOT NULL,
    name     VARCHAR(255),
    link     VARCHAR(255),
    image_id UUID,
    CONSTRAINT pk_company PRIMARY KEY (id)
);

CREATE TABLE portfolio.experience
(
    id          UUID NOT NULL,
    from_date   TIMESTAMP WITHOUT TIME ZONE,
    to_date     TIMESTAMP WITHOUT TIME ZONE,
    company_id  UUID,
    title       VARCHAR(255),
    description VARCHAR(255),
    user_id     UUID,
    CONSTRAINT pk_experience PRIMARY KEY (id)
);

CREATE TABLE portfolio.experience_technologies
(
    experience_id UUID NOT NULL,
    technology_id UUID NOT NULL,
    CONSTRAINT pk_experience_technologies PRIMARY KEY (experience_id, technology_id)
);

CREATE TABLE portfolio.image
(
    id       UUID NOT NULL,
    name     VARCHAR(255),
    alt_name VARCHAR(255),
    path     VARCHAR(255),
    CONSTRAINT pk_image PRIMARY KEY (id)
);

CREATE TABLE portfolio.project
(
    id          UUID NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    user_id     UUID,
    CONSTRAINT pk_project PRIMARY KEY (id)
);

CREATE TABLE portfolio.project_images
(
    project_id UUID NOT NULL,
    images_id  UUID NOT NULL,
    CONSTRAINT pk_project_images PRIMARY KEY (project_id, images_id)
);

CREATE TABLE portfolio.project_technologies
(
    project_id    UUID NOT NULL,
    technology_id UUID NOT NULL,
    CONSTRAINT pk_project_technologies PRIMARY KEY (project_id, technology_id)
);

CREATE TABLE portfolio.technology
(
    id       UUID NOT NULL,
    name     VARCHAR(255),
    type     VARCHAR(255),
    link     VARCHAR(255),
    image_id UUID,
    CONSTRAINT pk_technology PRIMARY KEY (id)
);

CREATE TABLE portfolio.technology_experiences
(
    technology_id  UUID NOT NULL,
    experiences_id UUID NOT NULL,
    CONSTRAINT pk_technology_experiences PRIMARY KEY (technology_id, experiences_id)
);

CREATE TABLE portfolio.technology_projects
(
    technology_id UUID NOT NULL,
    projects_id   UUID NOT NULL,
    CONSTRAINT pk_technology_projects PRIMARY KEY (technology_id, projects_id)
);

CREATE TABLE portfolio."user"
(
    id            UUID NOT NULL,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    photo_id      UUID,
    email         VARCHAR(255),
    birth_date    TIMESTAMP WITHOUT TIME ZONE,
    profile_title VARCHAR(255),
    description   VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE portfolio.company
    ADD CONSTRAINT uc_company_id UNIQUE (id);

ALTER TABLE portfolio.experience
    ADD CONSTRAINT uc_experience_id UNIQUE (id);

ALTER TABLE portfolio.experience_technologies
    ADD CONSTRAINT uc_experience_technologies_experience UNIQUE (experience_id);

ALTER TABLE portfolio.image
    ADD CONSTRAINT uc_image_id UNIQUE (id);

ALTER TABLE portfolio.project
    ADD CONSTRAINT uc_project_id UNIQUE (id);

ALTER TABLE portfolio.project_images
    ADD CONSTRAINT uc_project_images_pridimid UNIQUE (project_id, images_id);

ALTER TABLE portfolio.project_technologies
    ADD CONSTRAINT uc_project_technologies_project UNIQUE (project_id);

ALTER TABLE portfolio.technology_experiences
    ADD CONSTRAINT uc_technology_experiences_technology UNIQUE (technology_id);

ALTER TABLE portfolio.technology
    ADD CONSTRAINT uc_technology_id UNIQUE (id);

ALTER TABLE portfolio.technology_projects
    ADD CONSTRAINT uc_technology_projects_technology UNIQUE (technology_id);

ALTER TABLE portfolio."user"
    ADD CONSTRAINT uc_user_id UNIQUE (id);

ALTER TABLE portfolio.company
    ADD CONSTRAINT FK_COMPANY_ON_IMAGE FOREIGN KEY (image_id) REFERENCES portfolio.image (id);

ALTER TABLE portfolio.experience
    ADD CONSTRAINT FK_EXPERIENCE_ON_COMPANY FOREIGN KEY (company_id) REFERENCES portfolio.company (id);

ALTER TABLE portfolio.experience
    ADD CONSTRAINT FK_EXPERIENCE_ON_USER FOREIGN KEY (user_id) REFERENCES portfolio."user" (id);

ALTER TABLE portfolio.project
    ADD CONSTRAINT FK_PROJECT_ON_USER FOREIGN KEY (user_id) REFERENCES portfolio."user" (id);

ALTER TABLE portfolio.technology
    ADD CONSTRAINT FK_TECHNOLOGY_ON_IMAGE FOREIGN KEY (image_id) REFERENCES portfolio.image (id);

ALTER TABLE portfolio."user"
    ADD CONSTRAINT FK_USER_ON_PHOTO FOREIGN KEY (photo_id) REFERENCES portfolio.image (id);

ALTER TABLE portfolio.experience_technologies
    ADD CONSTRAINT fk_exptec_on_experience FOREIGN KEY (experience_id) REFERENCES portfolio.experience (id);

ALTER TABLE portfolio.experience_technologies
    ADD CONSTRAINT fk_exptec_on_technology FOREIGN KEY (technology_id) REFERENCES portfolio.technology (id);

ALTER TABLE portfolio.project_images
    ADD CONSTRAINT fk_proima_on_image FOREIGN KEY (images_id) REFERENCES portfolio.image (id);

ALTER TABLE portfolio.project_images
    ADD CONSTRAINT fk_proima_on_project FOREIGN KEY (project_id) REFERENCES portfolio.project (id);

ALTER TABLE portfolio.project_technologies
    ADD CONSTRAINT fk_protec_on_project FOREIGN KEY (project_id) REFERENCES portfolio.project (id);

ALTER TABLE portfolio.project_technologies
    ADD CONSTRAINT fk_protec_on_technology FOREIGN KEY (technology_id) REFERENCES portfolio.technology (id);

ALTER TABLE portfolio.technology_experiences
    ADD CONSTRAINT fk_tecexp_on_experience FOREIGN KEY (experiences_id) REFERENCES portfolio.experience (id);

ALTER TABLE portfolio.technology_experiences
    ADD CONSTRAINT fk_tecexp_on_technology FOREIGN KEY (technology_id) REFERENCES portfolio.technology (id);

ALTER TABLE portfolio.technology_projects
    ADD CONSTRAINT fk_tecpro_on_project FOREIGN KEY (projects_id) REFERENCES portfolio.project (id);

ALTER TABLE portfolio.technology_projects
    ADD CONSTRAINT fk_tecpro_on_technology FOREIGN KEY (technology_id) REFERENCES portfolio.technology (id);
