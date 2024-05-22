/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystemy12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thomas.brady
 */
public class LibrarySystemY12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Book> Books = new ArrayList<Book>();
        ArrayList<Customer> Customers = new ArrayList<Customer>();
        Books.add(new Book("1984","Orwell","Dystopian",1935,true));
        Books.add(new Book("Animal Farm","Orwell","Dystopian",1935,true));
        Book currentBook;
        Scanner inp = new Scanner(System.in);
        int choice=0;
        String BookChoice;
        int CustID;
        // for sake of demonstration just set customer ids to linear numbers. You can always add algorithm to search ids later on.
        Customers.add(new Customer(1,"Bill"));
        Customers.add(new Customer(2,"Lauren"));
        Customers.add(new Customer(3,"Jill"));
        Customers.add(new Customer(4,"Mike"));

        System.out.println("Choose an option. Enter 1 for output the list of books, Enter 2 to reserve a book, Enter 3 to return a book");
        choice = inp.nextInt();
        
        if(choice==1){
            for (int i=0; i<Books.size();i++){
                currentBook = Books.get(i);
                System.out.println(currentBook.getBookName() + " " + currentBook.getAuthor() + " In Stock: " + currentBook.getStock());
            }
        }
        else if(choice==2){
            System.out.println("Please enter your customer ID:");
            CustID = inp.nextInt();
            System.out.println("Please enter the name of the book you would like to reserve:");
            BookChoice = inp.nextLine();
            for (int i=0; i<Books.size();i++){
                   currentBook = Books.get(i);
                   if(currentBook.getBookName().equals(BookChoice)){
                       if(currentBook.getStock().equals(true)){
                           Customers.get(CustID-1).addBook(currentBook);
                       }
                       else{
                           System.out.println("Sorry that book is not in stock");
                       }
                   }
            }
            
        }
        
    }
}
    

