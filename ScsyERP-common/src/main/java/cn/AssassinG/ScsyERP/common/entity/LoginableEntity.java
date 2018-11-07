package cn.AssassinG.ScsyERP.common.entity;

public abstract class LoginableEntity extends BaseEntity {
    private String Name;

    public LoginableEntity() {
        super();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
