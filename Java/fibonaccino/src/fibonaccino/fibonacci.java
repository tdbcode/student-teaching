/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
package fibonaccino


/**
 *
 * @author thomas.brady
 * Find number in fibonacci sequence with recursion
 */
public class fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Scanner inputText = new Scanner(System.in);      
        System.out.println("Which number in the sequence would you like to output?");
        int choice = inputText.nextInt();
        System.out.println("The fibonacci number is: " + fibonacci2(choice));
    }

    
    public static int fibonacci(int number){
        if(number == 1 || number == 2){
            return 1;
        } 
       return fibonacci(number-1) + fibonacci(number -2); //tail recursion }
    }
    
    
    public static int fibonacci2(int number){
        if(number == 1 || number == 2){
            return 1;
        }
    
    int fibo1=1, fibo2=1, fibonacci=1; 
    for(int i= 3; i<= number; i++){ //Fibonacci number is sum of previous two Fibonacci number 
        fibonacci = fibo1 + fibo2;
        fibo1 = fibo2;
        fibo2 = fibonacci;
    } 
    return fibonacci; //Fibonacci number 

    }

    
}
