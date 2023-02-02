import java.sql.*;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane","postgres","5784");

        Statement st = con.createStatement();
        
        String sql1 = "Update companies set number_of_employees=16000 where number_of_employees < (select avg(number_of_employees) from companies)";
        int updateedilensatırsayısı = st.executeUpdate(sql1);
        System.out.println("updateedilensatırsayısı = " + updateedilensatırsayısı);

        String sql1a = "Select * from companies";
        ResultSet resultSet = st.executeQuery(sql1a);

        while (resultSet.next()){
            System.out.println( resultSet.getString(1)+"--"+ resultSet.getString(2)+"--"+ resultSet.getString(3));
        }

        con.close();
        st.close();
    }
}
