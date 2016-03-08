/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemodes;

import java.io.IOException;
import pieces.Board;
import pieces.ChessPiece;
import pieces.PieceColor;
import pieces.PieceType;
import utilites.GamePosition;

/**
 *
 * @author Usuario
 */
public class HPGame extends Game {

    private int whiteHP;
    private int blackHP;
    private PieceColor turnColor;
    private PieceColor myColor;
    private boolean running;
    private boolean isPieceSelected;
    private ChessPiece selectedPiece;        
    private String serverMsg;
    
    public HPGame(GameControlI control) throws IOException { super(control);}

    @Override
    public String getName() {
        return "hpGame";
    }

    @Override
    protected void servMsgAct(String msg) {        

        int i1,j1,i2,j2;
        i1 = msg.charAt(0) - '0';
        j1 = msg.charAt(1) - '0';
        i2 = msg.charAt(2) - '0';
        j2 = msg.charAt(3) - '0';
        
        kill(i2, j2);

        board.moveTo(i1,j1, i2, j2);        

        changeTurn();

        if(whiteHP < 1 || blackHP < 1){
            sendMsgToServ("finish");
            finish();
        }
    }    
    
    @Override
    protected void clickAct(int i, int j) {
        if(turnColor == myColor){
            if(isPieceSelected){

                if(board.isMarked(i, j)){                   
                   
                   GamePosition pos = selectedPiece.getPosition();
                   int aux = pos.getI()*1000 + pos.getJ()*100 + i*10 + j;
                   serverMsg = Integer.toString(aux);               
                   sendMsgToServ(serverMsg);
                                                         
                   kill(i, j);                   
                           
                   board.moveTo(selectedPiece, i, j);   
                   board.clean();
                   changeTurn();
                   
                   if(whiteHP < 1 || blackHP < 1)
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
    protected void initializeParameters() {        
        whiteHP = 10;
        blackHP = 10;
        turnColor = PieceColor.white;              
        isPieceSelected = false;       
        selectedPiece = null;       
        running = true;       
        //online = false;//temporarily
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
    
    //Aux func------------------------------------------------------------------
    private void changeTurn(){
        if(turnColor.equals(PieceColor.white))        
            turnColor = PieceColor.black;        
        else        
            turnColor = PieceColor.white;        
    }      
    
    private void kill(int i, int j){
        if(board.isOccupie(i, j)){
            int cost = 0;
            
            PieceType pc = board.getPieceType(i, j);
            
            switch(pc){
                case bishop: 
                    cost = 3;
                    break;
                case king:
                    cost = 10;
                    break;
                case knight:
                    cost = 2;
                    break;
                case pawn:
                    cost = 1;
                    break;
                case queen:
                    cost = 5;
                    break;
                case rook:
                    cost = 3;
                    break;
            }
            
            if(turnColor.equals(PieceColor.white))
                whiteHP -= cost;
            else
                blackHP -= cost;
        }
    }
    
}
