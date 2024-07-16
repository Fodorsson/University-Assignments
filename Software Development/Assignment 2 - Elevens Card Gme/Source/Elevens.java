package elevens;

import java.util.Scanner;

public class Elevens {
    
    public static Scanner input = new Scanner(System.in);
    public static Deck deck;
    public static ArrayBag<Card> hands;
    //We have to determine the maximum capacity the replay ArrayBag should have
    //Worst case scenario is if the player wins the game. This takes precisely 24 removals 
    //We add the initial deck and card print message to this number
    //So the capacity should be 25
    public static ArrayBag<String> replay;
    
    public static String gameMode;

    public static void main(String[] args) {
        newGame();
    }
    
    public static void newGame(){
        //We have to add an empty entry to the replay ArrayBag
        replay = new ArrayBag<String>(25);
        replay.add("Displaying the replay now!");
        
        gameMode = "notChosenYet";
        
        System.out.println("---");
        System.out.println("Choose a Game Mode: ");
        System.out.println("P - Player Vs Computer Mode");
        System.out.println("D - Demonstration Mode");
        System.out.println("---");
        
        String choice = input.nextLine();
        
        if (choice.equalsIgnoreCase("P")){
            gameMode = "playerVsComputer";
            Play();
        }
        else if (choice.equalsIgnoreCase("D")){
            gameMode = "demonstration";
            Play();
        }
        else{
            System.out.println("Invalid choice.");
            newGame();
        }
        
    }
    
    public static void Play(){
        deck = new Deck();
        deck.shuffle();
        
        hands = new ArrayBag<Card>(9);
        
        for (int i = 0; i < 9; i++) {
            hands.add(deck.elementAt(0) );
            deck.removeAt(0);
        }
        
        startTurn();
        
    }
    
    public static void printDeckAndHand(){
        String newString = "\n---"
                + "\nThe deck has " + deck.getSize() + " card(s) remaining."
                + "\nYour Hand:\n";
        replay.setElementAt(replay.getSize() - 1, replay.elementAt(replay.getSize() - 1 ) + newString);
        System.out.print(newString);
        
        for (int i = 0; i < hands.getSize(); i++){
            newString = i + 1 + " - " + hands.elementAt(i).getName() + "\n";
            replay.setElementAt(replay.getSize() - 1, replay.elementAt(replay.getSize() - 1 ) + newString);
            System.out.print(newString);
        }
            
    }
    
    public static void turnMenu(){
        System.out.println("---");
        System.out.println("S - Select a card to remove");
        System.out.println("H - Hint");
        System.out.println("N - New Game");
        System.out.println("E - Exit Game");
        System.out.println("---");
        
        String choice = input.nextLine();
        
        if (choice.equalsIgnoreCase("S") )
            select();
        else if (choice.equalsIgnoreCase("H") )
            printHint();
        else if (choice.equalsIgnoreCase("N") )
            newGame();
        else if (choice.equalsIgnoreCase("E"))
            System.exit(0);
        else{
            System.out.println("Invalid choice.");
            turnMenu();        
        }
    }
    
    public static void startTurn(){
        printDeckAndHand();
        //Check for stalemate
        //The array returning from the hint method
        int hint[] = hint();
        if (hint.length == 0)
            gameOver("a stalemate has been reached");
        
        if (gameMode.equalsIgnoreCase("playerVsComputer") )
            turnMenu();
        else if (gameMode.equalsIgnoreCase("demonstration") )
            selectDemo();
    }
    
