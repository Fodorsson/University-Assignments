package elevens;

public class CardTest {
    
    public static Card card1, card2;
    
    public static void main(String[] args) {
        
        //Constructor method
        card1 = new Card("Ace", "Spades");
        
        //getRankValue method
        System.out.println("Rank value: " + card1.getRankValue() );
        
        //getRankName method
        System.out.println("Rank name: " + card1.getRankName() );
        
        //getSuit method
        System.out.println("Suit: " + card1.getSuit() );
                
        //getName method       
        System.out.println("Name: " + card1.getName() );
        
        System.out.println("");
        
        //Constructor method
        card2 = new Card("Jack", "Diamonds");
        
        //getRankValue method
        System.out.println("Rank value: " + card2.getRankValue() );
        
        //getRankName method
        System.out.println("Rank name: " + card2.getRankName() );
        
        //getSuit method
        System.out.println("Suit: " + card2.getSuit() );
                
        //getName method       
        System.out.println("Name: " + card2.getName() );
                
        
    }
    
}
