package JDBC;

import java.sql.*;

public class Add_to_Patient
{
    String url = "jdbc:mysql://localhost:3306/lab_data";
    String user = "root";
    String pwd = "Berlin@5885";
    String patient_name, patient_sex, query, test;
    int age, pat_id;
    Connection con;
    PreparedStatement statement;
    public void Add_Patient(int id, String patient_name, int age, String patient_sex, String testing_for){
        this.patient_name = patient_name;
        this.patient_sex = patient_sex;
        this.age = age;
        pat_id = id;
        test = testing_for;
        switch (testing_for){
            case "Complete Blood Test":
                query = "INSERT INTO blood_test(patient_id,name, age, sex) VALUES(?,?,?,?)";
                break;
            case "Urinalysis":
                query = "INSERT INTO urinalysis(patient_id,name, age, sex) VALUES(?,?,?,?)";
                break;
            case "Thyroid Test":
                query = "INSERT INTO thyroid(patient_id,name, age, sex) VALUES(?,?,?,?)";
                break;
            case "Diabetes":
                query = "INSERT INTO diabetes(patient_id,name, age, sex) VALUES(?,?,?,?)";
                break;
            case "Sexually Transmitted Disease":
                query = "INSERT INTO sexually_transmitted_disease(patient_id,name, age, sex) VALUES(?,?,?,?)";
                break;
            case "Cholesterol Test":
                query = "INSERT INTO cholesterol(patient_id,name, age, sex) VALUES(?,?,?,?)";
                break;
            case "Drug Test":
                query = "INSERT INTO drug(patient_id,name, age, sex) VALUES(?,?,?,?)";
                break;
            case "Allergy Test":
                query = "INSERT INTO allergy(patient_id,name, age, sex) VALUES(?,?,?,?)";
                break;
            default:
                System.out.println("No Test Selected");
        }
        try {
            con = DriverManager.getConnection(url,user,pwd);
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2,patient_name);
            statement.setInt(3,age);
            statement.setString(4,patient_sex);
            statement.executeUpdate();
            System.out.println("Executed");
        }
        catch (Exception e){
            System.out.println("Not Able to connect");
        }
    }
}
