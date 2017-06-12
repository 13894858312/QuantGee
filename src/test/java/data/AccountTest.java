package data;

import DAO.accountDAO.AccountDAO;
import bean.*;
import data.accountData.AccountData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import po.UserAnalysisDataPO;

import java.io.*;
import java.util.List;

/**
 * Created by wangxue on 2017/5/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AccountTest {

    @Autowired
    AccountDAO accountDAO;

    @Test
    public void insertTest() {
        Account account = new Account();
        account.setUserId("wangxue");
        account.setPassword("wangxue");
        account.setRegisterDate("2017-06-12");
        account.setIsLogIn(0);
        accountDAO.addAccount(account);
    }

    @Test
    public void updateTest() {
        Account account = new Account();
        account.setUserId("db");
        account.setIsLogIn(1);
        account.setPassword("acvsds");
        Assert.assertEquals(accountDAO.updateAccount(account),true);
    }

    @Test
    public void findTest(){
        String userID = "db";
        Assert.assertEquals(accountDAO.getAccount(userID).getRegisterDate() , "201");
    }

    @Test
    public void analysis(){
        UserAnalysisDataPO userAnalysisDataPO = accountDAO.getUserAnalysisData();
        System.out.print(userAnalysisDataPO.getUserNum());
    }

}
