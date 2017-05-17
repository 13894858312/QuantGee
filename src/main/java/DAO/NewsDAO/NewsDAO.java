package DAO.NewsDAO;

import bean.News;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/15.
 */
public interface NewsDAO {

    /**
     * 得到新闻
     * @return 100条新闻Iterator，出错返回null
     */
    public Iterator<News> getNews();
}
