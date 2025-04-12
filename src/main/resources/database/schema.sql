CREATE TABLE IF NOT EXISTS public.users1
(
    user_id bigint NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    age integer,
    email character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey1 PRIMARY KEY (user_id),
    CONSTRAINT users_status_check1 CHECK (status::text = ANY (ARRAY['ONLINE'::character varying, 'OFFLINE'::character varying, 'AWAY'::character varying]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;