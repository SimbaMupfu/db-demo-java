import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/* Steps to follow
* Import package
* load and register
* create connection
* create statement
* execute statement
* process the results
* close connection*/

public class TryJdbc {

    public static void main(String[] args) throws Exception{
        Properties props = new Properties();

        try (InputStream input = TryJdbc.class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new IOException("Sorry, unable to find db.properties");
            }
            props.load(input);
        }

        String url = props.getProperty("db.url");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established!!!");
    }
}
