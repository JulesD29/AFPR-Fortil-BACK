 --  ###########################
 --  ## Output of sql command ##
 --  ###########################

 create table message (
    m_index binary(16) not null
	creation_date date
	modification_date date
	value varchar(255)
	user_index binary(16) not null
	primary key (m_index)) engine=InnoDB

 create table message_tag (
    message_index binary(16) not null
	tag_index binary(16) not null) engine=InnoDB

 create table tag (
    t_index binary(16) not null
	value varchar(255)
	primary key (t_index)) engine=InnoDB

 create table user (
    u_index binary(16) not null
	first_name varchar(255)
	last_name varchar(255)
	mail varchar(255)
	password varchar(255)
	primary key (u_index)) engine=InnoDB

 alter table message add constraint FK746ms79s2yk8ok5j4gg0wrqru foreign key (user_index) references user (u_index)
 alter table message_tag add constraint FKf6ioqafgoyayeapx07c3malhg foreign key (tag_index) references tag (t_index)
 alter table message_tag add constraint FKolps1d0x527rapqju6ut1se9f foreign key (message_index) references message (m_index)