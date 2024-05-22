/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysy12again;

import java.util.Scanner;

/**
 *
 * @author thomas.brady
 * Basic number averager using array and loop
 */
public class ArraysY12Again {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Scanner inputLine = new Scanner(System.in);
        
        for(int i = 0;i<numbers.length-1;i++){
            System.out.println("Enter the number:");
            numbers[i] = inputLine.nextInt();    
        }
        
        double total = 0;
        for(int i = 0;i<numbers.length-1;i++){
            total = total + numbers[i];    
        }
        
        double average = total / 10;
        System.out.println(average);
    }
    
}
