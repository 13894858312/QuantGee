import DAO.accountDAO.AccountDAO;
import bean.*;
import data.accountData.AccountData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import po.UserAnalysisDataPO;

import java.io.*;
import java.util.List;

/**
 * Created by wangxue on 2017/5/14.
 */
public class AccountDataTest {

    @Test
    public void insertTest(){
        Account account = new Account();
        account.setPassword("abcd");
        account.setUserId("123sd45");
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
        account.setPassword("acvs");
        AccountDAO accountDAO = new AccountData();
        accountDAO.updateAccount(account);
    }

    @Test
    public void getText(){
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(Account.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM User n ";
            List<User> list = session.createQuery(hql).list();

            for(User m:list){
                System.out.print(m.getUserId()+',');
            }

            transaction.commit();
            session.close();
            sessionFactory.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest2(){

        User user = new User();
        user.setUserId("1s00");
        user.setAlterName("dwx");
        user.setPhoneNumber("1221222");

        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
            session.close();
            sessionFactory.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

   @Test
    public void txt(){
        String url ="/MyGit/QuantGee/src/main/resources/code.txt";
        try {
            File file = new File(url);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("/MyGit/QuantGee/src/main/resources/comma1.txt");
            String str;
            while((str = bufferedReader.readLine())!=null){
                fileWriter.write("\""+str+"\",");
                System.out.print("\""+str+"\",");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
   }

}
