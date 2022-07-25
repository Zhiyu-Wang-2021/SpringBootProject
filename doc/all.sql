drop table if exists `ebook`;
create table `ebook`(
    `id` bigint not null comment 'id',
    `name` varchar(50) comment 'name',
    `category1_id` bigint comment 'category1',
    `category2_id` bigint comment 'category2',
    `description` varchar(200) comment 'description',
    `cover` varchar(200) comment 'cover',
    `doc_count` int comment 'doc count',
    `view_count` int comment 'view count',
    `vote_count` int comment 'vote count',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='ebook';

insert into `ebook` (id, name, description) values (1, '11111111', '111111111111111111111111');
insert into `ebook` (id, name, description) values (2, '22222222', '222222222222222222222222');
insert into `ebook` (id, name, description) values (3, '33333333', '333333333333333333333333');
insert into `ebook` (id, name, description) values (4, '44444444', '444444444444444444444444');
insert into `ebook` (id, name, description) values (5, '55555555', '555555555555555555555555');



drop table if exists `demo`;
create table `demo` (
    `id` bigint not null comment 'id',
    `name` varchar(50) comment 'name',
    `password` varchar(50) comment 'password',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='demo';


insert into `demo` (id, name, password) VALUES (1, 'demo', 'password');