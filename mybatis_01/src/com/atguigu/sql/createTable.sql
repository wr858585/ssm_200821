DROP DATABASE IF EXISTS mybatis;

CREATE DATABASE mybatis;

USE mybatis;
##############################################################################
################################### 单表 ######################################
##############################################################################
## 创建单表
CREATE TABLE t_user(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`last_name`	VARCHAR(50),
	`sex` INT
);

INSERT INTO t_user(`last_name`,`sex`) VALUES('wzg168',1);

SELECT * FROM t_user;
