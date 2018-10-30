package TestMyBatis.Dao;

import cn.AssassinG.ScsyERP.User.core.UMS.dao.UserRoleDao;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.User_Role;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class TestUserRole {
    private static Logger logger = Logger.getLogger(TestUserRole.class);
    @Autowired
    private UserRoleDao user_roleDao;

    @Test
    public void testGetById() {
        Long user_role_id = 1L;
        logger.info("The user_role who's id = "+user_role_id+" : "+user_roleDao.getById(user_role_id));
    }

    @Test
    public void testInsert() {
        User_Role user_role = new User_Role();
        user_role.setRoleId(1L);
        user_roleDao.insert(user_role);
        Long id = user_role.getId();
        if(id == null){
            logger.info("Inserted nothing");
        }else
            logger.info("Inserted : " + user_roleDao.getById(id));
    }

    @Test
    public void testBatchInsert() {
        User_Role user_role = new User_Role();
        user_role.setRoleId(1L);
        User_Role user_role2 = new User_Role();
        user_role2.setRoleId(2L);
        List<User_Role> user_roles = new ArrayList<User_Role>();
        user_roles.add(user_role);
        user_roles.add(user_role2);
        user_roleDao.insert(user_roles);
        if(user_roles.get(0).getId() != null)
            logger.info("Inserted : " + user_roleDao.getById(user_roles.get(0).getId()));
        if(user_roles.get(1).getId() != null)
            logger.info("Inserted : " + user_roleDao.getById(user_roles.get(1).getId()));
    }

    @Test
    public void testUpdate() {
        User_Role user_role = user_roleDao.getById(2);
        logger.info("Before Update: "+user_role);
        user_role.setRoleId(1L);
        user_roleDao.update(user_role);
        logger.info("After Updated: " + user_roleDao.getById(2));
    }

    @Test
    public void testBatchUpdate() {
        User_Role user_role2 = user_roleDao.getById(2);
        User_Role user_role4 = user_roleDao.getById(4);
        logger.info("User_Role2 Before Update: "+user_role2);
        logger.info("User_Role4 Before Update: "+user_role4);
        user_role2.setRoleId(1L);
        user_role4.setRoleId(2L);
        List<User_Role> user_roles = new ArrayList<User_Role>();
        user_roles.add(user_role2);
        user_roles.add(user_role4);
        user_roleDao.update(user_roles);
        logger.info("User_Role2 After Updated: " + user_roleDao.getById(2));
        logger.info("User_Role4 After Updated: " + user_roleDao.getById(4));
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        logger.info("Before Delete " + user_roleDao.getById(delete_id));
        user_roleDao.delete(delete_id);
        logger.info("After Deleted " + user_roleDao.getById(delete_id));
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        User_Role user_role = user_roleDao.getById(delete_id);
        logger.info("Before Delete " + user_roleDao.getById(delete_id));
        user_roleDao.delete(user_role);
        logger.info("After Deleted " + user_roleDao.getById(delete_id));
    }

    @Test
    public void testListAll() {
        List<User_Role> user_roles = user_roleDao.listAll();
        for (int i = 0; i < user_roles.size(); i++)
            logger.info("Item" + i + ":" + user_roles.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", true);
        paramMap.put("Id", 1L);
        logger.info(user_roleDao.getBy(paramMap));
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        List<User_Role> user_roles = user_roleDao.listBy(paramMap);
        for (int i = 0; i < user_roles.size(); i++)
            logger.info("Item" + i + ":" + user_roles.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<User_Role> pageBean = user_roleDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<User_Role> user_roles = pageBean.getRecordList();
        for (int i = 0; i < user_roles.size(); i++)
            logger.info("Item" + i + ":" + user_roles.get(i));
    }
}