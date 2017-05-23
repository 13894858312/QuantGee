package data.userData;

import DAO.userDAO.UserDAO;
import bean.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangxue on 2017/5/5.
 */
@Transactional
public class UserData implements UserDAO{

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public boolean updateUserInfo(User user) {
        hibernateTemplate.update(user);
        return true;
    }

    @Override
    public User searchUser(String userID) {
        User user = (User) hibernateTemplate.get(User.class, userID);
        return user;
    }

}
