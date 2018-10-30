package cn.AssassinG.ScsyERP.User.facade.UMS.entity;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class User extends BaseEntity {
    private String UserName;
    private String PassWord;
    private String Phone;
    private String Vcode;
    private Date VcodeTime;
    private Boolean IfRegistered;
    private Integer UserType;
    private Long UserInfo;

    public User() {
        super();
        this.IfRegistered = false;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getVcode() {
        return Vcode;
    }

    public void setVcode(String vcode) {
        Vcode = vcode;
    }

    public Date getVcodeTime() {
        return VcodeTime;
    }

    public void setVcodeTime(Date vcodeTime) {
        VcodeTime = vcodeTime;
    }

    public Boolean getIfRegistered() {
        return IfRegistered;
    }

    public void setIfRegistered(Boolean ifRegistered) {
        IfRegistered = ifRegistered;
    }

    public Integer getUserType() {
        return UserType;
    }

    public void setUserType(Integer userType) {
        UserType = userType;
    }

    public Long getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(Long userInfo) {
        UserInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Vcode='" + Vcode + '\'' +
                ", VcodeTime=" + VcodeTime +
                ", IfRegistered=" + IfRegistered +
                ", UserType=" + UserType +
                ", UserInfo=" + UserInfo +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IsDeleted=" + IsDeleted +
                '}';
    }
}
