package elevens;

public class ArrayBagTest {
    
    public static ArrayBag<String> bag;
    
    public static void main(String[] args) {
        
        //Using the constructor method
        bag = new ArrayBag<String>(5);
        
        //Using the getSize method
        System.out.println("Bag size: " + bag.getSize());
        System.out.println("");
        
        //Using the add method
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");
        
        //Using the elementAt method
        System.out.println("Content after adding elements:");
        for (int i = 0; i < bag.getSize(); i++) {
            System.out.println(bag.elementAt(i));
        }
        System.out.println("");
        
        //Using the setElementAt method
        System.out.println("Content after changing first element:");
        bag.setElementAt(0, "z");
        
        for (int i = 0; i < bag.getSize(); i++) {
            System.out.println(bag.elementAt(i));
        }
        System.out.println("");
        
        //Using the removeAt method
        System.out.println("Content after removing first element:");
        bag.removeAt(0);
        
        for (int i = 0; i < bag.getSize(); i++) {
            System.out.println(bag.elementAt(i));
        }
        
    }
    
}
