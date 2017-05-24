package data;

import DAO.strategyDAO.StrategyDAO;
import bean.Strategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class StrategyTest {

    @Autowired
    StrategyDAO strategyDAO;

    @Test
    public void addStrategyTest(){
        Strategy strategy = new Strategy();
        strategy.setUserId("123123");
        strategy.setStrategyContent("我是内容");
        strategy.setStrategyName("我是名字");
        strategy.setStrategyType("我是类型");
        strategy.setPosted(0);
        Assert.assertEquals(strategyDAO.addStrategy(strategy),true);
    }

    @Test
    public void addCollectedStrategyTest(){
        Assert.assertEquals(strategyDAO.addCollectedStrategy("123123",1),true);
    }

    @Test
    public void getUserStrategyTest(){
        Iterator<Strategy> iterator = strategyDAO.getUserStrategy("123123");
        while (iterator.hasNext()){
            System.out.println(iterator.next().getStrategyName());
        }
    }

    @Test
    public void removeCollectedStrategyTest(){
        Assert.assertEquals(strategyDAO.removeCollectedStrategy("123123",1),true);
    }

    @Test
    public void postStrategyTest(){
        Assert.assertEquals(strategyDAO.postStrategy(1),true);
    }


    @Test
    public void getUserCollectedStrategyTest(){
        Iterator<Integer> iterator = strategyDAO.getUserCollectedStrategy("123123");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void getStrategyTest(){
        Assert.assertEquals(strategyDAO.getStrategy(1).getStrategyName(),"我是名字");
    }


    @Test
    public void getAllPostStrategyTest(){
        Iterator<Strategy> iterator = strategyDAO.getAllPostStrategy();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getStrategyName());
        }
    }

    @Test
    public void removeStrategyTest(){
        Assert.assertEquals(strategyDAO.removeStrategy(2),true);
    }


}
