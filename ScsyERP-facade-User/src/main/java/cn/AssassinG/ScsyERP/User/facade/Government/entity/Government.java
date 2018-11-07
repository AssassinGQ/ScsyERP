package cn.AssassinG.ScsyERP.User.facade.Government.entity;

import cn.AssassinG.ScsyERP.User.facade.Government.enums.DeptType;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

public class Government extends LoginableEntity {
    private DeptType Dept;

    public Government(DeptType dept) {
        super();
        Dept = dept;
    }

    public DeptType getDept() {
        return Dept;
    }

    public void setDept(DeptType dept) {
        Dept = dept;
    }
}
