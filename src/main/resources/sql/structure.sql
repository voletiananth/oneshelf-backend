create table cart
(
    id        bigint auto_increment
        primary key,
    createdAt datetime(6) null,
    updatedAt datetime(6) null
);

create table categories
(
    id          bigint auto_increment
        primary key,
    createdAt   datetime(6)  null,
    updatedAt   datetime(6)  null,
    description varchar(255) not null,
    name        varchar(255) not null,
    thumbnail   varchar(255) not null,
    constraint UK_t8o6pivur7nn124jehx7cygw5
        unique (name)
);

create table pantry
(
    id          bigint auto_increment
        primary key,
    createdAt   datetime(6)  null,
    updatedAt   datetime(6)  null,
    city        varchar(255) not null,
    coordinates varchar(255) not null,
    description varchar(255) not null,
    email       varchar(255) not null,
    name        varchar(255) not null,
    phone       varchar(10)  not null,
    state       varchar(255) not null,
    street      varchar(255) not null,
    zipcode     int          not null,
    constraint UK5uic0rdtkbs1owiw2sprfqvnm
        unique (name),
    constraint UK_1qqxlimaf7bt1hx8d4e9qbked
        unique (email),
    constraint UK_733iyt2ageko2cmsskme0kjfo
        unique (phone)
);

create table products
(
    id          bigint auto_increment
        primary key,
    createdAt   datetime(6)  null,
    updatedAt   datetime(6)  null,
    brand       varchar(255) not null,
    description varchar(255) not null,
    name        varchar(255) not null,
    thumbnail   varchar(255) not null,
    category_id bigint       null,
    constraint UKgn0jwdt59nijxnmltuqnve2mj
        unique (name, brand),
    constraint FKog2rp4qthbtt2lfyhfo32lsw9
        foreign key (category_id) references categories (id)
);

create table cart_products
(
    createdAt  datetime(6) null,
    updatedAt  datetime(6) null,
    quantity   int         null,
    product_id bigint      not null,
    cart_id    bigint      not null,
    primary key (cart_id, product_id),
    constraint FKdayy17at10up1qqwlri9cocb3
        foreign key (product_id) references products (id)
            on delete cascade,
    constraint FKnlhjc091rdu9k5c8u9xwp280w
        foreign key (cart_id) references cart (id)
            on delete cascade
);

create table pantry_inventory
(
    createdAt  datetime(6) null,
    updatedAt  datetime(6) null,
    quantity   int         not null,
    product_id bigint      not null,
    pantry_id  bigint      not null,
    primary key (pantry_id, product_id),
    constraint FK3smejgddecl0u2vhdwfts66a4
        foreign key (pantry_id) references pantry (id)
            on delete cascade,
    constraint FKcxtqg14k2gf1en7gjqxot1f1e
        foreign key (product_id) references products (id)
            on delete cascade
);

create table slot_day
(
    id        bigint auto_increment
        primary key,
    createdAt datetime(6)  null,
    updatedAt datetime(6)  null,
    day       varchar(255) not null,
    pantry_id bigint       null,
    constraint UKn06lty7883cg1clmwy4fs8n6a
        unique (pantry_id, day),
    constraint FK4fa446q3tcc76bkn7d563m64y
        foreign key (pantry_id) references pantry (id)
            on delete cascade
);

create table slot_time
(
    id         bigint not null
        primary key,
    end_time   time   null,
    start_time time   null,
    constraint UK32fd3y5rr9cfi3nm1s96o4w4h
        unique (start_time, end_time)
);

create table orders
(
    id           bigint auto_increment
        primary key,
    createdAt    datetime(6) null,
    updatedAt    datetime(6) null,
    orderDate    date        null,
    order_number int         null,
    cart_id      bigint      null,
    pantry_id    bigint      null,
    time_slot_id bigint      not null,
    constraint UK5s8tq54youkd2ikn1kqix2nej
        unique (pantry_id, cart_id, time_slot_id),
    constraint FKe47e5nxoxyahyebap6qlfvsan
        foreign key (time_slot_id) references slot_time (id),
    constraint FKqku998lui1kt1jpddi4l1hxsd
        foreign key (pantry_id) references pantry (id)
            on delete cascade,
    constraint FKtpihbdn6ws0hu56camb0bg2to
        foreign key (cart_id) references cart (id)
);

create table pantry_slot
(
    createdAt    datetime(6) null,
    updatedAt    datetime(6) null,
    capacity     int         not null,
    slot_time_id bigint      not null,
    slot_day_id  bigint      not null,
    primary key (slot_day_id, slot_time_id),
    constraint FKg7rtmjsc7smv72ltij4mf03k4
        foreign key (slot_day_id) references slot_day (id)
            on delete cascade,
    constraint FKqkpda2jyjfhaxplu9ji0oto2v
        foreign key (slot_time_id) references slot_time (id)
);

create table slot_time_availability
(
    id           bigint auto_increment
        primary key,
    createdAt    datetime(6) null,
    updatedAt    datetime(6) null,
    capacity     int         null,
    date         date        null,
    slot_time_id bigint      not null,
    constraint UK8euyb2mh2y9pfxbnx8b61vsws
        unique (slot_time_id, date),
    constraint FKpihxab69lt3rubxqxxn7lx0er
        foreign key (slot_time_id) references slot_time (id)
);

create table user
(
    id        bigint auto_increment
        primary key,
    createdAt datetime(6)          null,
    updatedAt datetime(6)          null,
    isActive  tinyint(1) default 1 null,
    password  varchar(255)         null,
    role      varchar(255)         null,
    username  varchar(255)         null,
    constraint UK_sb8bbouer5wak8vyiiy4pf2bx
        unique (username)
);

create table manager_details
(
    id        bigint auto_increment
        primary key,
    createdAt datetime(6) null,
    updatedAt datetime(6) null,
    pantry_id bigint      null,
    user_id   bigint      null,
    constraint UK_qt4f7p72yq5fny6x88auv4fdg
        unique (user_id),
    constraint FKh1x0fhysqdwksmk37pffaqypn
        foreign key (user_id) references user (id)
            on delete cascade,
    constraint FKl7myav85tf17jiw0slac7r3f1
        foreign key (pantry_id) references pantry (id)
            on delete cascade
);

