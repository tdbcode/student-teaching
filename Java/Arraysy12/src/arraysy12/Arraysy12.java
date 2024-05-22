/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysy12;

import java.util.Scanner;

/**
 *
 * @author thomas.brady
 * Parallel Arrays Task
 */
public class Arraysy12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Use the scanner class for input system
       Scanner input = new Scanner(System.in);
       int scores[] = new int[6];   // Array for scores 
       boolean passorfail[] = new boolean[6];  // Array for pass or fail
       
       // Loop through and ask user to enter student score
       for(int x=0;x<5;x++){
           System.out.println("Enter score for student " + (x+1));
           scores[x] = input.nextInt();
           
           // Check if score is below 50, if so list pass or fail as false, else true
           if(scores[x]<50){
                passorfail[x] = false;
           }
           else{
                passorfail[x] = true;
           }
       }
       
       // Output results from parallel arrays
       for(int i=0;i<5;i++){
           System.out.print("\n Student " + (i+1) + "s score is: " + scores[i] + ". They have ");
           if(passorfail[i]){
                System.out.print("passed.");
            }
            else{
                System.out.print("failed.");
            }
       }
       
    }
    
}
