package data.newsData;

import DAO.NewsDAO.NewsDAO;
import bean.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/17.
 */
@Transactional
public class NewsData implements NewsDAO {

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Iterator<News> getNews() {
        Iterator<News> newsIterator = (Iterator<News>) hibernateTemplate.find("from News n").iterator();
        return newsIterator;
    }
}
