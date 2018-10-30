package TestMyBatis.Dao;

import cn.AssassinG.ScsyERP.User.core.UMS.dao.UserDao;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.User;
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
public class TestUser {
    private static Logger logger = Logger.getLogger(TestUser.class);
    @Autowired
    private UserDao userDao;

    @Test
    public void testGetById() {
        Long user_id = 1L;
        logger.info("The user who's id = "+user_id+" : "+userDao.getById(user_id));
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("asddf");
        user.setPassWord("d123456");
        userDao.insert(user);
        Long id = user.getId();
        if(id == null){
            logger.info("Inserted nothing");
        }else
            logger.info("Inserted : " + userDao.getById(id));
    }

    @Test
    public void testBatchInsert() {
        User user = new User();
        user.setUserName("asddf3");
        User user2 = new User();
        user2.setUserName("asddf4");
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        userDao.insert(users);
        if(users.get(0).getId() != null)
            logger.info("Inserted : " + userDao.getById(users.get(0).getId()));
        if(users.get(1).getId() != null)
            logger.info("Inserted : " + userDao.getById(users.get(1).getId()));
    }

    @Test
    public void testUpdate() {
        User user = userDao.getById(2);
        logger.info("Before Update: "+user);
        user.setUserName("updatedname3");
        userDao.update(user);
        logger.info("After Updated: " + userDao.getById(2));
    }

    @Test
    public void testBatchUpdate() {
        User user2 = userDao.getById(2);
        User user4 = userDao.getById(4);
        logger.info("User2 Before Update: "+user2);
        logger.info("User4 Before Update: "+user4);
        user2.setUserName("updatedname4");
        user4.setUserName("updatedname5");
        List<User> users = new ArrayList<User>();
        users.add(user2);
        users.add(user4);
        userDao.update(users);
        logger.info("User2 After Updated: " + userDao.getById(2));
        logger.info("User4 After Updated: " + userDao.getById(4));
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        logger.info("Before Delete " + userDao.getById(delete_id));
        userDao.delete(delete_id);
        logger.info("After Deleted " + userDao.getById(delete_id));
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        User user = userDao.getById(delete_id);
        logger.info("Before Delete " + userDao.getById(delete_id));
        userDao.delete(user);
        logger.info("After Deleted " + userDao.getById(delete_id));
    }

    @Test
    public void testListAll() {
        List<User> users = userDao.listAll();
        for (int i = 0; i < users.size(); i++)
            logger.info("Item" + i + ":" + users.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", true);
        paramMap.put("Id", 1L);
        logger.info(userDao.getBy(paramMap));
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("UserName", "admi");
        List<User> users = userDao.listBy(paramMap);
        for (int i = 0; i < users.size(); i++)
            logger.info("Item" + i + ":" + users.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<User> pageBean = userDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<User> users = pageBean.getRecordList();
        for (int i = 0; i < users.size(); i++)
            logger.info("Item" + i + ":" + users.get(i));
    }

    @Test
    public void testFindByUsername() {
        String username = "superadmin";
        logger.info("The user who's username = "+username+" : "+userDao.findByUserName(username));
    }

//    @Test
//    public void testFindRoleById() {
//        UserWithRole userWithRole = userDao.findRoleById(1);
//        logger.info(userWithRole);
//    }
}
