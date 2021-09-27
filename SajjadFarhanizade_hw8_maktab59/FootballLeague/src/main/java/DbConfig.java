import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DbConfig {
    static DataSource getDataSource(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/League");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        return mysqlDataSource;
    }
}
