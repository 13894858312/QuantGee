import DAO.accountDAO.AccountDAO;
import bean.Account;
import data.accountData.AccountData;
import org.junit.Test;

/**
 * Created by wangxue on 2017/5/14.
 */
public class AccountDataTest {

    @Test
    public void insertTest(){
        Account account = new Account();
        account.setPassword("abcd");
        account.setUserId("d1b");
        account.setRegisterDate("2011");
        account.setIsLogIn(0);
        AccountDAO accountDAO = new AccountData();
        accountDAO.addAccount(account);
    }

    @Test
    public void updateTest(){
        Account account = new Account();
        account.setUserId("db");
        account.setIsLogIn(1);
        account.setPassword("acs");
        AccountDAO accountDAO = new AccountData();
        accountDAO.updateAccount(account);
    }

}
