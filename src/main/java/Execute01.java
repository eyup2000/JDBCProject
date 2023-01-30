import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.adım : Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.adım: Database bağlan
     Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane","postgres","5784");

        //3.adım Statement oluştur
       Statement st = con.createStatement();

        System.out.println("Başarılı");

        //4.adım : query (sorgu) oluştur

       // --//1: Ornek: "workers" adinda bir table olusturup "worker_id, worker_name, worker_salary" sutunlarini ekleyin

        boolean sql1 = st.execute("Create Table workers(worker_id VARCHAR(20),worker_name VARCHAR(20),worker_salary INT)");
        System.out.println("sql1 = " + sql1);
        /*
        execute() methodu DDL -data definition language (create, drop, alter table) ve DQL -data query language -(select) için kullanılabiliriz

         */

        //--//2. Ornek: Table'a worker_address sutunu ekleyerek alter yapin

        String sql2 ="Alter Table workers Add worker_address VARCHAR(80)";
      Boolean sql2a = st.execute(sql2);
        System.out.println("sql2a = " + sql2a);

        //3.Ornek: workers table'ini silin
        String sql3 = "Drop Table workers";
        boolean sql3a = st.execute(sql3);
        System.out.println("sql3a = " + sql3a);


        //5.adım : Bağlantı ve statement'i kapatir

        con.close();
        st.close();


    }
}
