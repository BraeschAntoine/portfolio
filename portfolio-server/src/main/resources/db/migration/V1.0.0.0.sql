
CREATE TABLE student
(
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    uuid  VARCHAR(255)                            NOT NULL,
    name  VARCHAR(255),
    email VARCHAR(255),
    age   INTEGER,
    dob   date,
    CONSTRAINT pk_student PRIMARY KEY (id)
);



ALTER TABLE student
    ADD CONSTRAINT uc_student_id UNIQUE (id);

ALTER TABLE student
    ADD CONSTRAINT uc_student_uuid UNIQUE (uuid);

INSERT INTO student (id, uuid, name, email, age, dob) VALUES(1,'1a28b6c4-e68b-4714-8c8d-4ba067750aad','Antoine','antoine@test.com','21','2021-12-12');
