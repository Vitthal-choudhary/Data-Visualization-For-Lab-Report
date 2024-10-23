package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class STD implements Patient{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;

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
    }

}
