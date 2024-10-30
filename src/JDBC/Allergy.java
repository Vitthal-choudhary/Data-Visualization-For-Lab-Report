package JDBC;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;

public class Allergy implements Patient{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;
    public Allergy(float[] a){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE allergy SET Scallop=?, Cashew_Nut=?, Egg_White=?, Cow_Milk=?, CodFish=?, Wheat=?, Sesame_Seed=?, Peanut=?, Soybean=?, Almond=?, Shrimp=?, Tuna=?, Salmon=?, Walnut=? where patient_id=?";
            statement = con.prepareStatement(query);
            for (int i = 0; i < a.length; i++) {
                statement.setFloat(i + 1, a[i]);
            }
            statement.setInt(15, patient.pat_id);
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
            query = "SELECT * FROM allergy WHERE patient_id=?";
            statement = con.prepareStatement(query);
            statement.setInt(1, patient.pat_id);
            rs = statement.executeQuery();
            File file = new File("Report.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            while (rs.next()) {
                writer.write("Patient ID: " + rs.getInt(1) + "\nPatient Name: " + rs.getString(2) + "\nPatient Age: " + rs.getInt(3) + "\nPatient Sex: " + rs.getString(4) + "\n\n\n");
                writer.write("Scallop: " + rs.getFloat(5) + ((rs.getFloat(5) < 0.10) ? "    Normal" : "    Allergic"));
                writer.write("\nCashew Nut: " + rs.getFloat(6) + ((rs.getFloat(6) < 0.11) ? "    Normal" : "    Allergic"));
                writer.write("\nEgg White: " + rs.getFloat(7) + ((rs.getFloat(7) < 0.12) ? "    Normal" : "    Allergic"));
                writer.write("\nCow Milk: " + rs.getFloat(8) + ((rs.getFloat(8) < 0.13) ? "    Normal" : "    Allergic"));
                writer.write("\nCod Fish: " + rs.getFloat(9) + ((rs.getFloat(9) < 0.14) ? "    Normal" : "    Allergic"));
                writer.write("\nWheat: " + rs.getFloat(10) + ((rs.getFloat(10) < 0.15) ? "    Normal" : "    Allergic"));
                writer.write("\nSesame Seed: " + rs.getFloat(11) + ((rs.getFloat(11) < 0.16) ? "    Normal" : "    Allergic"));
                writer.write("\nPeanut: " + rs.getFloat(12) + ((rs.getFloat(12) < 0.17) ? "    Normal" : "    Allergic"));
                writer.write("\nSoybean: " + rs.getFloat(13) + ((rs.getFloat(13) < 0.18) ? "    Normal" : "    Allergic"));
                writer.write("\nAlmond: " + rs.getFloat(14) + ((rs.getFloat(14) < 0.19) ? "    Normal" : "    Allergic"));
                writer.write("\nShrimp: " + rs.getFloat(15) + ((rs.getFloat(15) < 0.20) ? "    Normal" : "    Allergic"));
                writer.write("\nTuna: " + rs.getFloat(16) + ((rs.getFloat(16) < 0.21) ? "    Normal" : "    Allergic"));
                writer.write("\nSalmon: " + rs.getFloat(17) + ((rs.getFloat(17) < 0.22) ? "    Normal" : "    Allergic"));
                writer.write("\nWalnut: " + rs.getFloat(18) + ((rs.getFloat(18) < 0.23) ? "    Normal" : "    Allergic"));
            }
            writer.close();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}