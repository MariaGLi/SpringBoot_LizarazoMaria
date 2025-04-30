CREATE DATABASE jpademo;
USE jpademo;

insert into personas(programming_language, last_name, full_name, rol_id) values
("Leal", "Java", "Sandra", 1),
("Lizarazo", "Python", "María", 2),
("López", "JavaScript", "Herney", 1);

insert into roles(id, name) values
(1, "User"),
(2, "Admin");

insert into passport(id, person_id, number, expiration) values
(1, 3, "NUM12345", "2029-10-28");

insert into project (id, name) values
(1, "Amazon"),
(2, "Facebook");

insert into personas_project (persona_id, project_id) values
(1,2),
(2,1);
insert into personas_project (persona_id, project_id) values
(1,1),
(2,2);

select * from personas;
select * from roles;
select * from passport;
select * from personas_project;

select * from personas p
inner join roles r on p.id = r.id;
