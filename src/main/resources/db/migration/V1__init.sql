create schema if not exists mails;

create table if not exists mails.email_message
(
    id              uuid primary key,
    email           varchar(255) not null,
    title           varchar(130) not null,
    subtitle        varchar(255) not null,
    first_name      varchar(255) not null,
    last_name       varchar(255) not null,
    content         text not null,
    creation_time   timestamp    not null,
    update_time     timestamp
);




