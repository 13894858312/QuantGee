package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/15.
 */
@Entity
public class Account {
    private String userId;
    private String password;
    private String registerDate;
    private int isLogIn;

    @Id
    @Column(name = "userID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "registerDate")
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (userId != null ? !userId.equals(account.userId) : account.userId != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (registerDate != null ? !registerDate.equals(account.registerDate) : account.registerDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "isLogIn")
    public int getIsLogIn() {
        return isLogIn;
    }

    public void setIsLogIn(int isLogIn) {
        this.isLogIn = isLogIn;
    }
}
