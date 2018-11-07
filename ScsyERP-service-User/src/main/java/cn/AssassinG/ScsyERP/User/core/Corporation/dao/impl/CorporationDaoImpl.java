package cn.AssassinG.ScsyERP.User.core.Corporation.dao.impl;

import cn.AssassinG.ScsyERP.User.core.Corporation.dao.CorporationDao;
import cn.AssassinG.ScsyERP.User.facade.Corporation.entity.Corporation;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="CorporationDao")
public class CorporationDaoImpl extends BaseDaoImpl<Corporation> implements CorporationDao {

}
