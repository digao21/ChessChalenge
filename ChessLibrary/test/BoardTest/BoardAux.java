/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardTest;

import pieces.Board;

/**
 *
 * @author MauroSérgio
 */
public abstract class BoardAux {
        
    static public void printBoard(char[][] c){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(c[i][j]);
            }
            System.out.println();
        }        
    }
    
    static public boolean compareDescription(char[][] myBoard, char[][] compareBoard){
        boolean answ = true;
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                answ = answ&&(myBoard[i][j] == compareBoard[i][j]);
            }
        }
        
        return answ;
    }
    
}
