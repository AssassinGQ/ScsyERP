package cn.AssassinG.ScsyERP.User.core.UMS.dao;

import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Role;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;

import java.util.Set;

public interface RoleDao extends BaseDao<Role> {
    Set<Role> findByUserId(long Id);
    Set<Role> findByUsername(String UserName);
}
