package cn.AssassinG.ScsyERP.User.core.Government.dao.impl;

import cn.AssassinG.ScsyERP.User.core.Government.dao.GovernmentDao;
import cn.AssassinG.ScsyERP.User.facade.Government.entity.Government;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="GovernmentDao")
public class GovernmentImpl extends BaseDaoImpl<Government> implements GovernmentDao {
}
