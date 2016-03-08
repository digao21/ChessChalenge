/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Usuario
 */
public class Player {
    
    private int id;
    
    private String user;
    private String password;
    private String name;
    
    public int getId(){
        return id;
    }    
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
}
