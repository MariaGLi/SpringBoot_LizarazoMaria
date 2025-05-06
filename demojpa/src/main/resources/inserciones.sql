USE jpademo;

insert into roles(id, name) values
(1, "User"),
(2, "Admin"),
(3, "Estudent");

insert into personas(programming_language, last_name, full_name, rol_id) values
("Java", "Leal", "Sandra", 1),
("Python", "Lizarazo", "María", 2),
("SpringBoot", "Guerrero", "Jean Franco", 3),
("JavaScript", "López", "Herney", 1);

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
