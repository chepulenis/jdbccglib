import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","qwerty123");

            Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE IF NOT EXISTS TEST");
            statement.execute("USE TEST");
            statement.execute("CREATE TABLE IF NOT EXISTS Example (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(256))");
            statement.execute("INSERT INTO EXAMPLE (Name) VALUES ('John'), ('Ann')");
            statement.execute("select * from EXAMPLE");
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }


    }
}
