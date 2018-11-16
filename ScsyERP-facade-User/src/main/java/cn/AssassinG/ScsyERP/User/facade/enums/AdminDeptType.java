package cn.AssassinG.ScsyERP.User.facade.enums;

public enum AdminDeptType {

    WarehouseAdmin("WarehouseAdmin", 0), ProjectAdmin("ProjectAdmin", 1), FinancialAdmin("FinancialAdmin", 2);
    private String Name;
    private Integer Value;

    private AdminDeptType(String name, Integer value) {
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
