package data.accountData;

import DAO.accountDAO.AccountDAO;
import bean.Account;
import bean.Analysis;
import bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import po.UserAnalysisDataPO;

import java.util.*;

/**
 * Created by wangxue on 2017/5/5.
 */
@Transactional
public class AccountData implements AccountDAO {

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public boolean addAccount(Account account) {

        hibernateTemplate.flush();
        if(hibernateTemplate.get(Account.class, account.getUserId())!=null){
            return false;
        }
        Analysis analysis = hibernateTemplate.get(Analysis.class, account.getRegisterDate());
        if(analysis!=null){
            int oriNum = analysis.getNum();
            analysis.setNum(oriNum+1);
            hibernateTemplate.update(analysis);
        }else{
            Analysis analysis1 = new Analysis();
            analysis1.setNum(1);
            analysis1.setDate(account.getRegisterDate());
            hibernateTemplate.save(analysis1);
        }

        hibernateTemplate.save(account);

        User user = new User();
        user.setUserId(account.getUserId());
        hibernateTemplate.save(user);
        hibernateTemplate.flush();

        return true;
    }

    @Override
    public boolean updateAccount(Account account) {
        hibernateTemplate.update(account);
        return true;
    }

    @Override
    public Account getAccount(String userID) {
        Account account = (Account)hibernateTemplate.get(Account.class,userID);
        return account;
    }

    @Override
    public UserAnalysisDataPO getUserAnalysisData() {
        UserAnalysisDataPO userAnalysisDataPO ;

        Iterator<Analysis> iterator = (Iterator<Analysis>) hibernateTemplate
                .find("from Analysis ").iterator();
        Long sum =(Long) hibernateTemplate
                .find("select sum(a.num) from Analysis a").listIterator().next();

        if(iterator == null){
                return null;
        }
        Map<String,Integer> map = new HashMap<String,Integer>();
            while (iterator.hasNext()){
                Analysis analysis = iterator.next();
                map.put(analysis.getDate(),analysis.getNum());
            }
        userAnalysisDataPO = new UserAnalysisDataPO(sum,map);
        return userAnalysisDataPO;
    }

}
