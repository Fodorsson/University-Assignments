package book;
import java.util.Date;

/**
 *
 * @author QAB00796884
 * David Fodor
 */
abstract class Book {
    
    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private String pages;
    private String language;
    private Date publicationDate;
    
    public Book(String title) {
        this.title = title;
    }
    
    public Book(String title, String author, String ISBN, String publisher, String pages, String language, Date publicationDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.pages = pages;
        this.language = language;
        this.publicationDate = publicationDate;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void changeTitle(String newTitle){
        title = newTitle;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void changeAuthor(String newAuthor){
        author = newAuthor;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public void changeISBN(String newISBN){
        ISBN = newISBN;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void changePublisher(String newPublisher){
        publisher = newPublisher;
    }
    
    public String getPages() {
        return pages;
    }
    
    public void changePages(String newPages){
        pages = newPages;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void changeLanguage(String newLanguage){
        language = newLanguage;
    }
    
    public Date getPublicationDate() {
        return publicationDate;
    }
    
    public void changePublicationDate(Date newPublicationDate){
        publicationDate = newPublicationDate;
    }
    
    @Override
    public String toString(){
        
        if (publicationDate != null)
            return "Title: "+title + "\nAuthor: "+author + "\nISBN: "+ISBN + "\nPublisher: "+publisher + "\nPages: "+pages + "\nLanguage: "+language + "\nPublication Date: "+publicationDate;
        else
            return "Title: "+title + "\nAuthor: "+author + "\nISBN: "+ISBN + "\nPublisher: "+publisher + "\nPages: "+pages + "\nLanguage: "+language + "\nPublication Date: "+"No publication date specified";
    }

    
    
}
