package service.news;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface NewsService {
    /**
     * 获取新闻动态信息
     * @return 返回新闻动态的ArrayList
     */
    public ArrayList<News> getNews();
}
