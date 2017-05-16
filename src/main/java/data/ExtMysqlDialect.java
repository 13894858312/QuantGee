package data;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;

import java.sql.Types;

/**
 * Created by wangxue on 2017/5/16.
 */
public class ExtMysqlDialect extends MySQLDialect {
    public ExtMysqlDialect() {
        super();
        registerHibernateType(Types.LONGVARCHAR,65535,"text");
    }
}