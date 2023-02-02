import java.math.BigDecimal;
import java.sql.*;
//import java.sql.;

public class CallableStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        /*
        Java'da methodlar return type sahibi olsa da olmasada method olarak adlandirilir
        SQL'de ise data return ediliyorsa "function" denir. Return yapmiyorsa "procedure" olarak adlandirilir
         */

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane", "postgres","5784");
        Statement st = con.createStatement();

        //CallableStatement ile function cagirmayi parametrelendiririz
        //1.Adim: Function'inin kodunu yaz
        String sql1 = "create or replace function toplam (x numeric , y numeric)" +
                "returns numeric language plpgsql" +
                "as" +
                "$$" +
                "begin return x+y" +
                "end" +
                "$$" +
                "select * from toplam (4,6) as toplam";
        //Create or Replace Function==> functioni olustur veya var ise degistir
        // plpgsql ==>  producure language postgre sql
        //2.Adim: Function'i calistir
        st.execute(sql1);

        //3.Adim: Function'i cagir
        CallableStatement cs1 = con.prepareCall("{? = call toplamaF (?, ?)}");// ilk parametre  (?) return type icindir

        //4.Adim: Return icin registerOurParameter(), parametrelere icin set() ...... methodlarimizi uygulariz
        cs1.registerOutParameter(1, Types.NUMERIC);

        cs1.setInt(2, 6);
        cs1.setInt(3, 8);
        //5.Adim: execute() ile CallableStatement'i calistir
        cs1.execute();
        //6.Adim: Sonucu cagirmak icin return data type bakilir
        BigDecimal toplam = cs1.getBigDecimal(1);
        System.out.println("toplam = " + toplam);



        //2.Ornek: Koninin hacmini hesaplayan bir function yazin // konu hacmi 3.14*r*r*h/3

        String sql2 = "create or replace function toplam (x numeric , y numeric)" +
                "returns numeric language plpgsql" +
                "as" +
                "$$" +
                "begin return 3.14*r*r*h/3" +
                "end" +
                "$$" +
                "select * from toplam (4,6) as toplam";
        st.execute(sql2);

        CallableStatement cs2 = con.prepareCall("{? = call koniHacmif (?,?)}");

        cs2.registerOutParameter(1, Types.NUMERIC);
        cs2.setInt(2,4);
        cs2.setInt(3,10);
        
        cs2.execute();
        
        BigDecimal konıHacmi = cs2.getBigDecimal(1);
        System.out.println("konıHacmi = " + konıHacmi);

    }
}
