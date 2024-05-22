/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogram;
import  java.util.*;
/**
 *
 * @author thomas.brady
 * Simple program with keyboard input and if statements with multiple conditions.
 */
public class FirstProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your age:");
       int age = keyboard.nextInt();
       
       if (age > 16 && age < 18){
           System.out.println("You are able to drive a macchinetta");
       }
       else if(age > 18){
           System.out.println("You can drive any car");
       }
       else{
           System.out.println("You cannot drive yet");
       }
        
    }
    
}
