package data;

import org.hibernate.dialect.MySQLDialect;

import java.sql.Types;

/**
 * hibernate方言扩展，勿动
 * Created by wangxue on 2017/5/16.
 */
public class ExtMysqlDialect extends MySQLDialect {
    public ExtMysqlDialect() {
        super();
        registerHibernateType(Types.LONGVARCHAR,65535,"text");
    }
}