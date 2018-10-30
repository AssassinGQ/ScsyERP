package cn.AssassinG.ScsyERP.User.core.UMS.dao;

import cn.AssassinG.ScsyERP.User.facade.UMS.entity.User;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;

public interface UserDao extends BaseDao<User> {
    User findByUserName(String UserName);
}
