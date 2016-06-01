/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runa.csvdataparser.dao;

import com.runa.csvdataparser.entity.Employee;
import java.util.List;

/**
 *
 * @author joyful
 */
public interface EmployeeDao {
    void insert(Employee e) throws Exception;
    List<Employee> getAll();
    Employee getByEmail(String email);
    boolean check_exists(String email);
}
