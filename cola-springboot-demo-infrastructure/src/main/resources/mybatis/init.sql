create table if not exists user(
    id integer primary key,
    name text,
    sex text,
    encrypted_password text
);