CREATE SCHEMA IF NOT EXISTS portfolio;

CREATE TABLE portfolio.student
(
    id  UUID NOT NULL,
    name  VARCHAR(255),
    email VARCHAR(255),
    age   INTEGER,
    dob   date,
    CONSTRAINT pk_student PRIMARY KEY (id)
);



ALTER TABLE portfolio.student
    ADD CONSTRAINT uc_student_id UNIQUE (id);

INSERT INTO portfolio.student (id, name, email, age, dob) VALUES('1a28b6c4-e68b-4714-8c8d-4ba067750aad','Antoine','antoine@test.com','21','2021-12-12');
