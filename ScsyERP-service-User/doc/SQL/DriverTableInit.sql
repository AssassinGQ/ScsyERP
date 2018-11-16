drop table if exists t_driver;

create table t_driver (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
#   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
#   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  name      VARCHAR(20) NOT NULL  COMMENT '名称',
  driver_license  VARCHAR(30) COMMENT '驾驶证号码',
  capable_car     VARCHAR(30) COMMENT '准驾车型',
  id_card_photo   BIGINT(20) COMMENT '身份证照片对应主键',
  PRIMARY KEY (id)
);

alter table t_driver comment '驾驶员信息表';

## 权限的初始化数据
insert into t_driver(name, driver_license, capable_car, id_card_photo) values ("张三驾驶员", "123456789", "红旗牌", "1");