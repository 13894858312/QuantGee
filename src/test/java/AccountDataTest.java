import DAO.accountDAO.AccountDAO;
import bean.Account;
import data.accountData.AccountData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import java.util.List;

/**
 * Created by wangxue on 2017/5/14.
 */
public class AccountDataTest {

    @Test
    public void insertTest(){
        Account account = new Account();
        account.setPassword("abcd");
        account.setUserId("d1b");
        account.setRegisterDate("2011");
        account.setIsLogIn(0);
        AccountDAO accountDAO = new AccountData();
        accountDAO.addAccount(account);
    }

    @Test
    public void updateTest(){
        Account account = new Account();
        account.setUserId("db");
        account.setIsLogIn(1);
        account.setPassword("acs");
        AccountDAO accountDAO = new AccountData();
        accountDAO.updateAccount(account);
    }

    @Test
    public void getTxT(){
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(Account.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "SELECT m.stockID FROM MarketInfo m";
            Query query = session.createQuery(hql);
            List<String> list = query.list();

            for(String l:list){
                System.out.print(l+",");
            }

            transaction.commit();
            session.close();
            sessionFactory.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
