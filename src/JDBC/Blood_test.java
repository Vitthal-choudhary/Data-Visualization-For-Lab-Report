package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Blood_test implements Patient{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;
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
    }
}
