package data.userData;

import DAO.userDAO.UserDAO;
import bean.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Created by wangxue on 2017/5/5.
 */
public class UserData implements UserDAO{
    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public boolean updateUserInfo(User user) {
        return false;
    }

    @Override
    public User searchUser(String userID) {
        return null;
    }

}
