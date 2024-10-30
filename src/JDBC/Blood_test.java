package JDBC;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Blood_test implements Patient{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;
    public Blood_test(float[] a){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE blood_test SET WBC=?, RBC=?, HAEMOGLOBIN=?, HEMATOCRIT=?, MCV=?, MCH=?, MCHC=?, RDW_CV=?, PLATELET_COUNT=?, MPV=? WHERE patient_id=?";
            statement = con.prepareStatement(query);
            for (int i = 0; i < a.length; i++) {
                statement.setFloat(i + 1, a[i]);
            }
            statement.setInt(11, patient.pat_id);
            statement.executeUpdate();
            System.out.println("Executed");
            statement.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            con = DriverManager.getConnection(url, user, pwd);
            query = "SELECT * FROM blood_test WHERE patient_id=?";
            statement = con.prepareStatement(query);
            statement.setInt(1, patient.pat_id);
            rs = statement.executeQuery();
            File file = new File("Report.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            while(rs.next()){
                writer.write("Patient ID: " + rs.getInt(1) + "\nPatient Name: " + rs.getString(2) + "\nPatient Age: " + rs.getInt(3) + "\nPatient Sex: " + rs.getString(4) + "\n\n\n");
                writer.write("WBC: " + rs.getFloat(5) + ((rs.getFloat(5) > 11.0) ? "    High" : ((rs.getFloat(5) < 4.5) ? "    Low" : "    Normal Range")));
                writer.write("\nRBC: " + rs.getFloat(6) + ((rs.getFloat(6) > 5.5) ? "    High" : ((rs.getFloat(6) < 3.5) ? "    Low" : "    Normal Range")));
                writer.write("\nHAEMOGLOBIN: " + rs.getFloat(7) + ((rs.getFloat(7) > 15.0) ? "    High" : ((rs.getFloat(7) < 12.0) ? "    Low" : "    Normal Range")));
                writer.write("\nHEMATOCRIT: " + rs.getFloat(8) + ((rs.getFloat(8) > 48.0) ? "    High" : ((rs.getFloat(8) < 36.0) ? "    Low" : "    Normal Range")));
                writer.write("\nMCV: " + rs.getFloat(9) + ((rs.getFloat(9) > 101.0) ? "    High" : ((rs.getFloat(9) < 79.0) ? "    Low" : "    Normal Range")));
                writer.write("\nMCH: " + rs.getFloat(10) + ((rs.getFloat(10) > 35.0) ? "    High" : ((rs.getFloat(10) < 25.0) ? "    Low" : "    Normal Range")));
                writer.write("\nMCHC: " + rs.getFloat(11) + ((rs.getFloat(11) > 37.0) ? "    High" : ((rs.getFloat(11) < 31.0) ? "    Low" : "    Normal Range")));
                writer.write("\nRDW_CV: " + rs.getFloat(12) + ((rs.getFloat(12) > 16.0) ? "    High" : ((rs.getFloat(12) < 11.0) ? "    Low" : "    Normal Range")));
                writer.write("\nPLATELET_COUNT: " + rs.getFloat(13) + ((rs.getFloat(13) > 420) ? "    High" : ((rs.getFloat(13) < 150) ? "    Low" : "    Normal Range")));
                writer.write("\nMPV: " + rs.getFloat(14) + ((rs.getFloat(14) > 10.0) ? "    High" : ((rs.getFloat(14) < 7.0) ? "    Low" : "    Normal Range")));
            }
            writer.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}