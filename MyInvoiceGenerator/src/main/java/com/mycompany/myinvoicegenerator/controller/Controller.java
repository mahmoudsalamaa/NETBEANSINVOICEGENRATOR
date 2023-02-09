
package com.mycompany.myinvoicegenerator.controller;
 

import com.mycompany.myinvoicegenerator.model.InvoiceHeader;
import com.mycompany.myinvoicegenerator.model.InvoiceLine;
import com.mycompany.myinvoicegenerator.view.MyInvoiceTemplate;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

 public class Controller implements ActionListener{

    private MyInvoiceTemplate myFrame;
    
    public Controller(MyInvoiceTemplate myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String actionCommand = e.getActionCommand();
       System.out.println("Action: " + actionCommand);
       switch (actionCommand){
               case "Load File":
               loadFile();
               break;
              
               case "Save File":
                  saveFile();
               break;
               case "Create New Invoice":
                 creatNewInvoice();
               break;
               case "Delete Invoice":
                 deleteInvoice();
               break;
               case "Creat Item":
                 creatItem();
               break;
               case "Delete Item":
                 deleteItem();
               break;
       }      
    }

    private void loadFile(){
        JFileChooser fileSelector = new JFileChooser();
         try {
        fileSelector.showOpenDialog(null);
       
                int reaction = fileSelector.showOpenDialog(null);
              if (reaction == JFileChooser.APPROVE_OPTION) {
                   File invoiceHeaderFile = fileSelector.getSelectedFile();
                   Path invoiceHeaderPath = Paths.get(invoiceHeaderFile.getAbsolutePath());
                   List<String> invoiceHeaderLines = Files.readAllLines(invoiceHeaderPath);
                    System.out.println("INVOICES HAVE BEEN READ");
                    ArrayList<InvoiceHeader> ivoicesHeadersArray = new ArrayList<>();
                    for (String invoiceHeaderLine : invoiceHeaderLines) {
                      try {
                        String[]  invoiceHeaderContents = invoiceHeaderLine.split(",");
                      int invoiceNum = Integer.parseInt(invoiceHeaderContents[0]);
                      String invoiceDate = invoiceHeaderContents[1];
                      String  customerName = invoiceHeaderContents[2];
                      InvoiceHeader invoiceHeader = new InvoiceHeader(invoiceNum,invoiceDate,customerName);
                      ivoicesHeadersArray.add(invoiceHeader);
                      
                       System.out.println("Check point");
                    }
                      catch (Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(myFrame, "Error in line format", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
               
                    
                    reaction = fileSelector.showOpenDialog(null);
              if (reaction == JFileChooser.APPROVE_OPTION) {
                   File invoiceLineFile = fileSelector.getSelectedFile();
                   Path invoiceLinePath = Paths.get(invoiceLineFile.getAbsolutePath());
                   List<String> invoiceLineLines = Files.readAllLines(invoiceLinePath);
                    System.out.println("LINES HAVE BEEN READ");
                    
                    ArrayList<InvoiceLine> ivoicesLinesArray = new ArrayList<>();
                    
                    for (String invoiceLineLine : invoiceLineLines) {
                     try {
                        String[]  invoiceLineContents = invoiceLineLine.split(",");
                      int invoiceNum = Integer.parseInt(invoiceLineContents[0]);
                      String itemName = invoiceLineContents[1];
                      Double itemPrice = Double.parseDouble(invoiceLineContents[2]);
                      int count = Integer.parseInt(invoiceLineContents[3]);
                      InvoiceHeader invoiceNumber = null;
                      for(InvoiceHeader invoiceHeader : ivoicesHeadersArray) {
                          if (invoiceHeader.getInvoiceNum() == invoiceNum) {
                             invoiceNumber = invoiceHeader;
                             break;
                          }
                          }
                                           System.out.println("Check point");

                      InvoiceLine invoiceLine = new InvoiceLine( itemName, itemPrice, count, invoiceHeader : invoiceNumber);
                      invoiceNumber.getInvoiceLines().add(invoicLine);
                     }
                     catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(myFrame, "Error in line format", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                       
                    
                     System.out.println("check point");
                        } 
                     
                       
              }
    }
        
 }

              

  catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(myFrame, "Cannot read file", "Error", JOptionPane.ERROR_MESSAGE);
}

    
}
    private void saveFile() {   
        }
        

    private void creatNewInvoice() {
       
    }

    private void deleteInvoice() {
        
    }

    private void creatItem() {
        
    }

    private void deleteItem() { 
    }

    @Override
    public String toString() {
        return "Controller{" + '}';
    }
    
 }
