package ir.maktab.jdbc.config;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceConfig {
    private static final DataSourceConfig INSTANCE = new DataSourceConfig();
    private final MysqlDataSource mysqlDataSource = new MysqlDataSource();

    private DataSourceConfig() {}

    public static DataSourceConfig getInstance() {
        return INSTANCE;
    }

    public DataSource createDataSource() {
        mysqlDataSource.setURL(DbConfig.URL);
        mysqlDataSource.setUser(DbConfig.USERNAME);
        mysqlDataSource.setPassword(DbConfig.PASSWORD);
        return mysqlDataSource;
    }
}
