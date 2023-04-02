create table if not exists Photo(
    id int auto_increment PRIMARY KEY ,
    file_name varchar(255),
    content_type varchar(255),
    data VARBINARY(max)
);