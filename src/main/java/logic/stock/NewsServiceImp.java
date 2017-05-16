package logic.stock;

import DAO.NewsDAO.NewsDAO;
import bean.News;
import logic.tools.TransferHelper;
import service.stock.NewsService;
import vo.stock.NewsVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class NewsServiceImp implements NewsService {

    private NewsDAO newsDAO;

    @Override
    public ArrayList<NewsVO> getNews() {
        ArrayList<News> news = newsDAO.getNews();
        if(news == null || news.size() == 0) {
            return null;
        }

        ArrayList<NewsVO> newsVOS = new ArrayList<>();

        for(News n : news) {
            newsVOS.add(TransferHelper.transToNewsVO(n));
        }

        return newsVOS;
    }

    public NewsDAO getNewsDAO() {
        return newsDAO;
    }

    public void setNewsDAO(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }
}
