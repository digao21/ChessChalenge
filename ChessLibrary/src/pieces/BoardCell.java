/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

/**
 *
 * @author MauroSérgio
 */
public class BoardCell 
{
    //Position
    private final int posI,posJ;
    
    //Cell information
    private boolean occupied;
    private boolean isMarked;    
    private final boolean boardEdge;
    
    //Game information
    private final Board myBoard;
    private SquareMark myMark;
    private ChessPiece myChessPiece;
    
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    
    public BoardCell(Board myBoard, int posI,int posJ, boolean boardEdge)
    {
        this.myBoard = myBoard;
        this.posI = posI;
        this.posJ = posJ;
        this.boardEdge = boardEdge;
        this.occupied = false;
        this.isMarked = false;
        this.myChessPiece = null;
        this.myMark = null;
    }    
    
    //--------------------------------------------------------------------------
    //GAME METHODS
        
    public boolean isOccupie(){
        return occupied;
    }
    
    public boolean isEdge(){
        return boardEdge;
    }
        
    public boolean isMarked(){
        return isMarked;
    }
    
    public void markCell(){
        if(!isMarked){            
            isMarked = true;
            myMark = new SquareMark(myBoard,posI,posJ);
        }
    }            
        
    public void unMarkCell(){
        isMarked = false;
        myMark.delet();
        myMark = null;
    }
        
    public void setChessPiece(ChessPiece newChezzPiece){
        occupied = true;
        this.myChessPiece = newChezzPiece;
    }
        
    public ChessPiece setOutChessPiece(){
        occupied = false;
        ChessPiece aux = myChessPiece;
        myChessPiece = null;
        return aux;
    }
        
    public char delet(){
        occupied = false;
        ChessPiece aux = myChessPiece;
        myChessPiece = null;
        return aux.delet();
    }
        
    public ChessPiece getChessPiece(){
        return myChessPiece;
    }
        
    public PieceColor getPieceColor(){
        return myChessPiece.getColor();
    }
        
    public PieceType getPieceType(){
        return myChessPiece.getType();
    }
        
    public char getCellId(){
        
        if(boardEdge)
            return '/';
        
        if(isMarked)
            return SquareMark.getId();
        
        if(!occupied)
            return 'O';
        
        return myChessPiece.getId();
        
    }

}
