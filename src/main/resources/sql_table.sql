CREATE SEQUENCE test.user_id_seq;

CREATE TABLE test.users
(
    user_id bigint NOT NULL default nextval('test.user_id_seq'),
    phone_number character varying(20) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    age smallint NOT NULL,
    status character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
)


ALTER TABLE test.users
    OWNER to postgres;

ALTER SEQUENCE test.user_id_seq owned by test.users.user_id;