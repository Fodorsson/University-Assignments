
package elevens;

public class TestDeck {
    public static void main(String[] args) {
        
    Deck test = new Deck();
        
        System.out.println("Size of the deck is: " + test.getSize() + " cards.");
        
        System.out.println();
    
        for (int i = 0; i <= 12; i++) {
            System.out.println("Rankname: " + test.elementAt(i).getRankName() + ", " + "Rankvalue: " + test.elementAt(i).getRankValue());
        }
       
        System.out.println();
        
        System.out.println("Value of Ace is: " + test.elementAt(0).getRankValue());
        System.out.println("Value of Kind is: " + test.elementAt(12).getRankValue());
        System.out.println("Value of 10 is: " + test.elementAt(9).getRankValue());
        System.out.println("Value of Jack is: " + test.elementAt(10).getRankValue());
        
        System.out.println();   
       
        //before shuffling the deck
        System.out.print("Before shuffling: ");
        for (int i = 0; i <= 12; i++) {
            System.out.print(test.elementAt(i).getRankName() + ", ");
        }
        
        System.out.println();
        System.out.println();
        
        test.shuffle();
        
        //after shuffling the deck
        System.out.print("After shuffling: ");
        for (int i = 0; i <= 12; i++) {
            System.out.print(test.elementAt(i).getRankName() + ", ");
        }
        
        System.out.println();
        
        //removing elemetent at index 5
        test.removeAt(5);
        
        System.out.println();
       
        //deck after removing element at index 5
        System.out.print("After removing element at index 5: ");
        for (int i = 0; i <= 12; i++) {
            System.out.print(test.elementAt(i).getRankName() + ", ");
        } 
       
        System.out.println();
        System.out.println();
        
        //getting the element at index 8
        System.out.print("Element at index 8 is: ");
        System.out.print(test.elementAt(6).getRankName());
        System.out.println();
   } 
}
