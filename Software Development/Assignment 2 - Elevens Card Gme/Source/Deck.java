package elevens;

import java.util.Random;

public class Deck {
    private ArrayBag<Card> deck;
    
    public Deck(){
        deck = new ArrayBag<Card>(52);
        
        deck.add(new Card("Ace", "Spades") );
        deck.add(new Card("2", "Spades") );
        deck.add(new Card("3", "Spades") );
        deck.add(new Card("4", "Spades") );
        deck.add(new Card("5", "Spades") );
        deck.add(new Card("6", "Spades") );
        deck.add(new Card("7", "Spades") );
        deck.add(new Card("8", "Spades") );
        deck.add(new Card("9", "Spades") );
        deck.add(new Card("10", "Spades") );
        deck.add(new Card("Jack", "Spades") );
        deck.add(new Card("Queen", "Spades") );
        deck.add(new Card("King", "Spades") );
        deck.add(new Card("Ace", "Clubs") );
        deck.add(new Card("2", "Clubs") );
        deck.add(new Card("3", "Clubs") );
        deck.add(new Card("4", "Clubs") );
        deck.add(new Card("5", "Clubs") );
        deck.add(new Card("6", "Clubs") );
        deck.add(new Card("7", "Clubs") );
        deck.add(new Card("8", "Clubs") );
        deck.add(new Card("9", "Clubs") );
        deck.add(new Card("10", "Clubs") );
        deck.add(new Card("Jack", "Clubs") );
        deck.add(new Card("Queen", "Clubs") );
        deck.add(new Card("King", "Clubs") );
        deck.add(new Card("Ace", "Hearts") );
        deck.add(new Card("2", "Hearts") );
        deck.add(new Card("3", "Hearts") );
        deck.add(new Card("4", "Hearts") );
        deck.add(new Card("5", "Hearts") );
        deck.add(new Card("6", "Hearts") );
        deck.add(new Card("7", "Hearts") );
        deck.add(new Card("8", "Hearts") );
        deck.add(new Card("9", "Hearts") );
        deck.add(new Card("10", "Hearts") );
        deck.add(new Card("Jack", "Hearts") );
        deck.add(new Card("Queen", "Hearts") );
        deck.add(new Card("King", "Hearts") );
        deck.add(new Card("Ace", "Diamonds") );
        deck.add(new Card("2", "Diamonds") );
        deck.add(new Card("3", "Diamonds") );
        deck.add(new Card("4", "Diamonds") );
        deck.add(new Card("5", "Diamonds") );
        deck.add(new Card("6", "Diamonds") );
        deck.add(new Card("7", "Diamonds") );
        deck.add(new Card("8", "Diamonds") );
        deck.add(new Card("9", "Diamonds") );
        deck.add(new Card("10", "Diamonds") );
        deck.add(new Card("Jack", "Diamonds") );
        deck.add(new Card("Queen", "Diamonds") );
        deck.add(new Card("King", "Diamonds") );
    }
    
    public void shuffle(){
        //Make a new deck with the size of the previous deck
        ArrayBag<Card> tempDeck = new ArrayBag<Card>(deck.getSize() );
        
        Random rand = new Random();
        
        //While the original deck has elements left
        while (deck.getSize() > 0){
            //We choose a random index between 0 and the size of the original deck
            int index = rand.nextInt(deck.getSize() );
            //We add the element with that index from the original deck to the new deck
            tempDeck.add(deck.elementAt(index) );
            //We remove the element from the original deck, so that it doesn't get picked again.
            deck.removeAt(index);
        }
        //Pass the contents of tempDeck back to the original deck
        deck = tempDeck;
        
    }
    
    public int getSize(){
        return deck.getSize();
    }
    
    public void removeAt(int index){
        deck.removeAt(index);
    }
    
    public Card elementAt(int index){
        return deck.elementAt(index);
    }
    
    
}
