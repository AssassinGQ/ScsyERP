package cn.AssassinG.ScsyERP.common.core.dao;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.exceptions.DaoException;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    public static final String SQL_INSERT = "insert";
    public static final String SQL_BATCH_INSERT = "batchInsert";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_BATCH_UPDATE = "batchUpdate";
    public static final String SQL_GET_BY_ID = "getById";
    public static final String SQL_DELETE_BY_ID = "deleteById";
    public static final String SQL_DELETE = "delete";
    public static final String SQL_LIST_ALL = "listAll";
    public static final String SQL_LIST_BY = "listBy";
    public static final String SQL_LIST_BY_LIKE = "listByLike";
    public static final String SQL_LIST_PAGE = "listPage";
    public static final String SQL_LIST_PAGE_LIKE = "listPageLike";
    public static final String SQL_LIST_PAGE_COUNT = "listPageCount";
    public static final String SQL_LIST_PAGE_COUNT_LIKE = "listPageCountLike";
//    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam"; // 根据当前分页参数进行统计


    private SqlSessionTemplate sessionTemplate;

    public SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }
    @Autowired
    @Qualifier("sessionTemplate")
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }
    @Autowired
    @Qualifier("sessionTemplate")
    public void setSqlSession(SqlSessionTemplate sessionTemplate){
        super.setSqlSessionTemplate(sessionTemplate);
    }

    public long insert(T entity) {
        int result = sessionTemplate.insert(getStatement(SQL_INSERT), entity);

        if (result <= 0) {
            throw DaoException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}", getStatement(SQL_INSERT));
        }

        if (entity != null && entity.getId() != null && result > 0) {
            return entity.getId();
        }

        return result;
    }

    public long insert(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }

        int result = sessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);

        if (result <= 0) {
            throw DaoException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}", getStatement(SQL_INSERT));
        }
        return result;
    }

    public int update(T entity) {
        int result = sessionTemplate.update(getStatement(SQL_UPDATE), entity);
        if (result <= 0) {
            throw DaoException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}", getStatement(SQL_UPDATE));
        }
        return result;
    }

    public int update(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }

        int result = sessionTemplate.update(getStatement(SQL_BATCH_UPDATE), list);
        if (result <= 0) {
            throw DaoException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}", getStatement(SQL_UPDATE));
        }
        return result;
    }

    public int delete(long id) {
        return (int) sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
    }

    public int delete(T entity) {
        int result = sessionTemplate.update(getStatement(SQL_DELETE), entity);
        if (result <= 0) {
            throw DaoException.DB_UPDATE_RESULT_0.newInstance("数据库操作,delete返回0.{%s}", getStatement(SQL_DELETE));
        }
        return result;
    }

    public T getById(long id) {
        return sessionTemplate.selectOne(getStatement(SQL_GET_BY_ID), id);
    }

    public List<T> listAll() {
        return sessionTemplate.selectList(getStatement(SQL_LIST_ALL));
    }

    public T getBy(Map<String, Object> paramMap) {
        return getBy(paramMap, false);
    }

    public T getBy(Map<String, Object> paramMap, boolean islike) {
        if (paramMap == null || paramMap.isEmpty()) {
            return null;
        }
        List<T> results = null;
        if(islike){
            results = sessionTemplate.selectList(getStatement(SQL_LIST_BY_LIKE), paramMap);
        }else{
            results = sessionTemplate.selectList(getStatement(SQL_LIST_BY), paramMap);
        }
        if(results.size() > 1)
            throw DaoException.DB_GETBY_TOOMANY_RESULT.newInstance("数据库操作,getBy返回多个结果.{%s}", getStatement(SQL_LIST_BY));
        else if(results.size() == 0)
            return null;
        else
            return results.get(0);
    }

    public List<T> listBy(Map<String, Object> paramMap) {
        return listBy(paramMap, false);
    }

    public List<T> listBy(Map<String, Object> paramMap, boolean islike) {
        if (paramMap == null || paramMap.isEmpty()) {
            return null;
        }

        if(islike)
            return sessionTemplate.selectList(getStatement(SQL_LIST_BY_LIKE), paramMap);
        else
            return sessionTemplate.selectList(getStatement(SQL_LIST_BY), paramMap);
    }

    public PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap){
        return listPage(pageParam, paramMap, false);
    }

    public PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap, boolean islike) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        // 根据页面传来的分页参数构造SQL分页参数
        paramMap.put("pageFirst", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize", pageParam.getNumPerPage());
        paramMap.put("startRowNum", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("endRowNum", pageParam.getPageNum() * pageParam.getNumPerPage());

        // 统计总记录数
        Long count;
        // 获取分页数据集
        List<T> list;
        if(islike){
            count = sessionTemplate.selectOne(getStatement(SQL_LIST_PAGE_COUNT_LIKE), paramMap);
            list = sessionTemplate.selectList(getStatement(SQL_LIST_PAGE_LIKE), paramMap);
        }else{
            count = sessionTemplate.selectOne(getStatement(SQL_LIST_PAGE_COUNT), paramMap);
            list = sessionTemplate.selectList(getStatement(SQL_LIST_PAGE), paramMap);
        }

        Object isCount = paramMap.get("isCount"); // 是否统计当前分页条件下的数据：1:是，其他为否
        if (isCount != null && "1".equals(isCount.toString())) {
//            Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
//            return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list, countResultMap);
            //暂不统计
            return new PageBean<T>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
        } else {
            // 构造分页对象
            return new PageBean<T>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
        }
    }

    public String getStatement(String sqlId) {
        String name = this.getClass().getName();
        StringBuffer sb = new StringBuffer();
        sb.append(name).append(".").append(sqlId);
        String statement = sb.toString();

        return statement;
    }
}
