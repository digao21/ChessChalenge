/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;
import graphics.DrawableObjectInterface;
import graphics.ImgAdm;
import java.awt.Image;
import java.util.concurrent.ConcurrentLinkedQueue;
import utilites.GamePosition;
import utilites.ImgPosition;
/**
 *
 * @author MauroSérgio
 */
public class Board implements DrawableObjectInterface
{

    //Graphics        
    private ImgPosition imgPos;    
    private ConcurrentLinkedQueue<DrawableObjectInterface> myList;
    
    //Board variables
    private BoardCell[][] myBoard;    
    
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    
    public Board(){
        initBoard();
        myList = new ConcurrentLinkedQueue<>();
        myList.add(this);
        imgPos = new ImgPosition(50,50);
    }        
    
    public Board(char[][] description){
        
        initBoard();
        myList = new ConcurrentLinkedQueue<DrawableObjectInterface>();
        myList.add(this);
        imgPos = new ImgPosition(50,50);
        
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                if(ChessPiece.isPieceId(description[i][j])){
                    ChessPiece aux = ChessPiece.getPieceById(description[i][j]);
                    aux.setBoard(this);
                    aux.setPosition(new GamePosition(i,j));                        
                    myBoard[i][j].setChessPiece(aux);
                }
            }
        }
    }        
        
    private void initBoard(){
        myBoard = new BoardCell[10][10];
        
        for(int i = 0; i < 10 ; i++)
        {
            myBoard[0][i] = new BoardCell(this,0,i,true);
            myBoard[9][i] = new BoardCell(this,9,i,true);
            myBoard[i][0] = new BoardCell(this,i,0,true);
            myBoard[i][9] = new BoardCell(this,i,9,true);
        }

        for(int i = 1; i <= 8 ; i++)
        {
            for(int j = 1; j <= 8 ; j++)
            {
                myBoard[i][j] = new BoardCell(this,i,j,false);
            }
        }
    }
    
    //--------------------------------------------------------------------------
    //ID
    
    public static char getId(){
        return 'M';
    }
    
    public char[][] getDescription(){
        
        char[][] description = new char[10][10];
        
        for(int i = 0; i < 10 ; i++){
            for(int j = 0; j < 10; j++){
                description[i][j] = myBoard[i][j].getCellId();
            }
        }
        
        return description;
    }     
    
    //--------------------------------------------------------------------------
    //GRAPHICS                                
        
    @Override
    public Image getImage() {
        return ImgAdm.getImage(getId());
    }
    
    @Override
    public ImgPosition getImgPos(){
        return imgPos;
    }        
    
    public void eraseFromDrawList(DrawableObjectInterface obj) {
        myList.remove(obj);
    }

    public void addToDrawList(DrawableObjectInterface obj) {
        myList.add(obj);
    }
    
    public ConcurrentLinkedQueue<DrawableObjectInterface> getDrawList(){
        return myList;
    }
    
    //--------------------------------------------------------------------------
    //GAME METHODS
        
    public void moveTo(ChessPiece piece, int i, int j){        
        boardTest(i,j);
        
        GamePosition pos = piece.getPosition();
        
        myBoard[pos.getI()][pos.getJ()].setOutChessPiece();
        if(myBoard[i][j].isOccupie())
            myBoard[i][j].delet();
        myBoard[i][j].setChessPiece(piece);
        piece.setPosition(i,j);        
    }
    
    //Move to i2/j2
    public void moveTo(int i, int j, int i2, int j2){        
        boardTest(i,j);
        boardTest(i2,j2);
        
        ChessPiece aux = myBoard[i][j].setOutChessPiece();
        if(myBoard[i2][j2].isOccupie())
            myBoard[i2][j2].delet();
        myBoard[i2][j2].setChessPiece(aux);
        aux.setPosition(i2,j2);                
    }
    
    public boolean canMoveTo(int i, int j, int i2, int j2){
        boolean answ = false;
        if(myBoard[i][j].isOccupie()){
            ChessPiece bp = myBoard[i][j].getChessPiece();
            answ = bp.canMoveTo(i2, j2);
        }
        return answ;
    }
        
    public ChessPiece selectPiece(int i, int j){
        boardTest(i,j);
        
        ChessPiece aux = myBoard[i][j].getChessPiece();        
        aux.selectPiece();
        
        return aux;
    }
        
    public void unMark(int i, int j){
        boardTest(i,j);
        myBoard[i][j].unMarkCell();
    }
    
    
    public void mark(int i, int j){
        boardTest(i,j);
        myBoard[i][j].markCell();
    }
        
    public boolean isKing(int i, int j){
        boolean answ = false;
        
        PieceType p = null;
        if(myBoard[i][j].isOccupie())
            p = myBoard[i][j].getPieceType();
        
        if(p!=null&&p.equals(PieceType.king))
            answ = true;
        
        return answ;
    }
    
    public boolean isOccupie(int i, int j){
        boardTest(i,j);
        return myBoard[i][j].isOccupie();
    }
    
    
    public boolean isMarked(int i, int j){
        boardTest(i,j);
        return myBoard[i][j].isMarked();
    }
        
    public boolean isEdge(int i, int j){
        boardTest(i,j);
        return myBoard[i][j].isEdge();
    }
       
    public PieceColor getPieceColor(int i, int j){
        boardTest(i,j);
        return myBoard[i][j].getPieceColor();
    }
        
    public PieceType getPieceType(int i, int j){
        boardTest(i,j);
        return myBoard[i][j].getPieceType();
    }        
    
    private void boardTest(int i, int j){
        if(i < 0 || i > 9)
            throw new IllegalArgumentException("Board position out of bound");
        if(j < 0 || j > 9)
            throw new IllegalArgumentException("Board position out of bound");
    }
        
    public void clean()
    {
        for(int i = 1; i<=8 ; i++)
        {
            for(int j = 1; j<=8 ; j++)
            {
                if(myBoard[i][j].isMarked())
                {
                   myBoard[i][j].unMarkCell();
                }
            }
        }        
    }    
    
}
