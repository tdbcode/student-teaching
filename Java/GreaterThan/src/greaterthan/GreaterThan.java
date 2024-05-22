/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greaterthan;

/**
 *
 * @author thomas.brady
 */
import java.util.Scanner;

public class GreaterThan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  
        System.out.println("Enter the first number:");
        int x = reader.nextInt(); 
        int y = reader.nextInt(); 
        
        greater(x,y);
    }
    
    private static void greater(int x, int y){
        System.out.print("The biggest value is: ");
        if (x > y){
            System.out.print(x);
        }
        else{
              System.out.print(y);
        }
        System.out.println("");
    }
    
}
