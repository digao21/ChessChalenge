/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gamecontrol.Controler;

/**
 *
 * @author MauroSérgio
 */
public class ChessGameMain {
    public static void main(String[] args){
        
        try{
            Controler.start();
        }catch(Exception x){
            System.err.println("Error in the main");
            System.err.println(x.toString());
        }
    }
}
