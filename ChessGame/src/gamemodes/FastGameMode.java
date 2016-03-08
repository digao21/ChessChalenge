/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemodes;

import pieces.*;
import java.io.IOException;
import utilites.GamePosition;

/**
 *
 * @author MauroSérgio
 */
public class FastGameMode extends Game 
{
    
    private PieceColor myColor;    
    private boolean isPieceSelected;
    private ChessPiece selectedPiece;        
    private String serverMsg;
    
    public FastGameMode(GameControlI control) throws IOException{super(control);}                

    @Override
    public String getName(){
        return "fastGame";
    }               
    
    //Enemy turn----------------------------------------------------------------
    @Override
    public void servMsgAct(String msg){
        
        boolean isKingDead = false;
        
        int i1,j1,i2,j2;
        i1 = msg.charAt(0) - '0';
        j1 = msg.charAt(1) - '0';
        i2 = msg.charAt(2) - '0';
        j2 = msg.charAt(3) - '0';
        
        
        isKingDead = board.isKing(i2, j2);
        
        board.moveTo(i1,j1, i2, j2);        
        board.clean();        
        
        isPieceSelected = false;
        selectedPiece = null;    
        
        if(isKingDead)
            finish();
    }        

    @Override
    public void clickAct(int i, int j) {
        
        if(isPieceSelected){
            if(board.isMarked(i,j)){
                
               GamePosition pos = selectedPiece.getPosition();
               int aux = pos.getI()*1000 + pos.getJ()*100 + i*10 + j;
               serverMsg = Integer.toString(aux);                              
               sendMsgToServ(serverMsg);  
               
            }
            else{                
                board.clean();                
                isPieceSelected = false;
                selectedPiece = null;
            }                        
        }
        else{                        
            if(board.isOccupie(i,j) && board.getPieceColor(i, j) == myColor){                
                isPieceSelected = true;
                selectedPiece = board.selectPiece(i, j);                                
            }
        }
        
    }

    @Override
    protected void initializeBoard() {
        board = new Board(new char[][]{
            {'/','/','/','/','/','/','/','/','/','/'},
            {'/','R','N','B','K','Q','B','N','R','/'},
            {'/','P','P','P','P','P','P','P','P','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','O','O','O','O','O','O','O','O','/'},
            {'/','p','p','p','p','p','p','p','p','/'},
            {'/','r','n','b','k','q','b','n','r','/'},
            {'/','/','/','/','/','/','/','/','/','/'},
        });
    }

    @Override
    protected void initializeParameters() {
        isPieceSelected = false;
        selectedPiece = null; 
    }

    @Override
    protected void firstServConnection() {
        serverMsg = readMsgFromServ();
        if(serverMsg.equals("white"))        
            myColor = PieceColor.white;        
        else        
            myColor = PieceColor.black;
    }
    
}
