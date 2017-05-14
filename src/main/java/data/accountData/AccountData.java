package data.accountData;

import DAO.accountDAO.AccountDAO;
import bean.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import po.AccountPO;

/**
 * Created by wangxue on 2017/5/5.
 */
public class AccountData implements AccountDAO {

    @Override
    public boolean addAccount(AccountPO accountPO) {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(Account.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Account account = new Account();
            account.setRegisterDate(accountPO.getRegisterDate());
            account.setIdentity(accountPO.getIdentity());
            account.setAccountId(accountPO.getAccountID());
            account.setPassword(accountPO.getPassword());

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
    public boolean updateAccount(AccountPO accountPO) {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(Account.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Account account = new Account();
            account.setRegisterDate(accountPO.getRegisterDate());
            account.setIdentity(accountPO.getIdentity());
            account.setAccountId(accountPO.getAccountID());
            account.setPassword(accountPO.getPassword());

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

}
