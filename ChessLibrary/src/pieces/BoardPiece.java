/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;


import graphics.DrawableObjectInterface;
import java.awt.Image;
import utilites.GamePosition;
import utilites.ImgPosition;

/**
 *
 * @author MauroSérgio
 */
public abstract class BoardPiece implements DrawableObjectInterface
{
    //Graphics
    protected Image image;
    private ImgPosition imgPos;            
    private ImgPosition imgZero;    
    private int desI, desJ;    
    
    //Game
    protected Board board;    
    protected GamePosition pos;
    
    //--------------------------------------------------------------------------
    //Constructors
    
    private void init(){
        image = null;
        imgPos = null;
        imgZero = null;
        pos = new GamePosition();
    }        
    
    public BoardPiece(Board board, GamePosition pos){
        init();
        setBoard(board);
        setPosition(pos);
    }
    
    public BoardPiece(Board board, int i, int j){
        init();
        setBoard(board);
        setPosition(i,j);
    }      

    //--------------------------------------------------------------------------
    //GAME
        
    abstract public char delet();    
    
    public void setPosition(int i, int j){
        pos.setI(i);
        pos.setJ(j);
        
        
        if(imgZero != null){
            imgPos.setI(imgZero.getI() + desI*(pos.getI() - 1));
            imgPos.setJ(imgZero.getJ() + desJ*(pos.getJ() - 1));
        }
        
    }
        
    public void setPosition(GamePosition pos){
        this.pos.setI(pos.getI());
        this.pos.setJ(pos.getJ());
        
        if(imgZero != null){
            imgPos.setI(imgZero.getI() + desI*(pos.getI() - 1));
            imgPos.setJ(imgZero.getJ() + desJ*(pos.getJ() - 1));
        }
    }
    
    
    public final GamePosition getPosition(){
        return pos.copy();
    }
                
    public final void setBoard(Board board){        
        this.board = board;        
        if(board != null)
            board.addToDrawList(this);
    }
        
    public final Board getBoard(){
        return board;
    }
    
    //--------------------------------------------------------------------------
    //GRAPHICS               
            
    @Override
    public final ImgPosition getImgPos(){
        
        if(imgZero == null)
            setImgFields();                
        
        return imgPos;
    }

    private void setImgFields(){
        
        imgPos = new ImgPosition();
        imgZero = board.getImgPos();
        desI = board.getImage().getHeight(null)/8;
        desJ = board.getImage().getWidth(null)/8;                
        
        imgPos.setI(imgZero.getI() + desI*(pos.getI() - 1));
        imgPos.setJ(imgZero.getJ() + desJ*(pos.getJ() - 1));
    }
            
}
