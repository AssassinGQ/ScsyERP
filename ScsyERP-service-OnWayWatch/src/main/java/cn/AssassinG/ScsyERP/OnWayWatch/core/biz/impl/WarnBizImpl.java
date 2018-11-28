package cn.AssassinG.ScsyERP.OnWayWatch.core.biz.impl;

import cn.AssassinG.ScsyERP.OnWayWatch.core.biz.WarnBiz;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.entity.Warn;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("WarnBiz")
public class WarnBizImpl extends BaseBizImpl<Warn> implements WarnBiz {
    protected BaseDao<Warn> getDao() {
        return null;
    }

    public void updateByMap(Long entityId, Map<String, Object> paramMap) {

    }
}
