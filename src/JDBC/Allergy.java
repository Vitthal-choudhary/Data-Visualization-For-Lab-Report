package JDBC;

import java.sql.*;

public class Allergy implements Patient{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String query;
    Connection con;
    PreparedStatement statement;

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
    }
}