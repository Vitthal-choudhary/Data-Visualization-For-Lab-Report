package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class Thyroid implements Patient
{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;

    public Thyroid(float[] a){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE thyroid SET T4=?, T3=?, TSH=? WHERE patient_id=?";
            statement = con.prepareStatement(query);
            statement.setFloat(1,a[0]);
            statement.setFloat(2,a[1]);
            statement.setFloat(3,a[2]);
            statement.setInt(4, patient.pat_id);
            statement.executeUpdate();
            System.out.println("Executed");
            statement.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
