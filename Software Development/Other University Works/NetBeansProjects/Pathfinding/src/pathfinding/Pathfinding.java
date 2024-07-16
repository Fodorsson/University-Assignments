package pathfinding;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class Pathfinding extends JFrame {
    
    static int startX = 1;
    static int startY = 1;
    static int goalX = 5;
    static int goalY = 8;
    
    static boolean[][] field;
    static boolean[][] checked;
    
    static ArrayList<Integer> xList = new ArrayList<Integer>();
    static ArrayList<Integer> yList = new ArrayList<Integer>();
    static ArrayList<Integer> hCostList = new ArrayList<Integer>();
    
    static ArrayList<Integer> parentXList = new ArrayList<Integer>();
    static ArrayList<Integer> parentYList = new ArrayList<Integer>();
    
    static int steps = 0;
    
    static int minInd = 0;
    
    static boolean finished;
    
    public Pathfinding(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension (825, 675));
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public static void FindPath(boolean[][] fld, int sX, int sY, int gX, int gY){
        
        startX = sX;
        startY = sY;
        goalX = gX;
        goalY = gY;
        
        field = fld;
        
        checked = new boolean[fld.length][fld[0].length];
        
        new Pathfinding();
        
        xList.add(startX);
        yList.add(startY);
        int hCost = Dist(goalX, goalY, startX, startY);
        hCostList.add(hCost);
        
        minInd = 0;
        
        while(!finished && steps<field.length*field[0].length){
            GetNeighbours(xList.get(minInd),yList.get(minInd));
            FindLowest();
            
            
        }
        
       // System.out.println("fields:");
        
        ///////////////////////////////////////
        
        for (int i = xList.size()-1; i >= 0; i--) {
            
           
            
            if (xList.get(i) != goalX || yList.get(i) != goalY ){
                xList.remove(i);
                yList.remove(i);
                hCostList.remove(i);
            }
            else
                break;
            
        }
        
        xList.remove(0);
        yList.remove(0);
        hCostList.remove(0);
        
        for (int i = xList.size()-2; i >= 0; i--) {
            
            
            if (Dist(xList.get(i), yList.get(i), xList.get(i+1), yList.get(i+1)) >1 ){
                xList.remove(i);
                yList.remove(i);
                hCostList.remove(i);
            }
            
            
        }
        
        
     //   System.out.println(xList.size());
        
        if (xList.size() == 0){}
    //        System.out.println("NO ROUTE");
        else{
        
            for (int i = 0; i < xList.size(); i++) {
                System.out.println(xList.get(i)+", "+yList.get(i));
            
            }
        }
        ////////////////////////////////////
    
    }
    
    
    
    public static int Dist (int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
    
    public static void GetNeighbours(int x, int y){
        
        steps++;
        
        int parentIndex = 0;
        
        for (int i = 0; i < hCostList.size(); i++) {
            if (xList.get(i) == x && yList.get(i) == y){
                parentIndex = i;
                break;
            }
            
        }
        
        if (y-1>=0 && !field[x][y-1] && !checked[x][y-1]){
            xList.add(x);
            yList.add(y-1);
            int hCost = Dist(goalX, goalY, x, y-1);
            hCost += Dist(goalX, goalY, x, y);
            hCost += hCostList.get(parentIndex);
            hCostList.add(hCost);
            parentXList.add(x);
            parentYList.add(y);
        }
        if (x+1<field.length && !field[x+1][y] && !checked[x+1][y]){
            xList.add(x+1);
            yList.add(y);
            int hCost = Dist(goalX, goalY, x+1, y);
            hCost += hCostList.get(parentIndex);
            hCostList.add(hCost);
            parentXList.add(x);
            parentYList.add(y);
        }
        if (y+1<field[0].length && !field[x][y+1] && !checked[x][y+1]){
            xList.add(x);
            yList.add(y+1);
            int hCost = Dist(goalX, goalY, x, y+1);
            hCost += hCostList.get(parentIndex);
            hCostList.add(hCost);
            parentXList.add(x);
            parentYList.add(y);
        }
        if (x-1>=0 && !field[x-1][y] && !checked[x-1][y]){
            xList.add(x-1);
            yList.add(y);
            int hCost = Dist(goalX, goalY, x-1, y);
            hCost += hCostList.get(parentIndex);
            hCostList.add(hCost);
            parentXList.add(x);
            parentYList.add(y);
        }
        
    }
    
    public static void FindLowest(){
        
        minInd = 0;
        hCostList.set(minInd, 1000);
        
        for (int i = 1; i < hCostList.size(); i++) {
            
            
            if (hCostList.get(i)<hCostList.get(minInd) && !checked[xList.get(i)][yList.get(i)])
                minInd = i;
            
            if (xList.get(i) == goalX && yList.get(i) == goalY)
                finished = true;
                
        }
        
        checked[xList.get(minInd)][yList.get(minInd)] = true;
        
        if (steps==field.length*field[0].length)
            finished = true;
            
        
    }
    
    public void paint(Graphics g){
        this.paintComponents(g);
        
        for (int i = 0; i < field.length; i++) {
            
            for (int j = 0; j < field[0].length; j++) {
                
                if (field[i][j])
                    g.setColor(Color.black);
                else
                    g.setColor(Color.white);
                
                g.fillRect((i)*70 + 30, (j)*70 + 50, 69, 69);
                
            }
            
        }
        
        for (int i = 0; i < xList.size(); i++){
                
            g.setColor(Color.green);
            g.fillRect(xList.get(i)*70 + 30, yList.get(i)*70 + 50, 69, 69);    
            g.setColor(Color.white);
            g.drawString(hCostList.get(i).toString(), xList.get(i)*70 + 55, yList.get(i)*70 + 90);
        }
    }
    
}

