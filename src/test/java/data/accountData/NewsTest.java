package data.accountData;

import DAO.NewsDAO.NewsDAO;
import bean.News;
import data.newsData.NewsData;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/17.
 */
public class NewsTest {
    NewsDAO newsDAO = new NewsData();
    @Test
    public void getNewsTest(){
        Iterator<News> iterator = newsDAO.getNews();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getTitle());
        }
    }
}
