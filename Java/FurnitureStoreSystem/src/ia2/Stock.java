/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Stock {
    
    private SimpleStringProperty Name;
    private SimpleIntegerProperty Stock;
    private SimpleIntegerProperty DangerStock;

    public Stock(String name, int stock, int dangerstock) {
        this.Name = new SimpleStringProperty(name);
        this.Stock = new SimpleIntegerProperty(stock);
        this.DangerStock = new SimpleIntegerProperty(dangerstock);
    }

    public String getName() {
        return Name.get();
    }

    public final void setName(String name) {
        Name.set(name);
    }

    public int getStock() {
        return Stock.get();
    }

    public final void setStock(int stock) {
        Stock.set(stock);
    }
    
    public int getDangerStock() {
        return DangerStock.get();
    }

    public final void setDangerStock(int danger) {
        DangerStock.set(danger);
    }
}
    

