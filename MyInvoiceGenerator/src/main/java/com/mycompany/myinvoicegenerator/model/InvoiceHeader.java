
package com.mycompany.myinvoicegenerator.model;
import java.util.ArrayList;
public class InvoiceHeader {
    private int invoiceNum;
    private string invoiceDate;
    private string customerName;
  
    private ArrayList<InvoiceLine >invoiceLines;
     
    public InvoiceHeader(int invoiceNum1, String invoiceDate1, String customerName1) {
    }

    public InvoiceHeader(int invoiceNum, string invoiceDate, string customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        if (invoiceLines == null){
            invoiceLines = new ArrayList<>();
        }
        return invoiceLines;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public string getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(string invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public string getCustomerName() {
        return customerName;
    }

    public void setCustomerName(string customerName) {
        this.customerName = customerName;
        
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "invoiceNum=" + invoiceNum + ", invoiceDate=" + invoiceDate + ", customerName=" + customerName + '}';
    }
public String getAsCSV() {
        return invoiceNum + "," + invoiceDate + "," + customerName;
    }

    String getNum() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}