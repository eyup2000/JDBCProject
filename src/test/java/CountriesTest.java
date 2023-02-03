import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountriesTest {
        /*
    Given user connects to the database
    When user sends the query to get the region ids from "countries" table
    Then verify that the number of region ids greater than 1 is 17.
    And user closes the connection
     */
    @Test
    public void countryTest() throws SQLException {
        //Given user connects to the database
        JDBCUtils.connectToDataBase("localhost","Arcane","postgres","5784");
       Statement statement = JDBCUtils.createStatement();

       //When user sends the query to get the region ids from "countries" table
        String sql = "Select region_id from countries;";
       ResultSet resultSet = statement.executeQuery(sql);

        List<Integer> ids = new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getInt(1));
        }
        System.out.println("ids = " + ids);

       // Then verify that the number of region ids greater than 1 is 17.
        List<Integer> birdenBuyukIds = new ArrayList<>();

        for (Integer herBirEleman : ids ){
            if (herBirEleman>1){
                birdenBuyukIds.add(herBirEleman);
            }
        }
        System.out.println("birdenBuyukIds = " + birdenBuyukIds);

        Assert.assertEquals( 17, birdenBuyukIds.size());

        //And user closes the connection
        JDBCUtils.closeConnectionVeStatement();

    }





}
