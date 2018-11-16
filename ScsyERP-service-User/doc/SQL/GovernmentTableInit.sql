drop table if exists t_government;

create table t_government (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
#   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
#   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  name      VARCHAR(20) NOT NULL  COMMENT '名称',
  dept      INT(3) NOT NULL   COMMENT '部门',
  PRIMARY KEY (id)
);

alter table t_government comment '政府信息表';

## 权限的初始化数据
insert into t_government(name, dept) values ("运管部", 0);
insert into t_government(name, dept) values ("交警部", 1);
insert into t_government(name, dept) values ("环保部", 2);
insert into t_government(name, dept) values ("消防部", 3);
insert into t_government(name, dept) values ("安监部", 4);