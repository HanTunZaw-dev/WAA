

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

