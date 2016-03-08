/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class PlayerDao {
    
    public void savePlayer(Player player){
        try(Connection con = ConnectionFactory.newConnection()){
            String str = "insert into player (user,password_,name_)\n" +
                        "values (?,?,?)";
            PreparedStatement stm = con.prepareStatement(str);
            stm.setString(1, player.getUser());
            stm.setString(2, player.getPassword());
            stm.setString(3, player.getName());
            
            stm.execute();
        }catch(SQLException ex){
            System.err.println(ex.toString());
            throw new RuntimeException("savePlayer fail\n"+ex.toString());
        }
    }
    
    public Player findPlayer(String user){
        try(Connection con = ConnectionFactory.newConnection()){
            
            String str = "select * from player\n" +
                         "where user = ?";
            
            PreparedStatement stm = con.prepareStatement(str);
            stm.setString(1, user);            
            
            ResultSet res =  stm.executeQuery();
            
            if(!res.next())
                return null;
            
            Player player = new Player();
            player.setId(Integer.parseInt(res.getString("player_id")));
            player.setName(res.getString("name_"));
            player.setUser(res.getString("user"));
            player.setPassword(res.getString("password_"));
            
            return player;
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
            throw new RuntimeException("savePlayer fail\n"+ex.toString());
        }        
    }
    
    public boolean existPlayer(String user){        
        Player p = findPlayer(user);        
        
        return p != null;
    }
    
}
