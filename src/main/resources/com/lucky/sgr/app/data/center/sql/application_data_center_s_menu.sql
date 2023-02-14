create table s_menu
(
    id          char(255)     not null
        primary key,
    p_id        char(255)     not null,
    menu_name   char(255)     not null,
    menu_route  char(255)     not null,
    menu_icon   char(255)     not null,
    server_type char(5)       not null,
    is_enable   int default 1 not null,
    create_time datetime      not null,
    update_time datetime      not null,
    constraint s_menu_id_uindex
        unique (id)
);

INSERT INTO application_data_center.s_menu (id, p_id, menu_name, menu_route, menu_icon, server_type, is_enable, create_time, update_time) VALUES ('21c8aadcecfc8e9910d572e6c3a74ec4', 'f9cc5ab813b7e6935e37d73db3731c01', '加载GLTF', 'loadingGltf', 'el-icon-magic-stick', 'gis', 1, '2022-02-16 15:28:41', '2022-02-16 15:28:41');
INSERT INTO application_data_center.s_menu (id, p_id, menu_name, menu_route, menu_icon, server_type, is_enable, create_time, update_time) VALUES ('4374692145fe53527ef706c2f9951c5a', 'd476d190994eb2254508e39f3d566f30', '资料汇总', 'documentSummary', 'el-icon-tickets', 'web', 1, '2022-02-04 16:11:22', '2022-02-04 16:11:22');
INSERT INTO application_data_center.s_menu (id, p_id, menu_name, menu_route, menu_icon, server_type, is_enable, create_time, update_time) VALUES ('4922d0fcec2ae07b6b8bdb202eea3173', 'd476d190994eb2254508e39f3d566f30', '上传下载', 'uploadOrDownload', 'el-icon-receiving', 'web', 1, '2022-03-11 11:33:39', '2022-03-11 11:33:39');
INSERT INTO application_data_center.s_menu (id, p_id, menu_name, menu_route, menu_icon, server_type, is_enable, create_time, update_time) VALUES ('e6fe72b026eb9cc343b08df6b221594f', 'cdc51376588a52abc2fe82b4691f4c04', '底图切换', 'basemapToggle', 'el-icon-refresh', 'gis', 1, '2022-02-16 14:32:43', '2022-02-16 14:32:43');
