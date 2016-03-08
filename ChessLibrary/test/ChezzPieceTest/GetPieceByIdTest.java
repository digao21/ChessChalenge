/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChezzPieceTest;

import pieces.*;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Rodrigo
 */
@RunWith(Parameterized.class)
public class GetPieceByIdTest {
    private final char input;
    private final ChessPiece expect;        
    
        
    public GetPieceByIdTest(char input, ChessPiece expect){
        this.input = input;
        this.expect = expect;
    }
    
    @Parameterized.Parameters
    public static Collection myInputs(){
        return Arrays.asList(new Object[][]{
                {'K',new King(null,1,1,PieceColor.black)},
                {'Q',new Queen(null,1,1,PieceColor.black)},
                {'N',new Knight(null,1,1,PieceColor.black)},
                {'B',new Bishop(null,1,1,PieceColor.black)},
                {'R',new Rook(null,1,1,PieceColor.black)},
                {'P',new Pawn(null,1,1,PieceColor.black)},
                {'k',new King(null,1,1,PieceColor.white)},
                {'q',new Queen(null,1,1,PieceColor.white)},
                {'n',new Knight(null,1,1,PieceColor.white)},
                {'b',new Bishop(null,1,1,PieceColor.white)},
                {'r',new Rook(null,1,1,PieceColor.white)},
                {'p',new Pawn(null,1,1,PieceColor.white)},
            }
        );
    }
    
    @Test
    public void test(){
        ChessPiece aux = ChessPiece.getPieceById(input);        
        assertEquals(expect.getColor(),aux.getColor());
        assertEquals(expect.getType(),aux.getType());
    }
}
