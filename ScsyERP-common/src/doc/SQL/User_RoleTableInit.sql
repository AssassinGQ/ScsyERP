drop table if exists t_user_role;

create table t_user_role (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  user_id     BIGINT(20) COMMENT '用户id',
  role_id     BIGINT(20) COMMENT '角色id',
  PRIMARY KEY (id),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY ('user_id') REFERENCES `t_user`('id'),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY ('role_id') REFERENCES `t_role`('id')
);

alter table t_user_role comment '用户角色关联表';

## 用户角色关联信息初始化
insert into t_user_role(user_id, role_id) values ("1", "1");
insert into t_user_role(user_id, role_id) values ("2", "2");