package data;

import DAO.NewsDAO.NewsDAO;
import bean.News;
import data.newsData.NewsData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class NewsTest {

    @Autowired
    NewsDAO newsDAO ;
    @Test
    public void getNewsTest(){
        Iterator<News> iterator = newsDAO.getNews();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getTitle());
        }
    }
}
