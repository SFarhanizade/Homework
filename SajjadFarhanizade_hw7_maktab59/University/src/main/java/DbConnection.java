import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {
    private MysqlDataSource dataSource = new MysqlDataSource();

    public DbConnection() {
        dataSource.setURL("jdbc:mysql://localhost:3306/University");
        dataSource.setUser("root");
        dataSource.setPassword("");

    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }
}
