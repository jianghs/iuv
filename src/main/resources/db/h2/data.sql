DELETE FROM iuv_tag;
INSERT INTO iuv_tag (id, tag_name, hits, tag_order, priority, tag_status, create_time, creator_id, modify_time, modifier_id) VALUES (1, 'a', 0, 1, 1, 1, '2020-12-30 06:16:49', 1, null, null);
INSERT INTO iuv_tag (id, tag_name, hits, tag_order, priority, tag_status, create_time, creator_id, modify_time, modifier_id) VALUES (2, 'bac', 0, 2, 1, 1, '2020-12-30 06:17:06', 1, null, null);
INSERT INTO iuv_tag (id, tag_name, hits, tag_order, priority, tag_status, create_time, creator_id, modify_time, modifier_id) VALUES (3, 'cc', 0, 3, 1, 1, '2020-12-30 06:17:16', 1, null, null);
INSERT INTO iuv_tag (id, tag_name, hits, tag_order, priority, tag_status, create_time, creator_id, modify_time, modifier_id) VALUES (4, 'abc', 0, 4, 0, 1, '2020-12-30 06:17:29', 1, null, null);
INSERT INTO iuv_tag (id, tag_name, hits, tag_order, priority, tag_status, create_time, creator_id, modify_time, modifier_id) VALUES (5, 'cda', 0, 5, 0, 1, '2020-12-30 06:17:41', 1, null, null);
INSERT INTO iuv_tag (id, tag_name, hits, tag_order, priority, tag_status, create_time, creator_id, modify_time, modifier_id) VALUES (6, 'wawew', 0, 6, 0, 1, '2020-12-30 06:18:03', 6, null, null);

DELETE FROM iuv_menu;
INSERT INTO iuv_menu VALUES (1, 0, 'top menu', 1, '顶级菜单', '', '', 1, 1, 0, 1, '2021-01-13 08:12:13', 1, NULL, NULL);
INSERT INTO iuv_menu VALUES (2, 1, '菜单1', 2, '菜单1', '', '/resources/r1', 1, 1, 1, 1, '2021-01-13 08:12:13', 1, NULL, NULL);
INSERT INTO iuv_menu VALUES (3, 1, '菜单2', 2, '菜单2', '', '/resources/r2', 1, 1, 2, 1, '2021-01-13 08:12:13', 1, NULL, NULL);

DELETE FROM iuv_role;
INSERT INTO iuv_role VALUES (1, 'role1', '角色1', 1, '2021-01-13 08:16:04', 1, NULL, NULL);
INSERT INTO iuv_role VALUES (2, 'role2', '角色2', 1, '2021-01-13 08:16:20', 1, NULL, NULL);

DELETE FROM iuv_role_menu_relation;
INSERT INTO iuv_role_menu_relation VALUES (1, 1, 1, 1, '2021-01-13 08:17:15', 1, NULL, NULL);
INSERT INTO iuv_role_menu_relation VALUES (2, 1, 2, 1, '2021-01-13 08:17:22', 1, NULL, NULL);
INSERT INTO iuv_role_menu_relation VALUES (3, 2, 1, 1, '2021-01-13 08:17:29', 1, NULL, NULL);
INSERT INTO iuv_role_menu_relation VALUES (4, 2, 2, 1, '2021-01-13 08:17:45', 1, NULL, NULL);
INSERT INTO iuv_role_menu_relation VALUES (5, 2, 3, 1, '2021-01-13 08:18:06', 1, NULL, NULL);

DELETE FROM iuv_user;
INSERT INTO iuv_user VALUES (1, 'baby', '$2a$10$Y6TDKHm4RFOWDA3iVHWEDOy.4RN1ggzXeLdoejazNky/9Tt4KSct2', '宝宝', '', 2, '1995-02-09', '', '', '', '', 1, 1, 0, '2021-01-13 08:06:30', '', '', '', '', 1, '2021-01-13 08:06:30', 1, NULL, NULL);
INSERT INTO iuv_user VALUES (2, 'uv', '$2a$10$MchxIcC4VLQ3nLNa01f7.u1a0Zfo0sTeapglSJ43KEWSVPAZ9QFeO', '宝宝', '', 2, '1995-02-09', '', '', '', '', 1, 1, 0, '2021-01-13 08:06:30', '', '', '', '', 1, '2021-01-13 08:06:30', 1, NULL, NULL);
INSERT INTO iuv_user VALUES (3, '刘备', '$2a$10$ezbdb5/Eg5wNjm.Ft73h.u3654.eZG3XovA6vGdsG3bOBByJnBau.', '玄德', '', 1, '公元前xx', '', '', '', '', 1, 1, 0, '2021-01-13 08:06:30', '', '', '', '', 1, '2021-01-13 08:06:30', 1, NULL, NULL);

DELETE FROM iuv_user_role_relation;
INSERT INTO iuv_user_role_relation VALUES (1, 1, 1, 1, '2021-01-13 08:18:46', 1, NULL, NULL);
INSERT INTO iuv_user_role_relation VALUES (2, 1, 2, 1, '2021-01-13 08:19:08', 1, NULL, NULL);
INSERT INTO iuv_user_role_relation VALUES (3, 2, 1, 1, '2021-01-13 08:19:08', 1, NULL, NULL);
INSERT INTO iuv_user_role_relation VALUES (4, 3, 2, 1, '2021-01-13 08:19:08', 1, NULL, NULL);