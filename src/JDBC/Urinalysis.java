package JDBC;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Urinalysis implements Patient
{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;
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
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, user, pwd);
            query = "SELECT * FROM urinalysis WHERE patient_id=?";
            statement = con.prepareStatement(query);
            statement.setInt(1, patient.pat_id);
            rs = statement.executeQuery();
            File file = new File("Report.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            while (rs.next()) {
                writer.write("Patient ID: " + rs.getInt(1) + "\nPatient Name: " + rs.getString(2) + "\nPatient Age: " + rs.getInt(3) + "\nPatient Sex: " + rs.getString(4) + "\n\n\n");
                writer.write("Color Urine: " + rs.getString(5) + ((rs.getString(5).equalsIgnoreCase("CLEAR")) ? "    Normal" : "    Abnormal"));
                writer.write("\nProtein Urine: " + rs.getString(6) + ((rs.getString(6).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    Abnormal"));
                writer.write("\nGlucose Urine Iris: " + rs.getString(7) + ((rs.getString(7).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    Abnormal"));
                writer.write("\nKetone Urine: " + rs.getString(8) + ((rs.getString(8).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    Abnormal"));
                writer.write("\nBilirubin Urine: " + rs.getString(9) + ((rs.getString(9).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    Abnormal"));
                writer.write("\nNitrite Urine: " + rs.getString(10) + ((rs.getString(10).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    Abnormal"));
                writer.write("\nLeukocyte Esterase Urine: " + rs.getString(11) + ((rs.getString(11).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    Abnormal"));
                writer.write("\nUrobilinogen Urine: " + rs.getFloat(12) + ((rs.getFloat(12)<2) ? "    Normal" : "    Abnormal"));
                writer.write("\nPH Urine: " + rs.getFloat(13) + ((rs.getFloat(13)<5) ? "    Normal" : ((rs.getFloat(13)>8) ? "    Abnormal" : "    Normal")));
            }
            writer.close();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
