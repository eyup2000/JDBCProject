import java.sql.Connection;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
    //1.adım : Driver'a kaydol
    //2.adım: Database bağlan
    Connection con = JDBCUtils.connectToDataBase("localhost","Arcane","postgres","5784");


    //3.adım statement oluştur
     Statement statement = JDBCUtils.createStatement();

    //4.adım query(sorgu) oluştur
    //JDBCUtils.execute("Create Table okul (okul_name VARCHAR(20),okul_kapasitesi INT, address VARCHAR(80))");

    JDBCUtils.createTable("students","name VARCHAR(20)","okul_no INT","address VARCHAR(80)");

    //5.adım
    JDBCUtils.closeConnectionVeStatement();



    }
}
