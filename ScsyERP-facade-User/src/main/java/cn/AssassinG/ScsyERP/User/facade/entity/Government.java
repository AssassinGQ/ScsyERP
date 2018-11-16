package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.User.facade.enums.GovernmentDeptType;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

public class Government extends LoginableEntity {
    private GovernmentDeptType Dept;

    public Government(GovernmentDeptType dept) {
        super();
        Dept = dept;
    }

    public GovernmentDeptType getDept() {
        return Dept;
    }

    public void setDept(GovernmentDeptType dept) {
        Dept = dept;
    }

    @Override
    public String toString() {
        return "Government{" +
                "Dept=" + Dept +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
