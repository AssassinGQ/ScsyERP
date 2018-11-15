package cn.AssassinG.ScsyERP.common.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {
    protected Long Id;
    protected Date CreateTime;
    protected Date UpdateTime;
    protected Date DeleteTime;
    protected Boolean IfDeleted;

    public BaseEntity() {
        IfDeleted = false;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        this.CreateTime = createTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.UpdateTime = updateTime;
    }

    public Date getDeleteTime() {
        return DeleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.DeleteTime = deleteTime;
    }

    public Boolean getIfDeleted() {
        return IfDeleted;
    }

    public void setIfDeleted(Boolean ifDeleted) {
        IfDeleted = ifDeleted;
    }
}
