/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import chessgameserver.Controler;


/**
 *
 * @author Rodrigo
 */
public class ChessGameServerMain {
    public static void main(String[] args){
        try{
            Controler.start();                                                            
        }catch(Exception e){
            System.err.println("Error in the main");
            System.err.println(e.toString());
        }
    }
}
