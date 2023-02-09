
package com.mycompany.myinvoicegenerator.model;

import java.util.ArrayList;


public class InvoiceLine {
    
    private string itemName;
    private double itemPrice;
    private int count; 
    private InvoiceHeader invoiceHeader;
    
    public InvoiceLine() {
    }

   
    public InvoiceLine(string itemName, double itemPrice, int count, InvoiceHeader InvoiceHeader) {
        
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.invoiceHeader = invoiceHeader;
    }

    public double getInvoiceLineTotal() {
        return itemPrice * count;
        }
     public int getCount() {
        return count;
     }

    public void setCount(int count) {
        this.count = count;
    }

  
    public string getItemName() {
        return itemName;
    }

    public void setItemName(string itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "itemName=" + itemName + ", itemPrice=" + itemPrice + ", count=" + count + '}';
    }
    public InvoiceHeader getInvoice() {
        return invoiceHeader;
    }
    
    public String getAsCSV() {
        return invoiceHeader.getNum() + "," + itemName + "," + itemPrice + "," + count;
    }
}
