package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Urinalysis implements Patient
{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;

    public Urinalysis(String[] a, float b, float c){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE urinalysis SET COLOR_URINE=?, PROTEIN_URINE=?, GLUCOSE_URINE_IRIS=?, KETONE_URINE=?, BILIRUBIN_URINE=?, NITRITE_URINE=?, LEUKOCYTE_ESTERASE_URINE=?, UROBILINOGEN_URINE=?, PH_URINE=? WHERE patient_id=?";
            statement = con.prepareStatement(query);
            for (int i = 0; i < a.length; i++) {
                statement.setString(i + 1, a[i]);
            }
            statement.setFloat(8, b);
            statement.setFloat(9, c);
            statement.setInt(10, patient.pat_id);
            statement.executeUpdate();
            System.out.println("Executed");
            statement.close();
            con.close();
        }
        catch (Exception e){
            System.out.println("Not Able to connect");
        }
    }

}
