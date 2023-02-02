import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCUtils {
    public static void main(String[] args) {
        connectionDataBase();
    }

    private static Connection connection;
    private  static Statement statement;
    //1.adım : Driver'a kaydol
    //2.adım: Database bağlan

    public static Connection connectionDataBase(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane","postgres","5784");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        if (connection!=null){
            System.out.println("connection Başarili");
        }else {
            System.out.println("connection Başarisiz");
        }

        return connection;
    }

    public static Statement createStatement(){
        try {
            Statement st = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;
    }



}
