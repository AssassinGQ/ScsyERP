drop table if exists t_admin;

create table t_admin (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
#   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
#   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  name      VARCHAR(20) NOT NULL COMMENT '名称',
  dept      int(3) NOT NULL   COMMENT '部门',
  PRIMARY KEY (id)
);

alter table t_admin comment '承运方管理员信息表';

## 权限的初始化数据
insert into t_admin(name, dept) values ("仓库管理员", 0);
insert into t_admin(name, dept) values ("项目管理员", 1);
insert into t_admin(name, dept) values ("财务管理员", 2);