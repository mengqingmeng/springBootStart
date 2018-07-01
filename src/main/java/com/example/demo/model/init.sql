-- 权限表 --
CREATE TABLE permission(
  pid int(11) not null auto_increment,
  name varchar(255) not null default '',
  url varchar(255) default '',
  primary key (pid)
) ENGINE = InnoDB default charset = utf8;

insert into permision values ('1','add','');
insert into permision values ('2','delete','');
insert into permision values ('3','edit','');
insert into permision values ('4','query','');

-- 用户表 --
create table user(
  uid int(11) not null auto_increment,
  username varchar(255) not null default '',
  password varchar(255) not null default '',
  primary key (uid)
) ENGINE = InnoDB default charset = utf8;

insert into user values ('1','admin','123');
insert into user values ('2','demo','123');

-- 角色表 --
create table role(
  rid int(11) not null auto_increment,
  rname varchar(255) not null default '',
  primary key (rid)
) ENGINE = InnoDB default charset = utf8;

insert into role values ('1','admin');
insert into role values ('2','customer');

-- 权限角色关系表 --
create table permission_role(
  rid int(11) not null,
  pid int(11) not null,
  key idx_rid (rid),
  key idx_pid (pid)
)ENGINE = InnoDB default charset = utf8;

insert into permission_role values ('1','1');
insert into permission_role values ('1','2');
insert into permission_role values ('1','3');
insert into permission_role values ('1','4');
insert into permission_role values ('2','1');
insert into permission_role values ('2','4');

-- 用户角色关系表 --
create table user_role(
  rid int(11) not null,
  uid int(11) not null,
  key idx_rid (rid),
  key idx_uid (uid)
)ENGINE = InnoDB default charset = utf8;

insert into user_role values (1,1);
insert into user_role values (2,2);
