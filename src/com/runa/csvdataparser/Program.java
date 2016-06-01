/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runa.csvdataparser;

import com.runa.csvdataparser.dao.EmployeeDao;
import com.runa.csvdataparser.dao.impl.EmployeeDaoImpl;
import com.runa.csvdataparser.entity.Employee;
import com.runa.csvdataparser.util.FileHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author joyful
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            List<String> lines = FileHandler.read("d:/employees.csv");
            List<String> valid_lines = new ArrayList<>();
            List<String> invalid_lines = new ArrayList<>();
            
            EmployeeDao employeedao = new EmployeeDaoImpl();
            
            for(String line : lines){
                StringTokenizer token = new StringTokenizer(line, ",");
                
                if(token.countTokens() >= 5){
                    try{      

                        Employee e = new Employee();

                        e.setId(Integer.parseInt(token.nextToken()));
                        e.setFirstName(token.nextToken());
                        e.setLastName(token.nextToken());
                        e.setEmail(token.nextToken());
                        e.setStatus((token.nextToken().equals("1")) ? true : false);
                        
                        employeedao.insert(e);
                        
                        valid_lines.add(line);
                        
                    }catch(Exception ex){
                        invalid_lines.add(line+":"+ex.getMessage());
                    }
                    
                } else{
                    invalid_lines.add(line+":"+"broken data");
                }
            }
            
            System.out.println("Invalid Lines");
            for(String line:invalid_lines){
                System.out.println(line);
            }
            
            System.out.println("Valid Lines");
            for(String line:valid_lines){
                System.out.println(line);
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
