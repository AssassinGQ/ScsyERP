package cn.AssassinG.ScsyERP.common.entity;

public abstract class UnLoginableEntity extends BaseEntity {
    private String Name;
    private String Phone;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}

