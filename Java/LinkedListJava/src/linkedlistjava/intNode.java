/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistjava;

/**
 *
 * @author thomas.brady
 */
public class intNode {
    
    public int data;
    public intNode next;
    
    public intNode(int data, intNode next){
        this.data = data;
        this.next = next;
    }
    
    public String toString(){
        return data + "";
    }
    
}
