package logic.stock;

import DAO.NewsDAO.NewsDAO;
import bean.News;
import logic.tools.TransferHelper;
import service.stock.NewsService;
import vo.stock.NewsVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class NewsServiceImp implements NewsService {

    private NewsDAO newsDAO;

    @Override
    public ArrayList<NewsVO> getNews() {
        Iterator<News> news = newsDAO.getNews();
        if(news == null) {
            return null;
        }

        ArrayList<NewsVO> newsVOS = new ArrayList<>();

        while (news.hasNext()) {
            newsVOS.add(TransferHelper.transToNewsVO(news.next()));
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
