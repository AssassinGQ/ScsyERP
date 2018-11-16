package cn.AssassinG.ScsyERP.common.core.biz;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface BaseBiz<T extends BaseEntity> {
    long create(T entity);
//    int create(List<T> list);
    void update(T entity);
//    long update(List<T> list);
    void deleteById(long id);
    T getById(long id);
    T getBy(Map<String, Object> paramMap);
    Object getBy(Map<String, Object> paramMap, String sqlId);
    List<T> listBy(Map<String, Object> paramMap);
    List<Object> listBy(Map<String, Object> paramMap, String sqlId);
    PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap);
    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId);
//    String getSeqNextValue(String seqName);
}
