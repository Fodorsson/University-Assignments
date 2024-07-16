package snack;

import javax.swing.JFrame;
import java.util.ArrayList;

public class Pathfinding extends JFrame {
    
    static int startX;
    static int startY;
    static int goalX;
    static int goalY;
    
    static boolean[][] field;
    static boolean[][] checked;
    
    static ArrayList<Integer> xList;
    static ArrayList<Integer> yList;
    static ArrayList<Integer> hCostList;
    
    static ArrayList<Integer> parentXList;
    static ArrayList<Integer> parentYList;
    
    static int steps;
    
    static int minInd;
    
    static boolean finished;
    
    
    
    public static String FindPath(boolean[][] fld, int sX, int sY, int gX, int gY){
        
        steps=0;
        minInd=0;
        finished = false;
        
        xList = new ArrayList<Integer>();
        yList = new ArrayList<Integer>();
        hCostList = new ArrayList<Integer>();
    
        parentXList = new ArrayList<Integer>();
        parentYList = new ArrayList<Integer>();
        
        startX = sX;
        startY = sY;
        goalX = gX;
        goalY = gY;
        
        field = fld;
        
        checked = new boolean[fld.length][fld[0].length];
        
        xList.add(startX);
        yList.add(startY);
        int hCost = Dist(goalX, goalY, startX, startY);
        hCostList.add(hCost);
        
        minInd = 0;
        
        while(!finished && steps<field.length*field[0].length){
            GetNeighbours(xList.get(minInd),yList.get(minInd));
            FindLowest();
            
            
        }
        
    //    System.out.println("fields:");
        
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
        
        if (xList!=null && !xList.isEmpty()){
        xList.remove(0);
        yList.remove(0);
        hCostList.remove(0);
        }
        
        
        for (int i = xList.size()-2; i >= 0; i--) {
            
            
            if (Dist(xList.get(i), yList.get(i), xList.get(i+1), yList.get(i+1)) >1 ){
                xList.remove(i);
                yList.remove(i);
                hCostList.remove(i);
            }
            
            
        }
        
        
     //   System.out.println(xList.size());
        
        if (xList.isEmpty()){}
     //       System.out.println("NO ROUTE");
        else{
        
            for (int i = 0; i < xList.size(); i++) {
    //            System.out.println(xList.get(i)+", "+yList.get(i));
            
            }
        }
        ////////////////////////////////////
        
        if (!xList.isEmpty()){
            
            if (xList.get(0) == startX && yList.get(0) == startY + 1)
                return "up";
            else if (xList.get(0) == startX && yList.get(0) == startY - 1)
                return "down";
            else if (xList.get(0) == startX + 1 && yList.get(0) == startY)
                return "right";
            else if (xList.get(0) == startX - 1 && yList.get(0) == startY)
                return "left";
            else return "stuck";
            
        }
        else return "stuck";
    
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
    
}

