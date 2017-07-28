CREATE DATABASE silencessm;

USE silencessm;
--用户表
CREATE TABLE USER (
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '业务主键',
	username VARCHAR(250) NOT NULL COMMENT '用户名',
	PASSWORD VARCHAR(250) NOT NULL COMMENT '密码',
	sex BIGINT(1) COMMENT '性别：0表示女性，1表示男性',
	birthday DATE COMMENT '生日',
	phone VARCHAR(20) COMMENT '电话号码',
	email VARCHAR(250) COMMENT '邮箱',
	description VARCHAR(1000) COMMENT '个人简介',
	role BIGINT(1) DEFAULT 1 COMMENT '用户角色：1表示普通用户，2表示管理员',
	flag BIGINT(1) DEFAULT 1 COMMENT '标识数据是否被删除：0表示删除，1表示未被删除',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY (id),
	KEY index_user_id (id)
) ENGINE = INNODB AUTO_INCREMENT = 10000 DEFAULT CHARSET = utf8;

INSERT INTO USER(username, PASSWORD, sex, birthday, phone, email, description) VALUES('Silence', '123456', '1', '1994-12-15', '18770814753', 'taogu2010@yeah.net', '路漫漫其修远兮，吾将上下而求索。');

--drop TABLE USER;