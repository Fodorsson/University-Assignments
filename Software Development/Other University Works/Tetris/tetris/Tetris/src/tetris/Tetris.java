package tetris;

import java.util.Random; 

public class Tetris {
    
    static boolean[][] filled = new boolean[13][23];
    
    static boolean[][][][] shape = new boolean[7][4][4][4];
    
    static int nextShape;
    static int currentShape;
    static int currentRot;
    static int posX, posY;
    
    static Random rand = new Random();
    
    static int score;
    
    public static void main(String[] args) {
        
        //L shape, 1st state
        shape[0][0][2][0] = true;
        shape[0][0][0][1] = true;
        shape[0][0][1][1] = true;
        shape[0][0][2][1] = true;
        
        //L shape, 2nd state
        shape[0][1][0][0] = true;
        shape[0][1][1][0] = true;
        shape[0][1][1][1] = true;
        shape[0][1][1][2] = true;
        
        //L shape, 3rd state
        shape[0][2][0][0] = true;
        shape[0][2][1][0] = true;
        shape[0][2][2][0] = true;
        shape[0][2][0][1] = true;
        
        //L shape, 4th state
        shape[0][3][0][0] = true;
        shape[0][3][0][1] = true;
        shape[0][3][0][2] = true;
        shape[0][3][1][2] = true;
        
        //J shape, 1st state
        shape[1][0][0][0] = true;
        shape[1][0][0][1] = true;
        shape[1][0][1][1] = true;
        shape[1][0][2][1] = true;
        
        //J shape, 2nd state
        shape[1][1][1][0] = true;
        shape[1][1][1][1] = true;
        shape[1][1][0][2] = true;
        shape[1][1][1][2] = true;
        
        //J shape, 3rd state
        shape[1][2][0][0] = true;
        shape[1][2][1][0] = true;
        shape[1][2][2][0] = true;
        shape[1][2][2][1] = true;
        
        //J shape, 4th state
        shape[1][3][0][0] = true;
        shape[1][3][1][0] = true;
        shape[1][3][0][1] = true;
        shape[1][3][0][2] = true;
        
        //S shape, 1st state
        shape[2][0][1][0] = true;
        shape[2][0][2][0] = true;
        shape[2][0][0][1] = true;
        shape[2][0][1][1] = true;
        
        //S shape, 2nd state
        shape[2][1][0][0] = true;
        shape[2][1][0][1] = true;
        shape[2][1][1][1] = true;
        shape[2][1][1][2] = true;
        
        //S shape, 3rd state
        shape[2][2][1][0] = true;
        shape[2][2][2][0] = true;
        shape[2][2][0][1] = true;
        shape[2][2][1][1] = true;
        
        //S shape, 4th state
        shape[2][3][0][0] = true;
        shape[2][3][0][1] = true;
        shape[2][3][1][1] = true;
        shape[2][3][1][2] = true;
        
        //Z shape, 1st state
        shape[3][0][0][0] = true;
        shape[3][0][1][0] = true;
        shape[3][0][1][1] = true;
        shape[3][0][2][1] = true;
        
        //Z shape, 2nd state
        shape[3][1][1][0] = true;
        shape[3][1][0][1] = true;
        shape[3][1][1][1] = true;
        shape[3][1][0][2] = true;
        
        //Z shape, 3rd state
        shape[3][2][0][0] = true;
        shape[3][2][1][0] = true;
        shape[3][2][1][1] = true;
        shape[3][2][2][1] = true;
        
        //Z shape, 4th state
        shape[3][3][1][0] = true;
        shape[3][3][0][1] = true;
        shape[3][3][1][1] = true;
        shape[3][3][0][2] = true;
        
        //T shape, 1st state
        shape[4][0][1][0] = true;
        shape[4][0][0][1] = true;
        shape[4][0][1][1] = true;
        shape[4][0][2][1] = true;
        
        //T shape, 2nd state
        shape[4][1][1][0] = true;
        shape[4][1][0][1] = true;
        shape[4][1][1][1] = true;
        shape[4][1][1][2] = true;
        
        //T shape, 3rd state
        shape[4][2][0][1] = true;
        shape[4][2][1][1] = true;
        shape[4][2][2][1] = true;
        shape[4][2][1][2] = true;
        
        //T shape, 4th state
        shape[4][3][1][0] = true;
        shape[4][3][1][1] = true;
        shape[4][3][2][1] = true;
        shape[4][3][1][2] = true;
        
        //I shape, 1st state
        shape[5][0][0][1] = true;
        shape[5][0][1][1] = true;
        shape[5][0][2][1] = true;
        shape[5][0][3][1] = true;
        
        //I shape, 2nd state
        shape[5][1][1][0] = true;
        shape[5][1][1][1] = true;
        shape[5][1][1][2] = true;
        shape[5][1][1][3] = true;
        
        //I shape, 3rd state
        shape[5][2][0][1] = true;
        shape[5][2][1][1] = true;
        shape[5][2][2][1] = true;
        shape[5][2][3][1] = true;
        
        //I shape, 4th state
        shape[5][3][1][0] = true;
        shape[5][3][1][1] = true;
        shape[5][3][1][2] = true;
        shape[5][3][1][3] = true;
        
        //B shape, 1st state
        shape[6][0][0][0] = true;
        shape[6][0][1][0] = true;
        shape[6][0][0][1] = true;
        shape[6][0][1][1] = true;
        
        //B shape, 2nd state
        shape[6][1][0][0] = true;
        shape[6][1][1][0] = true;
        shape[6][1][0][1] = true;
        shape[6][1][1][1] = true;
        
        //B shape, 3rd state
        shape[6][2][0][0] = true;
        shape[6][2][1][0] = true;
        shape[6][2][0][1] = true;
        shape[6][2][1][1] = true;
        
        //B shape, 4th state
        shape[6][3][0][0] = true;
        shape[6][3][1][0] = true;
        shape[6][3][0][1] = true;
        shape[6][3][1][1] = true;
        
        for (int i = 0; i < filled.length; i++) 
            filled[i][22] = true;
        
        for (int j = 0; j < filled[0].length; j++) {
                filled[0][j] = true;
                filled[11][j] = true;
                filled[12][j] = true;
            }
        
        nextShape = rand.nextInt(7);
        
        CreateShape();
        
        new Display();
    
}
    
    public static void CreateShape(){
        currentShape = nextShape;
        nextShape = rand.nextInt(7);
        currentRot = 0;
        
        if (currentShape == 5)
            posX = 4;
        else
            posX = 5;
        posY = 1;
        
    }
    
}
    
