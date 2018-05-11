--权限表--
CREATE TABLE permision(
  pid int(11) not null auto_increment,
  name varchar(255) not null default '',
  url varchar(255) default '',
  primary key (pid)
) ENGINE = InnoDB default charset = utf8;

--用户表--
create table user(
  uid int(11) not null auto_increment,
  username varchar(255) not null default '',
  password varchar(255) not null default '',
  primary key (uid)
) ENGINE = InnoDB default charset = utf8;

--角色表--
create table role(
  rid int(11) not null auto_increment,
  rname varchar(255) not null default '',
  primary key (rid)
) ENGINE = InnoDB default charset = utf8;