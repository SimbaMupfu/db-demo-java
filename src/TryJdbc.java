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

        Statement statement = conn.createStatement();
        //Retrieve data from DB
//        String query = "SELECT * FROM student ORDER BY sid ASC";
//        ResultSet resultSet = statement.executeQuery(query);
//        System.out.println("ID - Name - Marks");
//        while(resultSet.next()){
//            System.out.print(resultSet.getInt(1) + " - ");
//            System.out.print(resultSet.getString(2) + " - ");
//            System.out.println(resultSet.getInt(3));
//        }
        //insert into table
//        String query = "INSERT INTO student VALUES (8, 'Clever', 98)";
        //update field in table
        String query = "UPDATE student SET sname='Simbarashe' WHERE sid=5";
        statement.execute(query);
        conn.close();
    }
}
