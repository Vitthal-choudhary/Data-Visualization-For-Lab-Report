package JDBC;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class STD implements Patient{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;

    public STD(String[] a){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE sexual_disease SET Herpes_Simplex_1=?, Herpes_Simplex_2=?, HIV=?, Chlamydia=?, Gonorrhea=?, Syphilis=?, Hepatitis_A=?, Hepatitis_B=?, Hepatitis_C=? WHERE patient_id=?";
            statement = con.prepareStatement(query);
            for (int i=0; i<=8; i++){
                statement.setString(i+1,a[i]);
            }
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
            query = "SELECT * FROM sexual_disease WHERE patient_id=?";
            statement = con.prepareStatement(query);
            statement.setInt(1, patient.pat_id);
            rs = statement.executeQuery();
            File file = new File("Report.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            while (rs.next()){
                writer.write("Patient ID: " + rs.getInt(1) + "\nPatient Name: " + rs.getString(2) + "\nPatient Age: " + rs.getInt(3) + "\nPatient Sex: " + rs.getString(4) + "\n\n\n");
                writer.write("Herpes Simplex 1: " + rs.getString(5) + ((rs.getString(5).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
                writer.write("Herpes Simplex 2: " + rs.getString(6) + ((rs.getString(6).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
                writer.write("HIV: " + rs.getString(7) + ((rs.getString(7).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
                writer.write("Chlamydia: " + rs.getString(8) + ((rs.getString(8).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
                writer.write("Gonorrhea: " + rs.getString(9) + ((rs.getString(9).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
                writer.write("Syphilis: " + rs.getString(10) + ((rs.getString(10).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
                writer.write("Hepatitis A: " + rs.getString(11) + ((rs.getString(11).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
                writer.write("Hepatitis B: " + rs.getString(12) + ((rs.getString(12).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
                writer.write("Hepatitis C: " + rs.getString(13) + ((rs.getString(13).equalsIgnoreCase("NEGATIVE")) ? "    Normal" : "    STD POSITIVE") + "\n");
            }
            statement.close();
            writer.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
