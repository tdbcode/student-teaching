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
public class Customer {
    private int ID;
    private String name;
    private Book[] Books = new Book[5];
    private int NumberofBooks = 0;
    
    Customer(int ID, String name){
        this.ID = ID;
        this.name = name;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(){
        this.name = name;
    }
    
    public void addBook(Book b){
        if (NumberofBooks <= 4){
            Books[NumberofBooks] = b;
            NumberofBooks++;
            b.setStock(false);
        }
        else{
            System.out.println("You are at your maximum number of books");
        }
            
    }
}
