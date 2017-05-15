package data;

import bean.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by wangxue on 2017/5/15.
 */
public class Temp {
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

        transaction.commit();
        session.close();
        sessionFactory.close();

    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
