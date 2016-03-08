/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import utilites.GamePosition;

/**
 *
 * @author MauroSérgio
 */
public class Rook extends ChessPiece
{   
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Rook(Board board, GamePosition pos, PieceColor color){
        super(board,pos,PieceType.rook,color);
    }
        
    public Rook(Board board, int i, int j, PieceColor color){
        super(board,i,j,PieceType.rook,color);
    }      
    
    //--------------------------------------------------------------------------
    //PIECE INFORMATION
    
    public static char getBlackId(){
        return 'R';
    }
    
    public static char getWhiteId(){
        return 'r';
    }
    
    public static boolean isRookId(char id){
        return id == getBlackId() || id == getWhiteId();
    }
    
    @Override
    public char getId(){
        if(color == PieceColor.black)
            return getBlackId();
        return getWhiteId();
    }
    
    //--------------------------------------------------------------------------
    //SELECT AND MOVE METHODS
    
    /***************************************************************************
    *Brief:
    *   Select the positions in the board where this piece can move
    */
    @Override
    public void selectPiece()
    {
        int posI = pos.getI();
        int posJ = pos.getJ();
                
        selectPieceAux(posI,posJ, 1, 0);
        selectPieceAux(posI,posJ,-1, 0);
        selectPieceAux(posI,posJ, 0,-1);
        selectPieceAux(posI,posJ, 0, 1);
             
    }
}
