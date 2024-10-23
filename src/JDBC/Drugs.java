package JDBC;

import java.sql.*;

public class Drugs implements Patient{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;

    public Drugs(float[] a){
        try {
            con = DriverManager.getConnection(url,user,pwd);
            query = "UPDATE drug set AMPHETAMINES=?, BARBITURATES=?, BENZODIAZEPINES=?, COCAINE_METABOLITES=?, MARIJUANA_METABOLITES=?, MATHADONE=?, METHAQUALONE=?, OPIATES=?, PHENCYCLIDINE=?, PROPOXYPHENE=? where patient_id=?";
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
