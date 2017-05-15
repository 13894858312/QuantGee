package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/15.
 */
@Entity
public class UserMoney {
    private String userId;
    private double remainMoney;

    @Id
    @Column(name = "userID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "remainMoney")
    public double getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(double remainMoney) {
        this.remainMoney = remainMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserMoney userMoney = (UserMoney) o;

        if (Double.compare(userMoney.remainMoney, remainMoney) != 0) return false;
        if (userId != null ? !userId.equals(userMoney.userId) : userMoney.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId != null ? userId.hashCode() : 0;
        temp = Double.doubleToLongBits(remainMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
