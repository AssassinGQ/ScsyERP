package cn.AssassinG.ScsyERP.User.core.UMS.dao.impl;

import cn.AssassinG.ScsyERP.User.core.UMS.dao.UserDao;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.User;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import cn.AssassinG.ScsyERP.common.exceptions.DaoException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="UserDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public User findByUserName(String UserName) {
        List<User> results = super.getSessionTemplate().selectList(super.getStatement("findByUserNo"), UserName);
        if (results.size() == 0)
            return null;
        else if(results.size() > 1)
            throw DaoException.DB_FINDBYUSERNAME_TOOMANY_RESULT.newInstance("数据库操作,findByUserName返回多个结果.{%s},UserName{%s}", getStatement("findByUserNo"), UserName);
        else
            return results.get(0);
    }
}
