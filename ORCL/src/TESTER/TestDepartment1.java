/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TESTER;

import MODEL_HR.department;

/**
 *
 * @author admin
 */
public class TestDepartment1 {

    public static void main(String[] args) {
        department dept = new department (10, "Administration");
        dept.readEmployees();
        for (int i = 0; i < dept.getListEmployees().size(); i++) {
            System.out.println(dept.getListEmployees().get(i).toString());
        }
    }
}
