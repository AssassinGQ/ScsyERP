package cn.AssassinG.ScsyERP.common.core.dao;

import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
//    public SqlSessionTemplate getSessionTemplate();
//    public SqlSession getSqlSession();
    long insert(T entity);
    long insert(List<T> list);
    int update(T entity);
    int update(List<T> list);
    int delete(long id);
    int delete(T entity);
    T getById(long id);
    List<T> listAll();
    T getBy(Map<String, Object> paramMap);
    T getBy(Map<String, Object> paramMap, boolean islike);
    List<T> listBy(Map<String, Object> paramMap);
    List<T> listBy(Map<String, Object> paramMap, boolean islike);
    PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap);
    PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap, boolean islike);
}
