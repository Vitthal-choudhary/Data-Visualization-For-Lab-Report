package JDBC;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class Diabetes implements Patient
{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;
    public Diabetes(float[] a){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE diabetes SET Fasting_Blood_Sugar=?, Post_Prandial_Blood_Sugar=?, HAEMOGLOBIN_A1c=? WHERE patient_id=?";
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
        try {
            con = DriverManager.getConnection(url, user, pwd);
            query = "SELECT * FROM diabetes WHERE patient_id=?";
            statement = con.prepareStatement(query);
            statement.setInt(1, patient.pat_id);
            rs = statement.executeQuery();
            File file = new File("Report.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            while (rs.next()) {
                writer.write("Patient ID: " + rs.getInt(1) + "\nPatient Name: " + rs.getString(2) + "\nPatient Age: " + rs.getInt(3) + "\nPatient Sex: " + rs.getString(4) + "\n\n\n");
                writer.write("Fasting Blood Sugar: " + rs.getFloat(5) + ((rs.getFloat(5) < 125.0) ? "    Normal Range" : "    High"));
                writer.write("\nPost Prandial Blood Sugar: " + rs.getFloat(6) + ((rs.getFloat(6) < 200.0) ? "    Normal Range" : "    High"));
                writer.write("\nHAEMOGLOBIN A1c: " + rs.getFloat(7) + ((rs.getFloat(7) < 6.5) ? "    Normal Range" : "    High"));
            }
            statement.close();
            rs.close();
            writer.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
