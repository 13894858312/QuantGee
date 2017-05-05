package service.user;


/**
 * Created by Mark.W on 2017/5/5.
 */
public interface AccountService {

    public String register(Account account);

    public String login(Account account);

    public String modifyPassword(Account account);

    public String logout(Account account);

}
