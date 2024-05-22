/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystemy12;

/**
 *
 * @author thomas.brady
 */
public class Book {
    private String bookName;
    private String Author;
    private String Genre;
    private int releaseYear;
    private boolean inStock;
    
    Book(String book, String author, String genre, int year, boolean Stock){
        this.bookName = book;
        this.Author = author;
        this.Genre = genre;
        this.releaseYear = year;
        this.inStock = Stock;
    }
    
    public void setStock(boolean Stock){
        this.inStock = Stock;
    }
    
    public Boolean getStock(){
        return inStock;
    }
    
    public void setBookName(String book){
        this.bookName = book;
    }
    
    public String getBookName(){
        return bookName;
    }
    
    public void setAuthor(String author){
        this.Author = author;
    }
    
    public String getAuthor(){
        return Author;
    }
    
    public void setGenre(String genre){
        this.Genre = genre;
    }
    
    public String getGenre(){
        return Genre;
    }
    
    public void setYear(int year){
        this.releaseYear = year;
    }
    
    public int getYear(){
        return releaseYear;
    }
}
