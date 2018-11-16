package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

import java.util.Set;

public class Manufacturer extends LoginableEntity {
    private String Address;
    private String ManName;
    private Set<Long> WorkShops;

    public Manufacturer(String address) {
        super();
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getManName() {
        return ManName;
    }

    public void setManName(String manName) {
        ManName = manName;
    }

    public Set<Long> getWorkShops() {
        return WorkShops;
    }

    public void setWorkShops(Set<Long> workShops) {
        WorkShops = workShops;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "Address='" + Address + '\'' +
                ", ManName='" + ManName + '\'' +
                ", WorkShops=" + WorkShops +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
