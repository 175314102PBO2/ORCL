/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testOracle;

import MODEL_HR.Departments;

/**
 *
 * @author admin
 */
public class TestDepartment1 {

    public static void main(String[] args) {
        Departments dept = new Departments(10, "Administration");
        dept.readEmployees();
        for (int i = 0; i < dept.getListEmployees().size(); i++) {
            System.out.println(dept.getDepartment_id() + "" + dept.getListEmployees().get(i).toString());
        }

        Departments dept1 = new Departments(20, "Marketing");
        dept1.readEmployees();
        for (int i = 0; i < dept1.getListEmployees().size(); i++) {
            System.out.println(dept1.getDepartment_id() + "" + dept1.getListEmployees().get(i).toString());
        }
    }
}
