import DAO.accountDAO.AccountDAO;
import data.accountData.AccountData;
import org.junit.Test;
import po.AccountPO;

/**
 * Created by wangxue on 2017/5/14.
 */
public class AccountDataTest {

    @Test
    public void insertTest(){
        AccountPO accountPO = new AccountPO("000000","password","2016-11-11","1");
        AccountDAO accountDAO = new AccountData();
        accountDAO.addAccount(accountPO);
    }

    @Test
    public void updateTest(){
        AccountPO accountPO = new AccountPO("111111","password","2016-12-23","2");
        AccountDAO accountDAO = new AccountData();
        accountDAO.updateAccount(accountPO);
    }

}
