package logic.stock;

import DAO.NewsDAO.NewsDAO;
import bean.News;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import service.stock.NewsService;
import vo.stock.NewsVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class NewsServiceImp implements NewsService {

    @Autowired
    private NewsDAO newsDAO;
    @Autowired
    private TransferHelper transferHelper;

    @Override
    public ArrayList<NewsVO> getNews() {
        Iterator<News> news = newsDAO.getNews();
        if(news == null) {
            return null;
        }

        ArrayList<NewsVO> newsVOS = new ArrayList<>();

        while (news.hasNext()) {
            newsVOS.add(transferHelper.transToNewsVO(news.next()));
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
