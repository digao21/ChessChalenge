/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemodes;

import java.io.IOException;
import pieces.*;
import utilites.GamePosition;

/**
 *
 * @author MauroSérgio
 */
public class NormalGameMode extends Game
{    
    private PieceColor turnColor;
    private PieceColor myColor;
    private boolean running;
    private boolean isPieceSelected;
    private ChessPiece selectedPiece;        
    private String serverMsg;
    
    public NormalGameMode(GameControlI control) throws IOException {super(control);}

    @Override
    public String getName(){
        return "normalGame";
    }
                
    //--------------------------------------------------------------------------
    //Enemy turn
    @Override
    public void servMsgAct(String msg){
        
        boolean kingIsDead = false;
        PieceType c = null;

        int i1,j1,i2,j2;
        i1 = msg.charAt(0) - '0';
        j1 = msg.charAt(1) - '0';
        i2 = msg.charAt(2) - '0';
        j2 = msg.charAt(3) - '0';
        
        kingIsDead = board.isKing(i2, j2);

        board.moveTo(i1,j1, i2, j2);        

        changeTurn();

        if(kingIsDead){
            sendMsgToServ("finish");
            finish();
        }
    }        
    
    //Aux func------------------------------------------------------------------
    private void changeTurn(){
        if(turnColor.equals(PieceColor.white))        
            turnColor = PieceColor.black;        
        else        
            turnColor = PieceColor.white;        
    }   
    
    @Override
    public void clickAct(int i, int j) {
        if(turnColor == myColor){
            if(isPieceSelected){

                if(board.isMarked(i, j)){
                   boolean isKingDead = false;
                   PieceType c = null;
                   
                   GamePosition pos = selectedPiece.getPosition();
                   int aux = pos.getI()*1000 + pos.getJ()*100 + i*10 + j;
                   serverMsg = Integer.toString(aux);               
                   sendMsgToServ(serverMsg);
                                                         
                   isKingDead = board.isKing(i, j);                   
                           
                   board.moveTo(selectedPiece, i, j);   
                   board.clean();
                   changeTurn();
                   
                   if(isKingDead)
                       finish();
                   
                }
                else{
                    board.clean();                
                }

                isPieceSelected = false;
                selectedPiece = null;            
            }
            else{            
                if(board.isOccupie(i, j) && board.getPieceColor(i, j) == turnColor){

                    isPieceSelected = true;
                    selectedPiece = board.selectPiece(i, j);                
                }
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
    protected void firstServConnection() {
        serverMsg = readMsgFromServ();
        if(serverMsg.equals("white")){        
            myColor = PieceColor.white;
            System.out.println("Im white");
        }
        else{        
            myColor = PieceColor.black;
            System.out.println("Im black");
        }
    }

    @Override
    protected void initializeParameters() {
       turnColor = PieceColor.white;
       isPieceSelected = false;
       selectedPiece = null;
       running = true;
       //online = false;//temporarily
    }
    
}
