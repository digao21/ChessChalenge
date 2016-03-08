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
public class Pawn extends ChessPiece
{       
    private Boolean firstMove = null;
    
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    
    public Pawn(Board board, GamePosition pos, PieceColor color){
        super(board,pos,PieceType.pawn,color);
    }
        
    public Pawn(Board board, int i, int j, PieceColor color){
        super(board,i,j,PieceType.pawn,color);
    }            
    
    //--------------------------------------------------------------------------
    //PIECE INFORMATION
    
    public static char getBlackId(){
        return 'P';
    }
    
    public static char getWhiteId(){
        return 'p';
    }
    
    public static boolean isPawnId(char id){
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
        
    @Override
    public void selectPiece(){
        
        int posI = pos.getI();
        int posJ = pos.getJ();
        
        int movI;
        if(color == PieceColor.black)        
            movI = 1;        
        else        
            movI = -1;        
                
        int i = posI + movI;
        int j = posJ;
        
        
        if(!board.isEdge(i, j) && !board.isOccupie(i, j))        
            board.mark(i,j);
                
        if(firstMove && !board.isEdge(i+movI, j) && !board.isOccupie(i+movI, j))        
            board.mark(i+movI,j);        
        
        if(!board.isEdge(i, j+1) && board.isOccupie(i, j+1))
            if(board.getPieceColor(i, j+1) != color)
                board.mark(i, j+1);
        
        if(!board.isEdge(i, j-1) && board.isOccupie(i, j-1))
            if(board.getPieceColor(i, j-1) != color)
                board.mark(i, j-1);                                
        
    }
        
    @Override
    public void setPosition(GamePosition pos){
        super.setPosition(pos);
        
        if(firstMove == null)
            firstMove = true;
        
        else if(firstMove == true)
            firstMove = false;
    }
    
    @Override
    public void setPosition(int i, int j){
        super.setPosition(i,j);
        
        if(firstMove == null)
            firstMove = true;
        
        else if(firstMove == true)
            firstMove = false;
    }
    
}
