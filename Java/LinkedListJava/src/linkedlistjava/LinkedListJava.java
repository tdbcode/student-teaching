/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistjava;

import java.util.Scanner;

/**
 *
 * @author thomas.brady
 */
public class LinkedListJava {

    /**
     * @param args the command line arguments
     */
    
    public static intNode head = null;
    
    public static void main(String[] args) {
     Scanner s = new Scanner(System.in);
     head = new intNode(55, null);
    
     intNode currentNode = head;
     intNode currentNode2 = head;
     intNode tempNode;
    int nodeCount = 1;
    while(true){
        System.out.println("Please enter next number for the linked list");
        int tempNo = s.nextInt();
 
        tempNode = new intNode(tempNo, null);
     
     while(currentNode.next != null){
         currentNode = currentNode.next;
         nodeCount++;
     }
     
     currentNode.next = tempNode;
     System.out.println("Node added at end of list");
     
     for(int i = 0; i <= nodeCount; i++) {
         System.out.println(currentNode2.toString());
         if(currentNode2.next != null){
            currentNode2 = currentNode2.next;
         }
     }
    }
    
    }
}
            /* }
             else if(temp == 2){
                 tempNode.next = head;
                 head = tempNode;
             }
             else if(temp == 3){
                 intNode CurrentItem = head;  
                 while (CurrentItem.next != null){
                     if((CurrentItem.data >= tempNode.data) && (CurrentItem.next.data <= tempNode.data)){
                     tempNode.next = CurrentItem.next;
                     CurrentItem.next = tempNode;
                     break;
                 }                     
                     CurrentItem = CurrentItem.next;
               
                 }
             }
           
        }
       
        System.out.println("Would you like to output your linked list?");
        String link = s.next();
        
        
        intNode CurrentItem = head;
        
        if(link.equals("Y")){
             while (CurrentItem!=null){
                System.out.println(CurrentItem);
                CurrentItem = CurrentItem.next;
            }
        }
        
        
    }
    }*/
    