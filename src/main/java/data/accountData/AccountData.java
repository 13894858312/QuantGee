package data.accountData;

import DAO.accountDAO.AccountDAO;
import bean.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import po.UserAnalysisDataPO;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/5.
 */
public class AccountData implements AccountDAO {

    @Override
    public boolean addAccount(Account account) {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(Account.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(account);

            transaction.commit();
            session.close();
            sessionFactory.close();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAccount(Account account) {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(Account.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.update(account);

            transaction.commit();
            session.close();
            sessionFactory.close();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Account getAccount(String userID) {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();

            configuration.addClass(Account.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Account account = (Account) session.get(Account.class,userID);

            transaction.commit();
            session.close();
            sessionFactory.close();

            return account;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserAnalysisDataPO getUserAnalysisData() {
        return null;
    }

}