    public static void selectDemo(){
        System.out.println("\nPress Enter to watch the next step of the computer");
        input.nextLine();
        
        int hint[] = hint();
        
        if (hint.length == 2){
            String newString = "---\n" + hands.elementAt(hint[0]).getName() + " and " + hands.elementAt(hint[1]).getName() + " removed";
            replay.add(newString);
            System.out.print(newString);
            
            hands.removeAt(hint[1]);
            hands.removeAt(hint[0]);
            
            for (int i = 0; i < 2; i++) {
                    if (deck.getSize() > 0){
                        hands.add(deck.elementAt(0) );
                        deck.removeAt(0);
                    }
            }
            
            if (hands.getSize() + deck.getSize() == 0)
                    gameOver("all the cards have been removed.");
            
            startTurn();
        }
        else if (hint.length == 3){
            String newString = "---\n" + hands.elementAt(hint[0]).getName() + ", " + hands.elementAt(hint[1]).getName() + " and " + hands.elementAt(hint[2]).getName() + " removed";
            replay.add(newString);
            System.out.print(newString);
            
            hands.removeAt(hint[2]);
            hands.removeAt(hint[1]);
            hands.removeAt(hint[0]);
            
            
            for (int i = 0; i < 3; i++) {
                    if (deck.getSize() > 0){
                        hands.add(deck.elementAt(0) );
                        deck.removeAt(0);
                    }
            }
            
            if (hands.getSize() + deck.getSize() == 0)
                    gameOver("all the cards have been removed.");
            
            startTurn();
        }
        //If the hint() returns an empty array then no possible combinations were found
        else gameOver("a stalemate has been reached");
    }
    
    public static void select(){
        System.out.println("Select the first card");
        int choice1 = input.nextInt();
        System.out.println("Select the second card");
        int choice2 = input.nextInt();
        
        //We need choice 2 to be a bigger index than choice 1, otherwise when the item with the smaller index gets removed, 
        //the item with the bigger index gets its index modified
        //So if the player selected the card with the bigger index first, we have to swap them
        if (choice2 < choice1){
            int temp = choice2;
            choice2 = choice1;
            choice1 = temp;
        }
        
        //If the two selected cards are picture cards (their rank value is 0) then ask for a third card
        if (hands.elementAt(choice1-1).getRankValue() + hands.elementAt(choice2-1).getRankValue() == 0 ){
            System.out.println("Select the third card");
            int choice3 = input.nextInt();
            
            //Similarly to the first two choices, now we have to put all three choices in ascending order
            //If choice3 is smaller than both of them
            if (choice3 < choice1){
                int temp = choice1;
                choice1 = choice3;
                choice3 = choice2;
                choice2 = temp;
            }
            //If choice3 is only smaller than the second one
            else if (choice3 < choice2){
                int temp = choice2;
                choice2 = choice3;
                choice3 = temp;
            }
            
            //If the third selected card is also a picture card, and none of them have the same rank name
            if (hands.elementAt(choice1-1).getRankValue() + hands.elementAt(choice2-1).getRankValue() + hands.elementAt(choice3-1).getRankValue() == 0 
                && !hands.elementAt(choice1-1).getRankName().equals(hands.elementAt(choice2-1).getRankName() )
                && !hands.elementAt(choice1-1).getRankName().equals(hands.elementAt(choice3-1).getRankName() )
                && !hands.elementAt(choice2-1).getRankName().equals(hands.elementAt(choice3-1).getRankName() ) ){
                //Remove these
                
                String newString = "---\n" + hands.elementAt(choice1-1).getName() + ", " + hands.elementAt(choice2-1).getName() + " and " + hands.elementAt(choice3-1).getName() + " removed";
                replay.add(newString);
                System.out.print(newString);
                
                hands.removeAt(choice3-1);
                hands.removeAt(choice2-1);
                hands.removeAt(choice1-1);
                
                for (int i = 0; i < 3; i++) {
                    if (deck.getSize() > 0){
                        hands.add(deck.elementAt(0) );
                        deck.removeAt(0);
                    }
                }
                
                if (hands.getSize() + deck.getSize() == 0)
                    gameOver("all the cards have been removed.");
                
            }
            else
                System.out.println("Invalid choice.");
            
        }
        //If the sum of the rank values of the two cards is 11, then remove them from the player's hand and substitute them with new cards
        else if (hands.elementAt(choice1-1).getRankValue() + hands.elementAt(choice2-1).getRankValue() == 11){
            
            String newString = "---\n" + hands.elementAt(choice1-1).getName() + " and " + hands.elementAt(choice2-1).getName() + " removed";
            replay.add(newString);
            System.out.print(newString);
             
            hands.removeAt(choice2-1);
            hands.removeAt(choice1-1);
            
            for (int i = 0; i < 2; i++) {
                if (deck.getSize() > 0){
                    hands.add(deck.elementAt(0) );
                    deck.removeAt(0);
                }
            }
                
            if (hands.getSize() + deck.getSize() == 0)
                gameOver("all the cards have been removed.");
            
        }
        else{
            System.out.println("Invalid choice.");
        }
        
        input.nextLine();
        startTurn();
            
    }
    
