package data;

import DAO.userDAO.UserDAO;
import bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangxue on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class UserTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void updateTest(){
        User user = new User();
        user.setUserId("123123");
        user.setAlterName("wxwxwx");
        user.setPhoneNumber("13902900000");
        Assert.assertEquals(userDAO.updateUserInfo(user),true);
    }

    @Test
    public void searchTest(){
        Assert.assertEquals(userDAO.searchUser("123123").getAlterName(), "wxwxwx");
    }

}
