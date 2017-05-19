package logic.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.user.UserService;
import vo.user.UserVO;

/**
 * Created by Mark.W on 2017/5/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class UserServiceImpTest{

    @Autowired
    private UserService userService;

    @Test
    public void updateUserInfo() throws Exception {
    }

    @Test
    public void getUserInfo() throws Exception {

        UserVO userVO = userService.getUserInfo("wyy");

        System.out.println(userVO.getAccountID());
        System.out.println(userVO.getUserName());
        System.out.println(userVO.getPhoneNumber());

    }

}