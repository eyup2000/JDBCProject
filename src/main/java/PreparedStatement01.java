import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane","postgres","5784");

        Statement st = con.createStatement();



        //1. Orn: Prepared Statement kullanarak company adi IBM olan number_of_employees degerini 9999 olarak guncelleyin

        //1.adım preparedstetment query oluştur
        String sql1 = "update companies set number_of_employees=? where company = ?";

        //2.adım
       PreparedStatement ps1 =con.prepareStatement(sql1);

       //3.adım setInt() , setString ...... methotlarını kullanarak soru işareti yerine değer göndeririz
        ps1.setInt(1,9999);
        ps1.setString(2,"IBM");
       int guncellenenSatirSayisi = ps1.executeUpdate();

        String sql1a = "Select * from companies";
        ResultSet resultSet = st.executeQuery(sql1a);

        while (resultSet.next()){
            System.out.println( resultSet.getString(1)+"--"+ resultSet.getString(2)+"--"+ resultSet.getString(3));
        }


        ps1.setInt(1,5555);
        ps1.setString(2,"GOOGLE");
        System.out.println("-----------------------");

        int guncellenenSatirSayisi2 = ps1.executeUpdate();
        System.out.println("guncellenenSatirSayisi2 = " + guncellenenSatirSayisi2);

        ResultSet rs2 = st.executeQuery(sql1a);
        while (rs2.next()){
            System.out.println( resultSet.getString(1)+"--"+ resultSet.getString(2)+"--"+ resultSet.getString(3));

        }
    }
}
