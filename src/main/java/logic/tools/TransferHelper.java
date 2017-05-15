package logic.tools;

import bean.Account;
import vo.user.AccountVO;

/**
 * Created by Mark.W on 2017/5/15.
 * vo与entity的转换
 */
public class TransferHelper {

    public static Account transToAccount(AccountVO accountVO) {
        if(accountVO == null) {
            return null;
        }

        Account account = new Account();
        account.setUserId(accountVO.getAccountID());
        account.setPassword(accountVO.getPassword());
        account.setRegisterDate(accountVO.getRegisterDate());

        return account;
    }
}
