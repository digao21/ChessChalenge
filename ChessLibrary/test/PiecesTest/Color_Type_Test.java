/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package PiecesTest;

import pieces.*;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author MauroSérgio
 */
@RunWith(Parameterized.class)
public class Color_Type_Test {
    private final ChessPiece input;
    private final PieceColor expect;        
    private final PieceType expectT;
    
        
    public Color_Type_Test(ChessPiece input, PieceColor expect, PieceType expectT){
        this.input = input;
        this.expect = expect;
        this.expectT = expectT; 
    }
    
    @Parameterized.Parameters
    public static Collection myInputs(){
        return Arrays.asList(new Object[][]{
                {new King(null,1,1,PieceColor.black),PieceColor.black, PieceType.king},
                {new Queen(null,1,1,PieceColor.black),PieceColor.black, PieceType.queen},
                {new Knight(null,1,1,PieceColor.black),PieceColor.black, PieceType.knight},
                {new Bishop(null,1,1,PieceColor.black),PieceColor.black, PieceType.bishop},
                {new Rook(null,1,1,PieceColor.black),PieceColor.black, PieceType.rook},
                {new Pawn(null,1,1,PieceColor.black),PieceColor.black, PieceType.pawn},
                {new King(null,1,1,PieceColor.white),PieceColor.white, PieceType.king},
                {new Queen(null,1,1,PieceColor.white),PieceColor.white, PieceType.queen},
                {new Knight(null,1,1,PieceColor.white),PieceColor.white, PieceType.knight},
                {new Bishop(null,1,1,PieceColor.white),PieceColor.white, PieceType.bishop},
                {new Rook(null,1,1,PieceColor.white),PieceColor.white, PieceType.rook},
                {new Pawn(null,1,1,PieceColor.white),PieceColor.white, PieceType.pawn},
            }
        );
    }
    
    @Test
    public void test(){
        assertEquals(expect,input.getColor());
        assertEquals(expectT,input.getType());
    }
}
