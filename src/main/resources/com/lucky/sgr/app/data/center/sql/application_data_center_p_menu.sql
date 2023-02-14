create table p_menu
(
    id          char(255)     not null
        primary key,
    menu_name   char(255)     not null,
    menu_route  char(255)     not null,
    menu_icon   char(255)     not null,
    server_type char(5)       not null,
    is_enable   int default 1 not null,
    create_time datetime      not null,
    update_time datetime      not null,
    constraint p_menu_id_uindex
        unique (id)
);

INSERT INTO application_data_center.p_menu (id, menu_name, menu_route, menu_icon, server_type, is_enable, create_time, update_time) VALUES ('cdc51376588a52abc2fe82b4691f4c04', '地图管理', 'mapManagement', 'el-icon-picture-outline-round', 'gis', 1, '2022-02-16 14:30:55', '2022-02-16 14:30:55');
INSERT INTO application_data_center.p_menu (id, menu_name, menu_route, menu_icon, server_type, is_enable, create_time, update_time) VALUES ('d476d190994eb2254508e39f3d566f30', '文件管理', 'fileManagement', 'el-icon-folder-opened', 'web', 1, '2022-02-04 16:02:36', '2022-02-04 16:02:36');
INSERT INTO application_data_center.p_menu (id, menu_name, menu_route, menu_icon, server_type, is_enable, create_time, update_time) VALUES ('f9cc5ab813b7e6935e37d73db3731c01', '数据加载', 'dataLoading', 'el-icon-loading', 'gis', 1, '2022-02-16 15:27:41', '2022-02-16 15:27:41');
