import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.adım : Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.adım: Database bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane","postgres","5784");

        //3.adım Statement oluştur
        Statement st = con.createStatement();


        //1. Orn: region id'si 1 olan "country name" degerlerini cagirin

        String sql1 = "Select country_name from countries where region_id=1";
       boolean sonuc =  st.execute(sql1);
        System.out.println("sonuc = " + sonuc);

        //Record/satırları gormek için ExecuteQuery() methodunu kullanmalıyız

        ResultSet rs1 = st.executeQuery(sql1);
        System.out.println("rs1 = " + rs1);

        while (rs1.next()){

            rs1.getString(1);
            //System.out.println(rs1.getString(1));
        }

        //2. orn: "region_id'nin 2'den buyuk oldugu "country_id" ve "country_name" degerlerini cagirin

        String sql2 = "Select country_id,country_name from countries where region_id>2;";
        boolean sql2a = st.execute(sql2);

        ResultSet rs2 = st.executeQuery(sql2);

        while (rs2.next()){
            System.out.println(rs2.getString(1));
            System.out.println(rs2.getString(2));
            System.out.println("--------");
        }


        //3. orn: "number_of_employees" degeri en dusuk olan satirin tum degerlerini yazdirin.

        String sql3a ="select min(number_of_employees) from companies";
      ResultSet ra3 =  st.executeQuery(sql3a);

      while (ra3.next()){
          System.out.println(ra3.getString(1));
      }
      con.close();
      st.close();
    }
}
