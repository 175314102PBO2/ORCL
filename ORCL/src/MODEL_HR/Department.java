/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_HR;

import UTIL.MyOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Department {

    private int department_id;
    private String department_name;
    private ArrayList<Employee> listEmployees = new ArrayList<Employee>();
    private ArrayList<Employee> managers = new ArrayList<Employee>();

    public Department(int department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public void readEmployees() {
        try {
            // buat kelas database
            MyOracle ora = new MyOracle("172.23.9.185", "1521", "orcl",
                    MyOracle.USER_NAME, MyOracle.PASSWORD);
            // buat koneksi
            Connection con = ora.getConnection();
            // buat statement
            Statement statement = con.createStatement();
            // buat query
            // SELECT id_dokter,nama from puspa.dokter 
            String query = "SELECT first_name ,last_name FROM employees WHERE DEPARTMENT_ID = "+department_id;
            // kosongkan list 
            setListEmployees(new ArrayList<Employee>());
            // jalankan/eksekusi queri
            ResultSet emp = statement.executeQuery(query);
            while (emp.next()) {
                Employee temp = new Employee(emp.getString(1),emp.getString(2));
//                temp.setEmployee_id("DEPARTMET");
//                temp.setFirst_name(department_name);
                // tambahkan ke list
                listEmployees.add(temp);
            }
            // tutup koneksi
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readManager() {
//try {
//            // buat kelas database
//            MyOracle ora = new MyOracle("172.23.9.185", "1521", "orcl",
//                    MyOracle.USER_NAME, MyOracle.PASSWORD);
//            // buat koneksi
//            Connection con = ora.getConnection();
//            // buat statement
//            Statement statement = con.createStatement();
//            // buat query
//            // SELECT id_dokter,nama from puspa.dokter 
//            String query = "SELECT manager_id FROM departments WHERE DEPARTMENT_ID = "+department_id;
//            // kosongkan list 
//            setManagers(new ArrayList<Employee>());
//            // jalankan/eksekusi queri
//            ResultSet emp = statement.executeQuery(query);
//            while (emp.next()) {
//                m temp = new Employee(emp.getString(1),emp.getString(2));
////                temp.setEmployee_id("DEPARTMET");
////                temp.setFirst_name(department_name);
//                // tambahkan ke list
//               managers.add(temp);
//            }
//            // tutup koneksi
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public Department() {
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public ArrayList<Employee> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(ArrayList<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public ArrayList<Employee> getManagers() {
        return managers;
    }

    /**
     * @param managers the managers to set
     */
    public void setManagers(ArrayList<Employee> managers) {
        this.managers = managers;
    }
}
