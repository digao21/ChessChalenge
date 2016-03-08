/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardTest;

import pieces.Board;
import org.junit.Test;

/**
 *
 * @author MauroSérgio
 */
public class BoardTestAux {

    @Test
    public void auxTest(){
        Board b = new Board(new char[][]{
                {'/','/','/','/','/','/','/','/','/','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','P','O','k','O','O','O','/'},
                {'/','O','O','O','O','O','n','O','O','/'},
                {'/','O','O','O','N','O','O','O','O','/'},
                {'/','O','O','O','O','O','N','O','O','/'},
                {'/','O','O','p','O','q','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','O','O','O','O','O','O','O','O','/'},
                {'/','/','/','/','/','/','/','/','/','/'},
            });
        b.selectPiece(4, 4);
        
        BoardAux.printBoard(b.getDescription());
    }
    
}
