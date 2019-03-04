CREATE DATABASE checkup_project;
\c checkup_project;
DROP TABLE IF EXISTS todo;

CREATE TABLE todo (
  id serial primary key,
  completed boolean,
  created_at timestamp,
  title varchar(200)
);