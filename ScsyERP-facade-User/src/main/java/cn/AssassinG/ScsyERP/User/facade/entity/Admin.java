package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.User.facade.enums.AdminDeptType;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

public class Admin extends LoginableEntity {
    private AdminDeptType Dept;

    public Admin(AdminDeptType dept) {
        super();
        Dept = dept;
    }

    public AdminDeptType getDept() {
        return Dept;
    }

    public void setDept(AdminDeptType dept) {
        Dept = dept;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Dept=" + Dept +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
