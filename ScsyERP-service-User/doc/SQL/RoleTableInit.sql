drop table if exists t_role;

create table t_role (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  #create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  #update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT '2018-06-10 17:34:02'  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  role_name   VARCHAR(20) COMMENT '角色名称',
  role_desc   VARCHAR(20) COMMENT '角色描述',
  superrole_name VARCHAR(20) COMMENT '父角色名称',
  PRIMARY KEY (id)
);

alter table t_role comment '角色信息表';

## 角色的初始化数据
insert into t_role(role_name, role_desc) values ("superadmin", "超级管理员");##1

insert into t_role(role_name, role_desc, superrole_name) values ("corpration", "承运方账号", "superadmin");##2
insert into t_role(role_name, role_desc, superrole_name) values ("government", "政府账号", "superadmin");##3

insert into t_role(role_name, role_desc, superrole_name) values ("corp_admin", "承运方管理员", "corpration");##4
insert into t_role(role_name, role_desc, superrole_name) values ("corp_partner", "承运方合作方", "corpration");##5
insert into t_role(role_name, role_desc, superrole_name) values ("corp_employee", "承运方员工", "corpration");##6

insert into t_role(role_name, role_desc, superrole_name) values ("admin_warehouse", "仓库管理员", "corp_admin");##7
insert into t_role(role_name, role_desc, superrole_name) values ("admin_project", "项目管理员", "corp_admin");##8
insert into t_role(role_name, role_desc, superrole_name) values ("admin_finance", "财务管理员", "corp_admin");##9
insert into t_role(role_name, role_desc, superrole_name) values ("partner_consignor", "客户", "corp_partner");##10
insert into t_role(role_name, role_desc, superrole_name) values ("partner_manufacturer", "生产厂家", "corp_partner");##11
insert into t_role(role_name, role_desc, superrole_name) values ("partner_receiver", "收货方", "corp_partner");##12
insert into t_role(role_name, role_desc, superrole_name) values ("employee_driver", "驾驶员", "corp_employee");##13
insert into t_role(role_name, role_desc, superrole_name) values ("employee_supervisor", "监装员", "corp_employee");##14
insert into t_role(role_name, role_desc, superrole_name) values ("employee_leftworker", "起重工", "corp_employee");##15
insert into t_role(role_name, role_desc, superrole_name) values ("employee_driveworker", "行车工", "corp_employee");##16