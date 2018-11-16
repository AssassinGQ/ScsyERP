drop table if exists t_customer;

create table t_customer (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
#   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
#   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  name      VARCHAR(20) NOT NULL  COMMENT '名称',
  address      VARCHAR(50) COMMENT '地址',
  bank      VARCHAR(20) COMMENT '开户行',
  tax_number      VARCHAR(20) COMMENT '税务登记号',
  PRIMARY KEY (id)
);

alter table t_customer comment '客户信息表';

## 权限的初始化数据
insert into t_customer(name) values ("张武客户");