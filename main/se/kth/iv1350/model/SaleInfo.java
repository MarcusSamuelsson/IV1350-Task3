package main.se.kth.iv1350.model;

import java.util.HashMap;

import main.se.kth.iv1350.integration.Item;

public class SaleInfo {
    TimeAndDate timeAndDate = new TimeAndDate();
    HashMap<Integer,Item> items = new HashMap<Integer, Item>();

    void addItem(Item item) {
        int currID = item.getItemDesc().getId();
        
        if(items.get(currID) == null)
            items.put(currID, item);
        else
            items.get(currID).increaseQuantity(item.getQuantity());
    }

    /**
     * Returns the number of current items
     * @return the size of the items hashmap
     */
    public int numberOfItemsInCart(){
        return items.size();
    }

    /**
     * Converts the SaleInfo to an easily readable string
     */
    public String toString() {
        String finalString = timeAndDate.getTimeAndDate() +"\nProducts | Quantity | Cost | VAT";

        for (int i = 0; i < items.size(); i++) {
            finalString += "\n" + items.get(i).toString();
        }

        return finalString;
    }
}
