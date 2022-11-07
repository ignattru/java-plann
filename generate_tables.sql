-- Mysql DB
create table if not exists closereports
(
	id int(10) auto_increment
		primary key,
	reporttext varchar(1000) null
)
collate=utf8mb4_unicode_ci;

create table if not exists departments
(
	id int(10) auto_increment
		primary key,
	departmentname varchar(40) null,
	roles varchar(20) null
)
collate=utf8mb4_unicode_ci;

create table if not exists employees
(
	id int auto_increment
		primary key,
	name varchar(15) null,
	surname varchar(25) null,
	department varchar(20) null,
	salary int null
);

create table if not exists metasettings
(
	id int(10) auto_increment
		primary key,
	companyname varchar(20) null
)
collate=utf8mb4_unicode_ci;

create table if not exists notions
(
	id int auto_increment
		primary key,
	textnotion mediumtext null,
	enabled tinyint(1) default 2 not null comment '1-active 2-disable',
	createdate datetime null,
	updatedate datetime null
)
collate=utf8mb4_unicode_ci;

create table if not exists tasklist_subtasks
(
	id int(10) auto_increment
		primary key,
	taskid int(10) null,
	subtaskid int(10) null
);

create index subtaskid
	on tasklist_subtasks (subtaskid);

create table if not exists taskstatus
(
	id int(10) auto_increment
		primary key,
	statusname varchar(20) null
)
collate=utf8mb4_unicode_ci;

create table if not exists tasktags
(
	id int(10) auto_increment
		primary key,
	tagname varchar(30) null,
	createdate datetime null,
	updatedate datetime null
)
collate=utf8mb4_unicode_ci;

create table if not exists tasktags_tasklink
(
	id int(10) auto_increment
		primary key,
	taskid int(10) null,
	tagid int(10) null,
	constraint tasktags_tasklink_ibfk_2
		foreign key (tagid) references tasktags (id)
)
collate=utf8mb4_unicode_ci;

create index tagid
	on tasktags_tasklink (tagid);

create index taskid
	on tasktags_tasklink (taskid);

create table if not exists userlist
(
	id int(10) auto_increment
		primary key,
	login varchar(40) null,
	fio varchar(40) null,
	password varchar(100) null,
	enabled tinyint(1) default 1 not null,
	departmentid int(10) null,
	createdate datetime null,
	updatedate datetime null,
	constraint userlist_ibfk_1
		foreign key (departmentid) references departments (id)
)
comment 'Пользователи' collate=utf8mb4_unicode_ci;

create table if not exists tasklist
(
	id int(10) auto_increment
		primary key,
	title varchar(80) null,
	body mediumtext null,
	important int(1) default 1 null,
	reportid int(10) null,
	status int(10) null,
	makerid int(10) null,
	tagid int(10) null,
	createdate date null,
	updatedate datetime null,
	plandate date null,
	closedate datetime null,
	constraint tasklist_ibfk_1
		foreign key (reportid) references closereports (id),
	constraint tasklist_ibfk_2
		foreign key (status) references taskstatus (id),
	constraint tasklist_ibfk_3
		foreign key (makerid) references userlist (id)
)
comment 'Список задач' collate=utf8mb4_unicode_ci;

create index makerid
	on tasklist (makerid);

create index reportid
	on tasklist (reportid);

create index status
	on tasklist (status);

create index departmentid
	on userlist (departmentid);

create table if not exists users
(
	username varchar(15) not null
		primary key,
	password varchar(100) null,
	enabled tinyint(1) null
);

create table if not exists authorities
(
	username varchar(15) null,
	authority varchar(25) null,
	constraint authorities_ibfk_1
		foreign key (username) references users (username)
);

create index username
	on authorities (username);
