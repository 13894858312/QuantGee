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
        AccountDAO accountDAO = new AccountData();
        accountDAO.addAccount(account);
    }

    @Test
    public void updateTest(){
        Account accountPO = new Account();
        AccountDAO accountDAO = new AccountData();
        accountDAO.updateAccount(accountPO);
    }

}
