package cn.AssassinG.ScsyERP.User.core.UMS.dao.impl;

import cn.AssassinG.ScsyERP.User.core.UMS.dao.RolePermissionDao;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Role_Permission;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="RolePermissionDao")
public class RolePermissionDaoImpl extends BaseDaoImpl<Role_Permission> implements RolePermissionDao {
}
