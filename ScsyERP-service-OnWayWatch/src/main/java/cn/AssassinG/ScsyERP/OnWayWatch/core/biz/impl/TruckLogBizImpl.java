package cn.AssassinG.ScsyERP.OnWayWatch.core.biz.impl;

import cn.AssassinG.ScsyERP.OnWayWatch.core.biz.TruckLogBiz;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.entity.TruckLog;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("TruckLogBiz")
public class TruckLogBizImpl extends BaseBizImpl<TruckLog> implements TruckLogBiz {
    protected BaseDao<TruckLog> getDao() {
        return null;
    }

    public void updateByMap(Long entityId, Map<String, Object> paramMap) {

    }
}
