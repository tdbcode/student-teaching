/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fizz.bizz;


/**
 *
 * @author thomas.brady
 */
public class FizzBizz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         for (int n=1; n<=100; n++) { //creastes a for loop for numbers from 1 to 100
             if (((n%3) == 0) & (n%5) == 0){ //creates if statement where n is divisible by 3 and 5
                 System.out.println("Fizz Buzz");//prints fizz buzz if n is divisible by 3 and 5
             }
             else if ((n%3) == 0){ //creates if statement where n is divisible by 3
                 System.out.println("Fizz"); //prints fizz if n is divisible by 3
             }
             else if ((n%5)== 0) { //creates if statement where n is divisible by 5
                 System.out.println("Buzz"); //prints buzz if n is divisible by 5
             }
             else { 
                 System.out.println(n);//prints all the numbers that are not divisible by 3 and 5
             }
         }
    }
    
}
