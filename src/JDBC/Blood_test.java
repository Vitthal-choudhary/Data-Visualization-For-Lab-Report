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
            query = "UPDATE blood_test SET WBC="+a[0]+", RBC="+a[1]+",HAEMOGLOBIN="+a[2]+", HEMATOCRIT="+a[3]+", MCV="+a[4]+", MCH="+a[5]+", MCHC="+a[6]+
                    ", RDW_CV="+a[7]+", PLATELET_COUNT="+a[8]+", MPV="+a[9]+" WHERE patient_id="+patient.pat_id+";";
            System.out.println(query);
            statement = con.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("Executed");
            statement.close();
            con.close();
        }
        catch (Exception e){
            System.out.println("Not Able to connect");
        }
    }
}
