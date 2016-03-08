/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import graphics.GameWindow;
import graphics.ImgAdm;
import java.awt.Image;
import java.io.IOException;
import pieces.Board;
import pieces.King;
import utilites.ImgPosition;

/**
 *
 * @author Rodrigo
 */
public class ChessLibraryMain {
    
    public static void main(String[] args){
        try{
            ImgAdm.start();
            Board b = new Board(new char[][]{
            {'/','/','/','/','/','/','/','/','/','/'},
            {'/','R','N','B','K','Q','B','N','R','/'},
            {'/','P','P','P','P','P','P','P','P','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','p','p','p','p','p','p','p','p','/'},
            {'/','r','n','b','k','q','b','n','r','/'},
            {'/','/','/','/','/','/','/','/','/','/'},
        });
            GameWindow gw = new GameWindow();
            gw.setBoard(b);
            gw.setVisible(true);
            //gw.update();            
        }catch(IOException e){
            System.err.println(e.toString());
        }
    }
    
}
