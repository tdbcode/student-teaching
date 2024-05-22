/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

public class BE_Info {
    
    public static int fixedCosts, variableCosts, price; 

    public BE_Info(int fixedCosts, int variableCosts, int price) {
        this.fixedCosts = fixedCosts;
        this.variableCosts = variableCosts;
        this.price = price;
    }

    public int getFixedCosts() {
        return fixedCosts;
    }

    public void setFixedCosts(int fixedCosts) {
        this.fixedCosts = fixedCosts;
    }

    public int getVariableCosts() {
        return variableCosts;
    }

    public void setVariableCosts(int variableCosts) {
        this.variableCosts = variableCosts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
