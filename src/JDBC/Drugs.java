package JDBC;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;

public class Drugs implements Patient{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;

    public Drugs(int[] a){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE drug set AMPHETAMINES=?, BARBITURATES=?, BENZODIAZEPINES=?, COCAINE_METABOLITES=?, MARIJUANA_METABOLITES=?, MATHADONE=?, METHAQUALONE=?, OPIATES=?, PHENCYCLIDINE=?, PROPOXYPHENE=? where patient_id=?";
            statement = con.prepareStatement(query);
            for (int i = 0; i < a.length; i++) {
                statement.setInt(i + 1, a[i]);
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
        try {
            con = DriverManager.getConnection(url, user, pwd);
            query = "SELECT * FROM drug WHERE patient_id=?";
            statement = con.prepareStatement(query);
            statement.setInt(1, patient.pat_id);
            rs = statement.executeQuery();
            File file = new File("Report.txt");
            FileWriter writer = new FileWriter(file);
            while (rs.next()) {
                writer.write("Patient ID: " + rs.getInt(1) + "\nPatient Name: " + rs.getString(2) + "\nPatient Age: " + rs.getInt(3) + "\nPatient Sex: " + rs.getString(4) + "\n\n\n");
                writer.write("AMPHETAMINES: " + rs.getInt(5) + ((rs.getInt(5) > 1000) ? "    Positive" : "    Normal Range"));
                writer.write("\nBARBITURATES: " + rs.getInt(6) + ((rs.getInt(6) > 300) ? "    Positive" : "    Normal Range"));
                writer.write("\nBENZODIAZEPINES: " + rs.getInt(7) + ((rs.getInt(7) > 300) ? "    Positive" : "    Normal Range"));
                writer.write("\nCOCAINE_METABOLITES: " + rs.getInt(8) + ((rs.getInt(8) > 300) ? "    Positive" : "    Normal Range"));
                writer.write("\nMARIJUANA_METABOLITES: " + rs.getInt(9) + ((rs.getInt(9) > 50) ? "    Positive" : "    Normal Range"));
                writer.write("\nMATHADONE: " + rs.getInt(10) + ((rs.getInt(10) > 300) ? "    Positive" : "    Normal Range"));
                writer.write("\nMETHAQUALONE: " + rs.getInt(11) + ((rs.getInt(11) > 300) ? "    Positive" : "    Normal Range"));
                writer.write("\nOPIATES: " + rs.getInt(12) + ((rs.getInt(12) > 300) ? "    Positive" : "    Normal Range"));
                writer.write("\nPHENCYCLIDINE: " + rs.getInt(13) + ((rs.getInt(13) > 25) ? "    Positive" : "    Normal Range"));
                writer.write("\nPROPOXYPHENE: " + rs.getInt(14) + ((rs.getInt(14) > 300) ? "    Positive" : "    Normal Range"));
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
