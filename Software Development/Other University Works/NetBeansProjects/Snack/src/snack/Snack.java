package snack;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

import static snack.Pathfinding.FindPath;



public class Snack extends JFrame implements ActionListener{
    
    Timer timer, timer2;
    
    static boolean[][] field = new boolean[16][16];
    
    static int food1x, food1y, food2x, food2y, food3x, food3y = 16;
    
    
    static int snakeLength = 1;
    
    static ArrayList<Integer> snakeXList = new ArrayList<Integer>();
    static ArrayList<Integer> snakeYList = new ArrayList<Integer>();
    
    static boolean food1Empty = true;
    static boolean food2Empty = true;
    
    static boolean frozen = true;
    
    static String lastDir = null;
    
    //195 is the maximum score achievable by the computer
    
    public Snack(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension (645, 667));
        this.setResizable(false);
        this.setVisible(true);
        
        
        
        snakeXList.add(8);
        snakeYList.add(8);
        snakeXList.add(8);
        snakeYList.add(8);
        snakeXList.add(8);
        snakeYList.add(9);
        
        timer = new Timer(200, this);
        timer.start();
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (!frozen){
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    field[i][j] = false;
                }
                
            }
                
                
            for (int i = 0; i < 16; i++) {
                field[i][0] = true;
                field[i][15] = true;
            
            }
            for (int j = 1; j < 15; j++) {
                field[0][j] = true;
                field[15][j] = true;
            
            }
                
                int startX = snakeXList.get(0);
                int startY = snakeYList.get(0);
                int goalX = food1x;
                int goalY = food1y;
                
                for (int i = snakeXList.size()-1; i >0; i--) {
                    field[snakeXList.get(i-1)][snakeYList.get(i-1)] = true;
                    
                    
                }
         
                
                
                   if (startX != goalX || startY != goalY){
                       
                       if (FindPath(field, startX, startY, goalX, goalY) == "left")
                        snakeXList.set(0,snakeXList.get(0)-1);
                    else if (FindPath(field, startX, startY, goalX, goalY) == "right")
                        snakeXList.set(0,snakeXList.get(0)+1);
                    else if (FindPath(field, startX, startY, goalX, goalY) == "up")
                        snakeYList.set(0,snakeYList.get(0)+1);
                    else if (FindPath(field, startX, startY, goalX, goalY) == "down")
                        snakeYList.set(0,snakeYList.get(0)-1);
                       
                       for (int i = snakeXList.size()-1; i >0; i--) {
                    snakeXList.set(i, snakeXList.get(i-1));
                    snakeYList.set(i, snakeYList.get(i-1));
                    
                    field[snakeXList.get(i)][snakeYList.get(i)] = true;
                    
                    
                }
                       
                   }
                if (startX == goalX && startY == goalY){
                    
                    if (food1Empty && food2Empty && frozen == false){
                        frozen = true;
                        System.out.println("give food");
                        snakeXList.add(startX);
                        snakeYList.add(startY);
                        
                        
                        
                    }
                    
                    if (food1Empty && !food2Empty){
                        food1x = food2x;
                        food1y = food2y;
                        food2x = 16;
                        food2y = 16;
                        food1Empty = false;
                        food2Empty = true;
                        
                           
                    snakeXList.add(startX);
                    snakeYList.add(startY);
                        
                    }
                    else{
                        food1Empty = true;
                        
                        
                    }
                    
                    goalX = food1x;
                goalY = food1y;
                    
                
                    
                }
                
                
                
                
                
                    
            }
            }
        });
        
        timer2 = new Timer(100, this);
        timer2.start();
        timer2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                food3x = (MouseInfo.getPointerInfo().getLocation().x-getLocationOnScreen().x-3)/40;
                
                if (food3x<1)
                    food3x = 1;
                else if (food3x>14)
                    food3x = 14;
                
                food3y = (MouseInfo.getPointerInfo().getLocation().y-getLocationOnScreen().y-25)/40;
                
                if (food3y<1)
                    food3y = 1;
                else if (food3y>14)
                    food3y = 14;
                
                //System.out.println(x+", "+y);
        
            repaint();
            }
        
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                frozen = false;
                
                if (food1Empty && food2Empty){
                    food1x = food3x;
                    food1y = food3y;
                    food1Empty = false;
                }
                else if (food3x != food1x || food3y != food1y){
                    food2x = food3x;
                    food2y = food3y;
                    food2Empty = false;
                }
                
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
            
        });
    }
    
    @Override
    public void paint(Graphics g){
        this.paintComponents(g);
        
        for (int i = 0; i < 16; i++) {
            
            for (int j = 0; j < 16; j++) {
                
                if (field[i][j])
                    g.setColor(Color.black);
                else
                    g.setColor(Color.white);
                
                g.fillRect((i)*40 + 3, (j)*40 + 25, 39, 39);
                
            }
            
        }
        
        if (food3x<16 && food3y<16 && food3x>0 && food3y>0){
            g.setColor(Color.gray);
            g.fillRect((food3x)*40 + 3, (food3y)*40 + 25, 39, 39);
        }
        
        if (food1x<16 && food1y<16 && food1x>0 && food1y>0){
            g.setColor(Color.red);
            g.fillRect((food1x)*40 + 3, (food1y)*40 + 25, 39, 39);
        }
        
        if (food2x<16 && food2y<16 && food2x>0 && food2y>0){
            g.setColor(Color.pink);
            g.fillRect((food2x)*40 + 3, (food2y)*40 + 25, 39, 39);
        }
        
        g.setColor(Color.green);
        
        for (int i = 1; i < snakeXList.size(); i++) {
            g.fillRect((snakeXList.get(i))*40 + 3, (snakeYList.get(i))*40 + 25, 39, 39);
            
        }
        
        //
        /*
        ArrayList<Integer> xList = snack.Pathfinding.xList;
        ArrayList<Integer> yList = snack.Pathfinding.yList;
        
        if (xList!=null && !xList.isEmpty()){
        g.setColor(Color.green);
        g.fillRect(xList.get(0)*40 + 3, yList.get(0)*40 + 25, 39, 39);
        for (int i = 0; i < xList.size(); i++){
                
            g.setColor(Color.green);
             g.fillRect(xList.get(i)*40 + 3, yList.get(i)*40 + 25, 39, 39);    
            g.setColor(Color.white);
        }
        }
        */
        //
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    
}
