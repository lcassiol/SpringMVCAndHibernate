# SpringMVCAndHibernate
This project was develop to show an example of Spring MVC and Hibernate, I used jsp as a view for this project








--------------------------------------------------------------------------------------------------------------------
During development was tested on SGBD postgresql.

This project contains "db.properties", "log4j.properties" to settings all of configurations.

Create an user with name: springJdbc

Here are the create table:


CREATE TABLE Movie (
   
    id serial NOT NULL,
    name character varying(100) NOT NULL,
    director character varying(100) NOT NULL,
    writers character varying(100) NOT NULL,
    year integer NOT NULL,
    sinopse character varying(900) NOT NULL,
    stars character varying(100) NOT NULL,
    gender character varying(100) NOT NULL,
    PRIMARY KEY (id)
)
