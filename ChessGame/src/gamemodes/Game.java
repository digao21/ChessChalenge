/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemodes;

import web.WebControl;
import graphics.GameWindow;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Closeable;
import java.io.IOException;
import pieces.Board;
import utilites.ImgPosition;

/**
 *
 * @author MauroSérgio
 */
public abstract class Game extends MouseAdapter implements Runnable, Closeable{
    
    private int id;    
    private GameControlI control;
    private WebControl web;
    private Thread thread;
    private GameWindow window;
    protected boolean online = true;
    private boolean running = true;
    protected Board board = null;
    
    //--------------------------------------------------------------------------
    //CONTRUCTOR
    public Game(GameControlI control) throws IOException{
        if(control == null)
            throw new NullPointerException();
        this.control = control;
        
        window = new GameWindow();        
        window.addMouseListener(this);
        
        initializeBoard();
        if(board == null)
            throw new NullPointerException("Board cant be null - Wasnt initialied correct");
        window.setBoard(board);
        
        initializeParameters();
    }    
    
    //--------------------------------------------------------------------------
    //SERVER CONNECTION
    private void startServConnection(){
        try{
            web = new WebControl();
            web.sendMsgWithFlag(getName());
            firstServConnection();
            //id = Integer.parseInt(web.readMsg()); - NOT IMPLEMENTED
        }catch(IOException e){
            connectionProblem(e);
        }
    }                            

    @Override
    public void run() {
        String in;
        while(true){            
            in = readMsgFromServ();
            if(in != null){
                servMsgAct(in);
                if(running)
                    window.update();
            }
        }
    }

    protected final void sendMsgToServ(String msg){
        try{
            web.sendMsg(msg);
        }catch(IOException e){
            connectionProblem(e);
        }
    }
        
    protected final String readMsgFromServ(){
        try{
            return web.readMsg();
        }catch(IOException e){
            connectionProblem(e);
        }
        return null;
    }
    
    private void connectionProblem(IOException e){
        System.err.println("Connection Problem");
        System.err.println(e.toString());
        throw new UnsupportedOperationException();
    }
    
    //--------------------------------------------------------------------------
    //CLICK EVENT
    @Override
    public void mouseClicked(MouseEvent e){        
        if(clickTest(e)){
            int i = getI(e.getY());
            int j = getJ(e.getX());
            clickAct(i,j);
            if(running)
                window.update();                        
        }
    }
        
    protected boolean clickTest(MouseEvent e){        
        ImgPosition imgPos = board.getImgPos();
        Image img = board.getImage();
        
        if(e.getY() > imgPos.getI() && e.getY() < imgPos.getI() + img.getHeight(null)){
            if(e.getX() > imgPos.getJ() && e.getX() < imgPos.getJ() + img.getWidth(null)){
                return true;
            }
        }
        
        return false;
    }    
        
    protected int getI(int y){
        ImgPosition imgPos = board.getImgPos();
        Image img = board.getImage();
        
        return (y - imgPos.getI())/(img.getHeight(null)/8) +1;
    }        
    protected int getJ(int x){
        ImgPosition imgPos = board.getImgPos();
        Image img = board.getImage();
        
        return (x - imgPos.getJ())/(img.getWidth(null)/8) +1;
    }
    
    //--------------------------------------------------------------------------
    //START GAME
    public void play(){
        if(online){
            startServConnection();

            thread = new Thread(this);
            thread.start();
        }
        
        window.setVisible(true);
    }
    
    //--------------------------------------------------------------------------
    //CLOSE
    @Override
    public void close(){
        try{
            thread.stop();//UNSAFE - FIND A BETTER SOLUTION
            web.close();
        }catch(IOException e){
            System.err.println("Error in the close method");
            System.err.println(e.toString());
        }
    }
    
    //--------------------------------------------------------------------------
    //FINISH GAME
    // NOT WORKING
    protected void finish(){        
        System.out.println("finish");//MAKE SOMETHING BETTER

        running = false;

        window.setVisible(false);
        window.dispose();

        control.gameIsOver();
        
        close();
    }
    
    //--------------------------------------------------------------------------
    //ABSTRACT METHODS    
    public abstract String getName();        
    protected abstract void servMsgAct(String msg);    
    protected abstract void clickAct(int i, int j);
    protected abstract void initializeBoard();
    protected abstract void initializeParameters();
    protected abstract void firstServConnection();    
}
