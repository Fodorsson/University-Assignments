package tetris;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Display extends JFrame implements ActionListener{
    
    Timer timer;
    Timer timer2;
    boolean rotPressed;
    static int speed = 750;
    
    public Display(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension (290, 424));
        
        this.setResizable(false);
        
        this.setVisible(true);
        
        timer = new Timer(200, this);
        timer.start();
        
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped (KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_UP && !rotPressed){
                    boolean moveAllowed = true;
        
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (Tetris.shape[Tetris.currentShape][GetIncrement(Tetris.currentRot)][i][j] && Tetris.filled[Tetris.posX + i][Tetris.posY + j])
                                moveAllowed = false;
                        }
            
                    }
        
                    if (moveAllowed){
                        rotPressed = true;
                        Tetris.currentRot = GetIncrement(Tetris.currentRot);
                    }
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    timer2.setDelay(speed/15);
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    
                    boolean moveAllowed = true;
        
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (Tetris.shape[Tetris.currentShape][Tetris.currentRot][i][j] && Tetris.filled[Tetris.posX + i - 1][Tetris.posY + j])
                                moveAllowed = false;
                        }
            
                    }
        
                    if (moveAllowed){
                        Tetris.posX--;
                        repaint();
                    }
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    
                    boolean moveAllowed = true;
        
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (Tetris.shape[Tetris.currentShape][Tetris.currentRot][i][j] && Tetris.filled[Tetris.posX + i + 1][Tetris.posY + j])
                                moveAllowed = false;
                        }
            
                    }
                    
                    
        
                    if (moveAllowed){
                        Tetris.posX++;
                        repaint();
                    }
                }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    timer2.setDelay(speed);
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP){
                    rotPressed = false;
                }
                
            }
            
        });
        
        timer2 = new Timer(750, this);
        timer2.start();
        timer2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
        
            boolean moveAllowed = true;
        
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Tetris.shape[Tetris.currentShape][Tetris.currentRot][i][j] && Tetris.filled[Tetris.posX + i][Tetris.posY + j + 1])
                        moveAllowed = false;
                
                }
            
            }
        
            if (moveAllowed)
                Tetris.posY++;
            else{
                //burn shape into background
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (Tetris.shape[Tetris.currentShape][Tetris.currentRot][i][j])
                            Tetris.filled[Tetris.posX + i][Tetris.posY + j] = Tetris.shape[Tetris.currentShape][Tetris.currentRot][i][j];
                
                    }
            
                }
                Tetris.score+=10;
                speed = 750 - Tetris.score/100;
                //check for complete line
                
                boolean lineComplete = true;
                
                checkFullRow();
                
                //create new shape
                Tetris.CreateShape();
            }
        
            repaint();
            }
            
            
        });
        
    }
    
    public void checkFullRow(){
        
        int inARow = 0;
        
        for (int j = 21; j > 0; j--) {
                    inARow = 0;
                    for (int i = 1; i < 11; i++) {
                        
                        if (Tetris.filled[i][j]){
                            inARow++;
                        }
                        
                        if (inARow == 10){
                            
                            Tetris.score+=100;
                            
                            for (int k = j; k > 0; k--) {
                                for (int l = 1; l <11; l++) {
                                    Tetris.filled[l][k] = Tetris.filled[l][k-1]; 
                                }
                        
                            }
                            
                            checkFullRow();
                            
                            
                        }
                        
                    }
                    
                }
    
    }
    
    public int GetIncrement(int val){
        
        if (val==3)
            return 0;
        else
            return val+1;
    }

    public void paint(Graphics g){
        this.paintComponents(g);
        
        int dx = -18;
        int dy = -18;
        
        for (int row = 0; row < Tetris.filled[0].length-1; row++) {
            for (int col = 0; col < Tetris.filled.length-2; col++) {
                
               if (Tetris.filled[col][row] ){
                   g.setColor(Color.black);
                   g.fillRect(dx, dy, 19, 19);
               }
               else{
                   g.setColor(new Color(135, 147, 114));
                   g.fillRect(dx, dy, 19, 19);
               }
               
               dx+=20;
                
                
            }
            dy+=20;
            dx = -18;
            
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                
                if (Tetris.shape[Tetris.currentShape][Tetris.currentRot][i][j] ){
                   g.setColor(Color.black);
                   g.fillRect((Tetris.posX+i)*20-18, (Tetris.posY+j)*20-18, 19, 19);
               }
                
                
            }
            
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                
                if (Tetris.shape[Tetris.nextShape][0][i][j] ){
                   g.setColor(Color.black);
                   g.fillRect((12+i)*10+110, (10+j)*10+68, 9, 9);
               }
                
                
            }
            
        }
        
        g.setColor(Color.black);
        g.drawString("Score:", 230, 130);
        g.drawString(""+Tetris.score, 230, 150);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
}
