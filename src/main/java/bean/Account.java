package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/13.
 */
@Entity
public class Account {
    private String password;
    private String registerDate;
    private int identity;
    private String accountId;

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "registerDate", nullable = false, length = 10)
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "identity", nullable = false)
    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    @Id
    @Column(name = "accountId", nullable = false, length = 20)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (identity != account.identity) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (registerDate != null ? !registerDate.equals(account.registerDate) : account.registerDate != null)
            return false;
        if (accountId != null ? !accountId.equals(account.accountId) : account.accountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + identity;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }
}
