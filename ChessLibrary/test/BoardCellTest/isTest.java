/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardCellTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pieces.BoardCell;
import pieces.King;
import pieces.PieceColor;

/**
 *
 * @author Rodrigo
 */
public class isTest {
    @Test
    public void edge(){
        BoardCell c = new BoardCell(null,1,1,false);
        assertFalse(c.isEdge());
        
        BoardCell d = new BoardCell(null,1,1,true);
        assertTrue(d.isEdge());        
    }
    
    @Test
    public void occupie(){
        BoardCell c = new BoardCell(null,1,1,false);
        
        c.setChessPiece(new King(null,1,1,PieceColor.black));
        assertTrue(c.isOccupie());
        
        c.setOutChessPiece();
        
        assertFalse(c.isOccupie());
        
        c.setChessPiece(new King(null,1,1,PieceColor.black));
        assertTrue(c.isOccupie());
        
    }
    
    @Test
    public void mark(){
        BoardCell c = new BoardCell(null,1,1,false);
        
        c.markCell();
        assertTrue(c.isMarked());
        
        c.unMarkCell();
        
        assertFalse(c.isMarked());
        
        c.markCell();
        assertTrue(c.isMarked());
        
    }
    
}
