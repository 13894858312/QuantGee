import DAO.accountDAO.AccountDAO;
import bean.Account;
import logic.ClassA;
import logic.ClassB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mark.W on 2017/5/19.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDAO accountDAO = (AccountDAO)context.getBean("accountDao");
        Account account = new Account();
        account.setIsLogIn(1);
        account.setRegisterDate("134321");
        account.setPassword("34123");
        account.setUserId("2asa35");
        accountDAO.addAccount(account);
    }
}
