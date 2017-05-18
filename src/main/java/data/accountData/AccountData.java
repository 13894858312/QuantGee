package data.accountData;

import DAO.accountDAO.AccountDAO;
import bean.Account;
import bean.Analysis;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import po.UserAnalysisDataPO;

import java.util.*;

/**
 * Created by wangxue on 2017/5/5.
 */
public class AccountData implements AccountDAO {

    Configuration configuration = new Configuration().configure();

    @Override
    public boolean addAccount(Account account) {
        try{
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
            Configuration configuration = new Configuration().configure();
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
        UserAnalysisDataPO userAnalysisDataPO ;
        try{

            configuration.addClass(Analysis.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from Analysis ");
            Iterator<Analysis> iterator = query.list().iterator();

            Query query1 = session.createQuery("select sum (a.num) from Analysis a");
            Long sum = (Long) query1.uniqueResult();

            if(iterator == null){
                return null;
            }

            Map<String,Integer> map = new HashMap<String,Integer>();
            while (iterator.hasNext()){
                Analysis analysis = iterator.next();
                map.put(analysis.getDate(),analysis.getNum());
            }
            userAnalysisDataPO = new UserAnalysisDataPO(sum,map);

            transaction.commit();
            session.close();
            sessionFactory.close();

            return userAnalysisDataPO;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
