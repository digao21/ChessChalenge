/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiecesTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pieces.*;


/**
 *
 * @author Rodrigo
 */
public class IsMyId {
    @Test
    public void bishopId(){        
        assertTrue(Bishop.isBishopId('B'));
        assertTrue(Bishop.isBishopId('b'));
        assertTrue(!Bishop.isBishopId('P'));
        assertTrue(!Bishop.isBishopId('E'));
    }
    
    @Test
    public void kingId(){                
        assertTrue(King.isKingId('K'));
        assertTrue(King.isKingId('k'));
        assertTrue(!King.isKingId('B'));
        assertTrue(!King.isKingId('L'));
    }
    
    @Test
    public void knightId(){        
        assertTrue(Knight.isKnightId('N'));
        assertTrue(Knight.isKnightId('n'));
        assertTrue(!Knight.isKnightId('K'));
        assertTrue(!Knight.isKnightId('x'));
    }
    
    @Test
    public void pawnId(){        
        assertTrue(Pawn.isPawnId('P'));
        assertTrue(Pawn.isPawnId('p'));
        assertTrue(!Pawn.isPawnId('N'));
        assertTrue(!Pawn.isPawnId('l'));
    }
    
    @Test
    public void queenId(){        
        assertTrue(Queen.isQueenId('Q'));
        assertTrue(Queen.isQueenId('q'));
        assertTrue(!Queen.isQueenId('P'));
        assertTrue(!Queen.isQueenId('a'));
    }
    
    @Test
    public void rookId(){        
        assertTrue(Rook.isRookId('R'));
        assertTrue(Rook.isRookId('r'));
        assertTrue(!Rook.isRookId('N'));
        assertTrue(!Rook.isRookId('l'));
    }
    
}
