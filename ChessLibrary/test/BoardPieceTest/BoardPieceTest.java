/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardPieceTest;

import java.awt.Image;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pieces.Board;
import pieces.BoardPiece;
import utilites.GamePosition;

/**
 *
 * @author Rodrigo
 */

class DummyPiece extends BoardPiece{

    public DummyPiece(Board board, int i, int j) {
        super(board, i, j);
    }
    
    public DummyPiece(Board board, GamePosition pos) {
        super(board, pos);
    }

    @Override
    public char delet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

public class BoardPieceTest {
    @Test
    public void positionTest1(){        
        DummyPiece p = new DummyPiece(null,1,2);                
        
        assertEquals(1,p.getPosition().getI());
        assertEquals(2,p.getPosition().getJ());
        
        p.setPosition(3, 4);
        
        assertEquals(3,p.getPosition().getI());
        assertEquals(4,p.getPosition().getJ());
    }
    
    @Test
    public void positionTest2(){
        GamePosition pos = new GamePosition(1,2);
        DummyPiece p = new DummyPiece(null,pos);                
        
        assertEquals(pos.getI(),p.getPosition().getI());
        assertEquals(pos.getJ(),p.getPosition().getJ());
        
        p.setPosition(3, 4);
        
        assertEquals(1,pos.getI());
        assertEquals(2,pos.getJ());
        
        assertEquals(3,p.getPosition().getI());
        assertEquals(4,p.getPosition().getJ());
    }
    
    @Test
    public void setGetBoard1(){
        GamePosition pos = new GamePosition(1,2);
        DummyPiece p = new DummyPiece(null,pos);
        assertEquals(null,p.getBoard());
        
    }
    
    @Test
    public void setGetBoard2(){
        GamePosition pos = new GamePosition(1,2);
        Board b = new Board();
        DummyPiece p = new DummyPiece(b,pos);
        assertEquals(b,p.getBoard());
        
    }
}
