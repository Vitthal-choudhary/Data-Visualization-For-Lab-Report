package JDBC;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cholesterol implements Patient
{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;
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
        try {
            con = DriverManager.getConnection(url, user, pwd);
            query = "SELECT * FROM cholesterol WHERE patient_id=?";
            statement = con.prepareStatement(query);
            statement.setInt(1, patient.pat_id);
            rs = statement.executeQuery();
            File file = new File("Report.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            while (rs.next()) {
                writer.write("Patient ID: " + rs.getInt(1) + "\nPatient Name: " + rs.getString(2) + "\nPatient Age: " + rs.getInt(3) + "\nPatient Sex: " + rs.getString(4) + "\n\n\n");
                writer.write("Total Cholesterol: " + rs.getFloat(5) + ((rs.getFloat(5) < 200.0) ? "    Normal Range" : "    High"));
                writer.write("\nLDL Cholesterol: " + rs.getFloat(6) + ((rs.getFloat(6) < 130.0) ? "    Normal Range" : "    High"));
                writer.write("\nHDL Cholesterol: " + rs.getFloat(7) + ((rs.getFloat(7) > 60.0) ? "    Normal Range" : "    High"));
                writer.write("\nTriglycerides: " + rs.getFloat(8) + ((rs.getFloat(8) < 150.0) ? "    Normal Range" : "    High"));
                writer.write("\nNon-HDL Cholesterol: " + rs.getFloat(9) + ((rs.getFloat(9) < 130.0) ? "    Normal Range" : "    High"));
                writer.write("\nTG To HDL Ratio: " + rs.getFloat(10) + ((rs.getFloat(10) < 3.0) ? "    Normal Range" : "    High"));
            }
            writer.close();
            statement.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
