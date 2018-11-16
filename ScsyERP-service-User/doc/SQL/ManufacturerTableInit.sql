drop table if exists t_manufacturer;

create table t_manufacturer (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
#   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
#   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  name      VARCHAR(20) COMMENT '名称',
  address   VARCHAR(50) NOT NULL COMMENT '地址',
  man_name  VARCHAR(20) COMMENT '联系人姓名',
  workshops TEXT COMMENT '下属车间',
  PRIMARY KEY (id)
);

alter table t_manufacturer comment '生产商信息表';

## 权限的初始化数据
insert into t_manufacturer(name, address, man_name, workshops) values ("生产厂家", "浙江绍兴", "张流", "[]");