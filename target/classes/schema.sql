ALTER TABLE users ALTER COLUMN user_id SET DEFAULT nextval('users_user_id_seq');
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
