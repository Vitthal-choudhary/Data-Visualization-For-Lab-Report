package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Cholesterol implements Patient
{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    public Cholesterol(float[] a){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE cholesterol SET Total_Cholesterol=?, LDL_Cholesterol=?, HDL_Cholesterol=?, Triglycerides=?, Non_HDL_Cholesterol=?, TG_To_HDL_Ratio=? where patient_id=?";
            statement = con.prepareStatement(query);
            for (int i = 0; i < a.length; i++) {
                statement.setFloat(i + 1, a[i]);
            }
            statement.setInt(7, patient.pat_id);
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
