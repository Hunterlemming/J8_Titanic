package Model.DataBase;

import java.sql.*;

public class Config {

    private final String JDBC_DRIVER="org.apache.derby.jdbc.EmbeddedDriver";    //derby driver
    private final String URL="jdbc:derby:DB;create=true";                       //Embedded Derby database (DB)

    protected Connection conn = null;                                             //creating connection (bridge)
    protected DatabaseMetaData dbmd = null;

    protected Config(){
        try{
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("The bridge is inaccessible | "+e);
        }

        try {
            dbmd = conn.getMetaData();
        } catch (SQLException e) {
            System.out.println("Error occurred while accessing Metadata | " +e);
        }

        try {
            ResultSet rs = dbmd.getTables(null, "APP", "USERS", null);
            if(!rs.next()){
                String sql = "create table titanic(passengerid int, survived int, pclass int, name varchar(100), sex varchar(10), age double, sibsp int, parch int, ticket varchar(20), fare double, cabin varchar(20), embarkloc varchar(1))";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            //System.out.println("Error occurred while creating a table | " +e);
        }
    }

}