    public static void printHint(){
        //Prints a hint according to the int array that the hint() method returns
        int hint[] = hint();
        
        if (hint.length == 2){
            System.out.println("Hint: " + hands.elementAt(hint[0]).getName() + " and " + hands.elementAt(hint[1]).getName() );
            turnMenu();
        }
        else if (hint.length == 3){
            System.out.println("Hint: " + hands.elementAt(hint[0]).getName() + " and " + hands.elementAt(hint[1]).getName() + " and " + hands.elementAt(hint[2]).getName() );
            turnMenu();
        }
        //If the hint() returns an empty array then no possible combinations were found
        else gameOver("a stalemate has been reached");
        
    }
    
    public static int[] hint(){
        //This is where the computer goes through the hands ArrayBag in order to find pairs
        
        //Check for combinations of 2
        for (int i = 0; i < hands.getSize(); i++) {
            for (int j = i + 1; j < hands.getSize(); j++) {
                if (hands.elementAt(i).getRankValue() + hands.elementAt(j).getRankValue() == 11){
                    int[] answer = {i, j};
                    return answer;
                }
            }
        }
        //Check for combinations of 3
        //These three index variables refer to the index where these cards can be found in the player's hand
        //Since the index of elements of the hands ArrayBag ranges from 0 to 8, -1 does not refer to either one, so this is set as default
        int jackIndex = -1;
        int queenIndex = -1;
        int kingIndex = -1;
            
        for (int i = 0; i < hands.getSize(); i++) {
            if (hands.elementAt(i).getRankName().equals("Jack") ) jackIndex = i;
            if (hands.elementAt(i).getRankName().equals("Queen") ) queenIndex = i;
            if (hands.elementAt(i).getRankName().equals("King") ) kingIndex = i;
        }
            
        if (jackIndex > -1 && queenIndex > -1 && kingIndex > -1){
            //We need to sort them in an ascending order, so that the computer can remove them without messing up the index
            
            int[] temp = new int[3];
            temp[0] = jackIndex;
            temp[1] = queenIndex;
            temp[2] = kingIndex;
            
            int min = temp[0];
            int max = temp[0];
            int mid = temp[0];
            
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] < min) min = temp[i];
                if (temp[i] > max) max = temp[i];
                
            }
            
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != min && temp[i] != max){
                    mid = temp[i];
                    break;
                }
            }
            
            int[] answer = {min, mid, max};
            return answer;
            
        }
        
        int[] answer = {};
        return answer;
            
    }
    
    public static void gameOver(String reason){
        System.out.println("---");
        System.out.println("The game is over because " + reason);
        System.out.println("---");
        System.out.println("N - New Game");
        System.out.println("R - Replay");
        System.out.println("E - Exit Game");
        System.out.println("---");
        
        String choice = input.nextLine();
        
        if (choice.equalsIgnoreCase("N"))
            newGame();
        else if (choice.equalsIgnoreCase("R"))
            replay(reason);
        else if (choice.equalsIgnoreCase("E"))
            System.exit(0);
        else{
            System.out.println("Invalid choice.");
            gameOver(reason);
        }
        
    }
    
    public static void replay(String gameOverReason){
        for (int i = 0; i < replay.getSize(); i++) {
            System.out.print(replay.elementAt(i));
            input.nextLine();
        }
        
        gameOver(gameOverReason);
    }
    
}
