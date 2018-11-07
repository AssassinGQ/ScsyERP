package cn.AssassinG.ScsyERP.User.facade.Government.enums;

public enum DeptType {

    YGB("运管部", 0), JJB("交警部", 1), HBB("环保部", 2), XFB("消防部", 3), AJB("安监部", 4);
    private String Name;
    private Integer Value;

    private DeptType(String name, Integer value) {
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
