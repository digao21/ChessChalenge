/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import pieces.*;


/**
 *
 * @author Rodrigo
 */
public abstract class ImgAdm {
    
    private static boolean startFail; 
    private final static HashMap<Character,Image> imgHs = new HashMap<>();
    private final static HashMap<Character,String> fldHs = new HashMap<>();
    
    public static void start() throws IOException{
        startFail = false;
        
        setBishop();
        setKing();
        setKnight();
        setPawn();
        setQueen();
        setRook();
        setBoard();
        setSqrMark();
        
        if(startFail)
            throw new IOException("Start ImgAdm fail");
    }
    
    public static Image getImage(char key){
        return imgHs.get(key);
    }
    
    public static void setFolder(char key, String fld){
        fldHs.put(key, fld);
    }
    
    private static void setBishop(){
        
        String imgUrl = null;
        
        try{            
            if(fldHs.containsKey(Bishop.getBlackId()))
                imgUrl = fldHs.get(Bishop.getBlackId());
            else
            imgUrl = "imagem//BishopBlack.png";

            imgHs.put(Bishop.getBlackId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Bishop image at url: ".concat(imgUrl));            
            startFail = true;
        }
        
        try{
            if(fldHs.containsKey(Bishop.getWhiteId()))
                imgUrl = fldHs.get(Bishop.getWhiteId());
            else
                imgUrl = "imagem//BishopWhite.png";

            imgHs.put(Bishop.getWhiteId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Bishop image at url: ".concat(imgUrl));            
            startFail = true;
        }
    }    
    private static void setKing() throws IOException{
        
        String imgUrl = null;
        
        try{
            if(fldHs.containsKey(King.getBlackId()))
                imgUrl = fldHs.get(King.getBlackId());
            else
                imgUrl = "imagem//KingBlack.png";
        
            imgHs.put(King.getBlackId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read King image at url: ".concat(imgUrl));            
            startFail = true;
        }
        
        try{
            if(fldHs.containsKey(King.getWhiteId()))
                imgUrl = fldHs.get(King.getWhiteId());
            else
                imgUrl = "imagem//KingWhite.png";

            imgHs.put(King.getWhiteId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read King image at url: ".concat(imgUrl));            
            startFail = true;
        }
    }    
    private static void setKnight() throws IOException{
        
        String imgUrl = null;
        
        try{
            if(fldHs.containsKey(Knight.getBlackId()))
                imgUrl = fldHs.get(Knight.getBlackId());
            else
                imgUrl = "imagem//KnightBlack.png";

            imgHs.put(Knight.getBlackId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Knight image at url: ".concat(imgUrl));            
            startFail = true;
        }
        
        try{
            if(fldHs.containsKey(Knight.getWhiteId()))
                imgUrl = fldHs.get(Knight.getWhiteId());
            else
                imgUrl = "imagem//KnightWhite.png";

            imgHs.put(Knight.getWhiteId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Knight image at url: ".concat(imgUrl));            
            startFail = true;
        }
    }    
    private static void setPawn() throws IOException{
        
        String imgUrl = null;
        
        try{
            if(fldHs.containsKey(Pawn.getBlackId()))
                imgUrl = fldHs.get(Pawn.getBlackId());
            else
                imgUrl = "imagem//PawnBlack.png";

            imgHs.put(Pawn.getBlackId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Pawn image at url: ".concat(imgUrl));            
            startFail = true;
        }
        
        try{
            if(fldHs.containsKey(Pawn.getWhiteId()))
                imgUrl = fldHs.get(Pawn.getWhiteId());
            else
                imgUrl = "imagem//PawnWhite.png";

            imgHs.put(Pawn.getWhiteId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Pawn image at url: ".concat(imgUrl));            
            startFail = true;
        }
    }    
    private static void setQueen() throws IOException{
        
        String imgUrl = null;
        
        try{
            if(fldHs.containsKey(Queen.getBlackId()))
                imgUrl = fldHs.get(Queen.getBlackId());
            else
                imgUrl = "imagem//QueenBlack.png";

            imgHs.put(Queen.getBlackId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Queen image at url: ".concat(imgUrl));            
            startFail = true;
        }
        
        try{            
            if(fldHs.containsKey(Queen.getWhiteId()))
                imgUrl = fldHs.get(Queen.getWhiteId());
            else
                imgUrl = "imagem//QueenWhite.png";

            imgHs.put(Queen.getWhiteId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Queen image at url: ".concat(imgUrl));            
            startFail = true;
        }
    }    
    private static void setRook() throws IOException{
        
        String imgUrl=null;
        
        try{
            if(fldHs.containsKey(Rook.getBlackId()))
                imgUrl = fldHs.get(Rook.getBlackId());
            else
                imgUrl = "imagem//RookBlack.png";

            imgHs.put(Rook.getBlackId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Rook image at url: ".concat(imgUrl));            
            startFail = true;
        }
        
        try{    
            if(fldHs.containsKey(Rook.getWhiteId()))
                imgUrl = fldHs.get(Rook.getWhiteId());
            else
                imgUrl = "imagem//RookWhite.png";

            imgHs.put(Rook.getWhiteId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Rook image at url: ".concat(imgUrl));            
            startFail = true;
        }
    }
    
    private static void setBoard() throws IOException{
        String imgUrl=null;
        try{
            if(fldHs.containsKey(Board.getId()))
                imgUrl = fldHs.get(Board.getId());
            else
                imgUrl = "imagem//Board.png";

            imgHs.put(Board.getId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read Board image at url: ".concat(imgUrl));            
            startFail = true;
        }
    }
    
    private static void setSqrMark() throws IOException{
        String imgUrl = null;
        try{
            if(fldHs.containsKey(SquareMark.getId()))
                imgUrl = fldHs.get(SquareMark.getId());
            else
                imgUrl = "imagem//SelectSquare.png";

            imgHs.put(SquareMark.getId(), ImageIO.read(new File(imgUrl)));
        
        }catch(IOException e){
            System.err.println("Can't read SqrMark image at url: ".concat(imgUrl));            
            startFail = true;
        }
    }
    
}
