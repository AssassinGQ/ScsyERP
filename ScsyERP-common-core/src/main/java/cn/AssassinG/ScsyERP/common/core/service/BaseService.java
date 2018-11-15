package cn.AssassinG.ScsyERP.common.core.service;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity> {

	/**
	 * 根据ID查找记录.
	 * 
	 * @param id
	 *            .
	 * @return entity .
	 */
	T getById(long id);

	/**
	 * 根据条件查询 listBy: <br/>
	 *
	 * @param paramMap
	 * @return 返回实体
	 */
	T getBy(Map<String, Object> paramMap);

	Object getBy(Map<String, Object> paramMap, String sqlId);

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回集合
	 */
	List<T> listBy(Map<String, Object> paramMap);

	List<Object> listBy(Map<String, Object> paramMap, String sqlId);

	/**
	 * 分页查询 .
	 *
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            业务条件查询参数.
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId);

}
