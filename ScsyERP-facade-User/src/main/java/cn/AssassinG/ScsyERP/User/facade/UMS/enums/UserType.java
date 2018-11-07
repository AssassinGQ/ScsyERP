package cn.AssassinG.ScsyERP.User.facade.UMS.enums;

public enum UserType {

    Corporation("Corporation", 0), Government("Government", 1);

    private String Name;
    private Integer Value;

    private UserType(String name, Integer value) {
        Name = name;
        Value = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getValue() {
        return Value;
    }

    public void setValue(Integer value) {
        Value = value;
    }
}
