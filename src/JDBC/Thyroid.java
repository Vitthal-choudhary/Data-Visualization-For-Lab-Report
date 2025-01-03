package JDBC;

import java.io.FileWriter;
import java.sql.*;
import java.io.File;

public class Thyroid implements Patient
{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;
    String name, sex;
    int age, id;
    float T4, T3, TSH;

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
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "SELECT * FROM thyroid WHERE patient_id = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, patient.pat_id);
            rs = statement.executeQuery();
            File f = new File("Report.txt");
            f.createNewFile();
            FileWriter writer = new FileWriter(f);
            while(rs.next()){
                id = rs.getInt("patient_id");
                name = rs.getString("name");
                age = rs.getInt("age");
                sex = rs.getString("sex");
                T4 = rs.getFloat("T4");
                T3 = rs.getFloat("T3");
                TSH = rs.getFloat("TSH");
                writer.write("Patient ID: " + id + "\nPatient Name: " + name + "\nPatient Age: " + age + "\nPatient Sex: " + sex + "\n\n\n");
                writer.write("T4: " + T4 + ((T4 > 21.0) ? "    High" : ((T4 < 11.0) ? "    Low" : "    Normal Range")));
                writer.write("\nT3: " + T3 + ((T3 > 6.0) ? "    High" : ((T3 < 3.1) ? "    Low" : "    Normal Range")));
                writer.write("\nTSH: " + TSH + ((TSH > 5.0) ? "    High" : ((TSH < 0.5) ? "    Low" : "    Normal Range")));
                writer.write("\n");
            }
            writer.close();
            System.out.println("Executed");
            statement.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
