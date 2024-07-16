package pathfinding;

import java.util.Random;
import static pathfinding.Pathfinding.FindPath;


public class Main {
    
    
    
    static int startX = 2;
    static int startY = 1;
    static int goalX = 5;
    static int goalY = 8;
    static boolean[][] field = new boolean[16][16];
    static Random rand = new Random();
    
    public static void main(String[] args) {
        
        
        
        GenerateMap();
        FindPath(field, startX, startY, goalX, goalY);
    }
    
    public static void GenerateMap(){
        
        for (int i = 0; i < field.length; i++) {
            
            for (int j = 0; j < field[0].length; j++) {
                
                if (j%2 == 1 && i%2 == 1){
                    field[i][j] = true;
                }
                else{
                    field[i][j] = false;
                }
                
            }
            
        }
        
        
        for (int j = 0; j < field[0].length; j++) {
            int isOccupied = rand.nextInt(6) * 2;
            
            if (isOccupied == 0 && j == 0)
                isOccupied += 2;
            else if (isOccupied == field.length-1 && j == field[0].length-1)
                isOccupied -= 2;
            
            field[isOccupied][j] = true;
            
        }
        
        field[0][0] = false;
        field[field.length-1][field[0].length-1] = false;
        
    }
    
}
