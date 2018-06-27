Drop database if exists springsecurity;

CREATE DATABASE springsecurity;
use springsecurity;

 drop table if exists role;

  create table roles (
    role_id int(11) not null auto_increment,
    role varchar(255) default  null,
    PRIMARY  KEY (role_id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 drop table if exists users;

 Create table users(
 user_id int(11) not null auto_increment,
 active tinyInt default  null,
 email varchar (255) not null,
 name varchar (255) not null,
 last_name varchar (255) not null,
 password varchar (255) not null,
 PRIMARY  KEY(user_id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table  if exists  users_roles;

create table users_roles(
  user_id int(11) not null,
  role_id int(11) not null,
  PRIMARY  KEY (user_id, role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	Alter table users_roles add constraint  map_user foreign key (user_id) references  users(user_id);
	Alter table users_roles add constraint  map_role foreign key (role_id) references  roles(role_id);

    Insert into roles(role_id, role) value(1, 'ADMIN');
    insert into users(user_id, active, email, name, last_name, password)
	values
	(1,1,'admin@gmail.com','Jimmy','JR','jimmy'),
	(2,1,'admin@gmail.com','King','pham','king');


	INSERT INTO `users_roles` (user_id, `role_id`) VALUES (1,1);