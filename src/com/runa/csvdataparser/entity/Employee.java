/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runa.csvdataparser.entity;

/**
 *
 * @author joyful
 */
public class Employee {
    private int id;
    private String firstName,lastName,email;
    private Boolean status;

    public Employee() {
    }
    
    

    public Employee(int id, String firstName, String lastName, String email, Boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if(firstName.trim().equalsIgnoreCase("")){
            throw new Exception("First name Required");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if(lastName.trim().equalsIgnoreCase("")){
            throw new Exception("Last name Required");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email.trim().equalsIgnoreCase("")){
            throw new Exception("Email Required");
        }
        
        if(!validateEmail(email)){
            throw new Exception("email invalid");
        }
        
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
    
    public boolean validateEmail(String email) {
      String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      
      return email.matches(EMAIL_REGEX);    
      
   }
}
