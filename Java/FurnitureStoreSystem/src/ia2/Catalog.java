/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Catalog {
    private SimpleStringProperty Name;
    private SimpleStringProperty Type;
    private SimpleIntegerProperty Stock;

    public Catalog(String name, String type, int stock) {
        this.Name = new SimpleStringProperty(name);
        this.Type = new SimpleStringProperty(type);
        this.Stock = new SimpleIntegerProperty(stock);
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
    
    public String getType() {
        return Type.get();
    }

    public final void setType(String type) {
        Type.set(type);
    }
}
