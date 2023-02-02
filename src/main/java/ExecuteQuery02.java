import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.adım : Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.adım: Database bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane","postgres","5784");

        //3.adım Statement oluştur
        Statement st = con.createStatement();


        String sql1 = "Select company, number_of_employees From companies Order By number_of_employees DESC Offset 1 Row Fetch Next Row Only";
        String sql2 ="select max(number_of_employees)  from companies where number_of_employees<(select max(number_of_employees)from companies )";

       ResultSet rs1 = st.executeQuery(sql1);
       while (rs1.next()){
           System.out.println(rs1.getString(1)+"--"+ rs1.getString(2));
       }


       con.close();
       st.close();








    }
    }
