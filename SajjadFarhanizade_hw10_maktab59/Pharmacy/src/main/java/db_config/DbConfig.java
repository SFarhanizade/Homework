package db_config;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DbConfig {
    public static DataSource createDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/pharmacy");
        dataSource.setUser("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
