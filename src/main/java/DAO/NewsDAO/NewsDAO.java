package DAO.NewsDAO;

import bean.News;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/15.
 */
public interface NewsDAO {

    /**
     * 得到新闻
     * @return 100条新闻
     */
    public ArrayList<News> getNews();
}
