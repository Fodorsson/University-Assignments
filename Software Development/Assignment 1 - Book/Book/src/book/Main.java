package book;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author QAB00796884
 * David Fodor
 */
public class Main {
    
    public static Scanner input = new Scanner(System.in);
    static Book[] bookArray;
    public static int bookArrayInd = 0;

    public static void main(String[] args) {
        
        System.out.println("Welcome to this program");
        System.out.println("---");
        System.out.println("How many books should my application store?");
        
        //We have to make sure the user enters a number here, not something else 
        //which would cause an input mismatch exception
        
        while(!input.hasNextInt()){
            input.nextLine();
            System.out.println("---");
            System.out.println("That's not a number mate");
        }
        
        //We declare an array with the size of the user input
        int number = input.nextInt();
        bookArray = new Book[number];
        
        int choice;
        
        do{
            System.out.println("---");
            System.out.println("1. Add book (Type in title)");
            System.out.println("2. Add book details (Type in title)");
            System.out.println("3. Display book (Type in title)");
            System.out.println("4. List all books");
            System.out.println("5. Exit");
        
            choice = input.nextInt();
        
            switch (choice) {
                case 1:
                    //Add a new book (Only asks for a title, the rest of the 
                    //details of the book can be added later.)
                    if (bookArrayInd < bookArray.length)
                        AddBook();
                    else{
                        System.out.println("---");
                        System.out.println("You cannot add any more books");
                    }
                    break;
                case 2:
                    //This is where you add the rest of the details
                    AddDetails();
                    break;
                case 3:
                    //Here you can get all the details of a specific book, 
                    //chosen by typing in the book's name, non-case-sensitive
                    DisplayBook();
                    break;
                case 4:
                    //This choice displays the title of all the books
                    System.out.println("---");
                    for (int i = 0; i < bookArrayInd; i++) {
                        System.out.println(bookArray[i].getTitle() );
                        
                    }
                    
                    break;
                case 5:
                    //Number five is the exit option and it fulfils the while loop criteria, 
                    //thus ending the program
                    break;
                default:
                    //If it's not 1-5 you can try again buddy
                    System.out.println("---");
                    System.out.println("Invalid choice");
            }
        
        }while(choice != 5);
        
        System.out.println("---");
        System.out.println("Goodbye!");
    }
    
    public static void AddBook(){
        System.out.println("---");
        System.out.println("Type in the title of the book you would like to add");
        String title = input.next();
        bookArray[bookArrayInd] = new Book(title) {};
        //bookArrayInd keeps track of the current index of the book array, 
        //aka how many books have been added so far
        
        //It is a little more elegant to set these default values to the properties 
        //than just to simply let them display 'null'
        bookArray[bookArrayInd].changeAuthor("No author specified");
        bookArray[bookArrayInd].changeISBN("No ISBN specified");
        bookArray[bookArrayInd].changePublisher("No publisher specified");
        bookArray[bookArrayInd].changePages("No number of pages specified");
        bookArray[bookArrayInd].changeLanguage("No language specified");
        
        bookArrayInd++;
        System.out.println("---");
        System.out.println("Book added.");
        
    }
    
    public static void AddDetails(){
        
        System.out.println("---");
        System.out.println("Type in the title of the book you would like to add details to");
        String title = input.next();
        
        //Obviously you can't add details to a book which doesn't even exist. 
        //Default is false, we'll see if the program can find it.
        boolean bookFound = false;
        
        for (int i = 0; i < bookArrayInd; i++) {
            if (bookArray[i].getTitle().equalsIgnoreCase(title)){
                
                //Seems like the program has found a book with this title
                //We are in a submenu now
                System.out.println("---");
                System.out.println("1. Add title");
                System.out.println("2. Add author");
                System.out.println("3. Add ISBN");
                System.out.println("4. Add publisher");
                System.out.println("5. Add number of pages");
                System.out.println("6. Add language");
                System.out.println("7. Add publication date");
                System.out.println("8. Back");
                
                int choice;
        
                do{
        
                    choice = input.nextInt();
        
                    switch (choice) {
                        //The following lines should be self-explanatory.
                        case 1:
                            System.out.println("---");
                            System.out.println("Type in the new title");
                            bookArray[i].changeTitle(input.next() );
                            System.out.println("Title added");
                            break;
                        case 2:
                            System.out.println("---");
                            System.out.println("Type in the new author");
                            bookArray[i].changeAuthor(input.next() );
                            System.out.println("Author added");
                            break;
                        case 3:
                            System.out.println("---");
                            System.out.println("Type in the new ISBN");
                            bookArray[i].changeISBN(input.next() );
                            System.out.println("ISBN added");
                            break;
                        case 4:
                            System.out.println("---");
                            System.out.println("Type in the new publisher");
                            bookArray[i].changePublisher(input.next() );
                            System.out.println("Publisher added");
                            break;
                        case 5:
                            System.out.println("---");
                            System.out.println("Type in the new number of pages");
                            bookArray[i].changePages(input.next() );
                            System.out.println("Number of pages added");
                            break;
                        case 6:
                            System.out.println("---");
                            System.out.println("Type in the new language");
                            bookArray[i].changeLanguage(input.next() );
                            System.out.println("Language added");
                            break;
                        case 7:
                            //The date is a bit different. 
                            //You have to type in the date in the suggested format, 
                            //otherwise, the program won't accept it.
                            
                            System.out.println("---");
                            System.out.println("Type in the new date");
                            System.out.println("DD/MM/YYYY");
                            
                            String dateStr = input.next();
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         
                            Date date;
             
                            try {
                                    
                                dateFormat.setLenient(false);
                                date = dateFormat.parse(dateStr);
                                    
                                bookArray[i].changePublicationDate(date);
                                    
                                //The date is accepted, changed, back to the previous menu
                                System.out.println("---");
                                System.out.println("Date added");
                                System.out.println("---");
                                System.out.println("1. Add title");
                                System.out.println("2. Add author");
                                System.out.println("3. Add ISBN");
                                System.out.println("4. Add publisher");
                                System.out.println("5. Add number of pages");
                                System.out.println("6. Add language");
                                System.out.println("7. Add publication date");
                                System.out.println("8. Back");
 
                            } 
                            catch (ParseException e) {
                                //The program failed to recognise the user input string as a date
                                System.out.println("---");
                                System.out.println("That's not a date mate");
                                System.out.println("---");
                                System.out.println("1. Add title");
                                System.out.println("2. Add author");
                                System.out.println("3. Add ISBN");
                                System.out.println("4. Add publisher");
                                System.out.println("5. Add number of pages");
                                System.out.println("6. Add language");
                                System.out.println("7. Add publication date");
                                System.out.println("8. Back");
                            }
                            break;
                        case 8:
                            break;
                        default:
                            //The user didn't choose 1-8
                            System.out.println("---");
                            System.out.println("Invalid choice");
                    }
        
                }while(choice != 8);
                
                bookFound = true;
                
                break;
                }
            
        }
        
        if (!bookFound){
            System.out.println("---");
            System.out.println("No such book.");
        }
        
    }
    
    public static void DisplayBook(){
        System.out.println("---");
        System.out.println("Type in the title of the book you would like to display the details of");
        String title = input.next();
        
        boolean bookFound = false;
        
        for (int i = 0; i < bookArrayInd; i++) {
            if (bookArray[i].getTitle().equalsIgnoreCase(title)){
                
                System.out.println("---");
                System.out.println(bookArray[i].toString() );
                
                bookFound = true;
                
                break;
                }
            
        }
        
        if (!bookFound){
            System.out.println("---");
            System.out.println("No such book.");
        }
        
    }
    
}
