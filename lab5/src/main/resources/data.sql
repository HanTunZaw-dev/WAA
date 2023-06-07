INSERT INTO users (id, email, firstname, lastname, password)
VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (3, 'dean@miu.edu', 'Dean', 'Altarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');


INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (3, 2);


insert into post_user (name)
values ('Su Lai Myint');

insert into post_user (name)
values ('Anna Jones Smith');

insert into post_user (name)
values ('Peter David Parker');

insert into post ( author, content, title, user_id)
values ('Su Lai', 'Tornado Warning in MidWest including Iowa, Illinois', 'Tornado Warning in MidWest', 1);

insert into post ( author, content, title, user_id)
values ('Anna Jones', 'Singapore Prime minister and US President meet at white house on 29 Mar 2022', 'Singapore and USA Presidential Meeting', 2);

insert into post ( author, content, title, user_id)
values ('Peter Parker', 'People saying goodbye to winter and Farewell Winter and Welcome Spring', 'Farewell Winter and Welcome Spring', 3);

insert into post ( author, content, title, user_id)
values ('Anna Jones', 'Student from Aug 2021 Intake are now taking their career strategy class and they are much enjoying it', 'Students are enjoying Career Strategy Class in MIU', 2);

insert into public.comment (name, post_id)
values ('Nice Content! Very Much Helpful', 1);

insert into public.comment (name, post_id)
values ('Worth to read! ', 1);

insert into public.comment (name, post_id)
values ('Nice Article!', 2);

insert into public.comment (name, post_id)
values ('Its Disgusting!', 1);

insert into public.comment (name, post_id)
values ('Nice Content! Very Much Helpful', 3);